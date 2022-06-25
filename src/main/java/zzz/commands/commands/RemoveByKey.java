package zzz.commands.commands;

import zzz.collection.collection.Person;
import zzz.collection.helpers.StorageService;
import zzz.commands.CommandsManager;
import zzz.utils.DataBaseManager;
import zzz.utils.UserInterface;

import java.io.IOException;
import java.util.ArrayList;


public class RemoveByKey extends AbstractCommand {

    public RemoveByKey(){
        command = "remove_key";
        helpText = "Удалить элемент из коллекции по его ключу.";
        argumentsCount = 1;
    }

    @Override
    public ArrayList<String> execute(UserInterface userInterface, StorageService ss, String[] args, DataBaseManager dataBaseManager) throws IOException {
        if (args.length == argumentsCount) {
            try {
                CommandsManager.getInstance().getLock().lock();
                long key;
                try {
                    key = Long.parseLong(args[0]);
                } catch (NumberFormatException e) {
                    CommandsManager.getInstance().printToClient("Неправильный формат аргумента");
                    return null;
                }
                Person person = ss.list().get(key);
                if (dataBaseManager.removeFromDataBase(person)){
                    dataBaseManager.updateCollectionFromDataBase(ss);
                    CommandsManager.getInstance().printToClient("Персонаж с key " + key + " успешно удален!");
                } else{
                    CommandsManager.getInstance().printToClient("Персонаж с key " + key + " не найден или он не пренадлежит вам.");
                }
                dataBaseManager.updateCollectionFromDataBase(ss);
                return null;
            } finally {
                CommandsManager.getInstance().getLock().unlock();
            }
        }
        //logger.warn("Команда не были переданы аргументы");
        CommandsManager.getInstance().printToClient("Команда ожидала аргументы.");
        return null;
    }
}

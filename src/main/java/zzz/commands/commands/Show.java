package zzz.commands.commands;

import zzz.collection.helpers.StorageService;
import zzz.commands.CommandsManager;
import zzz.utils.DataBaseManager;
import zzz.utils.UserInterface;

import java.io.IOException;
import java.util.ArrayList;


public class Show extends AbstractCommand{

    public Show(){
        command = "show";
        helpText = "Вывести в стандартный поток вывода все элементы коллекции в строковом представлении.";
    }

    @Override
    public ArrayList<String> execute(UserInterface userInterface, StorageService ss, String[] args, DataBaseManager dataBaseManager) throws IOException {
            if (argumentsCount == args.length) {
                CommandsManager.getInstance().getLock().lock();
                try {
                    CommandsManager.getInstance().printToClient(ss.show());
                    return null;
                } finally {
                    CommandsManager.getInstance().getLock().unlock();
                }
            }
            //logger.warn("Команда не принимает аргументы");
            CommandsManager.getInstance().printToClient("Команда не принимает агрументы!");
            return null;
    }
}

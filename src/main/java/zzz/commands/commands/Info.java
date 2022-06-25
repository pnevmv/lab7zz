package zzz.commands.commands;

import zzz.collection.helpers.StorageService;
import zzz.commands.CommandsManager;
import zzz.utils.DataBaseManager;
import zzz.utils.UserInterface;

import java.io.IOException;
import java.util.ArrayList;


public class Info extends AbstractCommand{

    public Info(){
        command = "info";
        helpText = "Выводит в стандартный потор информацию о коллекции.";
    }

    @Override
    public ArrayList<String> execute(UserInterface userInterface, StorageService ss, String[] args, DataBaseManager dataBaseManager) throws IOException {
        if (argumentsCount == args.length) {
            CommandsManager.getInstance().printToClient(ss.info());
            return null;
        }
        //logger.warn("Команда не принимает аргументы");
        CommandsManager.getInstance().printToClient("Команда не принимает агрументы!");
        return null;
    }
}

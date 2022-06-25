package zzz.commands.commands;

import zzz.collection.helpers.StorageService;
import zzz.utils.DataBaseManager;
import zzz.utils.UserInterface;

import java.io.IOException;
import java.util.ArrayList;


public class Exit extends AbstractCommand {

    public Exit(){
        command = "exit";
        helpText = "Завершение работы программы без сохранения";
    }

    @Override
    public ArrayList<String> execute(UserInterface userInterface, StorageService ss, String[] args, DataBaseManager dataBaseManager) throws IOException {
        System.exit(-1);
        return null;
    }
}

package zzz.commands.commands;

import zzz.collection.helpers.StorageService;
import zzz.utils.DataBaseManager;
import zzz.utils.UserInterface;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;



public class Save extends AbstractCommand {
    private static final String PATH = Paths.get("out.csv").toAbsolutePath().toString();


    public Save(){
        command = "save";
        helpText = "Сохранить коллекцию в файл.";
    }


    @Override
    public ArrayList<String> execute(UserInterface userInterface, StorageService ss, String[] args, DataBaseManager dataBaseManager) throws IOException {
        if (args.length == argumentsCount){
            ss.save(PATH);
            System.out.println("Коллекция сохранена успешно.");
            return null;
        }
        //logger.warn("Команда не принимает аргументы");
        System.out.println("Команда не принимает агрументы!");
        return null;
    }
}

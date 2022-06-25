package zzz.commands.commands;

import zzz.collection.helpers.StorageService;
import zzz.utils.DataBaseManager;
import zzz.utils.UserInterface;

import java.io.IOException;
import java.util.ArrayList;

public class Register extends AbstractCommand {
    @Override
    public ArrayList<String> execute(UserInterface userInterface, StorageService ss, String[] args, DataBaseManager dataBaseManager) throws IOException {
        // Служебная команда
        return null;
    }
}

package zzz.commands.commands;

import zzz.collection.helpers.StorageService;
import zzz.commands.CommandsManager;
import zzz.utils.DataBaseManager;
import zzz.utils.UserInterface;

import java.io.IOException;
import java.util.ArrayList;


public class Help extends AbstractCommand{

    public Help(){
        command = "help";
        helpText = "Выводит справку по доступным командам.";
    }

    @Override
    public ArrayList<String> execute(UserInterface userInterface, StorageService ss, String[] args, DataBaseManager dataBaseManager) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (argumentsCount == args.length) {
            sb.append("Команды:").append("\n");
            for (AbstractCommand command : CommandsManager.getInstance().getAllCommands()) {
                sb.append(ANSI_YELLOW).append(command.getCommand()).append(ANSI_RESET).append(": ").append(command.getHelpText()).append("\n");
            }
            CommandsManager.getInstance().printToClient(sb.toString());
            return null;
        }
        //logger.warn("Команда не принимает аргументы");
        CommandsManager.getInstance().printToClient("Команда не принимает агрументы!");
        return null;
    }
}

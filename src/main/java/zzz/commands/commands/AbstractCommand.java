package zzz.commands.commands;

import zzz.collection.collection.Person;
import zzz.collection.helpers.StackPersonStorageService;
import zzz.collection.helpers.StorageService;
import zzz.exceptions.InvalidCountOfArgumentsException;
import zzz.utils.DataBaseManager;
import zzz.utils.UserInterface;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Абстрактный класс для команд.
 */
public abstract class AbstractCommand implements Serializable {
    protected static final String ANSI_RESET = "\u001B[0m";
    protected static final String ANSI_BLACK = "\u001B[30m";
    protected static final String ANSI_RED = "\u001B[31m";
    protected static final String ANSI_GREEN = "\u001B[32m";
    protected static final String ANSI_YELLOW = "\u001B[33m";
    protected static final String ANSI_BLUE = "\u001B[34m";
    protected static final String ANSI_PURPLE = "\u001B[35m";
    protected static final String ANSI_CYAN = "\u001B[36m";
    protected static final String ANSI_WHITE = "\u001B[37m";

    protected String command;
    protected String helpText;
    protected int argumentsCount = 0;
    protected boolean needObjectToExecute = false;
    protected String[] args;
    protected Person person;

    public String getCommand(){
        return command;
    }

    public String getHelpText(){
        return helpText;
    }

    public abstract ArrayList<String> execute(UserInterface userInterface, StorageService ss, String[] args, DataBaseManager dataBaseManager) throws IOException;{
    }

    public boolean isNeedObjectToExecute() {
        return needObjectToExecute;
    }

    public void setPerson(Person person, StackPersonStorageService storage) {
        storage.setPersons(person);
    }

    public void setArgs(String[] args) throws InvalidCountOfArgumentsException {
        this.args = args;
    }

    public String[] getArgs(){
        return args;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson(){
        return person;
    }
}

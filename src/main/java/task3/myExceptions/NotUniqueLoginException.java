package task3.myExceptions;

import task3.controllers.InputNotebookRecord;

public class NotUniqueLoginException extends Exception {
    private InputNotebookRecord record;
    public NotUniqueLoginException(String message, InputNotebookRecord record) {
        super(message);
        this.record = record;
    }

    public InputNotebookRecord getDataFromRecord() {
        return record;
    }
}

package task3.controllers;

import jdk.internal.util.xml.impl.Input;
import task3.models.Actions;
import task3.models.RecordBook;
import task3.models.PhoneRecord;
import task3.views.TextConstants;
import task3.views.View;

import java.util.Date;
import java.util.Scanner;

public class Controller {
    private RecordBook model;
    private View view;
    private Scanner sc = new Scanner(System.in);

    public Controller(RecordBook model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Whole application loop
     */
    public void processUser() {
        while (true) {
            //view.printMessage(TextConstants.ASK_USER);
            Actions act = inputAction();
            if (act == Actions.INPUT_NEW_USER) {
                InputNotebookRecord inr = createRecord();
                model.addRecord(new PhoneRecord(inr));
                view.printMessage(TextConstants.SUCCESS_ADD);
            } else if (act == Actions.SEE_ALL_USERS) {
                view.printList(model.getRecords());
            }
        }
    }

    /**
     * Creating and fulfilling new record
     * @return
     */
    private InputNotebookRecord createRecord() {
        InputNotebookRecord record = new InputNotebookRecord();
        record.setLastname(inputValidStringWithScanner(TextConstants.INP_LASTNAME, RegexContainer.NAME_REGEXP));
        record.setFirstname(inputValidStringWithScanner(TextConstants.INP_FIRSTNAME, RegexContainer.NAME_REGEXP));
        record.setNickname(inputValidStringWithScanner(TextConstants.INP_NICKNAME, RegexContainer.NICKNAME_REGEXP));
        record.setComment(inputValidStringWithScanner(TextConstants.INP_COMMENT, RegexContainer.COMMENT_REGEXP));
        record.setHomePhoneNumber(inputValidStringWithScanner(TextConstants.INP_HOME_PHONE, RegexContainer.HOME_PHONE_REGEXP));
        record.setMobilePhoneNumber(inputValidStringWithScanner(TextConstants.INP_MOBILE_PHONE, RegexContainer.MOBILE_PHONE_REGEXP));
        record.setEmail(inputValidStringWithScanner(TextConstants.INP_EMAIL, RegexContainer.EMAIL_REGEXP));
        return record;
    }

    /**
     * Ask user what to do
     * @return Actions
     */
    private Actions inputAction() {
        Actions action = null;
        String input = "";
        view.printMessage(TextConstants.ASK_USER);
        while (!(sc.hasNext() && (input = sc.next()).matches("[al]]"))) {
            //input = sc.next();
            if (input.equalsIgnoreCase("a")) {
                action = Actions.INPUT_NEW_USER;
            } else if (input.equalsIgnoreCase("l")) {
                action = Actions.SEE_ALL_USERS;
            }
        }
        return action;
    }

    /**
     * Validate input according to specific regex
     * @param message
     * @param regex
     * @return
     */
    private String inputValidStringWithScanner(String message, String regex) {
        String res;
        view.printMessage(message);
        while (!(sc.hasNext() && (res = sc.next()).matches(regex))) {
            view.printWrongInput();
            view.printMessage(message);
        }
        return res;
    }
}

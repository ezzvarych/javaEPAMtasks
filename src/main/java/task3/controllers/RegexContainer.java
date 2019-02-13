package task3.controllers;

public interface RegexContainer {
    String NAME_REGEXP = "[A-Z][a-z]*[-a-z]?[a-z]+";
    String NICKNAME_REGEXP = "\\w+";
    String COMMENT_REGEXP = ".+";
    String HOME_PHONE_REGEXP = "[0-9]{3,7}";
    String MOBILE_PHONE_REGEXP = "0[0-9]{9}";
    String EMAIL_REGEXP = "^[-\\w\\+]+(\\.[-\\w]+)*@\\w+(\\.\\w+)*(\\.[A-Za-z]{2,})$";

}

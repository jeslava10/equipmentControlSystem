package work.appdeploys.equipmentcontrolsystem.constants;

public enum MessageResource {
   SCHOOL_EXIST_NOT_SAVE("The School not exist, cant be save order"),
   SCHOOL_SAVED("The School saved"),
   SCHOOL_UPDATE("The School update"),
   SCHOOL_DELETED("The School as deleted"),
   SCHOOLS_LISTED("The all Schools as listed"),
   SCHOOL_SELECTED("The School as listed"),
   SCHOOLS_NOT_EXIST_RECORDS("Not exist records of schools"),
   SCHOOL_NOT_EXIST_NOT_DELETE("The School no exist, cant be delete"),
   SCHOOL_NOT_EXIST_NOT_UPDATE("The School no exist, cant be update"),
   SCHOOL_EXIST_NAME_NOT_UPDATE("The School name already exist, cant be update"),
   USER_SAVED("The user as saved"),
   USER_UPDATED("The user as updated"),
   USER_DELETED("The user as deleted"),
   USERS_LISTED("The all users as listed"),
   USER_LISTED("The user as listed"),
   USER_BAT_EMAIL("You entered an incorrect email address, cant be save"),
   USER_BAT_PASSWORD("You entered an incorrect password" +
            "the password must contain: \n" +
            "1. start of the \n" +
            "2. a digit must occur at least once \n" +
            "3. a lower case letter must occur at least once \n" +
            "4. an upper case letter must occur at least once \n" +
            "5. 4-8 character password, both inclusive \n" +
            "cant be save"),
   USER_BAT_ROL("Bat rol, cant be save"),
   USERS_EXIST_NOT_SAVE("The user already exist, cant be save"),
   USERS_EXIST_NOT_DELETE("The user no exist, cant be delete"),
   USERS_NOT_EXIST_NOT_UPDATE("The user no exist, cant be update"),
   USERS_EMAIL_ALREADY_EXIST_NOT_UPDATE("The email alredy exist in the other user, cant be update"),
   USERS_EMAIL_ALREADY_EXIST_NOT_SAVE("The email alredy exist in the other user, cant be save"),
   UPDATE_FAIL(", cant by update"),
   ORDER_SAVED("The order as saved"),
   ORDER_NOT_EXIST_RECORD("Not exist records of orders"),
   ORDER_NUNBER_NOT_EXIST_RECORD("Not exist records of order number"),
   ORDER_TMP_DIRECTORY("Error to make a directory temporal to Excel"),
   ORDER_NUNBER_NOT_EXIST_RECORD_DATE("Not exist records of order number in this date"),
   ORDER_UPDATED("The order as updated"),
   ORDER_NUMBER_LISTED("The records for order number as listed"),
   ORDER_LISTED("The order as listed"),
   ORDER_EXCEL_GENERATE("The order excel as gemerated"),
   ORDERS_DELETED("The order as deleted"),
   ORDERS_LISTED("The all orders as listed"),
   USERS_NOT_EXIST_RECORDS("Not exist records of users"),
   USERS_NOT_EXIST_RECORDS_EMAIL("Not exist records of users by this email"),
   USER_CREATE_ORDER_NOT_EXIST_NOT_SAVE("The user create no exist, cant be save"),
   USER_MOD_ORDER_NOT_EXIST_NOT_SAVE("The user modification no exist, cant be save"),
   DATA_USER_CREATE_NOT_VALID_NOT_SAVE("The user create no exist, cant be save"),
   DATA_USER_CREATE_NOT_VALID_NOT_UPDATE("The user create no exist, cant be update"),
   ORDER_ALREADY_EXIST_NOT_SAVE("The order alredy exist, cant be save"),
   ORDER_NOT_EXIST_NOT_DELETE("The order no exist, cant be delete"),
   ORDER_NOT_EXIST_NOT_UPDATE("The order no exist, cant be update"),
   ORDER_DATE_INVALID_NOT_SAVE("The date time is invalid, cant be update"),
   DIARY_TIME_START_INVALID_NOT_SAVE("The start hour is invalid, cant be update"),
   DIARY_TIME_ENDING_INVALID_NOT_SAVE("The ending hour is invalid, cant be update"),
   DIARY_WEEKDAY_INVALID_NOT_SAVE("The weekday is invalid, cant be update"),
   DIARY_REPLACEMENT_INVALID_NOT_SAVE("The replacement is invalid, cant be update"),
   DIARY_NOT_EXIST_NOT_DELETE("The diary no exist, cant be delete"),
   DIARY_NOT_EXIST_NOT_UPDATE("The diary no exist, cant be update"),
   DIARY_NOT_EXIST_RECORD("Not exist records of diary"),
   DIARY_EXIST_NOT_SAVE("The diary already exist, cant be save"),
   DIARY_SAVED("The diary as saved"),
   DIARY_UPDATE("The diary update"),
   DIARY_SELECTED("The diary as listed"),
   DIARY_NOT_EXIST_RECORDS("Not exist records of diarys"),
   DIARY_DELETED("The diary as deleted"),
   DIARY_LISTED("The all diary as listed"),
   USER_NOT_EXIST_RECORD("Not exist records by user id"),
   DIARY_SELECTED_USER("The diary as listed by user id"),
   SCHOOL_STATUS_NOT_EXIST_RECORD("Not exist records by school/status"),
   TOKEN_NOT_EXIST("The token does not exist"),
   TOKEN_EMAIL_IS_NULL("Error generating access token, username is null");

    private String value;

    public String getValue()
    {
        return this.value;
    }
    MessageResource(String value)
    {
        this.value = value;
    }

}

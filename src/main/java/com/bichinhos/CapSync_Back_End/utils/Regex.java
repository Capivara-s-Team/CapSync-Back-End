package com.bichinhos.CapSync_Back_End.utils;


public class Regex {

    public static final String PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).*$";

    public static final String LINKEDIN = "^www\\.linkedin\\.com/in/[a-zA-Z0-9-]+$";

    public static final String DISCORD = "^[a-zA-Z0-9._-]{2,32}#[0-9]{4}$";

    public static final String ASSETS_PATHS = "^src/assets/\\w+\\d*\\w*\\.((png)|(jpeg)|(svg))$";

    public static final String CELLPHONE_REGEX = "^\\+55\\s\\d{2}\\s\\d{5}\\s\\d{4}$";
}

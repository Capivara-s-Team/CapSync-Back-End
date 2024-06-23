package com.bichinhos.CapSync_Back_End.utils;


public class Regex {

    public static final String PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).*$";

    public static final String CELLPHONE = "^\\+\\d{1,3}[\\s\\-\\.]?\\(?>\\d{1,4}\\)?[\\s\\-\\.]?\\d{4,10}[\\s\\-\\.]?\\d{0,10}$";

    public static final String LINKEDIN = "^www\\.linkedin\\.com/in/[a-zA-Z0-9-]+$";

    public static final String DISCORD = "^[a-zA-Z0-9._-]{2,32}#[0-9]{4}$";

    public static final String ASSETS_PATHS = "^src/assets/\\w+\\d*\\w*\\.((png)|(jpeg)|(svg))$";
}

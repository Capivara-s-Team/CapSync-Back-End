package com.bichinhos.CapSync_Back_End.utils;

import org.springframework.stereotype.Component;


public class Regex {

    public static final String PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    public static final String CELLPHONE = "^\\+(\\d{1,3})\\s?(\\d{2,3})\\s?\\d{8,9}$\n";

    public static final String LINK = "^https:\\\\/\\\\/(www\\\\.)?linkedin\\\\.com\\\\/.*$";

    public static final String DISCORD = "^[a-zA-Z0-9._-]{2,32}#[0-9]{4}$";

    public static final String ONLY_LETTERS = "/^[/p{L}\s.,'’´~-]+$/u";

}

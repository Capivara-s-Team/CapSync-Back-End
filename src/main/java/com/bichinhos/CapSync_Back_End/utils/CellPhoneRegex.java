//package com.bichinhos.CapSync_Back_End.utils;
//
//import com.bichinhos.CapSync_Back_End.dto.request.UserRequest;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CellPhoneRegex {
//
//    public static final String CELLPHONE_PORTUGAL = "^\\+351\\s\\d{3}\\s\\d{3}\\s\\d{3}$";
//
//    public static final String CELLPHONE_USA = "^\\+1\\s\\(\\d{3}\\)\\s\\d{3}-\\d{4}$";
//
//    public String validatePhoneNumber(UserRequest userRequest) {
//        String CELLPHONE_REGEX = "";
//        String[] cellPhoneSplited = userRequest.getCellphone().split(" ");
//        for (int i = 0; i < cellPhoneSplited.length; i++) {
//            if (cellPhoneSplited[0].equals("+351") && userRequest.getCellphone().matches(CELLPHONE_PORTUGAL)){
//                CELLPHONE_REGEX = CELLPHONE_PORTUGAL;
//                return CELLPHONE_REGEX;
//            } else if (cellPhoneSplited[0].equals("+1") && userRequest.getCellphone().matches(CELLPHONE_USA)) {
//                CELLPHONE_REGEX = CELLPHONE_USA;
//                return CELLPHONE_REGEX;
//            }
//        }
//        return CELLPHONE_REGEX;
//    }
//}

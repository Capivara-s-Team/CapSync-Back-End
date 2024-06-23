package com.bichinhos.CapSync_Back_End.utils;

import com.bichinhos.CapSync_Back_End.dto.request.UserRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class CellPhoneRegex {

    public String validatePhoneNumber(UserRequest userRequest) {
        return userRequest.getCellphone();
    }
}

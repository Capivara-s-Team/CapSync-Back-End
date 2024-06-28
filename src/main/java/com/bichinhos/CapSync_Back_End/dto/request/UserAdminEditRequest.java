package com.bichinhos.CapSync_Back_End.dto.request;

import com.bichinhos.CapSync_Back_End.enumFields.Role;
import com.bichinhos.CapSync_Back_End.enumFields.Status;

public record UserAdminEditRequest(

        Status status,

        Role roleDesired

        //todo:Colocar a Squad
)
{}

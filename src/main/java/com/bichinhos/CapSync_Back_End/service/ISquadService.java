package com.bichinhos.CapSync_Back_End.service;

import com.bichinhos.CapSync_Back_End.dto.request.SquadRequest;
import com.bichinhos.CapSync_Back_End.dto.response.SquadResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ISquadService {

    SquadResponse createSquad(SquadRequest squadRequest);
    SquadResponse getSquadById(Long id);
    Page<SquadResponse> getAll(Pageable pageable);
    SquadResponse updateSquadById(Long id, SquadRequest squadRequest);
    void deleteSquadById(Long id);


}

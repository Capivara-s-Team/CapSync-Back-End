package com.bichinhos.CapSync_Back_End.service.impl;

import com.bichinhos.CapSync_Back_End.dto.mapper.SquadMapper;
import com.bichinhos.CapSync_Back_End.dto.request.SquadRequest;
import com.bichinhos.CapSync_Back_End.dto.response.SquadResponse;
import com.bichinhos.CapSync_Back_End.entity.SquadEntity;
import com.bichinhos.CapSync_Back_End.repository.ISquadRepository;
import com.bichinhos.CapSync_Back_End.service.ISquadService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SquadServiceImpl implements ISquadService {

    private final ISquadRepository iSquadRepository;

    @Override
    public SquadResponse createSquad(SquadRequest squadRequest) {

        Optional<SquadEntity> squadOptional = iSquadRepository.findByName(squadRequest.name());

        if (squadOptional.isPresent()){
            throw new RuntimeException("Stack already exists");
        }

        SquadEntity squad = SquadMapper.transformRequestToEntity(squadRequest);
        SquadEntity squadSaved = iSquadRepository.save(squad);

        return SquadMapper.transformEntityToResponse(squadSaved);
    }

    @Override
    public SquadResponse getSquadById(Long id) {

        SquadEntity squad = findByIdOrThrowException(id);
        return SquadMapper.transformEntityToResponse(squad);
    }

    @Override
    public Page<SquadResponse> getAll(Pageable pageable) {

        Page<SquadEntity> squads = iSquadRepository.findAll(pageable);
        return squads.map(SquadMapper::transformEntityToResponse);
    }

    @Override
    public SquadResponse updateSquadById(Long id, SquadRequest squadRequest) {

        SquadEntity squad = findByIdOrThrowException(id);

        if (squadRequest.name() != null){
            squad.setName(squadRequest.name());
        }

        SquadEntity squadUpdated = iSquadRepository.save(squad);

        return SquadMapper.transformEntityToResponse(squadUpdated);
    }

    @Override
    public void deleteSquadById(Long id) {
        findByIdOrThrowException(id);
        iSquadRepository.deleteById(id);
    }

    private SquadEntity findByIdOrThrowException(Long id){
        Optional<SquadEntity> squadOptional = iSquadRepository.findById(id);
        return squadOptional.orElseThrow(EntityNotFoundException::new);
    }
}

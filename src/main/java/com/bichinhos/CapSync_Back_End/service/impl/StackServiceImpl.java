package com.bichinhos.CapSync_Back_End.service.impl;

import com.bichinhos.CapSync_Back_End.dto.mapper.StackMapper;
import com.bichinhos.CapSync_Back_End.dto.request.StackRequest;
import com.bichinhos.CapSync_Back_End.dto.response.StackResponse;
import com.bichinhos.CapSync_Back_End.entity.StackEntity;
import com.bichinhos.CapSync_Back_End.repository.IStackRepository;
import com.bichinhos.CapSync_Back_End.service.IStackService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StackServiceImpl implements IStackService {

    private final IStackRepository iStackRepository;

    @Override
    public StackResponse createStack(StackRequest stackRequest) {

        StackEntity stackEntity = StackMapper.transformRequestToEntity(stackRequest);
        StackEntity stackSaved = iStackRepository.save(stackEntity);

        return StackMapper.transformEntityToResponse(stackSaved);
    }

    @Override
    public Page<StackResponse> getAllUsers(Pageable pageable) {

        Page<StackEntity> stacks = iStackRepository.findAll(pageable);
        return stacks.map(StackMapper::transformEntityToResponse);
    }

    @Override
    public StackResponse getUserById(Long id) {

        StackEntity stackEntity = findByIdOrThrowException(id);

        return StackMapper.transformEntityToResponse(stackEntity);
    }

    @Override
    public StackResponse updateEntityById(Long id, StackRequest stackRequest) {

        StackEntity stackEntity = findByIdOrThrowException(id);

        stackEntity.setName(stackRequest.name());

        StackEntity stackEntitySaved = iStackRepository.save(stackEntity);

        return StackMapper.transformEntityToResponse(stackEntitySaved);
    }

    @Override
    public void deleteEntityById(Long id) {
        iStackRepository.deleteById(id);
    }

    private StackEntity findByIdOrThrowException(Long id){

        Optional<StackEntity> optionalStack = iStackRepository.findById(id);

        return optionalStack.orElseThrow(() ->
                new EntityNotFoundException("Stack de ID " + id + " não encontrado.")
        );
    }
}

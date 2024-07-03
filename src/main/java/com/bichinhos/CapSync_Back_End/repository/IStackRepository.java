package com.bichinhos.CapSync_Back_End.repository;

import com.bichinhos.CapSync_Back_End.entity.StackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStackRepository extends JpaRepository<StackEntity, Long> {

    Optional<StackEntity> findByName(String name);
}

package com.bichinhos.CapSync_Back_End.repository;

import com.bichinhos.CapSync_Back_End.entity.SquadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISquadRepository extends JpaRepository<SquadEntity, Long> {

    Optional<SquadEntity> findByName(String name);

}

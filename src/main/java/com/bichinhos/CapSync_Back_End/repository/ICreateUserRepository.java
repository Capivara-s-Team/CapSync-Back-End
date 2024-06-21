package com.bichinhos.CapSync_Back_End.repository;

import com.bichinhos.CapSync_Back_End.entity.UserEntity;
import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreateUserRepository extends JpaRepository<UserEntity, UUID> {
}
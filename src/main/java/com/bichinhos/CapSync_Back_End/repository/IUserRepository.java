package com.bichinhos.CapSync_Back_End.repository;

import com.bichinhos.CapSync_Back_End.entity.UserEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, UUID> {
}
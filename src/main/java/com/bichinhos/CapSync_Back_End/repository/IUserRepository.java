package com.bichinhos.CapSync_Back_End.repository;

import com.bichinhos.CapSync_Back_End.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, UUID> {
    UserDetails findByEmail(String email);
    @Query("SELECT u FROM UserEntity u WHERE u.email = :email")
    UserEntity findByEmailToGetEntity(@Param("email") String email);
    @Query("SELECT u FROM UserEntity u WHERE u.name = :name")
    Optional<UserEntity> findByName(@Param("name") String name);
}
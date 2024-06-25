package com.bichinhos.CapSync_Back_End.entity;

import com.bichinhos.CapSync_Back_End.enumFields.Gender;
import com.bichinhos.CapSync_Back_End.enumFields.Seniority;
import com.bichinhos.CapSync_Back_End.enumFields.Status;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String surname;

    @Column(unique = true)
    private String email;

    private String password;

    private String cellphone;

    private String squad;

    private String role;

    @Column(unique = true)
    private String linkedin;

    @Column(unique = true)
    private String discord;

    @Column(unique = true)
    private String userPhoto;

    private String autoRacialDeclaration;

    private Status status;

    private Gender gender;

    private Seniority seniority;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;
}

package com.bichinhos.CapSync_Back_End.entity;

import com.bichinhos.CapSync_Back_End.enumFields.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;
    @Column(unique = true)

    private String cellphone;
    @Enumerated(EnumType.STRING)
    private EnumSquad enumSquad;
    @Enumerated(EnumType.STRING)
    private EnumRole enumRole;

    @Column(unique = true)
    private String linkedin;

    @Column(unique = true)
    private String discord;

    @Column(unique = true)
    private String userPhoto;

    private String autoDeclaration;

    private EnumGender enumGender;

    private EnumStatus enumStatus;

    private EnumSeniority enumSeniority;

    private Instant createdAt;

    private Instant updatedAt;
}

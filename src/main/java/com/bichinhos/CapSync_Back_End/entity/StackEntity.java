package com.bichinhos.CapSync_Back_End.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Data
@Builder
@Table(name = "stack")
public class StackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updateAt;

}

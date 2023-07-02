package com.inventorymanagement.commonservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

}

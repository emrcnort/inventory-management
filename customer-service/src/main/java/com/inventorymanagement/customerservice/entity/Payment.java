package com.inventorymanagement.customerservice.entity;

import com.inventorymanagement.commonservice.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
public class Payment extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

}

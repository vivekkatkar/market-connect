package com.example.marketconnect.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "shops")
@Getter
@Setter
@NoArgsConstructor
public class Shop {
    private Long id;
    private String name;
    private String latitude;
    private String longitude;

    @Column(name = "owner_email")
    private String ownerEmail;

    @Column(name = "owner_mobile")
    private String ownerMobile;
}

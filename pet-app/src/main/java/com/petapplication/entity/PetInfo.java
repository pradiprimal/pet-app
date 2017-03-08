package com.petapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.petapplication.utility.ModelBase;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pet_info")
@Getter
@Setter
public class PetInfo extends ModelBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @Column(name = "owner_no", nullable = false)
    private String ownerNo;

    @Column(name = "owner_email", nullable = false)
    private String ownerEmail;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "image_path", nullable = true)
    private String imagePath;

    @Column(name = "status", nullable = false)
    private Character status;

}

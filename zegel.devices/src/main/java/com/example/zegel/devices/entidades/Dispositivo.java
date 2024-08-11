package com.example.zegel.devices.entidades;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TP_DISPOSITIVOS")
public class Dispositivo

{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClaim;
    private boolean estado;
    private String brand;

    public Long getIdClaim() {
        return idClaim;
    }

    public void setIdClaim(Long idClaim) {
        this.idClaim = idClaim;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    private String model;
    private String serial;
    private String osVersion;

    @Temporal(TemporalType.DATE)
    private Date date_create;



    // Getters and setters

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public Date getDate_create() {
        return date_create;
    }

    public void setDate_create(Date date_create) {
        this.date_create = date_create;
    }

}


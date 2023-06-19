package com.webtech.project.demo.web.persistence;


import jakarta.persistence.*;

@Entity(name = "shopitems")
public class ShopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "artikel_name")
    private String artikelName;
    @Column(name = "ware_vorhanden")
    private boolean wareVorhanden;

    public ShopEntity( String artikelName, boolean wareVorhanden) {
        this.artikelName = artikelName;
        this.wareVorhanden = wareVorhanden;
    }

    protected  ShopEntity(){}

    public long getId() {
        return id;
    }

    public String getArtikelName() {
        return artikelName;
    }

    public void setArtikelName(String artikelName) {
        this.artikelName = artikelName;
    }

    public boolean getWareVorhanden() {
        return wareVorhanden;
    }

    public void setWareVorhanden(boolean wareVorhanden) {
        this.wareVorhanden = wareVorhanden;
    }
}

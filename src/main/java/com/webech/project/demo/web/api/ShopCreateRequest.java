package com.webech.project.demo.web.api;

public class ShopCreateRequest {

    private long id;
    private String artikelName;
    private boolean wareVorhanden;

    public ShopCreateRequest(long id, String artikelName, boolean wareVorhanden) {
        this.id = id;
        this.artikelName = artikelName;
        this.wareVorhanden = wareVorhanden;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArtikelName() {
        return artikelName;
    }

    public void setArtikelName(String artikelName) {
        this.artikelName = artikelName;
    }

    public boolean isWareVorhanden() {
        return wareVorhanden;
    }

    public void setWareVorhanden(boolean wareVorhanden) {
        this.wareVorhanden = wareVorhanden;
    }
}

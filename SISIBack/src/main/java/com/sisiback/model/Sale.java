package com.sisiback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Sale {

    @Id
    private int numeroServicio;
    private String nombreItem;
    private int cantidad;
    private String servicio;
    private int descuento;
    private float precio;
    private float totalSinDescuento;
    private float totalConDescuento;

    public int getNumeroServicio() {
        return numeroServicio;
    }

    public void setNumeroServicio(int numeroServicio) {
        this.numeroServicio = numeroServicio;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getTotalSinDescuento() {
        return totalSinDescuento;
    }

    public void setTotalSinDescuento(float totalSinDescuento) {
        this.totalSinDescuento = totalSinDescuento;
    }

    public float getTotalConDescuento() {
        return totalConDescuento;
    }

    public void setTotalConDescuento(float totalConDescuento) {
        this.totalConDescuento = totalConDescuento;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "numeroServicio=" + numeroServicio +
                ", nombreItem='" + nombreItem + '\'' +
                ", cantidad=" + cantidad +
                ", servicio='" + servicio + '\'' +
                ", descuento=" + descuento +
                ", precio=" + precio +
                ", totalSinDescuento=" + totalSinDescuento +
                ", totalConDescuento=" + totalConDescuento +
                '}';
    }
}

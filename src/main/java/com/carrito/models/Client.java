package com.carrito.models;

public class Client extends Carrito {
    private Carrito car;

    public Carrito getCar() {
        return car;
    }

    public void setCar(Carrito car) {
        this.car = car;
    }

    public Client(String nombre) {
        super(nombre);
    }
}

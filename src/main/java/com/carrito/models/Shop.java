package com.carrito.models;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Shop {
    private Stack<Carrito> carritosDisponibles; // definimos una pila
    private Queue<Client> f1; // definimos una cola
    private Queue<Client> f2; // definimos una cola
    private Queue<Client> filaEspera; // definimos una cola

    public Shop() {
        this.carritosDisponibles = new Stack<Carrito>();
        this.f1 = new LinkedList<Client>();
        this.f2 = new LinkedList<Client>();
        this.filaEspera = new LinkedList<Client>();
    }

    public void iniciarSimulacionStackAndQueue() {
        // Llenar la pila de carritos
        for (int i = 1; i <= 5; i++) {
            Carrito car = new Carrito("Carrito " + i);
            carritosDisponibles.push(car);
            System.out.println("se creo el carrito" + car.getNombre());
        }

        // Simular la llegada de clientes
        for (int i = 1; i <= 7; i++) {
            Client cliente = new Client("Cliente " + i);

            // Verificar qué fila tiene menos clientes y agregar el cliente a esa fila
            if (!carritosDisponibles.isEmpty()) {
                if (f1.size() < f2.size()) {
                    f1.offer(cliente); // no arroja un error si esta llena la cola
                    // f1.add(cliente); // arroja una excepcion si esta llena la cola
                } else {
                    f2.offer(cliente);
                }

                // Tomar un carrito de la pila
                Carrito carrito = carritosDisponibles.pop();
                cliente.setCar(carrito); // se le asigna el carrito al cliente
                System.out.println(cliente.getNombre() + " tomó el carrito " + carrito.getNombre());
            } else {
                System.out.println(String.format("El Cliente %s debe hacer cola", cliente.getNombre()));
                filaEspera.offer(cliente);
            }

        }

        // Mostrar el estado final de las filas y los carritos disponibles
        System.out.println("Estado final:");
        System.out.println("Fila 1 tiene: " + f1.size());
        System.out.println("Fila 2 tiene: " + f2.size());
        System.out.println("Fila de espera tiene: " + filaEspera.size());
        System.out.println("Carritos disponibles: " + carritosDisponibles.size());
    }
}

package org.jpcrown.ejemplos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class EjemploVuelo {
    static void main(String[] args) throws ParseException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        List<Vuelo> llegadas = new ArrayList<>();

        llegadas.add(new Vuelo("AAL 933", "New York", "Santiago", df.parse("2021-08-29 05:39"), 62));
        llegadas.add(new Vuelo("LAT 755", "Sao Paulo", "Santiago", df.parse("2021-08-31 04:45"), 47));
        llegadas.add(new Vuelo("SKU 621", "Rio De Janeiro", "Santiago", df.parse("2021-08-30 16:00"), 52));
        llegadas.add(new Vuelo("DAL 147", "Atlanta", "Santiago", df.parse("2021-08-29 13:22"), 59));
        llegadas.add(new Vuelo("AVA 241", "Bogota", "Santiago", df.parse("2021-08-31 14:05"), 25));
        llegadas.add(new Vuelo("AMX 10", "Mexico City", "Santiago", df.parse("2021-08-31 05:20"), 29));
        llegadas.add(new Vuelo("IBE 6833", "Londres", "Santiago", df.parse("2021-08-30 08:45"), 55));
        llegadas.add(new Vuelo("LAT 2479", "Frankfurt", "Santiago", df.parse("2021-08-29 07:41"), 51));
        llegadas.add(new Vuelo("SKU 803", "Lima", "Santiago", df.parse("2021-08-30 10:35"), 48));
        llegadas.add(new Vuelo("LAT 533", "Los Ángeles", "Santiago", df.parse("2021-08-29 09:14"), 59));
        llegadas.add(new Vuelo("LAT 1447", "Guayaquil", "Santiago", df.parse("2021-08-31 08:33"), 31));
        llegadas.add(new Vuelo("CMP 111", "Panama City", "Santiago", df.parse("2021-08-31 15:15"), 29));
        llegadas.add(new Vuelo("LAT 705", "Madrid", "Santiago", df.parse("2021-08-30 08:14"), 47));
        llegadas.add(new Vuelo("AAL 957", "Miami", "Santiago", df.parse("2021-08-29 22:53"), 60));
        llegadas.add(new Vuelo("ARG 5091", "Buenos Aires", "Santiago", df.parse("2021-08-31 09:57"), 32));
        llegadas.add(new Vuelo("LAT 1283", "Cancún", "Santiago", df.parse("2021-08-31 04:00"), 35));
        llegadas.add(new Vuelo("LAT 579", "Barcelona", "Santiago", df.parse("2021-08-29 07:45"), 61));
        llegadas.add(new Vuelo("AAL 945", "Dallas-Fort Worth", "Santiago", df.parse("2021-08-30 07:12"), 58));
        llegadas.add(new Vuelo("LAT 501", "París", "Santiago", df.parse("2021-08-29 18:29"), 49));
        llegadas.add(new Vuelo("LAT 405", "Montevideo", "Santiago", df.parse("2021-08-30 15:45"), 39));


        llegadas.sort((v1, v2) -> v2.getFechaLlegada().compareTo(v1.getFechaLlegada()));

        llegadas.forEach(IO::println);
        Vuelo ultimoVuelo = llegadas.get(0); //le pone 0 porque invirtio el orden
        System.out.println("El último vuelo en llegar es " + ultimoVuelo.getNombre() + ": " + ultimoVuelo.getOrigen() + ", aterriza el " + ultimoVuelo.getFechaLlegada());

        //como en los tipos primitivos no puedo usar compareTo (cantidadPasajeros lo es) entonces debo utilizar el met de una clase wrapper Integer.valueOf
        //o usamos el metodo de referencia con Comparator
        System.out.println("========================================Ordenando por cantidad de pasajeros");
        llegadas.sort(Comparator.comparingInt(Vuelo::getCantidadPasajeros).reversed());
        llegadas.forEach(IO::println);

        //Creamos una variable del tipo linkedlist para usar el metodo peeklast
        Vuelo menorNumeroPasajeros = new LinkedList<>(llegadas).peekLast();
        System.out.println("El vuelo con menor número de pasajeros es " + menorNumeroPasajeros.getNombre() + ": " + menorNumeroPasajeros.getOrigen()+ ", con " + menorNumeroPasajeros.getCantidadPasajeros() + " pasajeros.");

    }
}

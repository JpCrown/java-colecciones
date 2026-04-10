package org.jpcrown.ejemplos.list;

import org.jpcrown.ejemplos.modelo.Alumno;

import java.util.*;


public class EjemploListComparableComparator {
    static void main(String[] args) {

        //por defecto, si no ordenamos se listan segun el orden de insercion
        //los list aceptan los duplicados
        /*Comparator no sobrescribe compareTo. Lo que hace es proveer una forma
         alternativa y flexible de comparar objetos, sin depender del
          orden natural que define Comparable.
         */
        List<Alumno> sa = new ArrayList<>();
        sa.add(new Alumno("Alejandro", 5));
        sa.add(new Alumno("Cata", 6));
        sa.add(new Alumno("Lucy", 4));
        sa.add(new Alumno("Jano", 7));
        sa.add(new Alumno("Lucas", 3));
        sa.add(new Alumno("Zeus", 2));
        sa.add(new Alumno("Zeus2", 2));
        sa.add(new Alumno("Lucas", 2));
        sa.add(new Alumno("Seba", 2));

        //para ordenar las listas (arraylist o linkedlist) tenemos varias formas:
        //usando la clase helper Collections (utilizara el orden que establecimos en la clase Alumno en compareTo), en este caso por nota
        //si quiero sobreescribir este comportamiento por defecto, debo utilizar COMPARATOR
        //en el treeset lo usamos en el constructor, aqui en el metodo sort
        //podemos incluso reducir mas el codigo directamente con el metodo sort que tienen los list y el lambda
        //de esta manera sobreescribimos la manera por defecto que establecimos con compareTo
        //podemos lograr que sea descendente invirtiendo las letras
        //pero desde java 8 hay una manera mas practica aun, usando COMPARATOR y lambda
        //o mejor aun con un metodo de referencia
//        Collections.sort(sa, (a,b) -> a.getNota().compareTo(b.getNota()));
//        sa.sort((a, b) -> b.getNota().compareTo(a.getNota()));
//        sa.sort(Comparator.comparing((Alumno a) -> a.getNota()));
        sa.sort(Comparator.comparing(Alumno::getNota));
        System.out.println(sa);


        sa.forEach(IO::println); //metodo de referencia



    }
}

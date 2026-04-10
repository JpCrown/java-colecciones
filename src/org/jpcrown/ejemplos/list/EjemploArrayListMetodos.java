package org.jpcrown.ejemplos.list;

import org.jpcrown.ejemplos.modelo.Alumno;

import java.util.ArrayList;
import java.util.List;


public class EjemploArrayListMetodos {
    static void main(String[] args) {

        //Metodos de los arrayList o linkedlist
        //Size devuelve tamaño de una lista
        //isEmpty devuelve true o false, si esta o no vacia la lista
        //con el add y el indice podemos guardar un elemento en una posicion dada
        //con el uso de set y un indice modificamos un elemento (borrariamos un elemento de la lista)
        List<Alumno> al = new ArrayList<>();
        System.out.println(al + ", size = " + al.size()); // 0
        System.out.println("Esta vacia = " + al.isEmpty()); // true
        al.add(new Alumno("Alejandro", 5));
        al.add(new Alumno("Cata", 6));
        al.add(new Alumno("Lucy", 4));
        al.add(2, new Alumno("Jano", 7)); //movemos a jano a la posicion 2
        al.set(3, new Alumno("Lucas", 3));

        System.out.println(al + ", size = " + al.size()); // 5
        System.out.println("Esta vacia = " + al.isEmpty()); // false

        //metodo remove elimina por instancia o por indice
        //el elemento debe ser identico, si por ejemplo su nota es diferente no eliminaria a Jano
        //por debajo lo busca con el equals, por lo tanto, podemos personalizar nuestro equals y decir porque atributo eliminar
//        al.remove(new Alumno("Jano", 7));
        al.remove(2); //eliminamos a traves del indice
        System.out.println(al + ", size = " + al.size());

        //metodo contains, por debajo usa el equals (podemos sobreescribir el metodo y hacer que busque por la coincidencia que deseemos)
        boolean lista = al.contains(new Alumno("Jano", 7));
        System.out.println("En la lista se encuentra el alumno Jano? = " + lista);

        //convertir esta lista arrayList en un arreglo
        Object[] a = al.toArray();
        for(int i = 0; i < a.length; i++){
            System.out.println("Desde el arreglo = " + a[i]);
        }

    }
}

package org.jpcrown.set;



import java.util.*;

//para ordenar los String o las clases Wrapper no necesitamos implementar las interface comparable
//en cambio para los tipos creados por nosotros si es necesario

public class EjemploHashSetAgregar {
    static void main(String[] args) {

        //no es ordenado, no mantiene ni siquiera el orden de insercion
        //no permite duplicados
        //la velocidad de busqueda es muy rapida, al no tener que iterar x todos los elementos
        //comparten la misma interfaz collection con los list (mismos metodos)
        Set<String> hs = new HashSet<>();
        hs.add("uno");
        hs.add("dos");
        hs.add("tres");
        hs.add("cuatro");
        hs.add("cinco");


        System.out.println(hs);

        hs.add("tres");
        System.out.println(hs);

        //para ordenar un hashSet deberiamos convertirlo en una lista
        //y luego ordenar
        List<String> lista = new ArrayList<>(hs);
        Collections.sort(lista);
        System.out.println(lista);
    }
}

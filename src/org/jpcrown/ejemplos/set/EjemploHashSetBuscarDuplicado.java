package org.jpcrown.ejemplos.set;

import java.util.HashSet;
import java.util.Set;

public class EjemploHashSetBuscarDuplicado {
    static void main(String[] args) {

        //registraremos este arreglo en un set y buscar cual esta duplicado
        String[] peces = {"corvina", "lenguado", "pejerrey", "rovalo", "atun", "lenguado"};

        Set<String> unicos = new HashSet<>();

        //con un for agregamos elementos a nuestro hashSet
        //con el add agregamos y como devuelve una expresion booleana usamos el if
        //para saber si un elemento se encuentra duplicado o no
        //el add siempre devolvera true si en la lista no estaba el elemento (lo agrega con exito)
        //va a ir preguntando uno x uno cada pez, mientras no se encuentre en la lista lo va ir agregando
        for(String pez: peces){
            if(!unicos.add(pez)){ //si esta duplicado entonces ingreso al bloque
                System.out.println("Elemento duplicado: " + pez);
            }
        }

        System.out.println(unicos.size() + " elementos no duplicados: " + unicos);
    }
}

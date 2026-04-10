package org.jpcrown.ejemplos.set;

import java.util.HashSet;
import java.util.Set;

public class EjemploHashSetBuscarDuplicado2 {
    static void main(String[] args) {

       //desde un arreglo con elementos duplicados generaremos 2 set para detectar los duplicados
        //el add del set detecta los duplicados
        String[] peces = {"corvina", "lenguado", "pejerrey", "rovalo", "atun", "lenguado"};

        //creamos un set para los elementos unicos y otro para los duplicados
        Set<String> unicos = new HashSet<>();
        Set<String> duplicados = new HashSet<>();

        for(String pez: peces){
            if(!unicos.add(pez)){ //si esta duplicado entonces ingreso al bloque
                duplicados.add(pez); //aqui se guardan los duplicados solamente
            }
        }
//        unicos.removeAll(duplicados); //elimino todos los elementos duplicados de unicos que aparecen en duplicados
        System.out.println("Unicos: " + unicos);
        System.out.println("Duplicados: " + duplicados);
    }
}

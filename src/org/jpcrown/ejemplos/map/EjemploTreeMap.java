package org.jpcrown.ejemplos.map;

import java.util.*;

public class EjemploTreeMap {
    static void main(String[] args) {

        //por defecto un treeMap va a ordenar las llaves no los valores por orden alfab
        //No pueden existir elementos null en los treeMap
        //obviamente los elementos de direccion no estaran ordenados xq es un hashmap
        //ordenar de forma descendente en el constructor del treeset (compareTo)
        //o con Camparator.reverseOrder
        //Ordenamos por el largo del string Comparator.comparing(String::length) y con reverse si queremos al reves
        Map<String, Object> persona = new TreeMap<>(Comparator.comparing(String::length).reversed());

        //Guardar un elemento (metodo put)
        persona.put("nombre", "John");
        persona.put("apellido", "Doe");
        persona.put("apellidoPaterno", "Doe");
        persona.put("email", "johndoe@gmail.com");
        persona.put("edad", 40);

        Map<String, String> direccion = new HashMap<>();
        direccion.put("pais", "USA");
        direccion.put("estado", "California");
        direccion.put("ciudad", "Santa Barbara");
        direccion.put("calle", "One Street");
        direccion.put("numero", "120");


        persona.put("direccion", direccion);

        System.out.println(persona);


    }
}

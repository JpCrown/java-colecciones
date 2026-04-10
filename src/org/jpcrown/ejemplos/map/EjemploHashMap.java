package org.jpcrown.ejemplos.map;

import java.util.*;

public class EjemploHashMap {
    static void main(String[] args) {

        //Es parte del Api de coleccion de Java
        //no es de la interface collection
        //nos permite almacenar objetos de forma asociativa
        //asociada a un nombre(key), si queremos obtener un obj lo hacemos a traves de la key (metodo get)

        //hashmap esta basado en el algoritmo hashcode
        //no admite duplicados - usa por debajo equals y hashcode
        //no es ordenado, solamente a traves de la llave no del valor
        //acepta null en la key (uno solo no podemos tener null repetidos)
        //las llaves siempre son unicas, el valor si podemos repetirlo
        //si la key se repite siempre tomara la ultima insercion
        //no tiene un orden de insercion
        Map<String, String> persona = new HashMap<>();

        //Guardar un elemento (metodo put)
        persona.put(null, "1234");
        persona.put(null, "12345");
        persona.put("nombre", "John");
        persona.put("apellido", "Doe");
        persona.put("apellidoPaterno", "Doe");
        persona.put("email", "johndoe@gmail.com");
        persona.put("edad", "40");

        System.out.println(persona);

        //obtengo el valor a traves de la llave y el metodo get
        String nombre = persona.get("nombre");
        String apellido = persona.get("apellido");
        System.out.println(nombre);
        System.out.println(apellido);

        //metodo clear, elimina todos los valores asociativos del map

        //metodo remove, retorna el value que tiene guardado
        //elimina a traves de llave y a traves del valor
        //o solamente a traves de la llave
//        String valorApellPaterno = persona.remove("apellidoPaterno");
        boolean b = persona.remove("apellidoPaterno", "Doe");
        System.out.println("Eliminado " + b);
        System.out.println("Persona = " + persona);

        //metodo contains retorna un boolean (por llave o valor)
        boolean isNombre = persona.containsKey("nombre");
        boolean isApellidoPaterno = persona.containsKey("apellidoPaterno");
        boolean isEdad = persona.containsValue("40");
        System.out.println("Esta la llave nombre? " + isNombre);
        System.out.println("Esta la llave apellidoPaterno? " + isApellidoPaterno);
        System.out.println("Existe el valor de 40? " + isEdad);

        System.out.println("========================values");
        //retornar los valores con el metodo values
        //luego iteramos con un for clasico, for each, iterator, lambda, met referencia
        Collection<String> valores = persona.values();

        //iteracion con iterator
        Iterator<String> datos = persona.values().iterator();
        while(datos.hasNext()){
            String datosPersonales = datos.next();
            System.out.println(datosPersonales);
        }

        System.out.println("===============================metododereferencia");
        //iteracion con un metodo de referencia
        valores.forEach(IO::println);

        //metodo keyset obtengo los valores de las llaves
        //itera de cualquiera formas
        Set<String> llaves = persona.keySet();

        System.out.println("============================================forEach");
        //itero con un lambda
        llaves.forEach(key -> {
            System.out.println(key);
        });

        System.out.println("============================================entrySet");
        //iterar llave y valor, a traves del metodo entry de map
        //Entry es una clase inner que esta dentro de Map(embebida)
        //"Inner Class" (o interfaz anidada) se crea dentro de otra porque no tiene sentido que exista sola.
        for (Map.Entry<String, String> par: persona.entrySet()){
            System.out.println(par.getKey() + " => " + par.getValue());
        }

        System.out.println("============================================keySet");
        //con el get obtengo el valor a traves de la llave
        //otra manera de iterar llave y valor
        for (String key: persona.keySet()){
            String valor = persona.get(key);
            System.out.println(key + " => " + valor);
        }

        //Otra manera de iterar el hashmap con llave y valor
        //usando java 8
        System.out.println("=============================================forEach");
        persona.forEach((llave, valor) -> {
            System.out.println(llave + " => " + valor);
        });

        System.out.println("Total = " + persona.size());
        System.out.println("Contiene elementos? " + !persona.isEmpty()); //contiene elementos?

        //Reemplazar una llave con un nuevo valor, esta debe existir
        persona.replace("nombre", "Jp");
        System.out.println(persona);

        //Reemplazamos un nuevo antiguo por uno nuevo
        //si existe el nombre viejo se reemplaza y da true sino false
        boolean esReemplazable = persona.replace("nombre", "Juan", "Jp");
        System.out.println(esReemplazable);
    }
}

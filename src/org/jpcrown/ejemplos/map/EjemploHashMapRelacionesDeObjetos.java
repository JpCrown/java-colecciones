package org.jpcrown.ejemplos.map;

import java.util.*;

public class EjemploHashMapRelacionesDeObjetos {
    static void main(String[] args) {

        //en un map tambien podemos tener relaciones de objetos, asi como
        //en una clase un atributo puede ser del tipo de otra clase
        //podemos tener hashMap anidados, ejem persona tener una direccion
        // y direccion ser un hashMap con sus propios atributos
        //asi como un hashmap contiene string, integer entre los diamantes puede
        //contener otro hashmap, por eso que el hashmap principal tiene que ser del tipo generico
        Map<String, Object> persona = new HashMap<>();

        System.out.println("Contiene elementos? " + !persona.isEmpty());
        //Guardar un elemento (metodo put)
        persona.put(null, "1234");
        persona.put(null, "12345");
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

        //ahora asignamos el objeto direccion al hashmap "persona"
        //ahora igual que  en relaciones de objetos, tenemos un hashmap persona con
        //un atributo direccion (un hashmap dentro de otro hashmap)
        //un hashmap no solamente puede tener anidado otro hashmap, tambien puede tenr una clase o un objeto
        persona.put("direccion", direccion);


        System.out.println(persona);

        //obtengo el valor a traves de la llave y el metodo get
        String nombre = (String) persona.get("nombre");
        String apellido = (String) persona.get("apellido");
        System.out.println(nombre);
        System.out.println(apellido);

        //para trabajar con el elemento direccion(es una hashmap)
        //debemos castear porque es del tipo object
        //tratamiento distinto tanto a la hora de llamar un elemento como a la hora iterar
        Map<String, String> direccionPersona = (Map<String, String>) persona.get("direccion");
        String pais = direccionPersona.get("pais");
        String ciudad = direccionPersona.get("ciudad");
        String barrio = direccionPersona.getOrDefault("barrio", "La Playa"); //con getOrDefault evitamos el null
        System.out.println("El pais de " + nombre + " es " + pais);
        System.out.println("La ciudad de " + nombre + " es " + ciudad);
        System.out.println("El barrio de " + nombre + " es " + barrio);

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
        Collection<Object> valores = persona.values();

        //iteracion con iterator
        Iterator<Object> datos = persona.values().iterator();
        while(datos.hasNext()){
            Object datosPersonales = datos.next();
            System.out.println(datosPersonales);
        }

        System.out.println("===============================metododereferencia");
        //iteracion con un metodo de referencia
        valores.forEach(IO::println);

        //metodo keyset obtengo los valores de las llaves
        //itera de cualquier forma
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
        for (Map.Entry<String, Object> par: persona.entrySet()){

            Object valor = par.getValue();

            if(valor instanceof Map){
                String nom = (String) persona.get("nombre");

                Map<String, String> direccionMap = (Map<String, String>) valor;

                System.out.println("El pais de " + nom + ": " + direccionMap.get("pais"));
                System.out.println("La ciudad de " + nom + ": " + direccionMap.get("ciudad"));
                System.out.println("El estado de " + nom + ": " + direccionMap.get("estado"));
            }else {
                System.out.println(par.getKey() + " => " + valor);
            }
        }

        System.out.println("============================================keySet");
        //con el get obtengo el valor a traves de la llave
        //otra manera de iterar llave y valor
        for (String key: persona.keySet()){
            Object valor = persona.get(key);

            if(valor instanceof Map){//si valor es instancia de Map
                String nom = (String) persona.get("nombre"); //cuando se repite mas de 1 vez la instruccion de llamar el nombre se crea una variable
                Map<String, String> direccionMap = (Map<String, String>) valor;

                for (Map.Entry<String, String> parDir: direccionMap.entrySet()){
                    System.out.println(parDir.getKey() + " => " + parDir.getValue());
                }

            }else {
                System.out.println(key + " => " + valor);
            }
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

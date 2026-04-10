package org.jpcrown.ejemplos.set;

import org.jpcrown.ejemplos.modelo.Alumno;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class EjemploHashSetUnicidad {
    static void main(String[] args) {

        //ejemplo zeus = instancias distintas pero con los mismos valores en sus atributos
        //pero si creo un objeto de la clase alumno de forma separada y lo agrego 2 veces al hashSet
        //serian identicos, es la misma referencia, el mismo objeto que apunta a una misma direccion en la memoria
        //por lo tanto el hashset no lo duplicaria porque el equals compara por referencia
        //hashset compara por el metodo equals

        //como puedo hacer para que hashset no repita los mismos datos?
        //HashSet detecta la unicidad usando el equals y el hashcode (el valor tiene que ser unico)
        //ahora podria tener la misma nota pero distinto nombre y viceversa
        Set<Alumno> sa = new HashSet<>();
        sa.add(new Alumno("Alejandro", 5));
        sa.add(new Alumno("Cata", 6));
        sa.add(new Alumno("Lucy", 4));
        sa.add(new Alumno("Jano", 7));
        sa.add(new Alumno("Lucas", 3));
        sa.add(new Alumno("Zeus", 2));
        sa.add(new Alumno("Zeus2", 2));
        sa.add(new Alumno("Lucas", 2));
        sa.add(new Alumno("Seba", 2));

        System.out.println(sa);

        //3 formas de iterar un set, se aplica al hashset y al treeset
        //forEach: para el set o cualquier tipo de coleccion
        System.out.println("*** Iterando usando un forEach ***");
        for(Alumno a: sa){
            System.out.println(a);
        }

        //Todo coleccion tiene un iterator
        System.out.println("*** Iterando usando while y el iterator ***");
        Iterator<Alumno> it = sa.iterator();
        while (it.hasNext()){ //mientras tenga un siguiente elemento
            Alumno a = it.next();
            System.out.println(a.getNombre());
        }

        //uso de lambda (programacion funcional) para iterar, tambien lo tienes las listas
        System.out.println("*** Iterando usando Stream forEach ***");
        sa.forEach(a -> {
            System.out.println(a.getNombre());
        });

        sa.forEach(IO::println); //metodo de referencia

        //las lista aparte de estas 3 maneras de iterar puede utilizar el for clasico
        //podemos ordenar con sort
        //los set no tienen metodo get por eso no podemos iterar con un for clasico
        //podemos usarlo tambien con linkedlist, igual que el arraylist
        //los linkedlist tambien son ordenados y mantienen el orden en el cual se agregan
//        for(int i = 0; i < sa.size(); i++){
//            Alumno a = sa.get(i);
//            System.out.println(a.getNombre());
//        }

    }
}

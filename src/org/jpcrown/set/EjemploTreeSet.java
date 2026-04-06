package org.jpcrown.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {
    static void main(String[] args) {


        //TreeSet son set ordenados pero de manera natural, alfabetica si son cadenas
        //y numericos en orden natural en forma ascendente pero bueno depende de la forma de ordenami q le demos
        //Desventaja: tienen un costo de rendimiento porque son ordenados al agregar o eliminar
        //no admite duplicados
        //para ordenarlos de forma natural tienen que ser comparables -tienen implementada la interface compareTo- (cadenas, clases wrapper)

        //para ordenar de distintas formas deberias implementar el comparator
        //implementamos al vuelo con una clase anonima o expresiones lambda
        //estoy dando vuelta el ordenamiento natural del TreeSet (ahora en forma descendente)
        //podemos prescindir de las llaves cuando es un solo bloque de codigo y de los parentesis si fuese un solo argumento
        Set<String> ts = new TreeSet<>((a, b) -> b.compareTo(a));

        ts.add("uno");
        ts.add("dos");
        ts.add("tres");
        ts.add("tres");
        ts.add("cuatro");
        ts.add("cinco");

        System.out.println(ts);

        Set<Integer> numeros = new TreeSet<>((Comparator.reverseOrder())); //se puede realizar como esta arriba o de esta manera
        numeros.add(3);
        numeros.add(5);
        numeros.add(1);
        numeros.add(4);
        numeros.add(2);

        System.out.println(numeros);

        //Paralelo al aprendizaje de Java estamos aprendiendo a utilizar git y github
    }
}

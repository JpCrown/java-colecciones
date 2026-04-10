package org.jpcrown.ejemplos.list;

import org.jpcrown.ejemplos.modelo.Alumno;


import java.util.LinkedList;
import java.util.ListIterator;


public class EjemploLinkedListMetodos {
    static void main(String[] args) {

        //LinkedList(lista doblemente enlazada) - pilas y colas
        //manipularemos los limites: la cabecera y la cola

        LinkedList<Alumno> enlazada = new LinkedList<>();
        System.out.println(enlazada + ", size = " + enlazada.size()); // 0
        System.out.println("Esta vacia = " + enlazada.isEmpty()); // true
        enlazada.add(new Alumno("Alejandro", 5));
        enlazada.add(new Alumno("Cata", 6));
        enlazada.add(new Alumno("Lucy", 4));
        enlazada.add(new Alumno("Jano", 7));
        enlazada.add(new Alumno("Lucas", 3));

        System.out.println(enlazada + ", size = " + enlazada.size()); // 5

        //Agregaremos mas alumnos al principio y al final (addFirst y addLast)
        //manipular elementos en un linkedlist es mucho mas rapido que un arrayList
        enlazada.addFirst(new Alumno("Zeus", 5));
        enlazada.addLast(new Alumno("Ramiro", 6));
        System.out.println(enlazada + ", size = " + enlazada.size());

        //Para obtener el primero y el ultimo elemento (getFirst y getLast)
        //si no encuentra el elemento lanza una excepcion
        System.out.println("Primero = " + enlazada.getFirst() +
                ", Segundo = " + enlazada.getLast());

        //Con peekFirst y peekLast tambien podemos obtener el primero y el ultimo
        //pero a diferencia de los metodos anteriores no lanzan una excepcion sino solo null
        System.out.println("Primero = " + enlazada.peekFirst() +
                ", Segundo = " + enlazada.peekLast());

        //Obtener un elemento mediante el indice (get)
        System.out.println("Indice 2 = " + enlazada.get(2));

        //Remove: elimina de la lista y extrae el objeto
        //Remove solo: elimina el primer elemento
        //podemos hacer algo con el objeto extraido de la lista
        //lanza una excepcion cuando la lista esta vacia (removeFirst y removeLast)
        Alumno zeus = enlazada.removeFirst();
        Alumno ramiro = enlazada.removeLast();
        System.out.println(enlazada + ", size = " + enlazada.size());

        //Pero tambien tiene sus elementos homonimos los cuales no lanzan excepciones
        //pollFirst y pollLast, arrojan null cuando no existen
        //solo poll elimina el primero
        //pop es equivalente a removeFirst (lanza excepcion)
//        enlazada.pollFirst();
//        enlazada.pollLast();

        //Igual que el arrayList podemos eliminar el objeto mediante el indice
        //remove con indice
        enlazada.remove(new Alumno("Jano", 7));
        System.out.println(enlazada + ", size = " + enlazada.size());

        Alumno a = new Alumno("Leonel", 5);
        enlazada.addLast(a);

        //obtenemos el indice por el objeto (indexOf) - usa equals x nombre y nota
        System.out.println("Indice de Leonel = " + enlazada.indexOf(a));

        //eliminamos por el indice
        enlazada.remove(2);
        System.out.println(enlazada + ", size = " + enlazada.size());
        System.out.println("Indice de Leonel = " + enlazada.indexOf(a));

        //reemplazamos un elemento
        enlazada.set(3, new Alumno("Lalo", 7));
        System.out.println(enlazada + ", size = " + enlazada.size());

        //Diferencia entre el ListIterator y el Iterator
        ListIterator<Alumno> li = enlazada.listIterator();

        //para usar tanto el hasnext como el hasprevious tienen que haber elementos en el cursor
        //next retorna el objeto alumno (o el del tipo que creemos)
        while (li.hasNext()){ //preguntamos si tenemos elementos
            Alumno alumnos = li.next();
            System.out.println(alumnos); //movemos el cursor y obtenemos el elemnto hacia adelante
        }

        System.out.println("========================================Previous");
        //ahora queremos ir hacia atras
        while (li.hasPrevious()){
            Alumno alumnos = li.previous();
            System.out.println(alumnos);
        }

        //si queremos recorrer a la lista mientras eliminamos un elemento
        //no necesitamos el uso del iterator en los set
        //Evita la excepcion en el caso de eliminar algo durante proceso de iteracion
        enlazada.removeIf(alumn -> a.getNota() < 4);

        /*ListIterator es una versión "potenciada" de Iterator diseñada específicamente para listas (ArrayList, LinkedList).
        Aquí tienes las diferencias clave:
        1. Dirección del recorrido
        Iterator: Solo puede avanzar hacia adelante. Es unidireccional.
        ListIterator: Puede ir hacia adelante (next()) y hacia atrás (previous()). Es bidireccional.
        2. Modificación de la colección
        Iterator: Solo permite eliminar elementos (remove()) mientras recorres.
        ListIterator: Permite eliminar, reemplazar (set()) y añadir (add()) elementos en cualquier punto del recorrido.
        3. Índices
        Iterator: No sabe en qué posición está; solo sabe si hay un siguiente elemento.
                ListIterator: Puede decirte el índice del elemento actual, del siguiente (nextIndex()) o del anterior (previousIndex()).*/
        /*Para las colecciones de tipo Set (como HashSet, TreeSet o LinkedHashSet),
        solo puedes usar el Iterator estándar.
        Esto se debe a que la interfaz Set, por definición, representa un conjunto
        donde el orden no está garantizado (con excepción de TreeSet y LinkedHashSet) y no existe el concepto de "índice"
         */



        //IMPORTANTE PARA TENER EN CUENTA (NO PERDAMOS EL ORDEN NATURAL!!)
//        List<String> frutas = new ArrayList<>();
//        frutas.add("Manzana");
//        frutas.add("Pera");
//        frutas.add("Plátano");

//        System.out.println("Orden original: " + frutas);
//        // Resultado: [Manzana, Pera, Plátano]
//
//        // Invertimos la lista físicamente
//        Collections.reverse(frutas);
//
//        System.out.println("Lista después del reverse: " + frutas);
    // Resultado: [Plátano, Pera, Manzana]

    // ¡Cuidado! Si ahora haces cualquier operación, la lista SIGUE invertida.
    // El orden original "Manzana -> Pera -> Plátano" dejó de existir en tu variable.
        /// ///////////////////////////////////////////////////////
        // Empezamos al final de la lista
//        ListIterator<String> it = frutas.listIterator(frutas.size());

//        while (it.hasPrevious()) {
//            System.out.println(it.previous()); // Imprime Plátano, luego Pera...
//        }

        // Al terminar el bucle, si imprimes la lista, SIGUE IGUAL que al inicio.
//        System.out.println("Lista intacta: " + frutas);
        // Resultado: [Manzana, Pera, Plátano]

    }
}

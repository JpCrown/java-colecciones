package org.jpcrown.ejemplos.set;

import org.jpcrown.ejemplos.modelo.Alumno;

import static java.util.Comparator.comparing;
import java.util.Set;
import java.util.TreeSet;

/*El "Orden a Medida" (Lambda / Comparator)
Cuando pasas un Lambda en el constructor del TreeSet:
Set<Alumno> alumnos = new TreeSet<>((a1, a2) -> a1.getNota().compareTo(a2.getNota()));
Estás ignorando el orden natural (el Comparable) y diciéndole a ese conjunto
específico: "No me importa lo que diga la clase Alumno, ordénalos así".
 */
public class EjemploTreeSetComparable {
    static void main(String[] args) {

        //TreeSet evita los valores duplicados por lo tanto si quieres comparar..
        //.. 2 valores iguales por nota por ejemplo deberias comparar nombre y viceversa.. o en su defecto si iguales en ambos valores, agregar un 3er elemento de comparacion un Id por ejemplo
        /*los TreeSet son colecciones ordenadas, y precisamente por eso
        necesitan que los elementos implementen la interfaz Comparable
        (o que les pases un Comparator).
         */
        /*el TreeSet ordena sus elementos automáticamente según su orden natural
         (alfabético para Strings, numérico para Integers, etc.).
         */
        /*Si intentas meter un objeto de una clase propia (ej. Persona)
        en un TreeSet y esa clase no implementa Comparable, Java lanzará
         un error: ClassCastException.
         */
        /*Si quiero ordenar por nota y este es primitivo no puedo utilizar el compareTo*/

        //con una expresion lambda sobreescribimos la comparacion de nota
        //podemos comparar de forma ascendente o descendente (solo cambiamos las letras de orden)
        //o ordenamos de la manera simplificada con un metodo de referencia usando comparator
        //podemos simplificar aun mas importando comparator de forma static
//        Set<Alumno> sa = new TreeSet<>((a,b) -> b.getNota().compareTo(a.getNota()));
        Set<Alumno> sa = new TreeSet<>(comparing(Alumno::getNota));
        sa.add(new Alumno("Alejandro", 5));
        sa.add(new Alumno("Cata", 6));
        sa.add(new Alumno("Lucy", 4));
        sa.add(new Alumno("Jano", 7));
        sa.add(new Alumno("Lucas", 3));
        sa.add(new Alumno("Zeus", 2));
        sa.add(new Alumno("Zeus", 2)); //no permite valores duplicados

        System.out.println(sa);

        /*Para que tu código sea más limpio, puedes usar los métodos estáticos
        de la interfaz Comparator que ya vienen listos a partir de Java 8:
        Asc: Set<Alumno> alumnos = new TreeSet<>(Comparator.comparing(Alumno::getNota));
        Desc: Set<Alumno> alumnos = new TreeSet<>(Comparator.comparing(Alumno::getNota).reversed());
         */
        /*Java tiene comparadores específicos para tipos primitivos que son muy
        eficientes: Set<Alumno> alumnos = new TreeSet<>(Comparator.comparingInt(Alumno::getNota));
        Agregamos reversed para lograr el orden forma Desc
         */

        /*El TreeSet considera que dos objetos son iguales si su comparador devuelve 0.
         Si solo comparas por nota, dos alumnos distintos con un "7" serán tratados
         como el mismo y uno desaparecerá.
         Puedes encadenar comparaciones usando el método .thenComparing():
         // Ordena por nota y, si empatan, usa el nombre como desempate
        Set<Alumno> alumnos = new TreeSet<>(Comparator.comparing(Alumno::getNota)
                                                .thenComparing(Alumno::getNombre));
        o en la clase en cuestion sobreescribe el compareTo y comparas por nota y luego
        si el resultado da 0 comparas por nombre.
            // Comparamos por nota
            int resultado = Integer.compare(this.nota, otro.getNota());

            // Si la nota es la misma (resultado == 0), comparamos por nombre
            if (resultado == 0) {
                return this.nombre.compareTo(otro.getNombre());
               }
               return resultado;
         */
    }
}

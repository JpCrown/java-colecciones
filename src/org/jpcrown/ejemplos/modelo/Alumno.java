package org.jpcrown.ejemplos.modelo;

import java.util.Objects;

/*El "Orden Natural" (Comparable)
Al implementar Comparable en la clase Alumno, estás definiendo cómo se ordena
un alumno por defecto. Si alguien crea un TreeSet simple:
Set<Alumno> alumnos = new TreeSet<>();
Java buscará automáticamente el método compareTo que escribiste en la clase.
Sin eso, el código fallaría.*/
public class Alumno implements Comparable<Alumno> {

    private String nombre;
    private Integer nota;


    public Alumno() {
    }

    public Alumno(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return nombre + ", nota = "+ nota;
    }

    //CompareTo nos permite ordenar por un solo atributo
    //para comparar primitivos utilizamos los condicionales
    @Override
    public int compareTo(Alumno a) {
        if(this.nombre == null){
            return 0;
        }
        return this.nombre.compareTo(a.nombre);

        //comparacion de primitivos
//        if(this.nota == a.nota){
//            return 0;
//        }
//        if(this.nota > a.nota){
//            return 1;
//        }else{
//            return -1;
//        }
        //comparacion de clase wrapper
//        if(this.nota == null){
//            return 0;
//        }
//        return this.nota.compareTo(a.nota);
    }

    //Para detectar la unicidad en hashSet debemos implementar los metodos equals y hashcode
    //en equals compara por nombre y por nota
    //y en hashCode por el hashcode de nombre y sino de nota
    //Objects es una clase helpers
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Paso extra recomendado: ¿son el mismo objeto en memoria?
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        // Comparamos nombre ignorando mayúsculas y nota de forma normal
        return (nombre != null && nombre.equalsIgnoreCase(alumno.nombre)) &&
                Objects.equals(nota, alumno.nota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nota);
    }
}

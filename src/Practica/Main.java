package Practica;

public class Main {
    public static void main(String[] args) {
        Alumno alu1 = new Alumno(123, "Juan", "Perez");

        System.out.println("Ci: " + alu1.getCi() + " " + alu1.getNombre() + " " + alu1.getApellido());
    }
}

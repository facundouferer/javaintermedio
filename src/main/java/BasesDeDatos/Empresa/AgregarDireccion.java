package BasesDeDatos.Empresa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class AgregarDireccion {
    public static void main(String[] args) {
        // Crear el EntityManagerFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmpleadoPersistencia");

        // Crear el EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        // Pedir el nombre del empleado
        System.out.print("Ingrese el nombre del empleado: ");
        String nombreEmpleado = scanner.nextLine();

        // Crear la instancia de Empleado
        Empleado empleado = new Empleado();
        empleado.setNombre(nombreEmpleado);

        // Pedir la dirección del empleado
        System.out.print("Ingrese la dirección para " + nombreEmpleado + ": ");
        String direccionEmpleado = scanner.nextLine();

        // Crear la instancia de Direccion
        Direccion direccion = new Direccion();
        direccion.setDireccion(direccionEmpleado);

        // Asignar la dirección al empleado
        empleado.setDireccion(direccion);

        // Iniciar una transacción
        entityManager.getTransaction().begin();

        try {
            // Persistir la dirección
            entityManager.persist(direccion);

            // Persistir el empleado
            entityManager.persist(empleado);

            // Commit de la transacción
            entityManager.getTransaction().commit();

            System.out.println("Empleado y dirección guardados exitosamente.");
        } catch (Exception e) {
            // En caso de error, hacer rollback
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            // Cerrar el EntityManager y el EntityManagerFactory
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}

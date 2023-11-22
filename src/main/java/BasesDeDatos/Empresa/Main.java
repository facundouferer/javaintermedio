package BasesDeDatos.Empresa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // Crear el EntityManagerFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmpleadoPersistencia");

        // Crear el EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Operaciones con la base de datos
        Empleado empleado = new Empleado();
        empleado.setNombre("Rita Celeste");

        // Iniciar una transacción
        entityManager.getTransaction().begin();

        // Persistir el objeto en la base de datos
        entityManager.persist(empleado);

        // Commit de la transacción
        entityManager.getTransaction().commit();

        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}

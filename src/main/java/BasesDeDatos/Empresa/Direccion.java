package BasesDeDatos.Empresa;

import javax.persistence.*;

@Entity
@Table(name = "direccion")
class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "direccion")
    private String direccion;

    @OneToOne(mappedBy = "direccion")
    private Empleado empleado;

    // Constructor, getters y setters

    // Constructor vacío necesario para JPA
    public Direccion() {}

    public Direccion(String direccion) {
        this.direccion = direccion;
    }

    // Getters y setters

    // Métodos de utilidad para establecer y obtener la relación bidireccional
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setDireccion(String direccionEmpleado) {
        this.direccion = direccionEmpleado;
    }

    public String getDireccion() {
        return direccion;
    }
}

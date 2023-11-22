package BasesDeDatos.Empresa;

import javax.persistence.*;

@Entity
@Table(name = "empleado")
class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private Direccion direccion;

    // Constructor, getters y setters

    // Constructor vacío necesario para JPA
    public Empleado() {}

    public Empleado(String nombre, Direccion direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    // Getters y setters

    // Métodos de utilidad para establecer y obtener la relación bidireccional
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
        if (direccion != null) {
            direccion.setEmpleado(this);
        }
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setNombre(String nombreEmpleado) {
        this.nombre = nombreEmpleado;
    }

    public String getNombre() {
        return nombre;
    }
}

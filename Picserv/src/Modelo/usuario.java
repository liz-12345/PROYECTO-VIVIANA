package Modelo;

public class usuario {

    private int id_documentousu;
    private String nombre;
    private String apellido;
    private int telefono;
    private String direccion;
    private int edad;



    //Getter y Setter

    public int getId_documentousu() {
        return id_documentousu;
    }

    public void setId_documentousu(int id_documentousu) {
        this.id_documentousu = id_documentousu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    //Constructor

    public usuario(int id_documentousu, String nombre, String apellido, int telefono, String direccion, int edad) {
        this.id_documentousu = id_documentousu;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.edad = edad;
    }


    //Constructor vacio

    public usuario(int id_documentousu) {
    }


    //ToString


    @Override
    public String toString() {
        return "Usuarios " +
                "id_documentousu= " + id_documentousu + '\n' +
                "Nombre= " + nombre + '\n' +
                "Apellido= " + apellido + '\n' +
                "telefono= " + telefono + '\n' +
                "direccion= " + direccion + '\n' +
                "Edad= " + edad;
    }
}

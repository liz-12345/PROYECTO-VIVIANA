package Modelo;

public class trabajos {

    private int id_trabajo;
    private int id_docusuario;
    private String descripcion;
    private String remuneracion;
    private int horas;


    //Getter y Setter


    public int getId_trabajo() {
        return id_trabajo;
    }

    public void setId_trabajo(int id_trabajo) {
        this.id_trabajo = id_trabajo;
    }

    public int getId_docusuario() {
        return id_docusuario;
    }

    public void setId_docusuario(int id_docusuario) {
        this.id_docusuario = id_docusuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRemuneracion() {
        return remuneracion;
    }

    public void setRemuneracion(String remuneracion) {
        this.remuneracion = remuneracion;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    //Constructor


    public trabajos(int id_trabajo, int id_docusuario, String descripcion, String remuneracion, int horas) {
        this.id_trabajo = id_trabajo;
        this.id_docusuario = id_docusuario;
        this.descripcion = descripcion;
        this.remuneracion = remuneracion;
        this.horas = horas;
    }

    //Constructor vacio


    public trabajos(int id_trabajo) {
    }


    //ToString


    @Override
    public String toString() {
        return "Trabajos " +
                "Id_trabajo= " + id_trabajo + '\n' +
                "Id_docusuario= " + id_docusuario + '\n' +
                "Descripcion= " + descripcion + '\n' +
                "Remuneracion='" + remuneracion + '\n' +
                "Horas=" + horas
                ;
    }
}

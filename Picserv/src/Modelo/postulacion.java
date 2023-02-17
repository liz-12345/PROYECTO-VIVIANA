package Modelo;

public class postulacion {

    private int id_usuario;
    private int nid_trabajo;
    private String fecha_postulacion;


    //Getter y Setter


    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getNid_trabajo() {
        return nid_trabajo;
    }

    public void setNid_trabajo(int nid_trabajo) {
        this.nid_trabajo = nid_trabajo;
    }

    public String getFecha_postulacion() {
        return fecha_postulacion;
    }

    public void setFecha_postulacion(String fecha_postulacion) {
        this.fecha_postulacion = fecha_postulacion;
    }

    //Constructor


    public postulacion(int id_usuario, int nid_trabajo, String fecha_postulacion) {
        this.id_usuario = id_usuario;
        this.nid_trabajo = nid_trabajo;
        this.fecha_postulacion = fecha_postulacion;
    }

    //Constructor vacio


    public postulacion(int id_usuario) {
    }

    //toString


    @Override
    public String toString() {
        return "Postulacion " + '\n' +
                "Id_usuario=" + id_usuario + '\n' +
                "Nid_trabajo=" + nid_trabajo + '\n' +
                "Fecha_postulacion='" + fecha_postulacion
                ;
    }
}

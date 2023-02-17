package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class gestorTrabajos {

    private ArrayList<trabajos> datos = new ArrayList<trabajos>();
    Conexion con = new Conexion();
    Connection conec = null;
    Statement st = null;
    ResultSet res = null;
    PreparedStatement ps = null;//Consultas con parametros
    static Scanner snn = new Scanner(System.in);

    public ArrayList<trabajos> consultaTodosTra() {

        try {
            conec = con.conecta();
            String sql = "Select * from trabajos";
            st = conec.createStatement();
            res = st.executeQuery(sql);

            while (res.next()) {
                trabajos tra1 = new trabajos(res.getInt(1), res.getInt(2), res.getString(3), res.getString(4), res.getInt(5));
                datos.add(tra1);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar:" + e);
        }
        return datos;
    }

    public trabajos buscarTrabajo(int id_trabajo){
        trabajos tra=null;
        try{
            conec=con.conecta();
            String sql="select * from trabajos where id_trabajo=?";
            ps=conec.prepareStatement(sql);
            ps.setInt(1,id_trabajo);
            res=ps.executeQuery();

            while(res.next()){
                tra = new trabajos(res.getInt(1), res.getInt(2), res.getString(3), res.getString(4), res.getInt(5));
            }
        }catch (SQLException ex){
            System.out.println("Error al consultar ");
        }
        return tra;

    }

    public void insertarTrabajo(trabajos trabajo) {
        boolean respuesta = false;
        try {
            if (buscarTrabajo(trabajo.getId_trabajo()) == null){
                conec = con.conecta();
                String sql = "INSERT INTO trabajos values(?,?,?,?,?)";
                ps = conec.prepareStatement(sql);
                ps.setInt(1, trabajo.getId_trabajo());
                ps.setInt(2, trabajo.getId_docusuario());
                ps.setString(3, trabajo.getDescripcion());
                ps.setString(4, trabajo.getRemuneracion());
                ps.setInt(5, trabajo.getHoras());
                respuesta = ps.executeUpdate() > 0;
            }
            else{
                System.out.println("El trabajo ya existe en la BD");
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar el trabajo " + e);
        }
    }


    public void actualizarTrabajo(trabajos trabajo){
        conec = con.conecta();
        String sql = "UPDATE trabajos set id_docusuario=?, descripcion=?, remuneracion=?, horas=?, where id_trabajo=?";

        boolean resultado = false;

        try (PreparedStatement ps = con.connec.prepareStatement(sql);
        ) {
            ps.setInt(1, trabajo.getId_docusuario());
            ps.setString(2, trabajo.getDescripcion());
            ps.setString(3, trabajo.getRemuneracion());
            ps.setInt(4, trabajo.getHoras());
            ps.setInt(5, trabajo.getId_trabajo());


            resultado = ps.executeUpdate() > 0;

        }catch (SQLException e) {
            System.out.println("Error al actualizar el trabajo");
        }
    }

    public void eliminarTrabajo(trabajos trabajo) {
        boolean resultado = false;
        try {
            if (buscarTrabajo(trabajo.getId_trabajo()) != null) {
                conec = con.conecta();
                String SQL = "delete from trabajos where id_trabajo=?";
                ps = conec.prepareStatement(SQL);
                ps.setInt(1, trabajo.getId_trabajo());
                resultado= ps.executeUpdate()>0;
            }else {
                System.out.println("El trabajo no esta en la BD");
            }
            conec.close();
        } catch (SQLException e) {
            System.out.println("El trabajo no ha sido eliminado");
        }
    }
}

package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class gestorPostulacion {

    private ArrayList<postulacion> datos = new ArrayList<postulacion>();
    Conexion con = new Conexion();
    Connection conec = null;
    Statement st = null;
    ResultSet res = null;
    PreparedStatement ps = null;//Consultas con parametros
    static Scanner snn = new Scanner(System.in);

    public ArrayList<postulacion> consultaTodosPos() {

        try {
            conec = con.conecta();
            String sql = "Select * from postulacion";
            st = conec.createStatement();
            res = st.executeQuery(sql);

            while (res.next()) {
                postulacion pos = new postulacion(res.getInt(1), res.getInt(2), res.getString(3));
                datos.add(pos);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar:" + e);
        }
        return datos;
    }

    public postulacion buscarPostulacion(int id_usuario){
        postulacion tra=null;
        try{
            conec=con.conecta();
            String sql="select * from postulacion where id_usuario=?";
            ps=conec.prepareStatement(sql);
            ps.setInt(1,id_usuario);
            res=ps.executeQuery();

            while(res.next()){
                postulacion pos = new postulacion(res.getInt(1), res.getInt(2), res.getString(3));
            }
        }catch (SQLException ex){
            System.out.println("Error al consultar ");
        }
        return tra;

    }

    public void insertarPostulacion(postulacion postulacion) {
        boolean respuesta = false;
        try {
            if (buscarPostulacion(postulacion.getId_usuario()) == null){
                conec = con.conecta();
                String sql = "INSERT INTO postulacion values(?,?,?)";
                ps = conec.prepareStatement(sql);
                ps.setInt(1, postulacion.getId_usuario());
                ps.setInt(2, postulacion.getNid_trabajo());
                ps.setString(3, postulacion.getFecha_postulacion());
                respuesta = ps.executeUpdate() > 0;
            }
            else{
                System.out.println("La postulacion ya existe en la BD");
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar la postulacion " + e);
        }
    }


    public void actualizarTrabajo(postulacion postulacion){
        conec = con.conecta();
        String sql = "UPDATE postulacion set nid_trabajo=?, fecha_postulacion=?, id_usuario=?";

        boolean resultado = false;

        try (PreparedStatement ps = con.connec.prepareStatement(sql);
        ) {
            ps.setInt(1, postulacion.getNid_trabajo());
            ps.setString(2, postulacion.getFecha_postulacion());
            ps.setInt(3, postulacion.getId_usuario());


            resultado = ps.executeUpdate() > 0;

        }catch (SQLException e) {
            System.out.println("Error al actualizar la postulacion");
        }
    }

    public void eliminarPostulacion(postulacion postulacion) {
        boolean resultado = false;
        try {
            if (buscarPostulacion(postulacion.getId_usuario()) != null) {
                conec = con.conecta();
                String SQL = "delete from postulacion where id_usuario=?";
                ps = conec.prepareStatement(SQL);
                ps.setInt(1, postulacion.getId_usuario());
                resultado= ps.executeUpdate()>0;
            }else {
                System.out.println("La postulacion no esta en la BD");
            }
            conec.close();
        } catch (SQLException e) {
            System.out.println("La postulacion no ha sido eliminado");
        }
    }
}

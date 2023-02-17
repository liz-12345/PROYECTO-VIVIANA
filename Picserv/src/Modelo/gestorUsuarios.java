package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class gestorUsuarios {

    private ArrayList<usuario> datos = new ArrayList<usuario>();
    Conexion con = new Conexion();
    Connection conec = null;
    Statement st = null;
    ResultSet res = null;
    PreparedStatement ps = null;//Consultas con parametros
    static Scanner snn = new Scanner(System.in);

    public ArrayList<usuario> consultaTodos() {

        try {
            conec = con.conecta();
            String sql = "Select * from usuario";
            st = conec.createStatement();
            res = st.executeQuery(sql);

            while (res.next()) {
                usuario tra = new usuario(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5), res.getInt(6));
                datos.add(tra);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar:" + e);
        }
        return datos;
    }

    public usuario buscarUsuario(int id_documentousu){
        usuario tra=null;
        try{
            conec=con.conecta();
            String sql="select * from usuario where id_documentousu=?";
            ps=conec.prepareStatement(sql);
            ps.setInt(1,id_documentousu);
            res=ps.executeQuery();

            while(res.next()){
                tra=new usuario(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5), res.getInt(6));
            }
        }catch (SQLException ex){
            System.out.println("Error al consultar ");
        }
        return tra;

    }

    public void insertarUsuario(usuario usuario) {
        boolean respuesta = false;
        try {
            if (buscarUsuario(usuario.getId_documentousu()) == null){
                conec = con.conecta();
                String sql = "INSERT INTO usuario values(?,?,?,?,?,?)";
                ps = conec.prepareStatement(sql);
                ps.setInt(1, usuario.getId_documentousu());
                ps.setString(2, usuario.getNombre());
                ps.setString(3, usuario.getApellido());
                ps.setInt(4, usuario.getTelefono());
                ps.setString(5, usuario.getDireccion());
                ps.setInt(6, usuario.getEdad());
                respuesta = ps.executeUpdate() > 0;
            }
            else{
                System.out.println("El usuario ya existe en la BD");
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar el usuario " + e);
        }
    }


    public void actualizarUsuario(usuario usuario){
        conec = con.conecta();
        String sql = "UPDATE usuario set nombre=?, apellido=?, telefono=?, direccion=?, edad=?, where id_documentousu=?";

        boolean resultado = false;

        try (PreparedStatement ps = con.connec.prepareStatement(sql);
        ) {
                ps.setString(1, usuario.getNombre());
                ps.setString(2, usuario.getApellido());
                ps.setInt(3, usuario.getTelefono());
                ps.setString(4, usuario.getDireccion());
                ps.setInt(5, usuario.getEdad());
                ps.setInt(6, usuario.getId_documentousu());


                resultado = ps.executeUpdate() > 0;

        }catch (SQLException e) {
            System.out.println("Error al actualizar el usuario");
        }
    }

    public void eliminarUsuario(usuario usuario) {
        boolean resultado = false;
        try {
            if (buscarUsuario(usuario.getId_documentousu()) != null) {
                conec = con.conecta();
                String SQL = "delete from usuario where id_documentousu=?";
                ps = conec.prepareStatement(SQL);
                ps.setInt(1, usuario.getId_documentousu());
                resultado= ps.executeUpdate()>0;
            }else {
                System.out.println("El usuario no esta en la BD");
            }
            conec.close();
        } catch (SQLException e) {
            System.out.println("El usuario no ha sido eliminado");
        }
    }
}

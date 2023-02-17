import Modelo.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        gestorUsuarios tra = new gestorUsuarios();
        gestorTrabajos tra1 = new gestorTrabajos();
        gestorPostulacion tra5 = new gestorPostulacion();
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while(!salir){

            System.out.println("1. Mostrar Usuarios");
            System.out.println("2. Buscar Usuarios");
            System.out.println("3. Insertar Usuarios");
            System.out.println("4. Modificar Usuarios");
            System.out.println("5. Eliminar Usuarios");
            System.out.println("6. Mostrar Trabajos");
            System.out.println("7. Buscar Trabajo");
            System.out.println("8. Insertar Trabajo");
            System.out.println("9. Modificar Trabajo");
            System.out.println("10. Eliminar Trabajo");
            System.out.println("11. Mostrar postulaciones");
            System.out.println("12. Buscar postulaciones");
            System.out.println("13. Insertar postulacion");
            System.out.println("14. Eliminar postulacion");
            System.out.println("15. Salir");

            System.out.println("Digite la opcion que desea ejecutar");
            opcion = sn.nextInt();

            switch(opcion){
                case 1:
                    System.out.println(tra.consultaTodos());
                    break;
                case 2:
                    tra= new gestorUsuarios();
                    tra.consultaTodos();
                    System.out.println("Ingrese el id_documento del usuario que esta buscando");
                    int id_documentousu=sn.nextInt();
                    if(tra.buscarUsuario(id_documentousu)==null){
                        System.out.println("El usuario no se econtro");
                    }else{
                        System.out.println(tra.buscarUsuario(id_documentousu).toString());
                        System.out.println(" ");
                        System.out.println("usuario encontrado con exito");
                        System.out.println(" ");
                    }
                    break;
                case 3:
                    tra = new gestorUsuarios();
                    System.out.println("Ingrese el id_documentousu de este ususario: ");
                    id_documentousu = sn.nextInt();
                    System.out.println("Ingres el nombre de este usuario: ");
                    String nombre = sn.next();
                    sn.nextLine();
                    System.out.println("Ingrese el apellido de este usuario: ");
                    String apellido = sn.next();
                    sn.nextLine();
                    System.out.println("Ingrese numero de telefono de este usuario: ");
                    int telefono = sn.nextInt();
                    System.out.println("Ingrese la direccion de este usuario: ");
                    String direccion = sn.next();
                    sn.nextLine();
                    System.out.println("Ingrese la edad del ususario: " );
                    int edad = sn.nextInt();
                    usuario usuario = new usuario(id_documentousu, nombre, apellido, telefono, direccion, edad);
                    tra.insertarUsuario(usuario);
                    break;
                case 4:
                    tra = new gestorUsuarios();
                    System.out.println("Ingrese el id_documentousu del usuario a modificar" );
                    id_documentousu = sn.nextInt();
                    System.out.println("Ingrese el Nombre nuevo: ");
                    nombre = sn.next();
                    sn.nextLine();
                    System.out.println("Ingrese el nuevo Apellido: ");
                    apellido = sn.nextLine();
                    System.out.println("Ingrese el Telefono nuevo: ");
                    telefono = sn.nextInt();
                    sn.nextLine();
                    System.out.println("Ingrese la Direccion nueva: ");
                    direccion = sn.nextLine();
                    System.out.println("Ingrese la Edad nueva: ");
                    edad = sn.nextInt();
                    usuario usuario1 = new usuario(id_documentousu, nombre, apellido, telefono, direccion, edad);
                    tra.actualizarUsuario(usuario1);
                    break;
                case 5:
                    tra = new gestorUsuarios();
                    System.out.println("Ingrese el id del usuario a eliminar: ");
                    id_documentousu = sn.nextInt();
                    usuario tra2 = new usuario(id_documentousu);
                    gestorUsuarios usuarios = new gestorUsuarios();
                    usuarios.eliminarUsuario(tra2);
                    break;
                case 6:
                    System.out.println(tra1.consultaTodosTra());
                    break;
                case 7:
                    tra1= new gestorTrabajos();
                    tra1.consultaTodosTra();
                    System.out.println("Ingrese el id_trabajo del trabajo que esta buscando");
                    int id_trabajo=sn.nextInt();
                    if(tra1.buscarTrabajo(id_trabajo)==null){
                        System.out.println("El trabajo no se econtro");
                    }else{
                        System.out.println(tra1.buscarTrabajo(id_trabajo).toString());
                        System.out.println(" ");
                        System.out.println("trabajo encontrado con exito");
                        System.out.println(" ");
                    }
                    break;
                case 8:
                    tra1 = new gestorTrabajos();
                    System.out.println("Ingrese el id_trabajo de este trabajo: ");
                    id_trabajo = sn.nextInt();
                    System.out.println("Ingres el id_docusuario de este trabajo: ");
                    int id_docusuario = sn.nextInt();
                    System.out.println("Ingrese la descripcion de este trabajo: ");
                    String descripcion = sn.next();
                    sn.nextLine();
                    System.out.println("Ingrese la remuneracion asignado a este trabajo: ");
                    String remuneracion = sn.next();
                    sn.nextLine();
                    System.out.println("Ingrese las horas requeridas para este trabajo: ");
                    int horas = sn.nextInt();
                    trabajos trabajos = new trabajos(id_trabajo, id_docusuario, descripcion, remuneracion, horas);
                    tra1.insertarTrabajo(trabajos);
                    break;
                case 9:
                    tra1 = new gestorTrabajos();
                    System.out.println("Ingrese el id_trabajo del trabajo a modificar" );
                    id_trabajo = sn.nextInt();
                    System.out.println("Ingrese el id_docusuario nuevo: ");
                    id_docusuario = sn.nextInt();
                    System.out.println("Ingrese la nueva Descripcion: ");
                    descripcion = sn.next();
                    sn.nextLine();
                    System.out.println("Ingrese la Remuneracion nueva: ");
                    remuneracion = sn.next();
                    sn.nextLine();
                    System.out.println("Ingrese las nuevas Horas asignadas: ");
                    horas = sn.nextInt();
                    trabajos trabajos1 = new trabajos(id_trabajo,id_docusuario,descripcion,remuneracion,horas);
                    tra1.actualizarTrabajo(trabajos1);
                    break;
                case 10:
                    tra1 = new gestorTrabajos();
                    System.out.println("Ingrese el id del trabajo a eliminar: ");
                    id_trabajo = sn.nextInt();
                    trabajos tra3 = new trabajos(id_trabajo);
                    gestorTrabajos trabajos2 = new gestorTrabajos();
                    trabajos2.eliminarTrabajo(tra3);
                case 11:
                    System.out.println(tra5.consultaTodosPos());
                    break;
                case 12:
                    tra5 = new gestorPostulacion();
                    tra5.consultaTodosPos();
                    System.out.println("Ingrese el id_usuario de la postulacion que esta buscando");
                    int id_usuario=sn.nextInt();
                    if(tra5.buscarPostulacion(id_usuario)==null){
                        System.out.println("La postulacion no se econtro");
                    }else{
                        System.out.println(tra5.buscarPostulacion(id_usuario).toString());
                        System.out.println(" ");
                        System.out.println("Postulacion encontrada con exito");
                        System.out.println(" ");
                    }
                    break;
                case 13:
                    tra5 = new gestorPostulacion();
                    System.out.println("Ingrese el id_usuario de esta postulacion: ");
                    id_usuario = sn.nextInt();
                    System.out.println("Ingres el nid_trabajo de esta postulacion: ");
                    int nid_trabajo = sn.nextInt();
                    System.out.println("Ingrese la fecha de esta postulacion: ");
                    String fecha_postulacion = sn.next();
                    sn.nextLine();
                    postulacion postulacion = new postulacion(id_usuario, nid_trabajo, fecha_postulacion);
                    tra5.insertarPostulacion(postulacion);
                    break;
                case 14:
                    tra5 = new gestorPostulacion();
                    System.out.println("Ingrese el id_usuario de la postulacion a eliminar: ");
                    id_usuario = sn.nextInt();
                    postulacion tra22 = new postulacion(id_usuario);
                    gestorPostulacion trabajos3 = new gestorPostulacion();
                    trabajos3.eliminarPostulacion(tra22);
                    break;
                case 15:
                    salir=true;
                    break;
                default:
                    System.out.println("Error,Solo se aceptan números entre 1 y 4");
            }




        }

    }
}
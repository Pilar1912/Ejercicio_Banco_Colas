import java.util.Scanner;
import java.util.Queue;
//import java.util.LinkedList;

public class Metodos {
    public Queue<ObjBanco> RegistrarClientes(Queue<ObjBanco> cola, Scanner sc, Metodos m){
        boolean continuar = true;

        while(continuar){
            ObjBanco o = new ObjBanco();
            o.setTurno(m.ValidarTurno(cola));

            System.out.println("Ingrese el número de identificación del cliente:");
            o.setIdentificacion(sc.next());

            System.out.println("Ingrese el nombre del cliente:");
            o.setNombre(sc.next());

            System.out.println("Ingrese el tipo de trámite que va a realizar:");
            o.setTipoTramite(m.TipoTramites(sc));

            System.out.println("Selecciones una de las siguientes opciones si el cliente cumple con al menos una de ellas:");
            o.setCondicionAt(m.CondicionesAtencion(sc));
            
            System.out.println("Ingrese la edad del cliente:");
            o.setEdad(m.ValidarEntero(sc));

            o.setEstado(1);
            System.out.println("Desea agregar mas trámites/turnos 1. SI \n 2. NO");
            int opt = sc.nextInt();
            if (opt == 2) {
                System.out.println("Vuelve pronto");
                continuar = false;
            }
            cola.offer(o);
        }

        return cola;
    }    

    public String MostrarTurnos(Queue<ObjBanco> cola, int opt){
        switch(opt){
            case 1:
                for (ObjBanco o : cola){
                    System.out.println("Turno: " + o.getTurno());
                    System.out.println("Nombre: " + o.getNombre());
                    System.out.println("Identificación: " + o.getIdentificacion());
                    System.out.println("Edad: " + o.getEdad());
                    System.out.println("Trámite a realizar: " + Tramites(o.getTipoTramite()));
                    
                    if (o.getCondicionAt() == 6) {
                        System.out.println("Condición especial: Ninguna\n");
                    }else{
                        System.out.println("Condición especial: " + Condiciones(o.getCondicionAt()) + "\n ATENCIÓN PREFERENCIAL");
                    }
                    
                    if(o.getEstado() == 1){
                        System.out.println("Estado: Pendiente");
                    }else if(o.getEstado() == 2){
                        System.out.println("Estado: Atendido");
                    }else{
                        System.out.println("Estado: Cancelado.");
                    }
                    System.out.println("------------------------------------------------\n");

                    
                }
                break;

                case 2:
                    for(ObjBanco o : cola){
                        if(o.getEstado() == 1){
                            System.out.println("Turno: " + o.getTurno());
                            System.out.println("Nombre: " + o.getNombre());
                            System.out.println("Identificación: " + o.getIdentificacion());
                            System.out.println("Edad: " + o.getEdad());
                            System.out.println("Trámite a realizar: " + Tramites(o.getTipoTramite()));

                            if (o.getCondicionAt() == 6) {
                                System.out.println("Condición especial: Ninguna\n");
                            }else{
                                System.out.println("Condición especial: " + Condiciones(o.getCondicionAt()) + "\n ATENCIÓN PREFERENCIAL\n");
                            }

                            if(o.getEstado() == 1){
                                System.out.println("Estado: Pendiente");
                            }else if(o.getEstado() == 2){
                                System.out.println("Estado: Atendido");
                            }else{
                                System.out.println("Estado: Cancelado.");
                            }
                            System.out.println("------------------------------------------------\n");
                        }
                    }
                    break;

                    case 3:
                    for(ObjBanco o : cola){
                        if(o.getEstado() == 3){
                            System.out.println("Turno: " + o.getTurno());
                            System.out.println("Nombre: " + o.getNombre());
                            System.out.println("Identificación: " + o.getIdentificacion());
                            System.out.println("Edad: " + o.getEdad());
                            System.out.println("Trámite a realizar: " + Tramites(o.getTipoTramite()));

                            if (o.getCondicionAt() == 6) {
                                System.out.println("Condición especial: Ninguna\n");
                            }else{
                                System.out.println("Condición especial: " + Condiciones(o.getCondicionAt()) + "\n ATENCIÓN PREFERENCIAL\n");
                            }

                            if(o.getEstado() == 1){
                                System.out.println("Estado: Pendiente");
                            }else if(o.getEstado() == 2){
                                System.out.println("Estado: Atendido");
                            }else{
                                System.out.println("Estado: Cancelado.");
                            }
                            System.out.println("------------------------------------------------\n");
                        }
                    }
                    break;

                    default:
                        for(ObjBanco o : cola){
                            if(o.getEstado() == 2){
                            System.out.println("Turno: " + o.getTurno());
                            System.out.println("Nombre: " + o.getNombre());
                            System.out.println("Identificación: " + o.getIdentificacion());
                            System.out.println("Edad: " + o.getEdad());
                            System.out.println("Trámite a realizar: " + Tramites(o.getTipoTramite()));

                            if (o.getCondicionAt() == 6) {
                                System.out.println("Condición especial: Ninguna\n");
                            }else{
                                System.out.println("Condición especial: " + Condiciones(o.getCondicionAt()) + "\nATENCIÓN PREFERENCIAL\n");
                            }

                            if(o.getEstado() == 1){
                                System.out.println("Estado: Pendiente");
                            }else if(o.getEstado() == 2){
                                System.out.println("Estado: Atendido");
                            }else{
                                System.out.println("Estado: Cancelado.");
                            }
                            System.out.println("------------------------------------------------\n");
                        }
                    }
                    if (cola.isEmpty()) {
                        System.out.println("No se ha atendido ningún cliente.");  
                    }
                    break;
        }
        return "Datos mostrados correctamente";
        
    }

    public Queue<ObjBanco> Atender(Queue<ObjBanco> cola){
        for(ObjBanco o : cola){
            if (o.getEstado() == 1 && o.getCondicionAt() != 6) {
                System.out.println("\nEl siguiente turno es: " + o.getTurno() + 
                "\nA nombre del usuario: " + o.getNombre() + 
                "\nNúmero de identificación: " + o.getIdentificacion());
                o.setEstado(2);
                System.out.println("\nUsuario atendido exitosamente.");
                System.out.println("------------------------------------------------\n");
                //break;
                return cola;
            }   
        }

        for(ObjBanco o : cola){
            if (o.getEstado() == 1) {
                System.out.println("\nEl siguiente turno es: " + o.getTurno() + 
                "\nA nombre del usuario: " + o.getNombre() + 
                "\nNúmero de identificación: " + o.getIdentificacion());
                o.setEstado(2);
                System.out.println("\nUsuario atendido exitosamente.");
                System.out.println("------------------------------------------------\n");
                //break;
                return cola;
            }   
        }

        System.out.println("No hay clientes pendientes por atender.");
        System.out.println("------------------------------------------------\n");
 
        return cola;
    }

    public void BuscarClientePorId(Queue<ObjBanco> cola, Scanner sc) {
        System.out.println("Ingrese el número de identificación a buscar:");
        String buscado = sc.next();
        boolean encontrado = false;

        for (ObjBanco o : cola) {

            String estado = "";

            if(o.getEstado() == 1){
                estado = "Pendiente.";
            }else if(o.getEstado() == 2){
                estado = "Atendido.";
            }else{
                estado = "Cancelado.";
            }

            if (o.getIdentificacion().equals(buscado)) {
                System.out.println("\n--- CLIENTE ENCONTRADO ---");
                System.out.println("Turno: " + o.getTurno());
                System.out.println("Nombre: " + o.getNombre());
                System.out.println("Edad: " + o.getEdad());
                
                if (o.getCondicionAt() == 6) {
                    System.out.println("Condición especial: Ninguna\n");
                }else{
                    System.out.println("Condición especial: " + Condiciones(o.getCondicionAt()) + "\n ATENCIÓN PREFERENCIAL");
                }
                
                System.out.println("Trámite: " + Tramites(o.getTipoTramite()));
                System.out.println("Estado: " + estado);
                System.out.println("---------------------------\n");
                encontrado = true;
                break; 
            }
        }

        if (!encontrado) {
            System.out.println("El cliente con identificación " + buscado + " no se encuentra registrado aún.\n");
        }
    }

    public Queue<ObjBanco> CambiarAtencion(Queue<ObjBanco> cola, Scanner sc, Metodos m){

        System.out.println("Ingrese el número de identificación del cliente: ");
        String buscar = sc.next();

        boolean encontrado = false;

        for(ObjBanco o : cola){
            if (o.getIdentificacion().equals(buscar)) {

                encontrado = true;

                if (o.getCondicionAt() != 6) {
                    System.out.println("El usuario ya tiene atención preferencial.");
                    break;
                }

                System.out.println("El cliente fue encontrado.");
                System.out.println("-----DATOS DEL CLIENTE BUSCADO-----");
                System.out.println("Nombre: " + o.getNombre());
                System.out.println("Identificación: " + o.getIdentificacion());
                System.out.println("Edad: " + o.getEdad());
                System.out.println("Trámite: " + o.getTipoTramite());
                if (o.getCondicionAt() == 6) {
                    System.out.println("Condición especial: Ninguna\n");
                }else{
                    System.out.println("Condición especial: " + Condiciones(o.getCondicionAt()) + "\nATENCIÓN PREFERENCIAL\n");
                }
                System.out.println("--------------------------------------------------------\n");
                System.out.println("Seleccione la condición que está acreditando:");
                System.out.println("1. Es un cliente Premium.");
                System.out.println("2. Es mayor de 60 años.");
                System.out.println("3. Tiene una discapacidad física.");
                System.out.println("4. Condición especial de salud.");
                System.out.println("5. Embarazo.");

                int condicion = m.ValidarEntero(sc);

                if (condicion >= 1 && condicion <= 5) {
                    o.setCondicionAt(condicion);
                    System.out.println("La atención del cliente ahora es preferencial.");
                }else{
                    System.out.println("Opción no válida.");
                }
                break;
                
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningun cliente con esa identificación.");
        }

        return cola;
    } 

    public void CancelarTurno(Queue<ObjBanco> cola, Scanner sc) {

        System.out.println("Ingrese el número de identificación del cliente del que se cancelará el turno:");
        String buscado = sc.next();

        boolean encontrado = false;

        for (ObjBanco o : cola) {

            if (o.getIdentificacion().equals(buscado)) {

                encontrado = true;

                if (o.getEstado() == 2) {
                    System.out.println("El cliente ya fue atendido, su turno no se puede cancelar.");
                } 
                else if (o.getEstado() == 3) {
                    System.out.println("El turno del cliente ya está cancelado.");
                } 
                else if (o.getEstado() == 1) {

                    System.out.println("\n--- CLIENTE ENCONTRADO ---");
                    System.out.println("Turno: " + o.getTurno());
                    System.out.println("Nombre: " + o.getNombre());
                    System.out.println("Edad: " + o.getEdad());

                    o.setEstado(3);

                    System.out.println("\nEl turno " + o.getTurno() + " fue cancelado con éxito.");
                    System.out.println("-------------------------------------------------------");
                }

                break;
            }
        }

        if (!encontrado) {
            System.out.println("El cliente con identificación " + buscado + " no se encuentra registrado aún.\n");
        } 
    }

    public void ContarPendientes(Queue<ObjBanco> cola, int opt){
        int contadorNor = 0;
        int contadorPre = 0;
        switch (opt) {
            case 1:
                for (ObjBanco o : cola) {
                    if (o.getEstado() == 1 && o.getCondicionAt() == 6) {
                        contadorNor ++;
                    }
                }
                System.out.println("Cantidad de clientes normales que están pendientes: " + contadorNor);
                break;

            case 2:
                for (ObjBanco o : cola) {
                    if (o.getEstado() == 1 && o.getCondicionAt() != 6) {
                        contadorPre ++;
                    }
                }
                System.out.println("Cantidad de clientes normales que están pendientes: " + contadorPre);
                break;

            default:
                System.out.println("Total de clientes en espera: " + (contadorNor + contadorPre));
                break;
        }
    }


    //*************VALIDACIÓN Y MENÚS*************

    public int ValidarTurno(Queue<ObjBanco> cola) {
        int turno = 0;
        if (cola.isEmpty()) {
            turno = 1;
        } else {
            turno = cola.size() + 1;
        }
        return turno;
    }

    public int ValidarEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Por favor ingresar un número entero.");
                sc.next();
            }
            return sc.nextInt();
        }
        
    private int TipoTramites(Scanner sc){
            System.out.println("1. Apertura de cuenta.");
            System.out.println("2. Depósito o retiro.");
            System.out.println("3. Solicitud de tarjeta.");
            System.out.println("4. Pago de créditos");
            System.out.println("5. PQRS.");
            return sc.nextInt();
        }

    private static String Tramites(int opt) {
        String mensaje = "";
        switch (opt) {
            case 1:
                mensaje = "Apertura de cuenta.";
                break;
            case 2:
                mensaje = "Depósito o retiro.";
                break;
            case 3:
                mensaje = "Solicitud de tarjeta.";
                break;
            case 4:
                mensaje = "Pago de créditos.";
                break;

            default:
                mensaje = "PQRS.";
                break;
        }
        return mensaje;
    }

    private int CondicionesAtencion(Scanner sc){
        System.out.println("1. Es un cliente Premium.");
        System.out.println("2. Es mayor de 60 años.");
        System.out.println("3. Tiene una discapacidad física.");
        System.out.println("4. Condición especial de salud.");
        System.out.println("5. Embarazo.");
        System.out.println("6. No tiene ninguna condición especial.");
        return sc.nextInt();
    }

    private static String Condiciones(int opt) {
        String mensaje = "";
        switch (opt) {
            case 1:
                mensaje = "Es un cliente Premium.";
                break;
            case 2:
                mensaje = "Es mayor de 60 años.";
                break;
            case 3:
                mensaje = "Tiene una discapacidad física.";
                break;
            case 4:
                mensaje = "Condición especial de salud.";
                break;
            case 5:
                mensaje = "Embarazo.";
                break;

            default:
                mensaje = "Ninguna.";
                break;
        }
        return mensaje;
    }

    
}

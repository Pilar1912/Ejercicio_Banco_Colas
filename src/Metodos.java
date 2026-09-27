import java.util.Scanner;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class Metodos {
    public Queue<ObjBanco> RegistrarClientes(Queue<ObjBanco> cola, Scanner sc, Metodos m){
        boolean continuar = true;

        while(continuar){
            ObjBanco o = new ObjBanco();
            o.setTurno(m.ValidarTurno(cola));

            System.out.println("Ingrese el número de identificación del cliente:");
            o.setIdentificacion(sc.next());

            System.out.println("Ingrese el nombre del cliente:");
            o.setNombre(sc.nextLine());

            System.out.println("Ingrese el tipo de trámite que va a realizar:");
            o.setTipoTramite(m.TipoTramites(sc));

            System.out.println("Ingrese la edad del cliente:");
            o.setEdad(m.ValidarEntero(sc));

            System.out.println("Selecciones una de las siguientes opciones si el cliente cumple con al menos una de ellas:");
            o.setCondicionAt(m.CondicionesAtencion(sc));

            o.setEstado(1);
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
                    System.out.println("Trámite a realizar: " + Tramites(o.getTipoTramite()));
                    System.out.println("Edad: " + o.getEdad());
                    
                    if (o.getCondicionAt() == 6) {
                        System.out.println("Condición especial: Ninguna\n");
                    }else{
                        System.out.println("Condición especial: " + Condiciones(o.getCondicionAt()) + "\n ATENCIÓN PREFERENCIAL");
                    }
                    
                    if(o.getEstado() == 1){
                        System.out.println("Estado: Pendiente");
                    }else{
                        System.out.println("Estado: Atendido");
                    }
                    System.out.println("------------------------------------------------\n");
                }
        }

        return "Datos mostrados correctamente";
        
    }

    public Queue<ObjBanco> Atender(Queue<ObjBanco> cola){
        for(ObjBanco o : cola){
            if (o.getEstado() == 1) {
                System.out.println("El siguiente turno es: " + o.getTurno() + 
                "\n A nombre del usuario: " + o.getNombre() + 
                "\n Número de identificación: " + o.getIdentificacion());
                o.setEstado(2);
                break;
            }
        }
        System.out.println("Usuario atendido exitosamente.");
        return cola;
    }

    public void BuscarClientePorId(Queue<ObjBanco> cola, Scanner sc) {
    System.out.println("Ingrese el número de identificación a buscar:");
    String buscado = sc.next();
    boolean encontrado = false;

    for (ObjBanco o : cola) {
        if (o.getIdentificacion().equals(buscado)) {
            System.out.println("\n--- CLIENTE ENCONTRADO ---");
            System.out.println("Turno: " + o.getTurno());
            System.out.println("Nombre: " + o.getNombre());
            System.out.println("Trámite: " + Tramites(o.getTipoTramite()));
            System.out.println("Estado: " + (o.getEstado() == 1 ? "Pendiente" : "Atendido"));
            System.out.println("---------------------------\n");
            encontrado = true;
            break; 
        }
    }

    if (!encontrado) {
        System.out.println("El cliente con identificación " + buscado + " no se encuentra registrado aún.\n");
    }
}


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
            System.out.println(
                "Por favor ingresar un número entero.");
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

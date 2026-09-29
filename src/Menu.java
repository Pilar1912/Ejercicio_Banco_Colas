import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<ObjBanco> cola = new LinkedList<>();
        Metodos m = new Metodos();
        boolean continuar = true;
        while (continuar) {
            System.out.println("-----BIENVENIDOS AL BANCO-----");
            System.out.println("¿Qué desea realizar?");
            System.out.println("1. Registrar cliente.");
            System.out.println("2. Mostrar todos los clientes.");
            System.out.println("3. Mostrar clientes pendientes.");
            System.out.println("4. Mostrar clientes cancelados.");
            System.out.println("5. Mostrar clientes atendidos.");
            System.out.println("6. Llamar al siguiente cliente (Atender siguiente turno).");
            System.out.println("7. Buscar cliente por número de identificación.");
            System.out.println("8. Cambiar a atención preferencial.");
            System.out.println("9. Cancelar turno.");
            System.out.println("10. Clientes normales pendientes.");
            System.out.println("11. Clientes preferenciales pendientes.");
            System.out.println("12. Total de clientes en espera.");
            System.out.println("13. Salir.");
            int opt = sc.nextInt();
            switch (opt) {
                case 1:
                    cola = m.RegistrarClientes(cola, sc, m);
                    break;
                case 2:
                    System.out.println("\n " + m.MostrarTurnos(cola, 1));
                    break;
                case 3:
                    System.out.println("\n" + m.MostrarTurnos(cola, 2));
                    break;
                case 4:
                    System.out.println("\n" + m.MostrarTurnos(cola, 3));
                    break;
                case 5:
                    System.out.println("\n" + m.MostrarTurnos(cola, 4));
                    break;
                case 6:
                    cola = m.Atender(cola);
                    break;
                case 7:
                    m.BuscarClientePorId(cola, sc);
                    break;
                case 8:
                    m.CambiarAtencion(cola, sc, m);
                    break;
                case 9:
                    m.CancelarTurno(cola, sc);
                    break;
                case 10:
                    m.ContarPendientes(cola, 1);
                    break;
                case 11:
                    m.ContarPendientes(cola, 2);
                    break;
                case 12:
                    m.ContarPendientes(cola, 3);
                    break;
                case 13:
                    System.out.println("Hasta luego.");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Ingrese un número del 1 al 10.");
                    break;
            }
        }
        
    }
    
}

package radio;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Radio radio = new RadioCarro(); // <- aquí se puede cambiar la implementación
        int opcion;

        do {
            System.out.println("\n===== RADIO =====");
            System.out.println("Estado: " + (radio.isEncendido() ? "Encendido" : "Apagado"));
            System.out.println("Banda: " + (radio.isFM() ? "FM" : "AM"));
            System.out.println("Emisora: " + radio.getEmisoraActual());
            System.out.println("-----------------");
            System.out.println("1. Prender radio");
            System.out.println("2. Cambiar AM/FM");
            System.out.println("3. Avanzar emisora");
            System.out.println("4. Guardar emisora");
            System.out.println("5. Cargar emisora");
            System.out.println("6. Apagar radio");
            System.out.println("0. Salir");
            System.out.print("Seleccione opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    radio.prenderRadio();
                    break;

                case 2:
                    radio.cambiarAMFM();
                    break;

                case 3:
                    radio.avanzarEmisora();
                    break;

                case 4:
                    System.out.print("Número de botón (1-12): ");
                    radio.guardarEmisora(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Número de botón (1-12): ");
                    radio.cargarEmisora(sc.nextInt());
                    break;

                case 6:
                    radio.apagarRadio();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);

        sc.close();
    }
}

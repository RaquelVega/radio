import java.util.Scanner;

/**
 * Programa principal para controlar un radio de carro.
 * Presenta un menú interactivo con las opciones principales.
 * 
 * @author Raquel Pamela Tejada Vega / Will Orellana
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {

        Radio miRadio = new RadioCarro();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        System.out.println("=================================");
        System.out.println("   SIMULADOR DE RADIO DE CARRO   ");
        System.out.println("=================================\n");

        while (!salir) {

            mostrarMenu(miRadio);

            System.out.print("\nSeleccione una opción: ");
            String opcion = scanner.nextLine().trim();

            switch (opcion) {

                case "1":
                    miRadio.prenderRadio();
                    System.out.println("\n✓ Radio encendido");
                    break;

                case "2":
                    if (verificarEncendido(miRadio)) {
                        if (miRadio.esFM()) {
                            miRadio.cambiarAM();
                            System.out.println("\n✓ Cambiado a AM");
                        } else {
                            miRadio.cambiarFM();
                            System.out.println("\n✓ Cambiado a FM");
                        }
                    }
                    break;

                case "3":
                    if (verificarEncendido(miRadio)) {
                        miRadio.avanzarEstacion();
                        System.out.println("\n✓ Estación avanzada");
                    }
                    break;

                case "4":
                    if (verificarEncendido(miRadio)) {
                        System.out.print("Ingrese el número de botón (1-12): ");
                        try {
                            int boton = Integer.parseInt(scanner.nextLine().trim());
                            if (boton >= 1 && boton <= 12) {
                                miRadio.guardarEstacion(boton);
                                System.out.println("\n✓ Estación guardada en botón " + boton);
                            } else {
                                System.out.println("\n✗ Número de botón inválido (debe ser 1-12)");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("\n✗ Entrada inválida");
                        }
                    }
                    break;

                case "5":
                    if (verificarEncendido(miRadio)) {
                        System.out.print("Ingrese el número de botón (1-12): ");
                        try {
                            int boton = Integer.parseInt(scanner.nextLine().trim());
                            if (boton >= 1 && boton <= 12) {
                                miRadio.cargarEstacion(boton);
                                System.out.println("\n✓ Estación cargada desde botón " + boton);
                            } else {
                                System.out.println("\n✗ Número de botón inválido (debe ser 1-12)");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("\n✗ Entrada inválida");
                        }
                    }
                    break;

                case "6":
                    miRadio.apagarRadio();
                    System.out.println("\n✓ Radio apagado");
                    break;

                case "7":
                    System.out.println("\n¡Gracias por usar el simulador de radio!");
                    salir = true;
                    break;

                default:
                    System.out.println("\n✗ Opción inválida. Intente nuevamente.");
            }

            if (!salir) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void mostrarMenu(Radio radio) {
        System.out.println("\n---------------------------------");
        System.out.println("Estado: " + radio.getEstado());
        System.out.println("---------------------------------");
        System.out.println("1. Prender el radio");
        System.out.println("2. Cambiar de AM a FM (o viceversa)");
        System.out.println("3. Avanzar en el dial de emisoras");
        System.out.println("4. Guardar emisora en un botón");
        System.out.println("5. Seleccionar emisora de un botón");
        System.out.println("6. Apagar el radio");
        System.out.println("7. Salir del programa");
        System.out.println("---------------------------------");
    }

    private static boolean verificarEncendido(Radio radio) {
        if (!radio.estaEncendido()) {
            System.out.println("\n✗ El radio está apagado. Enciéndalo primero.");
            return false;
        }
        return true;
    }
}

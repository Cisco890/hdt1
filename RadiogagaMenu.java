import java.util.Scanner;

public class RadiogagaMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Radiogaga radio = new Radiogaga(false, false, 0.0, new double[12], new double[12]);

        while (true) {// primer menu del programa
            System.out.println("\n 1. Encender Radio");
            System.out.println("2. Cerrar programa");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                scanner.nextLine();  
                switch (opcion) {
                    case 1:// opcion para encender radio
                        radio.SwitchOnOff();
                       
                        if (radio.isON()) {// enciende la radio
                            System.out.println("Radio encendido.");

                            // Submenú para la radio encendida
                            while (true) {
                                System.out.println("\n Usted esta escuchando la emisora "+ radio.emisora() +" en la frecuencia "  + radio.frecuencia());
                                System.out.println("\n Opciones de Radio Gaga");
                                System.out.println("1. Apagar Radio Gaga");
                                System.out.println("2. Siguiente emisora");
                                System.out.println("3. Cambiar de frecuencia (AM/FM)");
                                System.out.print("Seleccione una opción: ");
                                
                                if (scanner.hasNextInt()) {
                                    int opcionSubMenu = scanner.nextInt();
                                    scanner.nextLine();
                                    if (opcionSubMenu == 1) {
                                        System.out.println("Apagando Radio Gaga");
                                        radio.SwitchOnOff(); // Apaga la radio
                                        break; // Salir del submenú, apagar la radio
                                    } else if (opcionSubMenu == 2) {
                                        System.out.println("Cambiando de emisora");
                                        radio.nextStation();
                                        System.out.println("\n La nueva emisora es la número "+ radio.emisora() );
                                    } else if (opcionSubMenu == 3) {
                                        System.out.println("Cambiando de frecuencia ");
                                        radio.SwitchAMFM(); // Cambiar de AM a FM/ de FM a AM

                                        System.out.println("\n Frecuencia cambiada a " + radio.frecuencia());
                                    } else {
                                        System.out.println("Opción no válida");
                                    }
                                }
                            }
                        } else {
                            System.out.println("El radio ya está encendido.");
                        }
                        break;
                    

                    case 2:
                        System.out.println("Saliendo del programa. Sintonice Radio Gaga pronto :)");
                        return;  // Salir del método main y finalizar el programa

                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            }
            }
}
}
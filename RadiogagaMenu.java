/** Anthony Lou Shwank 23410/Juan Francisco Martínez 23617
  * RadiogagaMenu
 
  * @param Scanner_de_usuario,objeto_radio
  * @throws Todo el funcionamiento de la radio
  */
import java.util.Scanner;
import java.lang.reflect.Field;


public class RadiogagaMenu {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        Scanner scanner = new Scanner(System.in);

        Radiogaga radio = new Radiogaga(false, false, 0.0, new double[12], new double[12]);

        while (true) {// primer menu del programa
            System.out.println("\n1. Encender Radio");
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
                                String frecuencia;
                                if (radio.isAM()== true) {// revisar en que frecuencia se esta utilizando
                                    frecuencia= "AM";
                                } else {
                                    frecuencia = "FM";
                                }
                                // Obtén la referencia al campo privado 'station' en la clase Radiogaga n
                                Field campoStation = Radiogaga.class.getDeclaredField("station");

                                // Hacer el campo accesible, incluso si es privado
                                campoStation.setAccessible(true);

                                // Obtener el valor del campo 'station' en el objeto 'radio'
                                double valorStation = (double) campoStation.get(radio);
                                double valorStationR = Math.round(valorStation * 10.0) / 10.0;
                                //nota de la linea 40 a la 42 se saco de chatgpt, porque no encontrabamos otra manera de obtener el valor de la radio

                                System.out.println("\n Usted esta escuchando la emisora "+ valorStationR +" en la frecuencia "  + frecuencia);
                                System.out.println("\n Opciones de Radio Gaga");
                                System.out.println("1. Apagar Radio Gaga");
                                System.out.println("2. Siguiente emisora");
                                System.out.println("3. Cambiar de frecuencia (AM/FM)");
                                System.out.println("4. Guardar la estación actual");
                                System.out.println("5. Seleccionar la radio guardada que desea escuchar (de 1 a 12)");
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
                                        System.out.println("\n La nueva emisora es la número "+ valorStationR );
                                    } else if (opcionSubMenu == 3) {
                                        System.out.println("Cambiando de frecuencia ");
                                        radio.SwitchAMFM(); // Cambiar de AM a FM/ de FM a AM
                                        if (radio.isAM()== true) {// revisar que frecuencia se esta utilizando 
                                            frecuencia= "AM";
                                        } else {
                                            frecuencia = "FM";
                                        }
                                        System.out.println("\n Frecuencia cambiada a " + frecuencia);
                                    } 
                                    else if (opcionSubMenu == 4) {

                                       System.out.println("Para guardar la estacion "+ valorStationR+" presione un número del 1 al 12");
                                       int boton = scanner.nextInt()-1;
                                        radio.saveStation(boton, valorStationR);
                                        System.out.println("Se ha guardado la "+ valorStationR +" en el número: " + (boton+1));
                                    }
                                    else if (opcionSubMenu == 5) {
                                        System.out.println("Seleccione el número (1-12) de la emisora guardada que desea escuchar");
                                        int emisoraGuardada = scanner.nextInt();
                                    
                                        // Validar si la emisora guardada está configurada
                                        if (emisoraGuardada >= 1 && emisoraGuardada <= 12) {
                                            double emisoraSeleccionada = radio.selectStation(emisoraGuardada - 1);
                                    
                                            // Verificar si la emisora seleccionada es diferente de 0.0 (o cualquier valor por defecto)
                                            if (emisoraSeleccionada != 0.0) {
                                                System.out.println("Escuchando la emisora guardada " + emisoraSeleccionada);
                                            } else {
                                                System.out.println("La emisora guardada en la posición " + emisoraGuardada + " no está configurada.");
                                            }
                                        } else {
                                            System.out.println("Número de emisora no válido. Debe estar en el rango de 1 a 12.");
                                        }
                                    }
                                    else {
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
/** Anthony Lou Shwank 23410/Juan Francisco Martínez 23617
  * Radiogaga
 
  * @param   no_hay
  * @throws Interfaz creada por todos en la clase
  */
interface IRadio {
    void saveStation (int buttonId, double station ); //Metodo que servira para guardar una estacion a base del boton a el cual sera guardado y el numero de la estacion
    boolean isAM(); //Nos dice en que frecuencia esta la radio
    boolean isOn(); //Nos dice si la radio esta encendida o apagada
    double selectStation(int buttonId); //Metodo que servira para seleccionar el boton en donde se guardo una emisora
    void  switchOnOff(); //Enciende o apaga la radio, solo con instanciar el metodo hara el contrario del estado actual
    void switchAMFM(); //Cambia la frecuencia a la que la radio esta funcionando
    double nextStation(); //Cambia a la siguiente estacion, cabe resaltar que habra una diferenciacion de cuantos numeros avanzara a base de la frecuencia en la que se encuentre la radio
}
import org.junit.*;
import org.junit.Before;
import org.junit.Test;

public class RadiogagaTest {

    private Radiogaga radio; 

    @Before
    public void setUp() {
        // Configuración inicial antes de cada prueba
        radio = new Radiogaga(false, true, 530.0, new double[12], new double[12]);
    }

    @Test
    public void testSaveStationInAM() {
        int buttonId = 0;
        double station = 100.5;

        radio.saveStation(buttonId, station);

        // Verifica que la estación se haya guardado correctamente en la lista AM
        Assert.assertEquals(station, radio.isAM() ? radio.selectStation(buttonId) : 0.0, 0.001);
    }

    @Test
    public void testSaveStationInFM() {
        radio.SwitchAMFM(); // Cambia a la frecuencia FM
        int buttonId = 0;
        double station = 95.2;

        radio.saveStation(buttonId, station);

        // Verifica que la estación se haya guardado correctamente en la lista FM
        Assert.assertEquals(station, radio.isAM() ? 0.0 : radio.selectStation(buttonId), 0.001);
    }

    @Test
    public void testSwitchAMFM() {
        radio.SwitchAMFM();

        // Verifica que la frecuencia haya cambiado correctamente
        Assert.assertEquals("FM", radio.frecuencia());
    }

    @Test
    public void testSwitchOnOff() {
        radio.SwitchOnOff();

        // Verifica que el estado de encendido/apagado haya cambiado correctamente
        Assert.assertTrue(radio.isON());
    }

    @Test
    public void testNextStationInAM() {
        double initialStation = radio.emisora();
        radio.nextStation();

        // Verifica que la siguiente estación en AM se haya calculado correctamente
        Assert.assertEquals(initialStation + 10.0, radio.emisora(), 0.001);
    }

    @Test
    public void testNextStationInFM() {
        radio.SwitchAMFM(); 
        double initialStation = radio.emisora();
        radio.nextStation();

        Assert.assertEquals(initialStation + 0.2, radio.emisora(), 0.001);
    }
}

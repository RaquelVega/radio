import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RadioTest {

    private Radio radio;

    @Before
    public void setup() {
        radio = new RadioCarro();
    }

    @Test
    public void testRadioIniciaApagado() {
        assertFalse(radio.estaEncendido());
    }

    @Test
    public void testPrenderRadio() {
        radio.prenderRadio();
        assertTrue(radio.estaEncendido());
    }

    @Test
    public void testCambiarAM() {
        radio.prenderRadio();
        radio.cambiarAM();
        assertFalse(radio.esFM());
    }

    @Test
    public void testAvanzarEstacionFM() {
        radio.prenderRadio();
        radio.avanzarEstacion();
        assertEquals("Radio encendido - FM: 88.1", radio.getEstado());
    }

    @Test
    public void testGuardarYCargarEstacion() {
        radio.prenderRadio();
        radio.avanzarEstacion(); // 88.1
        radio.guardarEstacion(1);

        radio.avanzarEstacion(); // 88.3
        radio.cargarEstacion(1);

        assertEquals("Radio encendido - FM: 88.1", radio.getEstado());
    }
}

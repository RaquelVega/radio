import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RadioCarroTest {

    private RadioCarro radio;

    @Before
    public void setup() {
        radio = new RadioCarro();
    }

    @Test
    public void testIniciaApagado() {
        assertFalse(radio.estaEncendido());
    }

    @Test
    public void testIniciaEnFM() {
        assertTrue(radio.esFM());
    }

    @Test
    public void testFrecuenciaInicialFM() {
        radio.prenderRadio();
        assertEquals("Radio encendido - FM: 87.9", radio.getEstado());
    }

    @Test
    public void testAvanzarFM() {
        radio.prenderRadio();
        radio.avanzarEstacion();
        assertEquals("Radio encendido - FM: 88.1", radio.getEstado());
    }

    @Test
    public void testCambiarAM() {
        radio.prenderRadio();
        radio.cambiarAM();
        assertEquals("Radio encendido - AM: 530", radio.getEstado());
    }

    @Test
    public void testAvanzarAM() {
        radio.prenderRadio();
        radio.cambiarAM();
        radio.avanzarEstacion();
        assertEquals("Radio encendido - AM: 540", radio.getEstado());
    }

    @Test
    public void testGuardarYCargarFM() {
        radio.prenderRadio();
        radio.avanzarEstacion(); // 88.1
        radio.guardarEstacion(1);

        radio.avanzarEstacion(); // 88.3
        radio.cargarEstacion(1);

        assertEquals("Radio encendido - FM: 88.1", radio.getEstado());
    }

    @Test
    public void testNoAvanzaSiEstaApagado() {
        radio.avanzarEstacion();
        assertEquals("Radio apagado", radio.getEstado());
    }
}
 
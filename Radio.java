/**
 * Interfaz que define las operaciones básicas de un radio.
 * Permite encender/apagar, cambiar entre AM/FM, avanzar estaciones,
 * y guardar/cargar estaciones en botones programables.
 * 
 * @author Raquel Pamela Tejada Vega / Will Orellana
 * @version 1.0
 */
public interface Radio {

    /**
     * Enciende el radio.
     */
    void prenderRadio();

    /**
     * Apaga el radio.
     */
    void apagarRadio();

    /**
     * Avanza a la siguiente estación en el dial actual (FM o AM).
     */
    void avanzarEstacion();

    /**
     * Guarda la estación actual en un botón programable.
     * 
     * @param numeroBoton número del botón (1-12) donde guardar
     */
    void guardarEstacion(int numeroBoton);

    /**
     * Carga una estación previamente guardada en un botón.
     * 
     * @param numeroBoton número del botón (1-12) a cargar
     */
    void cargarEstacion(int numeroBoton);

    /**
     * Cambia el radio a modo FM.
     */
    void cambiarFM();

    /**
     * Cambia el radio a modo AM.
     */
    void cambiarAM();
}


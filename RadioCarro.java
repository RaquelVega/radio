/**
 * Clase que implementa la interfaz Radio para simular el funcionamiento
 * de un radio de carro con capacidad de sintonizar estaciones AM y FM.
 * 
 * @author Raquel Pamela Tejada Vega / Will Orellana
 * @version 1.0
 */
public class RadioCarro implements Radio {

    private boolean encendido;
    private boolean esFM;
    private double estacionFM;
    private int estacionAM;
    private double[] botonesFM;
    private int[] botonesAM;

    /**
     * Constructor que inicializa el radio en estado apagado,
     * en modo FM, con la estación FM en 87.9 y AM en 530.
     * Inicializa los 12 botones para cada banda.
     */
    public RadioCarro() {
        encendido = false;
        esFM = true;
        estacionFM = 87.9;
        estacionAM = 530;
        botonesFM = new double[12];
        botonesAM = new int[12];
        
        // Inicializar botones con valores por defecto
        for (int i = 0; i < 12; i++) {
            botonesFM[i] = 87.9;
            botonesAM[i] = 530;
        }
    }

    /**
     * Enciende el radio.
     */
    @Override
    public void prenderRadio() {
        encendido = true;
    }

    /**
     * Apaga el radio.
     */
    @Override
    public void apagarRadio() {
        encendido = false;
    }

    /**
     * Cambia el radio a modo FM.
     */
    @Override
    public void cambiarFM() {
        esFM = true;
    }

    /**
     * Cambia el radio a modo AM.
     */
    @Override
    public void cambiarAM() {
        esFM = false;
    }

    /**
     * Avanza a la siguiente estación en el dial.
     * FM avanza en incrementos de 0.2 (87.9 a 107.9).
     * AM avanza en incrementos de 10 (530 a 1610).
     * Al llegar al final, reinicia desde el principio.
     */
    @Override
    public void avanzarEstacion() {
        if (!encendido) {
            return;
        }

        if (esFM) {
            estacionFM += 0.2;
            // Redondear para evitar problemas de precisión con doubles
            estacionFM = Math.round(estacionFM * 10.0) / 10.0;
            if (estacionFM > 107.9) {
                estacionFM = 87.9;
            }
        } else {
            estacionAM += 10;
            if (estacionAM > 1610) {
                estacionAM = 530;
            }
        }
    }

    /**
     * Guarda la estación actual en uno de los 12 botones.
     * 
     * @param numeroBoton número del botón (1-12) donde guardar la estación
     */
    @Override
    public void guardarEstacion(int numeroBoton) {
        if (!encendido || numeroBoton < 1 || numeroBoton > 12) {
            return;
        }

        if (esFM) {
            botonesFM[numeroBoton - 1] = estacionFM;
        } else {
            botonesAM[numeroBoton - 1] = estacionAM;
        }
    }

    /**
     * Carga la estación guardada en uno de los 12 botones.
     * 
     * @param numeroBoton número del botón (1-12) de donde cargar la estación
     */
    @Override
    public void cargarEstacion(int numeroBoton) {
        if (!encendido || numeroBoton < 1 || numeroBoton > 12) {
            return;
        }

        if (esFM) {
            estacionFM = botonesFM[numeroBoton - 1];
        } else {
            estacionAM = botonesAM[numeroBoton - 1];
        }
    }


    /**
     * Obtiene la estación FM actual.
     * 
     * @return frecuencia FM actual
     */
    public double getEstacionFM() {
        return estacionFM;
    }

    /**
     * Obtiene la estación AM actual.
     * 
     * @return frecuencia AM actual
     */
    public int getEstacionAM() {
        return estacionAM;
    }


        /**
     * Indica si el radio está encendido.
     */
    @Override
    public boolean estaEncendido() {
        return encendido;
    }

    /**
     * Indica si el radio está en modo FM.
     */
    @Override
    public boolean esFM() {
        return esFM;
    }

    /**
     * Obtiene el estado actual del radio como String.
     */
    @Override
    public String getEstado() {
        if (!encendido) {
            return "Radio apagado";
        }

        if (esFM) {
            return "Radio encendido - FM: " + String.format("%.1f", estacionFM);
        } else {
            return "Radio encendido - AM: " + estacionAM;
        }
    }

}

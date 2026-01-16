public class RadioCarro implements Radio {

    private boolean encendido;
    private boolean esFM;

    private double estacionFM;
    private int estacionAM;

    private double[] botonesFM;
    private int[] botonesAM;

    public RadioCarro() {
        encendido = false;
        esFM = true;

        estacionFM = 87.9;
        estacionAM = 530;

        botonesFM = new double[12];
        botonesAM = new int[12];
    }

    @Override
    public void prenderRadio() {
        encendido = true;
    }

    @Override
    public void apagarRadio() {
        encendido = false;
    }

    @Override
    public void cambiarFM() {
        esFM = true;
    }

    @Override
    public void cambiarAM() {
        esFM = false;
    }

    @Override
    public void avanzarEstacion() {
        if (!encendido) {
            return;
        }

        if (esFM) {
            estacionFM += 0.2;
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
}

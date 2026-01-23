package radio;

public class RadioCarro implements Radio {

    private boolean encendido;
    private boolean esFM;
    private double emisoraActual;

    private double[] botonesFM;
    private double[] botonesAM;

    public RadioCarro() {
        encendido = false;
        esFM = true;
        emisoraActual = 87.9;

        botonesFM = new double[12];
        botonesAM = new double[12];

        for (int i = 0; i < 12; i++) {
            botonesFM[i] = 87.9;
            botonesAM[i] = 530;
        }
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
    public void cambiarAMFM() {
        esFM = !esFM;
        emisoraActual = esFM ? 87.9 : 530;
    }

    @Override
    public void avanzarEmisora() {
        if (!encendido) return;

        if (esFM) {
            emisoraActual += 0.2;
            if (emisoraActual > 107.9) {
                emisoraActual = 87.9;
            }
        } else {
            emisoraActual += 10;
            if (emisoraActual > 1610) {
                emisoraActual = 530;
            }
        }
    }

    @Override
    public void guardarEmisora(int boton) {
        if (boton < 1 || boton > 12) return;

        if (esFM) {
            botonesFM[boton - 1] = emisoraActual;
        } else {
            botonesAM[boton - 1] = emisoraActual;
        }
    }

    @Override
    public void cargarEmisora(int boton) {
        if (boton < 1 || boton > 12) return;

        emisoraActual = esFM ? botonesFM[boton - 1] : botonesAM[boton - 1];
    }

    @Override
    public boolean isEncendido() {
        return encendido;
    }

    @Override
    public boolean isFM() {
        return esFM;
    }

    @Override
    public double getEmisoraActual() {
        return emisoraActual;
    }
}

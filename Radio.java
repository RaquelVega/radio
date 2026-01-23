package radio;

public interface Radio {

    void prenderRadio();
    void apagarRadio();
    void cambiarAMFM();
    void avanzarEmisora();
    void guardarEmisora(int boton);
    void cargarEmisora(int boton);

    boolean isEncendido();
    boolean isFM();
    double getEmisoraActual();
}

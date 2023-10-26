package umu.tds.modelo;

public class Controlador {

    private Reproductor reproductor;
    private static String CODIGO_PROMOCIONAL = "JULISCO";

    public Controlador(){
        reproductor = new Reproductor();
    }

    public void play(){
        reproductor.play(null);
    }
}

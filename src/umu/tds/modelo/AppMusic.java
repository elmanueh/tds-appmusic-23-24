package umu.tds.modelo;

public class AppMusic {

    private Reproductor reproductor;
    private RepositorioCanciones repositorioCanciones;
    private RepositorioUsuarios reproductorUsuarios;
    private static String CODIGO_PROMOCIONAL = "JULISCO";

    public AppMusic(){
        reproductor = new Reproductor();
        repositorioCanciones = new RepositorioCanciones();
    }

    public void play(){
        reproductor.play(null);
    }
}

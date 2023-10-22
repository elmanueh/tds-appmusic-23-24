package umu.tds.vista;

public class AppMusic {

    private Reproductor reproductor;
    private RepositorioCanciones repositorioCanciones;
    private RepositorioUsuarios reproductorUsuarios;

    public AppMusic(){
        reproductor = new Reproductor();
        repositorioCanciones = new RepositorioCanciones();
    }

    public void play(){
        reproductor.play(null);
    }
}

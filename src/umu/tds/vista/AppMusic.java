package umu.tds.vista;

import umu.tds.vista.clases.RepositorioCanciones;
import umu.tds.vista.clases.RepositorioUsuarios;
import umu.tds.vista.clases.Reproductor;

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

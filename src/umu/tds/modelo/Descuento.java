package umu.tds.modelo;

public class Descuento {

	public int rebaja;
	
	public Descuento(){
    }

    public int calcDescuento(int Coste){
        return Coste - rebaja;
    }

}

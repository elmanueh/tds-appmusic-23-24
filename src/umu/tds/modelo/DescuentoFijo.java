package umu.tds.modelo;

public class DescuentoFijo extends Descuento{

    public DescuentoFijo(){

    }
    @Override
    public int calcDescuento(int Coste){
        return 1;
    }
}
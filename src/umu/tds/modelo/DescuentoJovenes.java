package umu.tds.modelo;

public class DescuentoJovenes extends Descuento{
    
    public DescuentoJovenes(){

    }
    @Override
    public int calcDescuento(int Coste){
        return 1;
    }
}

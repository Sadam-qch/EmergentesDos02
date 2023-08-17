import java.util.ArrayList;

public class Subasta
{
    // instance variables - replace the example below with your own
    private ArrayList<Lote> lotes;
    private int numeroDeLoteSiguiente;
    
    public Subasta()
    {
        // initialise instance variables
        lotes = new ArrayList<Lote>();
        numeroDeLoteSiguiente = 1;
    }
    
    public void ingresarLote(String descripcion){
        lotes.add(new Lote(numeroDeLoteSiguiente, descripcion));
        numeroDeLoteSiguiente++;
    }
    public void mostrarLotes(){
        for(Lote lote : lotes){
            System.out.println(lote.toString());
        }
    }
    public void ofertarPara(int numeroDeLote, Persona ofertante, long valor){
        Lote loteElegido = getLote(numeroDeLote);
        boolean exito = false;
        
        if(loteElegido != null){
            exito = loteElegido.ofertarPara(new Oferta(ofertante, valor));
        }
        if(exito){
            System.out.println("La oferta oara el Nº "+numeroDeLote+"resulto exitosa");
        }else{
            Oferta ofertaMaxima = loteElegido.getOfertaMaxima();
            System.out.println("El lote Nº "+ numeroDeLote + " tiene una oferta de: "+ofertaMaxima.getMonto());
            
        }
    }
    public Lote getLote(int numeroDeLote){
        if ((numeroDeLote >= 1) && (numeroDeLote < numeroDeLoteSiguiente)){
                Lote loteElegido = lotes.get(numeroDeLote -1);
                if(loteElegido.getNumero() != numeroDeLote){
                    System.out.println("Error interno: se retorno el lote Nº.. "+loteElegido.getNumero()+" en el lugar de: "+numeroDeLote);
                }
                return loteElegido;
        }else{
            System.out.println("El lote numero: "+numeroDeLote+" no existe");
            return null;
        }
    }
    
    public void mostrarAdjudicados(){
        for(Lote  lote : lotes){
            System.out.println(lote.mostrarGanador());
        }
    }
}

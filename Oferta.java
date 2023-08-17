
public class Oferta
{
    private Persona ofertante;
    private long monto;
    
    public Oferta(Persona ofertante, long monto)
    {
        // initialise instance variables
        this.ofertante = ofertante;
        this.monto = monto;
    }   
    public long getMonto(){
        return monto;
    }
    public String getNombre(){
        return ofertante.getPersona();
    }
}

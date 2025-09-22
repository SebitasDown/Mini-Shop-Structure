package app.Model;

public class Alimento extends Producto{
    private String TipodeAlimento;
    public Alimento(String nombre, double precio) {
        super(nombre, precio);
        setTipodeAlimento(TipodeAlimento);
    }
    
    public String getTipodeAlimento() {
        return TipodeAlimento;
    }
    public void setTipodeAlimento(String TipodeAlimento) {
        this.TipodeAlimento = TipodeAlimento;
    }

    @Override
    public String getDescripcion() {
        return "";
    }
}

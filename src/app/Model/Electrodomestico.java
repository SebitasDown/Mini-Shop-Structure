package app.Model;

public class Electrodomestico extends Producto {
    private String Marca;
    public Electrodomestico(String nombre, double precio) {
        super(nombre, precio);
        setMarca(Marca);
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }
    public String getMarca() {
        return Marca;
    }

    @Override
    public String getDescripcion() {
        return "Nombre: " + getNombre() + ", Precio: " + getPrecio() + ", Marca: " + getMarca();
    }
}

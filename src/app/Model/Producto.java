package app.Model;

public abstract class Producto {
   private String nombre;
   private double precio;

    public Producto(String nombre, double precio) {
        setNombre(nombre);
        setPrecio(precio);
    }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getNombre() { return nombre; }

    public void setPrecio(double precio) { this.precio = precio; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return "nombre: " + getNombre() + ", precio: " + getPrecio();
    }

    public abstract String getDescripcion();
}

package app.Service;

import app.Interfaces.productoInterface;
import app.Model.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServiceProductos implements productoInterface {
    private List<Producto> listProductos = new ArrayList<>();
    private HashMap<String, Integer> Stock = new HashMap<>();
    private double[] precios;



    @Override
    public void ListarProductos() {

    }

    @Override
    public void AgregarProducto() {

    }

    @Override
    public void comprarProducto() {

    }

    @Override
    public void buscarProducto() {

    }
}

package app.Service;

import app.Interfaces.productoInterface;
import app.Model.Producto;
import app.Model.Alimento;
import app.Model.Electrodomestico;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServiceProductos implements productoInterface {
    private List<Producto> listProductos = new ArrayList<>();
    private HashMap<String, Integer> stock = new HashMap<>();
    private double[] precios;
    private double totalCompras = 0;

    @Override
    public void ListarProductos() {
        if (listProductos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos en el inventario.");
            return;
        }

        StringBuilder sb = new StringBuilder("Inventario:\n");
        for (Producto p : listProductos) {
            sb.append(p.getNombre())
                    .append(" - $").append(p.getPrecio())
                    .append(" - Stock: ").append(stock.get(p.getNombre()))
                    .append(" - ").append(p.getDescripcion())
                    .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    @Override
    public void AgregarProducto() {
        String tipo = JOptionPane.showInputDialog("Ingrese tipo (Alimento/Electrodomestico):");
        String nombre = JOptionPane.showInputDialog("Nombre del producto:");

        if (nombre == null || nombre.isBlank()) {
            JOptionPane.showMessageDialog(null, "Nombre inválido");
            return;
        }
        if (stock.containsKey(nombre)) {
            JOptionPane.showMessageDialog(null, "Ya existe un producto con ese nombre");
            return;
        }

        double precio;
        try {
            precio = Double.parseDouble(JOptionPane.showInputDialog("Precio:"));
            if (precio <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Precio inválido");
            return;
        }

        int cantidad;
        try {
            cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad en stock:"));
            if (cantidad <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad inválida");
            return;
        }

        Producto p;
        if (tipo.equalsIgnoreCase("Alimento")) {
            p = new Alimento(nombre, precio);
        } else if (tipo.equalsIgnoreCase("Electrodomestico")) {
            p = new Electrodomestico(nombre, precio);
        } else {
            JOptionPane.showMessageDialog(null, "Tipo inválido");
            return;
        }

        listProductos.add(p);
        stock.put(nombre, cantidad);
        actualizarPrecios();
        JOptionPane.showMessageDialog(null, "Producto agregado exitosamente.");
    }

    @Override
    public void comprarProducto() {
        if (listProductos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos disponibles.");
            return;
        }

        String nombre = JOptionPane.showInputDialog("Ingrese nombre del producto:");
        if (!stock.containsKey(nombre)) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.");
            return;
        }

        int cantidad;
        try {
            cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad a comprar:"));
            if (cantidad <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad inválida");
            return;
        }

        int disponible = stock.get(nombre);
        if (cantidad > disponible) {
            JOptionPane.showMessageDialog(null, "Stock insuficiente.");
            return;
        }

        for (Producto p : listProductos) {
            if (p.getNombre().equals(nombre)) {
                totalCompras += p.getPrecio() * cantidad;
                break;
            }
        }

        stock.put(nombre, disponible - cantidad);
        JOptionPane.showMessageDialog(null, "Compra realizada con éxito.");
    }

    @Override
    public void buscarProducto() {
        if (listProductos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos en el inventario.");
            return;
        }

        String termino = JOptionPane.showInputDialog("Ingrese el nombre o parte del nombre a buscar:");
        if (termino == null || termino.isBlank()) {
            JOptionPane.showMessageDialog(null, "Búsqueda inválida.");
            return;
        }

        StringBuilder sb = new StringBuilder("Resultados de la búsqueda:\n");
        boolean encontrado = false;

        for (Producto p : listProductos) {
            if (p.getNombre().toLowerCase().contains(termino.toLowerCase())) {
                sb.append(p.getNombre())
                        .append(" - $").append(p.getPrecio())
                        .append(" - Stock: ").append(stock.get(p.getNombre()))
                        .append(" - ").append(p.getDescripcion())
                        .append("\n");
                encontrado = true;
            }
        }

        if (encontrado) {
            JOptionPane.showMessageDialog(null, sb.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron productos con ese término.");
        }
    }

    @Override
    public void estadisticas() {
        if (listProductos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos para analizar.");
            return;
        }

        Producto masCaro = listProductos.get(0);
        Producto masBarato = listProductos.get(0);

        for (Producto p : listProductos) {
            if (p.getPrecio() > masCaro.getPrecio()) masCaro = p;
            if (p.getPrecio() < masBarato.getPrecio()) masBarato = p;
        }

        JOptionPane.showMessageDialog(null,
                "📊 Estadísticas:\n" +
                        "Producto más caro: " + masCaro.getNombre() + " ($" + masCaro.getPrecio() + ")\n" +
                        "Producto más barato: " + masBarato.getNombre() + " ($" + masBarato.getPrecio() + ")");
    }

    @Override
    public void mostrarTicketFinal() {
        JOptionPane.showMessageDialog(null, "Total de compras realizadas: $" + totalCompras);
    }

    // 🔄 Actualizar array de precios para estadísticas rápidas
    private void actualizarPrecios() {
        precios = listProductos.stream().mapToDouble(Producto::getPrecio).toArray();
    }
}

package app;

import app.Service.ServiceProductos;

import javax.swing.*;

public class Menu {
    private ServiceProductos service = new ServiceProductos();

    public void mostrarMenu() {
        int opcion;
        do {
            String menu = """
                    --- MINI SHOP ---
                    1. Agregar producto
                    2. Listar inventario
                    3. Comprar producto
                    4. Estadísticas
                    5. Buscar producto
                    6. Salir
                    """;
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1 -> service.AgregarProducto();
                case 2 -> service.ListarProductos();
                case 3 -> service.comprarProducto();
                case 4 -> service.estadisticas();
                case 5 -> service.buscarProducto();
                case 6 -> service.mostrarTicketFinal();
                default -> JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while (opcion != 6);
    }
}

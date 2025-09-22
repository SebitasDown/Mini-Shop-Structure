package app;

import javax.swing.JOptionPane;
public class Menu {

    // aqui va el servicio donde se llaman las comprovaciones de los inputs

    public void menu() {
        int opcion = 0;
        do {
            String menu = """
                        ════════════════════════════════
                                  🛒 MINI-TIENDA        
                        ════════════════════════════════
                            1.  Agregar Producto          
                            2.  Listar Inventario         
                            3.  Comprar Producto          
                            4.  📊 Estadísticas           
                            5.  🔍 Buscar Producto          
                            6.  🚪 Salir                   
                        ════════════════════════════════
                        
                       👉 Elija una opción:                    """;

            String input = JOptionPane.showInputDialog(menu);
            if (input == null){
                break;
            }
            try {
                 opcion = Integer.parseInt(input);
                switch (opcion) {
                    case 1 -> {
                        // Agregar Producto
                    }
                    case 2 -> {
                        // Listar Inventario
                    }
                    case 3 -> {
                        // Comprar Producto
                    }
                    case 4 -> {
                        // Estadísticas
                    }
                    case 5 -> {
                        // Buscar Producto
                    }
                    case 6 -> JOptionPane.showMessageDialog(null, "¡Gracias por usar la Mini-Tienda! ¡Hasta luego!");
                    default -> JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción del 1 al 6.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
            }


        }while(opcion != 6);

    }
}

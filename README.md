# Mini-Tienda

Mini-Tienda es una aplicación Java sencilla que simula la gestión de una tienda, permitiendo agregar productos, listar inventario, comprar productos y buscar productos.

## Estructura del Proyecto

```
src/
  app/
    Main.java
    Menu.java
    Interfaces/
      productoInterface.java
    Model/
      Alimento.java
      Electrodomestico.java
      Producto.java
    Service/
      ServiceProductos.java
```

## Descripción de Carpetas y Archivos

- **Main.java**: Punto de entrada de la aplicación.
- **Menu.java**: Muestra el menú principal y gestiona la interacción con el usuario.
- **Interfaces/productoInterface.java**: Define las operaciones principales sobre productos.
- **Model/**: Contiene las clases de modelo:
  - `Producto.java`: Clase abstracta base para productos.
  - `Alimento.java`: Representa productos de tipo alimento.
  - `Electrodomestico.java`: Representa productos de tipo electrodoméstico.
- **Service/ServiceProductos.java**: Implementa la lógica para gestionar productos.

## Cómo ejecutar

1. Compila el proyecto:
   ```sh
   javac -d out src/app/Main.java
   ```
2. Ejecuta la aplicación:
   ```sh
   java -cp out app.Main
   ```

## Funcionalidades

- Agregar productos
- Listar inventario
- Comprar productos
- Buscar productos

## Requisitos

- Java 8 o superior

---

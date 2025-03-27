package cafeteria;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Pedido {
    private String idPedido;
    private Producto[] productos;
    public enum Estado {PENDIENTE, EN_PROCESO, ENTREGADO}
    private Estado estado;
    private double total;
    private int cantidadProductos;


    public Pedido(String idPedido) {
        this.idPedido = idPedido;
        this.productos = new Producto[10];
        this.cantidadProductos = 0;
        this.estado = Estado.PENDIENTE;
        this.total = 0.0;
    }

    public void agregarProducto(Producto producto) {
        if(producto != null && cantidadProductos < productos.length) {
            productos[cantidadProductos] = producto;
            cantidadProductos++;
            System.out.println("Producto agregado con exito");
        } else {
            System.out.println("Hubo un problema al agregar el producto");
        }
    }

    public double calcularTotal() {
        for(int i = 0; i < cantidadProductos; i++) {
            this.total += productos[i].getPrecio();
        }
        return total;
    }

    public void generarAlbaran() {
        File archivo = new File("albaranes/albaran_" + this.idPedido + ".txt");
        archivo.getParentFile().mkdirs(); // Crear el directorio si no existe
        try (FileWriter writer = new FileWriter(archivo)) {
            writer.write("Albarán del Pedido\n");
            writer.write("ID: " + this.idPedido + "\n");
            writer.write("Estado: " + this.estado + "\n");
            writer.write("Productos:\n");
            for (int i = 0; i < this.cantidadProductos; i++) {
                writer.write(" - " + this.productos[i].getNombre() + ", Precio: " + String.format("%.2f", this.productos[i].getPrecio()) + " EUR\n");
            }
            writer.write("Total: " + String.format("%.2f", this.total) + " EUR\n");
            System.out.println("Albarán generado: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al generar el albarán: " + e.getMessage());
        }
    }

    public void leerAlbaran() {
        File archivo = new File("albaranes", "albaran_" + this.idPedido + ".txt");

        if (!archivo.exists()) {
            System.out.println("El albarán no se encontró en el directorio 'albaranes'. Verifica si fue generado correctamente.");
            return;
        }

        try (FileReader fileReader = new FileReader(archivo)) {
            int caracter;
            StringBuilder contenido = new StringBuilder();
            while ((caracter = fileReader.read()) != -1) {
                contenido.append((char) caracter);
            }
            System.out.println("Contenido del albarán:");
            System.out.println(contenido);
            System.out.println("El albarán ha sido leído correctamente.");
        } catch (IOException e) {
            System.err.println("Error al leer el albarán: " + e.getMessage());
        }
    }

    public void cambiarEstado(Estado estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {

        StringBuilder productosStr = new StringBuilder();

        for(int i = 0; i < cantidadProductos; i++) {
            productosStr.append(productos[i] + "\n");
        }
        return "Pedido{ " + this.idPedido + "\n"
                + "Cantidad: " + this.cantidadProductos + "\n"
                + "Total: " + this.total + "\n"
                + ", Productos: " + productosStr + "\n"
                + ", Estado: " + this.estado + " }";
    }


}

package cafeteria;

public class Main {
    public static void main(String[] args) {
        Producto producto1 = new Producto("1a","Producto1", Producto.Categoria.COMIDA, 5.6);
        Producto producto2 = new Producto("2b","Producto2", Producto.Categoria.COMIDA, 3.7);
        Producto producto3 = new Producto("3c","Producto3", Producto.Categoria.COMIDA, 7.0);
        Producto producto4 = new Producto("4d","Producto4", Producto.Categoria.COMIDA, 2.95);
        Producto producto5 = new Producto("5e","Producto5", Producto.Categoria.COMIDA, 1.6);

        Pedido pedido1 = new Pedido("P01");
        Pedido pedido2 = new Pedido("P02");


        pedido1.agregarProducto(producto1);
        pedido1.agregarProducto(producto2);
        pedido1.agregarProducto(producto3);

        pedido2.agregarProducto(producto1);
        pedido2.agregarProducto(producto2);
        pedido2.agregarProducto(producto3);

        System.out.println(pedido1.calcularTotal());
        System.out.println(pedido2.calcularTotal());

        pedido1.cambiarEstado(Pedido.Estado.EN_PROCESO);
        System.out.println(pedido1);
        pedido1.cambiarEstado(Pedido.Estado.ENTREGADO);
        System.out.println(pedido1);

        pedido2.cambiarEstado(Pedido.Estado.ENTREGADO);

        /*pedido1.generarAlbaran();
        pedido1.leerAlbaran();

        pedido2.generarAlbaran();
        pedido2.leerAlbaran();*/
    }
}

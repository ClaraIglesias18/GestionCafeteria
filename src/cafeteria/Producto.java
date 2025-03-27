package cafeteria;

public class Producto {
    private String codigo;
    private String nombre;
    public enum Categoria {BEBIDAS, COMIDA, POSTRES, OTROS};
    private Categoria categoria;
    private double precio;

    public Producto() {
        this.codigo = "null";
        this.nombre = "desconocido";
        this.categoria = Categoria.OTROS;
        this.precio = 0.0;
    }

    public Producto(String codigo, String nombre, Categoria categoria, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{ Código: " + codigo + "\n"
                + " Nombre: +" + nombre + "\n"
                + " Categoria: " + categoria + "\n"
                + " Precio: " + precio + " }";
    }
}

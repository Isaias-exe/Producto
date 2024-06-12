
public class Producto {
    public String CodProd;
    public String name;
    public int precio;
    private int costo;
    public String descripcion;

    public Producto(String codProd, String name, int precio, int costo, String descripcion) {
        this.CodProd = codProd;
        this.name = name;
        this.precio = precio;
        this.costo = costo;
        this.descripcion = descripcion;
    }

    public int getCosto() {
        return this.costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public void mostrarDetalles() {
        System.out.println("Código: " + this.CodProd);
        System.out.println("Nombre: " + this.name);
        System.out.println("Precio: " + this.precio);
        System.out.println("Costo: " + this.costo);
        System.out.println("Descripción: " + this.descripcion);
    }
}
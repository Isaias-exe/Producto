import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static Scanner sc = new Scanner(System.in);

    public static ArrayList<Producto> productos = new ArrayList<Producto>();

    public static void main(String[] args) throws Exception {
        System.out.println("Bienvenido a la tienda");

        boolean repetir = true;

        do {
            try {
                System.out.println("Qué acción desea realizar");
                System.out.println("1. Mostrar catálogo");
                System.out.println("2. Ingresar producto");
                System.out.println("3. Eliminar producto");
                System.out.println("4. Buscar producto");
                System.out.println("5. Modificar producto");
                System.out.println("0. Salir");

                int respuesta = sc.nextInt();
                sc.nextLine(); 

                switch (respuesta) {
                    case 1:
                        mostrarCatalogo();
                        break;
                    case 2:
                        ingresarProducto();
                        break;
                    case 3:
                        eliminarProducto();
                        break;
                    case 4:
                        buscarProducto();
                        break;
                    case 5:
                        modificarProducto();
                        break;
                    case 0:
                        repetir = false;
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: ");
                sc.nextLine(); 
            }
        } while (repetir);

        System.out.println("Gracias por usar la tienda");
    }

    public static void mostrarCatalogo() {
        if (productos.size() == 0) {
            System.out.println("No hay productos en el catálogo.");
        } else {
            for (Producto producto : productos) {
                producto.mostrarDetalles();
                System.out.println("-------------------------");
            }
        }
    }

    public static void ingresarProducto() {
        System.out.println("Ingrese el código del producto:");
        String codProd = sc.nextLine();
        System.out.println("Ingrese el nombre del producto:");
        String name = sc.nextLine();
        System.out.println("Ingrese el precio del producto:");
        int precio = sc.nextInt();
        System.out.println("Ingrese el costo del producto:");
        int costo = sc.nextInt();
        sc.nextLine(); 
        System.out.println("Ingrese la descripción del producto:");
        String descripcion = sc.nextLine();

        Producto nuevoProducto = new Producto(codProd, name, precio, costo, descripcion);
        productos.add(nuevoProducto);

        System.out.println("Producto agregado exitosamente.");
    }

    public static void eliminarProducto() {
        System.out.println("Ingrese el código del producto a eliminar:");
        String codProd = sc.nextLine();

        Producto productoAEliminar = null;
        for (Producto producto : productos) {
            if (producto.CodProd.equals(codProd)) {
                productoAEliminar = producto;
                break;
            }
        }

        if (productoAEliminar != null) {
            productos.remove(productoAEliminar);
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public static void buscarProducto() {
        System.out.println("Ingrese el código del producto a buscar:");
        String codProd = sc.nextLine();

        for (Producto producto : productos) {
            if (producto.CodProd.equals(codProd)) {
                producto.mostrarDetalles();
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public static void modificarProducto() {
        System.out.println("Ingrese el código del producto a modificar:");
        String codProd = sc.nextLine();

        for (Producto producto : productos) {
            if (producto.CodProd.equals(codProd)) {
                System.out.println("Ingrese el nuevo nombre del producto:");
                producto.name = sc.nextLine();
                System.out.println("Ingrese el nuevo precio del producto:");
                producto.precio = sc.nextInt();
                System.out.println("Ingrese el nuevo costo del producto:");
                producto.setCosto(sc.nextInt());
                sc.nextLine(); 
                System.out.println("Ingrese la nueva descripción del producto:");
                producto.descripcion = sc.nextLine();

                System.out.println("Producto modificado exitosamente.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }
}

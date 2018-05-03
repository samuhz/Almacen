import java.util.List;
import java.util.Scanner;

// Crear la clase Producto y completar los métodos

public class MiAlmacen {
	static private ModeloAbs almacen;
	static Scanner sc;

	public static void main(String[] args) {
		almacen = new ModeloArrayList();
		sc = new Scanner(System.in);
		int opcion = 0;
		do {
			mostrarMenu();
			opcion = leerOpcion(1, 9);
			switch (opcion) {
			case 1:
				crear();
				break;
			case 2:
				consultar();
				break;
			case 3:
				borrar();
				break;
			case 4:
				modificarPrecio();
				break;
			case 5:
				comprar();
				break;
			case 6:
				vender();
				break;
			case 7:
				listar();
				break;
			case 8:
				listarPocoStock();
				break;
			}
			System.out.println("\n---------------------------- ");
			System.out.print("Pulse enter para continuar");
			sc.nextLine();
		} while (opcion != 9);
		sc.close();

	}

	private static void mostrarMenu() {
		System.out.println("\n\n    MENU");
		System.out.println("1. Nuevo producto ");
		System.out.println("2. Consulta producto ");
		System.out.println("3. Borrar producto ");
		System.out.println("4. Modificar precio ");
		System.out.println("5. Compra de productos ");
		System.out.println("6. Venta de productos ");
		System.out.println("7. Listado completo de productos ");
		System.out.println("8. Listado de productos con stock inferior al mínimo");
		System.out.println("9. Terminar ");
		System.out.print("Elige una opción (1-9)");
	}

	// Lee un entero del System.in que este comprendido entre primero y ultimo
	private static int leerOpcion(int primero, int ultimo) {
		int valor = leerEntero();
		while (valor < primero || valor > ultimo) {
			valor = leerEntero();
		}
		return valor;
	}

	// Metodos Auxiliares leerFloat y LeerEntero,
	// Lee de la System.in con el scanner sc y controlan la excepcion de
	// NumberFormatException
	static private float leerFloat() {

		boolean error = false;
		float valor = 0;
		String cadena;
		do {
			error = false;
			try {
				// Intento leer directamente un entero
				cadena = sc.nextLine();
				valor = Float.parseFloat(cadena);

			} catch (NumberFormatException e) {
				System.out.println("Error en formato.");
				error = true;
			}
		} while (error);
		return valor;
	}

	static private int leerEntero() {
		int valor = 0;
		do {
			try {
				sc = new Scanner(System.in);
				valor = sc.nextInt(); 
				if (valor <= 0) {
					System.out.println("El valor no puede ser negativo o 0");
				}
			} catch(Exception e) {
				
			}
		} while (valor > 0);
		sc.close();
		return valor; 
	}

	static private String leerCadena() {
		return ""; // Implementar
	}

	// Muestra los datos de un producto a partir de su codigo

	private static void consultar() {
		System.out.println("<CONSULTA>");
		System.out.print("Introduzca codigo:");
		int codigo = leerEntero();
		Producto p = almacen.buscarProducto(codigo);
		if (p == null) {
			System.out.println("El producto no se encuentra en almacen");
		} else {
			System.out.println("PRODUCTO " + p);
		}

	}

	// Borrar un producto a partir de su codigo

	private static void borrar() {
		System.out.println("<ELIMINAR>");
		int codigo = leerEntero();
		Producto p = almacen.buscarProducto(codigo);
		if (p == null) {
			System.out.println("El producto no se encuentra en almacen");
		} else {
			System.out.println("PRODUCTO " + p);
			System.out.println("¿Está seguro de que quiere eliminar el producto? (S/N)");
			String s = leerCadena();
			if (s.equals("S")) {
				boolean deleted = almacen.borrarProducto(codigo);
				if (deleted) {
					System.out.println("Producto borrado");
				} else {
					System.out.println();
				}
			}
		}
		// IMPLEMENTAR
	}

	// Cambia el precio de un producto a partir de su codigo
	private static void modificarPrecio() {
   
		System.out.println("<MODIFICAR PRECIO>");
		System.out.println("Aún no disponible");
		int codigo = leerEntero();
		Producto p = almacen.buscarProducto(codigo);
		if (p == null) {
			System.out.println("El producto no se encuentra en almacen");
		} else {
			System.out.println("PRODUCTO" + p);
			System.out.println("Introduzca un nuevo valor");
			int valor = leerEntero();
			p.setPrecio(valor);
		}

		// IMPLEMENTAR
	}

	// Incrementa el stock
	private static void comprar() {
		System.out.println("<COMPRAR>");
		System.out.println("Aún no disponible");
		int codigo = leerEntero();
		Producto p = almacen.buscarProducto(codigo);
		if (p == null) {
			System.out.println("El producto no se encuentra en almacen");
		} else {
			p.setStock(leerEntero() +p.getStock());
		}
		// IMPLEMENTAR
	}

	// Decrementa el stock
	private static void vender() {
		System.out.println("<VENDER>");
		System.out.println("Aún no disponible");
		int codigo = leerEntero();
		Producto p = almacen.buscarProducto(codigo);
		if (p == null) {
			System.out.println("El producto no se encuentra en almacen");
		} else {
			p.setStock(leerEntero() - p.getStock());
		}
		// IMPLEMENTAR

	}

	// Listado de todos los productos
	private static void listar() {
		System.out.println("<LISTAR>");
		almacen.listarProductos();
	}

	// Listado de todos los productos con stock inferior a stock minimo
	private static void listarPocoStock() {
		System.out.println("<LISTAR STOCK BAJO MINIMOS>");
		@SuppressWarnings("unchecked")
		List<Producto> lista = (List<Producto>) almacen.getList();
		for (Producto p : lista) {
			if (p.getStock_min() > p.getStock()) {
				System.out.println(p.toString());
			}
		}
	}

	// Solicita datos al usuario para dar de alta un nuevo producto
	// El codigo no se puede repetir
	private static void crear() {
		    System.out.println("<NUEVO PRODUCTO>");
       System.out.print("Codigo:");
       int codigo = leerEntero();
       Producto p = almacen.buscarProducto(codigo);
       if ( p != null){
           System.out.println("Ya existe el codigo en almacen "+p);
           return;
        }
       System.out.print("Nombre:");
       String nombre = sc.nextLine();
       p = new Producto(codigo,nombre);
       System.out.print("Stock:");
       int stock = leerEntero(); p.setStock(stock);
       System.out.print("Stock Minimo:");
       int stock_min = leerEntero(); p.setStock(stock_min);
       System.out.print("Precio:");
       float precio = leerFloat(); p.setPrecio(precio);
       almacen.insertarProducto(p);
    }
       
	}



/**
 * Clase Producto - representa un NODO del arbol binario de busqueda.
 *
 * Cada producto guarda sus propios datos (id, nombre) y ademas
 * dos "punteros" (referencias) a otros productos:
 *   - izquierdo: apunta al producto con ID MENOR que el suyo.
 *   - derecho:   apunta al producto con ID MAYOR que el suyo.
 *
 * Si un puntero vale null, significa que ese lado del arbol
 * todavia no tiene ningun hijo (esa rama esta "vacia").
 */
public class Producto {

    int id;
    String nombre;

    Producto izquierdo;
    Producto derecho;

    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izquierdo = null; // al crear el nodo, todavia no tiene hijos
        this.derecho = null;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre;
    }
}

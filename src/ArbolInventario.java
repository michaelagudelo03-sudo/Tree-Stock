/**
 * Clase ArbolInventario - contiene la LOGICA del arbol binario de busqueda (BST).
 *
 * La regla de oro de un BST es siempre la misma en cada nodo:
 *   - Si el nuevo ID es MENOR que el ID del nodo actual -> va hacia la IZQUIERDA.
 *   - Si el nuevo ID es MAYOR que el ID del nodo actual -> va hacia la DERECHA.
 *   - Si el ID ya existe -> no se duplica.
 *
 * Gracias a esa regla, un recorrido "inorden" (izquierda -> nodo -> derecha)
 * siempre entrega los productos ordenados de menor a mayor ID.
 */
public class ArbolInventario {

    private Producto raiz; // punto de entrada al arbol; null = arbol vacio

    public ArbolInventario() {
        this.raiz = null;
    }

    // ---------------------------------------------------------
    // INSERTAR (publico) - punto de entrada que llama al recursivo
    // ---------------------------------------------------------
    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    /**
     * Metodo recursivo privado que hace el trabajo real.
     * "nodoActual" es el subarbol donde estamos parados en este paso
     * de la recursion (al principio es la raiz completa).
     */
    private Producto insertarRecursivo(Producto nodoActual, int id, String nombre) {
        // Caso base: llegamos a una rama vacia -> aqui se crea el nuevo nodo
        if (nodoActual == null) {
            return new Producto(id, nombre);
        }

        // Caso recursivo: comparamos el ID para decidir hacia donde bajar
        if (id < nodoActual.id) {
            nodoActual.izquierdo = insertarRecursivo(nodoActual.izquierdo, id, nombre);
        } else if (id > nodoActual.id) {
            nodoActual.derecho = insertarRecursivo(nodoActual.derecho, id, nombre);
        } else {
            // ID repetido: no se inserta, solo avisamos
            System.out.println(">> Ya existe un producto con el ID " + id + ". No se registro.");
        }

        // Devolvemos el nodo actual para que el nivel superior
        // reconecte correctamente su puntero (izquierdo o derecho).
        return nodoActual;
    }

    // ---------------------------------------------------------
    // BUSCAR (publico) - por ID
    // ---------------------------------------------------------
    public Producto buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    private Producto buscarRecursivo(Producto nodoActual, int id) {
        // Caso base 1: subarbol vacio -> no se encontro
        if (nodoActual == null) {
            return null;
        }
        // Caso base 2: el ID coincide con el nodo actual -> encontrado
        if (id == nodoActual.id) {
            return nodoActual;
        }
        // Caso recursivo: seguimos bajando por izquierda o derecha
        if (id < nodoActual.id) {
            return buscarRecursivo(nodoActual.izquierdo, id);
        } else {
            return buscarRecursivo(nodoActual.derecho, id);
        }
    }

    // ---------------------------------------------------------
    // RECORRIDO INORDEN - lista el inventario ordenado por ID
    // ---------------------------------------------------------
    public void mostrarInventario() {
        if (raiz == null) {
            System.out.println(">> El inventario esta vacio.");
            return;
        }
        System.out.println("----- INVENTARIO (ordenado por ID) -----");
        inordenRecursivo(raiz);
        System.out.println("-----------------------------------------");
    }

    private void inordenRecursivo(Producto nodoActual) {
        if (nodoActual == null) {
            return; // caso base: no hay nada que imprimir en esta rama
        }
        inordenRecursivo(nodoActual.izquierdo);  // 1. primero todo lo menor (izquierda)
        System.out.println(nodoActual);          // 2. luego el nodo actual
        inordenRecursivo(nodoActual.derecho);     // 3. despues todo lo mayor (derecha)
    }
}

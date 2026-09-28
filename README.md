# Tree-Stock — Sistema de Inventario con Árbol Binario de Búsqueda

## Objetivo
Aplicación de consola en Java que gestiona un inventario de productos usando un
**Árbol Binario de Búsqueda (BST)**, donde cada producto se ubica según su `id`:
los IDs menores quedan a la izquierda del nodo y los mayores a la derecha. Esto
permite listar el inventario siempre ordenado (recorrido inorden) y buscar un
producto en tiempo logarítmico promedio.

## Estructura del proyecto
```
tree-stock/
└── src/
    ├── Producto.java          # Nodo del árbol (id, nombre, izquierdo, derecho)
    ├── ArbolInventario.java   # Lógica: insertar, buscar, recorrido inorden
    └── Main.java              # Menú interactivo (switch-case)
```

## Lógica de los punteros (resumen para la sustentación)
- Cada `Producto` tiene dos referencias: `izquierdo` y `derecho`, que al crearse
  valen `null` (sin hijos todavía).
- **Insertar**: se compara el nuevo `id` contra el nodo actual; si es menor se
  baja por `izquierdo`, si es mayor se baja por `derecho`, hasta encontrar un
  puntero en `null`, donde se crea el nuevo nodo.
- **Buscar**: mismo principio de comparación, pero en vez de insertar, se
  retorna el nodo si el `id` coincide, o `null` si se llega a una rama vacía.
- **Recorrido inorden** (`izquierdo -> nodo -> derecho`): al visitar siempre
  primero todo lo menor, luego el nodo, y después todo lo mayor, el resultado
  sale ordenado de menor a mayor ID sin necesidad de ordenar nada aparte.

## Cómo ejecutar
Requisitos: JDK instalado (probado con JDK 21) y VS Code (opcional).

```bash
cd src
javac Producto.java ArbolInventario.java Main.java
java Main
```

## Uso del menú
```
1. Registrar Producto   -> pide ID y nombre
2. Mostrar Inventario   -> recorrido inorden (lista ordenada por ID)
3. Buscar Producto      -> pide ID y dice si existe o no
0. Salir
```

## Capturas de pantalla
### Ejecución en consola
[Ejecución en consola](capturas/ejecucion.png)

## Video de sustentación
> https://youtu.be/WCZqCYsRAc4

## Integrantes y commits
> _Cada integrante debe aportar al menos 3 commits propios al repositorio._

## Parte 2.1 — Implementación dinámica
 
| Operación | Complejidad | Justificación |
|---|---|---|
| `crear()` | O(1) | Solo inicializa la cabeza en null y el contador en 0 |
| `definir(d, clave, valor)` | O(n) | La inserción en la cabeza es O(1), pero antes hay que recorrer la cadena para saber si la clave ya existe (actualizar) o no (agregar). En el peor caso, la clave no está y se recorren los n nodos |
| `obtener(d, clave)` | O(n) | No hay orden ni acceso directo, asi que se busca nodo por nodo. En el peor caso, la clave está en el último nodo |
| `eliminar(d, clave)` | O(n) | Desenganchar el nodo es O(1), pero para llegar a él (y a su anterior) hay que recorrer la cadena. En el peor caso, es el último |
| `existeClave(d, clave)` | O(n) | Misma búsqueda lineal que `obtener`. En el peor caso, la clave no existe y se recorre todo |
| `esVacio(d)` | O(1) | Solo compara la cabeza con null |
| `cantidadClaves(d)` | O(1) | Devuelve un contador que se actualiza en `definir` y `eliminar`. Sin ese contador habría que contar los nodos y sería O(n) |
| `claves(d)` | O(n) | Recorre los n nodos una vez, y cada inserción en la Lista es O(1) porque se hace al inicio |
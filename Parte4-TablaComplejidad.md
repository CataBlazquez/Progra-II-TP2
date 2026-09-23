## Parte 4 — Métodos de utilización
 
| Método | Complejidad | Justificación |
|---|---|---|
| `combinarDiccionarios(d1, d2)` | O(n²) | Por cada una de las n claves se hace un `obtener` (O(n)) y un `definir` sobre el resultado, que puede tener hasta n claves (O(n)). n veces O(n) da O(n²). |
| `invertir(d)` | O(n²) | Por cada una de las n claves se hace un `obtener` en d (O(n)) y un `definir` en el resultado (O(n)). |
| `contarValoresMayoresA(d, umbral)` | O(n²) | No crea ningún diccionario, pero por cada una de las n claves hace un `obtener`, que es O(n). |
| `clavesOrdenadas(d)` | O(n²) | Copiar las claves a un arreglo es O(n²), ordenar por selección es O(n²) (dos bucles anidados) y armar la Lista es O(n). Manda el mayor: O(n²). |
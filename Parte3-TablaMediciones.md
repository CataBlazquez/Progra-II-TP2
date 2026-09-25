PRUEBA MEDICIONES DE TIEMPO EN NANOSENGUNDOS


n       | definir() Estática (ns)       | obtener() Estática (ns)
------------------------------------------------------------------
1000    |       10200                   |       21600
10000   |       15800                   |       67900
100000  |       221800                  |       222600

Segun los resultados obtenidos en la medicion del codigo, es evidente que aumenta el tiempo de ejecucion 
de cada funcion con respecto a la cantidad de valores y claves. Aunque entre 1000 y 10000 no parezca haber un gran salto 
temporal, es mucho mas notorio cuando la cantidad de entradas es de 100000. 
En la practica, la version estatica es mas rapida ya que aprovecha la manera en la que la CPU interactua con la Cache al ser almacenado los valores en bloques fisicamente cercanos, mientras que los nodos, son almacenados en direcciones de memoria aleatorias. Ademas, al saber de entrada cuanto espacio de memoria es el maximo, se evita tener un overhead para cada nodo y adicionar el espacio del puntero. 
import java.util.function.Supplier;

public class UtilizacionDiccionario {

    private final Supplier<Diccionario> fabrica;

    public UtilizacionDiccionario(Supplier<Diccionario> fabrica) {
        this.fabrica = fabrica;
    }

    public Diccionario combinarDiccionarios(Diccionario d1, Diccionario d2) {
        Diccionario resultado = fabrica.get();

        Lista claves1 = d1.claves();
        for (int i = 0; i < claves1.tamanio(); i++) {
            Object clave = claves1.obtener(i);
            resultado.definir(clave, d1.obtener(clave));
        }
        Lista claves2 = d2.claves();
        for (int i = 0; i < claves2.tamanio(); i++) {
            Object clave = claves2.obtener(i);
            resultado.definir(clave, d2.obtener(clave));
        }
        return resultado;
    }

    public Diccionario invertir(Diccionario d) {
        Diccionario resultado = fabrica.get();
        Lista claves = d.claves();
        for (int i = 0; i < claves.tamanio(); i++) {
            Object clave = claves.obtener(i);
            Object valor = d.obtener(clave);
            resultado.definir(valor, clave);
        }
        return resultado;
    }

    public int contarValoresMayoresA(Diccionario d, int umbral) {
        int contador = 0;
        Lista claves = d.claves();
        for (int i = 0; i < claves.tamanio(); i++) {
            Object clave = claves.obtener(i);
            Number valor = (Number) d.obtener(clave);
            if (valor.doubleValue() > umbral) {
                contador++;
            }
        }
        return contador;
    }

    public Lista clavesOrdenadas(Diccionario d) {
        Lista claves = d.claves();
        int n = claves.tamanio();

        String[] aux = new String[n];
        for (int i = 0; i < n; i++) {
            aux[i] = (String) claves.obtener(i);
        }

        for (int i = 0; i < n - 1; i++) {
            int posMenor = i;
            for (int j = i + 1; j < n; j++) {
                if (aux[j].compareTo(aux[posMenor]) < 0) {
                    posMenor = j;
                }
            }
            String tmp = aux[i];
            aux[i] = aux[posMenor];
            aux[posMenor] = tmp;
        }

        Lista resultado = new Lista();
        for (int i = 0; i < n; i++) {
            resultado.agregarAlFinal(aux[i]);
        }
        return resultado;
    }
}
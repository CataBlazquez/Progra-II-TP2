public class DiccionarioDinamico implements Diccionario {

    private DiccionarioNodo cabeza;
    private int cantidad;

    public DiccionarioDinamico() {
        cabeza = null;
        cantidad = 0;
    }

    private DiccionarioNodo buscarNodo(Object clave) {
        DiccionarioNodo actual = cabeza;
        while (actual != null) {
            if (actual.clave.equals(clave)) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    @Override
    public void definir(Object clave, Object valor) {
        DiccionarioNodo existente = buscarNodo(clave);
        if (existente != null) {
            existente.valor = valor;
        } else {
            DiccionarioNodo nuevo = new DiccionarioNodo(clave, valor);
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
            cantidad++;
        }
    }

    @Override
    public Object obtener(Object clave) {
        DiccionarioNodo nodo = buscarNodo(clave);
        if (nodo == null) {
            throw new RuntimeException("obtener(): la clave no existe -> " + clave);
        }
        return nodo.valor;
    }

    @Override
    public void eliminar(Object clave) {
        DiccionarioNodo actual = cabeza;
        DiccionarioNodo anterior = null;
        while (actual != null) {
            if (actual.clave.equals(clave)) {
                if (anterior == null) {
                    cabeza = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                cantidad--;
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        throw new RuntimeException("eliminar(): la clave no existe -> " + clave);
    }

    @Override
    public boolean existeClave(Object clave) {
        return buscarNodo(clave) != null;
    }

    @Override
    public boolean esVacio() {
        return cabeza == null;
    }

    @Override
    public int cantidadClaves() {
        return cantidad;
    }

    @Override
    public Lista claves() {
        Lista resultado = new Lista();
        DiccionarioNodo actual = cabeza;
        while (actual != null) {
            resultado.agregarAlInicio(actual.clave);
            actual = actual.siguiente;
        }
        return resultado;
    }

    @Override
    public String toString() {
    StringBuilder sb = new StringBuilder("{ ");
    DiccionarioNodo actual = cabeza;
    while (actual != null) {
        sb.append(actual.clave).append("=").append(actual.valor).append(" ");
        actual = actual.siguiente;
    }
    return sb.append("}").toString();
}

}
public class Lista {

    private ListaNodo primero;
    private ListaNodo ultimo;
    private int cantidad;

    public Lista() {
        primero = null;
        ultimo = null;
        cantidad = 0;
    }

    public void agregarAlInicio(Object x) {
        ListaNodo nuevo = new ListaNodo(x);
        nuevo.siguiente = primero;
        primero = nuevo;
        if (ultimo == null) {
            ultimo = nuevo;
        }
        cantidad++;
    }

    public void agregarAlFinal(Object x) {
        ListaNodo nuevo = new ListaNodo(x);
        if (ultimo == null) {
            primero = nuevo;
        } else {
            ultimo.siguiente = nuevo;
        }
        ultimo = nuevo;
        cantidad++;
    }


    public Object obtener(int i) {
        if (i < 0 || i >= cantidad) {
            throw new RuntimeException("obtener(): posicion invalida -> " + i);
        }
        ListaNodo actual = primero;
        for (int k = 0; k < i; k++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    public int tamanio() {
        return cantidad;
    }

    public boolean esVacia() {
        return cantidad == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        ListaNodo actual = primero;
        while (actual != null) {
            sb.append(actual.dato).append(" ");
            actual = actual.siguiente;
        }
        return sb.append("]").toString();
    }
}
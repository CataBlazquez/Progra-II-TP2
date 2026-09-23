public class DiccionarioNodo {
    Object clave;
    Object valor;
    DiccionarioNodo siguiente;

    public DiccionarioNodo(Object clave, Object valor) {
        this.clave = clave;
        this.valor = valor;
        this.siguiente = null;
    }
}
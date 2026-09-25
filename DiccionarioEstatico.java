public class DiccionarioEstatico implements Diccionario {
    
    private Object [] claves;
    private Object [] valores;
    private int cantidad;
    
    public DiccionarioEstatico(int cantidad) {
        this.cantidad = 0;
        claves = new Object[cantidad];
        valores = new Object[cantidad];
    }
    
    @Override 
    public Lista claves() {
        Lista resultado = new Lista();
        for (int i = 0; i < claves.length; i++) {
            if (claves[i] != null) {
                resultado.agregarAlInicio(claves[i]);
            }
        }
        return resultado;
        }
    @Override
    public void definir(Object clave, Object valor) {
        int IndiceLibre = -1;
        for (int i = 0; i < claves.length; i++) {
            if (claves[i] != null && claves[i].equals(clave)) {
                valores[i] = valor;
                return;
            }
            if (claves[i] == null && IndiceLibre == -1) {
                IndiceLibre = i;
            }
            
        }
        if (IndiceLibre != -1) {
            claves[IndiceLibre] = clave;
            valores[IndiceLibre] = valor;
            cantidad++;
            return;
        }
        throw new RuntimeException("No hay espacio disponible");    }

    @Override
    public Object obtener(Object clave) {

        for (int i = 0; i < claves.length; i++) {
            if (claves[i] != null && claves[i].equals(clave)) {
                return valores[i];
            }
        }
        throw new RuntimeException("obtener(): la clave no existe -> " + clave);
    }

    @Override
    public void eliminar(Object clave) {
        for (int i = 0; i < claves.length; i++) {
            if (claves[i] != null && claves[i].equals(clave)) {
                claves[i] = null;
                valores[i] = null;
                cantidad--;
                return;
            };
        }
        throw new RuntimeException("eliminar(): la clave no existe -> " + clave);
    }

    @Override
    public boolean existeClave(Object clave) {
        for (int i = 0; i < claves.length; i++) {
            if (claves[i] != null && claves[i].equals(clave)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean esVacio() {
        for (int i = 0; i < claves.length; i++) {
            if (claves[i] != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int cantidadClaves() {
       for (int i = 0; i < claves.length; i++) {
            if (claves[i] != null) {
                return cantidad;
            }
        }
        return 0;
    }

}

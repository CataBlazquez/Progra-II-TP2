public class Main {

    public static void main(String[] args) {
        probarDiccionarioDinamico();
        System.out.println();
        probarUtilizacion();
        probarDiccionarioEstatico();
        MedirNanosegundos();
    }

    private static void probarDiccionarioDinamico() {
        System.out.println("========== PARTE 2: DICCIONARIO DINAMICO ==========");
        System.out.println("Ejemplo: diccionario de nombres (clave) y edades (valor)");
        System.out.println();

        Diccionario d = new DiccionarioDinamico();
        System.out.println("1) Se crea el diccionario vacio");
        System.out.println("   Esta vacio?: " + d.esVacio());
        System.out.println("   Cantidad de claves: " + d.cantidadClaves());
        System.out.println();

        d.definir("Ana", 20);
        d.definir("Juan", 35);
        d.definir("Carlos", 28);
        System.out.println("2) Se agregan Ana=20, Juan=35 y Carlos=28");
        System.out.println("   Contenido: " + d);
        System.out.println("   Cantidad de claves: " + d.cantidadClaves());
        System.out.println();

        d.definir("Juan", 40);
        System.out.println("3) Se vuelve a definir Juan con 40 (ya existia, entonces se actualiza)");
        System.out.println("   Contenido: " + d);
        System.out.println("   Cantidad de claves: " + d.cantidadClaves() + " (sigue igual, no se duplico)");
        System.out.println();

        System.out.println("4) Se consulta el valor de Ana");
        System.out.println("   Edad de Ana: " + d.obtener("Ana"));
        System.out.println();

        System.out.println("5) Se pregunta si existen algunas claves");
        System.out.println("   Existe Carlos?: " + d.existeClave("Carlos"));
        System.out.println("   Existe dani?: " + d.existeClave("dani"));
        System.out.println();

        System.out.println("6) Se piden todas las claves");
        System.out.println("   Claves: " + d.claves());
        System.out.println();

        d.eliminar("Carlos");
        d.eliminar("Ana");
        System.out.println("7) Se eliminan Carlos y Ana");
        System.out.println("   Contenido: " + d);
        System.out.println("   Cantidad de claves: " + d.cantidadClaves());
        System.out.println();

        d.eliminar("Juan");
        System.out.println("8) Se elimina Juan, la ultima clave que quedaba");
        System.out.println("   Esta vacio?: " + d.esVacio());
        System.out.println();

        System.out.println("9) Se intenta obtener Ana, que ya no existe");
        try {
            d.obtener("Ana");
        } catch (RuntimeException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
    }

    private static void probarUtilizacion() {
        System.out.println("========== PARTE 4: UTILIZACION ==========");
        System.out.println("Ejemplo: diccionarios de frutas (clave) y precios (valor)");
        System.out.println();

        UtilizacionDiccionario u = new UtilizacionDiccionario(() -> new DiccionarioDinamico());

        Diccionario d1 = new DiccionarioDinamico();
        d1.definir("pera", 10);
        d1.definir("bAnana", 25);
        d1.definir("manzAna", 5);

        Diccionario d2 = new DiccionarioDinamico();
        d2.definir("bAnana", 99);
        d2.definir("uva", 40);

        System.out.println("Diccionarios de partida:");
        System.out.println("   d1: " + d1);
        System.out.println("   d2: " + d2);
        System.out.println();

        System.out.println("7) Combinar d1 y d2 (bAnana esta en los dos, gAna el valor de d2)");
        System.out.println("   Resultado: " + u.combinarDiccionarios(d1, d2));
        System.out.println();

        System.out.println("8) Invertir d1 (los precios pasan a ser claves y las frutas valores)");
        System.out.println("   Resultado: " + u.invertir(d1));
        System.out.println();

        System.out.println("9) Contar cuantas frutas de d1 cuestan mas de 8");
        System.out.println("   Resultado: " + u.contarValoresMayoresA(d1, 8));
        System.out.println();

        System.out.println("10) Claves de d1 ordenadas alfabeticamente");
        System.out.println("   Resultado: " + u.clavesOrdenadas(d1));
        System.out.println();

        System.out.println("Se verifica que d1 y d2 no se modifiCarlosn:");
        System.out.println("   d1: " + d1);
        System.out.println("   d2: " + d2);
    }



    private static void probarDiccionarioEstatico() {
        System.out.println("========== PARTE 3: DICCIONARIO ESTATICO ==========");
        System.out.println("Ejemplo: diccionario de nombres (clave) y edades (valor)");
        System.out.println();

        Diccionario d = new DiccionarioEstatico(10);
        System.out.println("1) Se crea el diccionario vacio");
        System.out.println("   Esta vacio?: " + d.esVacio());
        System.out.println("   Cantidad de claves: " + d.cantidadClaves());
        System.out.println();

        d.definir("Ana", 20);
        d.definir("Juan", 35);
        d.definir("Carlos", 28);
        
        System.out.println("2) Se agregan Ana=20, Juan=35 y Carlos=28");
        System.out.println("   Contenido: " + d);
        System.out.println("   Cantidad de claves: " + d.cantidadClaves());
        System.out.println();
    
        d.definir("Juan", 40);
        System.out.println("3) Se vuelve a definir Juan con 40 (ya existia, entonces se actualiza)");
        System.out.println("   Contenido: " + d);
        System.out.println("   Cantidad de claves: " + d.cantidadClaves() + " (sigue igual, no se duplico)");
        System.out.println();

        System.out.println("4) Se consulta el valor de Ana");
        System.out.println("   Edad de Ana: " + d.obtener("Ana"));
        System.out.println();

        System.out.println("5) Se pregunta si existen algunas claves");
        System.out.println("   Existe Carlos?: " + d.existeClave("Carlos"));
        System.out.println("   Existe dani?: " + d.existeClave("dani"));
        System.out.println();

        System.out.println("6) Se piden todas las claves");
        System.out.println("   Claves: " + d.claves());
        System.out.println();

        d.eliminar("Carlos");
        d.eliminar("Ana");
        System.out.println("7) Se eliminan Carlos y Ana");
        System.out.println("   Contenido: " + d);
        System.out.println("   Cantidad de claves: " + d.cantidadClaves());
        System.out.println();

        d.eliminar("Juan");
        System.out.println("8) Se elimina Juan, la ultima clave que quedaba");
        System.out.println("   Esta vacio?: " + d.esVacio());
        System.out.println();

        System.out.println("9) Se intenta obtener Ana, que ya no existe");
        try {
            d.obtener("Ana");
        } catch (RuntimeException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
    }

    public static void MedirNanosegundos() {
    int[] tamaños = {1000, 10000, 100000};
    int repeticiones = 100; // Cantidad de repeticiones para obtener el mejor tiempo
    System.out.println("------------------------------------------------------------------");
    System.out.println("PRUEBA MEDICIONES DE TIEMPO EN NANOSENGUNDOS");
    System.out.println("n\t| definir() Estática (ns)\t| obtener() Estática (ns)");
    System.out.println("------------------------------------------------------------------");

    for (int n : tamaños) {
        // 1. Preparar el diccionario con capacidad de 'n' + espacio para las pruebas
        DiccionarioEstatico dict = new DiccionarioEstatico(n + repeticiones);

        // Pre-cargar el diccionario con n claves
        for (int i = 0; i < n; i++) {
            dict.definir("Clave_Base_" + i, i);
        }

        // 2. Medir definir() en el peor caso (insertar claves nunca antes vistas)
        long mejorTiempoDefinir = Long.MAX_VALUE;
        for (int i = 0; i < repeticiones; i++) {
            // Aseguramos una clave inédita en cada intento
            String claveInedita = "Clave_Nueva_" + n + "_" + i; 
            
            long inicio = System.nanoTime();
            dict.definir(claveInedita, 1);
            long fin = System.nanoTime();
            
            long tiempo = fin - inicio;
            if (tiempo < mejorTiempoDefinir) {
                mejorTiempoDefinir = tiempo;
            }
        }

        // 3. Medir obtener() en el peor caso (buscar una clave inexistente recorre todo)
        long mejorTiempoObtener = Long.MAX_VALUE;
        String claveInexistente = "Clave_Inexistente_Absoluta";
        
        for (int i = 0; i < repeticiones; i++) {
            long inicio = System.nanoTime();
            try {
                dict.obtener(claveInexistente);
            } catch (RuntimeException e) {
                // Se espera la excepción porque la clave no existe, la atrapamos para continuar
            }
            long fin = System.nanoTime();
            
            long tiempo = fin - inicio;
            if (tiempo < mejorTiempoObtener) {
                mejorTiempoObtener = tiempo;
            }
        }

        // Imprimir los resultados de la fila actual
        System.out.println(n + "\t|\t" + mejorTiempoDefinir + "\t\t\t|\t" + mejorTiempoObtener);
    }
}
}
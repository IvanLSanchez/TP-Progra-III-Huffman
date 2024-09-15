package metodos;

import impl.MinHeap;
import impl.NodoHuffman;
import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;
import api.HeapTDA;

public class Huffman {
    private static NodoHuffman crearHojaArbolHuffman(String info, float prioridad){
        NodoHuffman elemento = new NodoHuffman();
        elemento.probabilidad = prioridad;
        elemento.info = info.toUpperCase();
        elemento.hijoIzq = new NodoHuffman();
        elemento.hijoDer = new NodoHuffman();
        return elemento;
    }

    private static NodoHuffman fusionNodosHuffman (NodoHuffman x, NodoHuffman y){
        NodoHuffman aux = new NodoHuffman();
        aux.hijoIzq = x;
        aux.hijoDer = y;
        aux.info = x.info + y.info;
        aux.probabilidad = x.probabilidad + y.probabilidad;
        return aux;
    }
    
    public static NodoHuffman crearArbol(DiccionarioSimpleTDA diccionarioVP){
        HeapTDA colaPrioridadProbabilidadMin = new MinHeap();
        colaPrioridadProbabilidadMin.InicializarHeap();

        int i=0;
        ConjuntoTDA claves = diccionarioVP.Claves();
        while(!claves.ConjuntoVacio()){
            String eleccion = claves.Elegir();
            colaPrioridadProbabilidadMin.Agregar(crearHojaArbolHuffman(eleccion, diccionarioVP.Recuperar(eleccion)));
            claves.Sacar(eleccion);
            i++;
        }
        
        for (int j = 0; j < i-1; j++) {
            NodoHuffman x1 = colaPrioridadProbabilidadMin.Primero();
            colaPrioridadProbabilidadMin.Sacar();
            NodoHuffman x2 = colaPrioridadProbabilidadMin.Primero();
            colaPrioridadProbabilidadMin.Sacar();

            colaPrioridadProbabilidadMin.Agregar(fusionNodosHuffman(x1, x2));
        }
            
        return colaPrioridadProbabilidadMin.Primero();
    }

    private static String ObtenerCodigoLetra(NodoHuffman a,char valorBuscado, String codigo){
        if(a.info.length()==1 || a.info.indexOf(valorBuscado)==-1){
            return codigo;
        }else{
            if(a.hijoIzq.info.indexOf(valorBuscado) != -1){
                return ObtenerCodigoLetra(a.hijoIzq, valorBuscado, codigo + "0");
            }else{
                return ObtenerCodigoLetra(a.hijoDer, valorBuscado, codigo + "1");
            }
        }
    }

    public static void ListarCodigo(NodoHuffman a, String codigo){
        /* El siguiente metodo busca mostrar todos los codigos de un arbol de huffman
         * El codigo requerira de los siguientes atributos: el arbol de trabajar y un string que contenera el estado
         * actual del codigo (el mismo debera iniciar en "")
         * El proceso para obtener los codigos sera el siguiente
         * - entrara a la estructura y se fijara si el nodo raiz es una hoja.
         *  - de serlo se imprimira el valor de la hoja junto con el codigo obtenido hasta el momento
         *  - de no serlo le cambiara la raiz a sus hijos y agregara al codigo un 0 o un 1 dependiendo a que hijo fue.
         */
        if(a.hijoIzq.info==null && a.hijoDer.info==null){
            System.out.println("- " + a.info + ": " + codigo);
        }else{
            ListarCodigo(a.hijoIzq, codigo + "0");
            ListarCodigo(a.hijoDer, codigo + "1");
        }
    }

    public static String EncriptarMensaje(String mensaje, NodoHuffman encriptador){
        mensaje = mensaje.toUpperCase();
        String codigo = "";
        for(int i=0; i<mensaje.length(); i++){
            String letraCodificada = ObtenerCodigoLetra(encriptador , mensaje.charAt(i), "");
            codigo = letraCodificada!="" ? codigo+letraCodificada : codigo+mensaje.charAt(i);
        }
        return codigo;
    }

    public static String DesencriptarMensajes(String mensaje, NodoHuffman desencriptador){
        String mensajeDesencriptado = "";
        NodoHuffman raizArbol = desencriptador;
        for(int i=0; i<mensaje.length(); i++){
            char trozoMensaje = mensaje.charAt(i);
            if(trozoMensaje!='0' && trozoMensaje!='1'){
                mensajeDesencriptado = mensajeDesencriptado + trozoMensaje;
            }else{
                desencriptador = trozoMensaje == '1'? desencriptador.hijoDer:desencriptador.hijoIzq;
                if(desencriptador.info.length()==1){
                    mensajeDesencriptado = mensajeDesencriptado + desencriptador.info;
                    desencriptador = raizArbol;
                }
            }
        }
        return mensajeDesencriptado;
    }
}

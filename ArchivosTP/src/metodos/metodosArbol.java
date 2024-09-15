package metodos;

import impl.NodoHuffman;

public class metodosArbol {
    public static void PreOrder(NodoHuffman a){
        if(!(a.info==null)){
            System.out.println(a.info);
            PreOrder(a.hijoIzq);
            PreOrder(a.hijoDer);
        }
    }

    public static void InOrder(NodoHuffman a){
        if(!(a.info==null)){
            InOrder(a.hijoIzq);
            System.out.println(a.info);
            InOrder(a.hijoDer);
        }
    }

    public static void PostOrder(NodoHuffman a){
        if(!(a.info==null)){
            PostOrder(a.hijoIzq);
            PostOrder(a.hijoDer);
            System.out.println(a.info);
        }
    }

    public static void Codificacion(NodoHuffman a, String codigo){
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
            Codificacion(a.hijoIzq, codigo + "0");
            Codificacion(a.hijoDer, codigo + "1");
        }
    }
}

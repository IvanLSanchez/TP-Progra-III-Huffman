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
}

package metodos;

import impl.NodoHuffman;

public class metodosArbol {
    public static void PreOrder(NodoHuffman a){
        if(!(a.info==null)){
            System.out.print(a.info+" - ");
            PreOrder(a.hijoIzq);
            PreOrder(a.hijoDer);
        }
    }

    public static void InOrder(NodoHuffman a){
        if(!(a.info==null)){
            InOrder(a.hijoIzq);
            System.out.print(a.info+" - ");
            InOrder(a.hijoDer);
        }
    }
}

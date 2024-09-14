package metodos;

public class metodosArbol {
    public static void PreOrder(ABBTDA a){
        if(!a.ArbolVacio()){
            System.out.println(a.Raiz());
            PreOrder(a.HIjoIzq());
            PreOrder(a.HIjoDer());
        }
    }

    public static void InOrder(ABBTDA a){
        if(!a.ArbolVacio()){
            InOrder(a.HIjoIzq());
            System.out.println(a.Raiz());
            InOrder(a.HIjoDer());
        }
    }

    public static void PostOrder(ABBTDA a){
        if(!a.ArbolVacio()){
            PostOrder(a.HIjoIzq());
            PostOrder(a.HIjoDer());
            System.out.println(a.Raiz());
        }
    }
}

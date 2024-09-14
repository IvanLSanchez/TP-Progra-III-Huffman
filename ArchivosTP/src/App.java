import api.DiccionarioSimpleTDA;
import impl.NodoHuffman;
import metodos.Huffman;
import impl.DiccionarioSimple;

public class App {
    public static void main(String[] args) {
        DiccionarioSimpleTDA dic = new DiccionarioSimple();
        dic.InicializarDiccionario();
        dic.Agregar("A", 45);
        dic.Agregar("D", 16);
        dic.Agregar("B", 13);
        dic.Agregar("C", 12);
        dic.Agregar("E", 9);
        dic.Agregar("F", 5);

        NodoHuffman muestra = Huffman.crearArbol(dic);




        }
}

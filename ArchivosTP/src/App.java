import api.DiccionarioSimpleTDA;
import impl.NodoHuffman;
import metodos.Huffman;
import metodos.metodosArbol;
import impl.DiccionarioSimple;

public class App {
    public static void main(String[] args) {
        DiccionarioSimpleTDA dic = new DiccionarioSimple();
        dic.InicializarDiccionario();
        
        dic.Agregar("A", 12.59f);
        dic.Agregar("B", 1.44f);
        dic.Agregar("C", 4.68f);
        dic.Agregar("D", 5.81f);
        dic.Agregar("E", 13.68f);
        dic.Agregar("F", 0.69f);
        dic.Agregar("G", 0.92f);
        dic.Agregar("H", 0.73f);
        dic.Agregar("I", 6.25f);
        dic.Agregar("J", 0.44f);
        dic.Agregar("K", 0.11f);
        dic.Agregar("L", 5.46f);
        dic.Agregar("M", 2.41f);
        dic.Agregar("N", 7.97f);
        dic.Agregar("Ñ", 0.2f);
        dic.Agregar("O", 8.68f);
        dic.Agregar("P", 2.25f);
        dic.Agregar("Q", 0.88f);
        dic.Agregar("R", 6.87f);
        dic.Agregar("S", 7.93f);
        dic.Agregar("T", 4.58f);
        dic.Agregar("U", 2.78f);
        dic.Agregar("V", 1.04f);
        dic.Agregar("W", 0.05f);
        dic.Agregar("X", 0.22f);
        dic.Agregar("Y", 0.91f);
        dic.Agregar("Z", 0.43f);


        NodoHuffman muestra = Huffman.crearArbol(dic);
        
        System.out.println("Codigos");
        Huffman.ListarCodigo(muestra, "");
        System.out.println(Huffman.EncriptarMensaje("SOS", muestra));
        }
}

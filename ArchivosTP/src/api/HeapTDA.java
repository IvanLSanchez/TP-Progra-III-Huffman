package api;
import impl.NodoHuffman;

public interface HeapTDA {
    void InicializarHeap();
    void Agregar(NodoHuffman x);
    void Sacar();
    NodoHuffman Primero();
    boolean HeapVacio();
}

package api;

import impl.NodoHuffman;

public interface ConjuntoTDA {
    void InicializarConjunto();
    boolean ConjuntoVacio();
    void Agregar(int x);
    int Elegir();
    void Sacar(int x);
    boolean Pertenece(int x);
    ///a
}

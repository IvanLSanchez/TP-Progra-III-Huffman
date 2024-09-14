package api;

public interface ConjuntoTDA {
    void InicializarConjunto();
    boolean ConjuntoVacio();
    void Agregar(String x);
    int Elegir();
    void Sacar(String x);
    boolean Pertenece(String x);
    ///a
}

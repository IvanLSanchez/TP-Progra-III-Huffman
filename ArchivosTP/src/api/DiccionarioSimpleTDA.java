package api;

public interface DiccionarioSimpleTDA {
    void InicializarDiccionario();
    void Agregar(String clave, float valor);
    void Eliminar(String clave);
    float Recuperar(String clave);
    ConjuntoTDA Claves();
}

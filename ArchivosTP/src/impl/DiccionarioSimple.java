package impl;
import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;
import impl.Conjunto;

public class DiccionarioSimple implements DiccionarioSimpleTDA {
    // Clase interna para representar un elemento clave-valor
    class Elemento {
        int clave;
        int valor;
    }

    // Arreglo para guardar los elementos
    Elemento[] elementos;
    // Variable para guardar la cantidad de elementos en el diccionario
    int cant;

    public void InicializarDiccionario() {
        cant = 0;
        elementos = new Elemento[100];
    }

    public void Agregar(String clave, float valor) {
        int pos = Clave2Indice(clave);
        if (pos == -1) {
            pos = cant;
            elementos[pos] = new Elemento();
            elementos[pos].clave = clave;
            cant++;
        }
        elementos[pos].valor = valor;
    }

    // Busca el índice de una clave en el arreglo de elementos
    private int Clave2Indice(int clave) {
        int i = cant - 1;
        while (i >= 0 && elementos[i].clave != clave) {
            i--;
        }
        return i;
    }

    // Elimina una clave (y su valor asociado) del diccionario
    public void Eliminar(String clave) {
        int pos = Clave2Indice(clave);
        if (pos != -1) {
            elementos[pos] = elementos[cant - 1];
            cant--;
        }
    }

    // Recupera el valor asociado a una clave
    public float Recuperar(String clave) {
        int pos = Clave2Indice(clave);
        if(pos != -1){
            return elementos[pos].valor;
        }
        else{
            return 0;
        }
    }

    // Devuelve un conjunto de todas las claves presentes en el diccionario
    public ConjuntoTDA Claves() {
        ConjuntoTDA c = new ConjuntoEstatico();
        c.InicializarConjunto();
        for (int i = 0; i < cant; i++) {
            c.Agregar(elementos[i].clave);
        }
        return c;
    }
}

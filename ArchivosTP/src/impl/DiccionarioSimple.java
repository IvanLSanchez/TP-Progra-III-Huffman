package impl;
import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA {

    class Elemento {
        String clave;
        float valor;
    }

    Elemento[] elementos;
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

    private int Clave2Indice(String clave) {
        int i = cant - 1;
        while (i >= 0 && !(elementos[i].clave.equals(clave))) {
            i--;
        }
        return i;
    }

    public void Eliminar(String clave) {
        int pos = Clave2Indice(clave);
        if (pos != -1) {
            elementos[pos] = elementos[cant - 1];
            cant--;
        }
    }

    public float Recuperar(String clave) {
        int pos = Clave2Indice(clave);
        if(pos != -1){
            return elementos[pos].valor;
        }
        else{
            return 0;
        }
    }

    public ConjuntoTDA Claves() {
        ConjuntoTDA c = new Conjunto();
        c.InicializarConjunto();
        for (int i = 0; i < cant; i++) {
            c.Agregar(elementos[i].clave);
        }
        return c;
    }
}

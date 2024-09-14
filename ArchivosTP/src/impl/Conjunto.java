package impl;

import api.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {
    int[] a;
    int cant;

    public void Agregar(String x) {
        if (!this.Pertenece(x)) {
            a[cant] = x;
            cant++;
        }
    }

    public boolean ConjuntoVacio() {
        return cant == 0;
    }

    public int Elegir() {
        return a[cant - 1];
    }

    public void InicializarConjunto() {
        a = new int[100];
        cant = 0;
    }

    public boolean Pertenece(String x) {
        int i = 0;
        while (i < cant && a[i] != x) {
            i++;
        }
        return (i < cant);
    }

    public void Sacar(String x) {
        int i = 0;
        while (i < cant && a[i] != x) {
            i++;
        }
        if (i < cant) {
            a[i] = a[cant - 1];
            cant--;
        }
    }

}

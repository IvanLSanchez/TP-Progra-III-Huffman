package impl;

import api.HeapTDA;

public class MinHeap implements HeapTDA{

    NodoHuffman[] valores;
    int cont, n;

    @Override
    public void InicializarHeap() {
        n = 100;
        valores = new NodoHuffman[n];
        cont = 0;
    }

    @Override
    public void Agregar(NodoHuffman x) {
        if (cont >= n) {
            n *= 2; // Duplicar el tamaño del array si es necesario
            NodoHuffman[] aux = new NodoHuffman[n];
            System.arraycopy(valores, 0, aux, 0, valores.length);
            valores = aux;
        }

        valores[cont] = x;
        cont++;
        Ordenar(cont - 1);
    }

    @Override
    public void Sacar() {
        if (cont > 0) {
            valores[0] = valores[cont - 1];
            cont--;
            OrdenarParaAbajo(0);
        }
    }

    @Override
    public NodoHuffman Primero() {
        if (cont > 0) {
            return valores[0];
        } else {
            throw new IllegalStateException("Heap vacío");
        }
    }

    @Override
    public boolean HeapVacio() {
        return (cont == 0);
    }

    private void Ordenar(int i) {
        int IndicePadre = (i - 1) / 2;

        if (i > 0 && valores[i].probabilidad < valores[IndicePadre].probabilidad) {
            NodoHuffman aux = valores[IndicePadre];
            valores[IndicePadre] = valores[i];
            valores[i] = aux;
            Ordenar(IndicePadre);
        }
    }

    private void OrdenarParaAbajo(int i) {
        while (true){
            int indiceHjoI = 2 * i + 1;
            int indiceHjoD = 2 * i + 2;
            int indiceAIntercambiar = i;

            // Verificar si el hijo izquierdo está dentro de los límites y si es menor que el elemento actual
            if (indiceHjoI < cont && valores[indiceHjoI].probabilidad < valores[indiceAIntercambiar].probabilidad) {
                indiceAIntercambiar = indiceHjoI;
            }

            // Verificar si el hijo derecho está dentro de los límites y si es menor que el elemento actual
            if (indiceHjoD < cont && valores[indiceHjoD].probabilidad < valores[indiceAIntercambiar].probabilidad) {
                indiceAIntercambiar = indiceHjoD;
            }
            /*FIJAR*/
            // Si el índice a intercambiar sigue siendo el mismo, la propiedad del heap se mantiene
            if (indiceAIntercambiar == i) {
                break;
            }

            // Intercambiar los elementos
            NodoHuffman aux = valores[i];
            valores[i] = valores[indiceAIntercambiar];
            valores[indiceAIntercambiar] = aux;

            // Continuar con el siguiente nodo
            i = indiceAIntercambiar;
        }
    }
}

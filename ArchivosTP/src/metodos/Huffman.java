package metodos;
import impl.ColaPrioridadMinHeap;
import impl.VP;

public class Huffman {

    public static void main(String[] args) {        
        VP[] conjuntoCaracteres = new VP[5];

        for (int i = 0; i < conjuntoCaracteres.length; i++) {
            conjuntoCaracteres[i] = new VP();
        }

        conjuntoCaracteres[0].valor = 'A';
        conjuntoCaracteres[1].valor = 'D';
        conjuntoCaracteres[2].valor = 'B';
        conjuntoCaracteres[3].valor = 'C';
        conjuntoCaracteres[4].valor = 'E';
        conjuntoCaracteres[5].valor = 'F';

        conjuntoCaracteres[0].prioridad = 45;
        conjuntoCaracteres[1].prioridad = 16;
        conjuntoCaracteres[2].prioridad = 13;
        conjuntoCaracteres[3].prioridad = 12;
        conjuntoCaracteres[4].prioridad = 9;
        conjuntoCaracteres[5].prioridad = 5;

        int n = conjuntoCaracteres.length;

        ColaPrioridadMinHeap colaPrioridad = new ColaPrioridadMinHeap();
        colaPrioridad.InicializarCola();

        for (int i = 0; i < conjuntoCaracteres.length; i++) {
            colaPrioridad.AcolarPrioridad(conjuntoCaracteres[i].valor , conjuntoCaracteres[i].prioridad);
        }

        for (int j = 0; j < n; j++) {

            VP x = colaPrioridad.Primero();

            //armar el arbol
            
        }


       



    }

}

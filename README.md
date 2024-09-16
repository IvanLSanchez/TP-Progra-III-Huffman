# TP Programacion III Arboles de Huffman
## Integrantes
- Erik Berns
- Tomas Liñeira Abal
- Nicolas Lussoro
- Ivan Lautaro Sanchez
- Tiago Valentini
### Turno
- Lunes, Turno tarde (14-18hs).
## Objetivo del proyecto
Elaborar un codigo capaz de crear arboles de Huffman. Creando las implementaciones necesarias para el proyecto

## Lenguaje empleado
Aprovechando que las implementaciones ya estaban hechas en programacion II en Java aprovechamos las mismas e hicimos el proyecto en Java.

## Consideraciones que se hicieron en el proyecto
- Se creo un NodoHuffman. El mismo esta derivado del nodo de un ABB pero agregando el atributo de probabilidad
- El TDA heap se adapto para que controle nodos de Huffman
- Se considero que cada hoja dentro del arbol abarcaria un carater (variables tipo char)
- Se hicieron ademas del objetivo un codigo capaz de:
    - listarnos los codigos que se crean con el arbol
    - Encriptar mensajes con el arbol creado
    - Desencriptar un mensaje con el arbol creado
- Se tomo que si un caracter no tiene codigo en el arbol creado. al encriptarse se colocara en la secuencia de 1 y 0 tal como figura. Ejemplo si tenemos un arbol que tiene los caracteres {a,b,c}, si queremos encriptar el caracter M el caracter encriptado sera M.

## Fallas que encontramos (aspectos a mejorar)
- tanto el conjunto como el diccionario estan implementados de manera estatica lo que limita el numero de caracteres que se pueden ingresar al arbol.
    - solucion: implementar de manera dinamica los TDA
- La implementacion ordenarParaAbajo de heap posee malas practicas al programar.
    - solucion: reevaluar los condicionales de la funcion para una correcta implementacion
- El codigo al encriptar genera errores ya que distingue entre minusculas y mayusculas (solucionado).
    - solucion: al crear el arbol y encriptar mensajes se transforman todos los caracteres (que se puedan) en mayusculas.
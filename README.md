# TP Programacion III Arboles de Huffman
## Integrantes
- Erik Berns
- Tomas Liñeira Abal
- Nicolas Lussoro
- Ivan Lautaro Sanchez
- Tiago Valentini

## Objetivo del proyecto
Elaborar un codigo capaz de crear arboles de Huffman.

## Consideraciones que se hicieron en el proyecto
- Se creo un nodo Huffman. El mismo esta derivado del nodo de un ABB pero agregando el atributo de probabilidad
- El TDA heap se adapto para que controle nodos de Huffman
- Se considero que cada hoja dentro del arbol abarcaria un carater (variables tipo char)
- Se hicieron ademas del objetivo un codigo capaz de:
    - listarnos los codigos que se crean con el arbol
    - Encriptar mensajes con el arbol creado
    - Desencriptar un mensaje con el arbol creado
- Se tomo que si un caracter no tiene codigo en el arbol creado. al encriptarse se colocara en la secuencia de 1 y 0 tal como figura. Ejemplo si tenemos un arbol que tiene los caracteres {a,b,c}, si queremos encriptar el caracter M el caracter encriptado sera M.

#include <stdio.h>
#include <stdlib.h>

/**
* Compara as linhas de entrada com a palavra "FIM", que define o encerramento do programa.
*
* @param texto Ponteiro para a linha de entrada lida do programa.
* @return 1 se a linha for "FIM", 0 caso contrário.
*/
int comparar(char *texto){
    if(*(texto) == 'F' && *(texto+1) == 'I' && *(texto+2) == 'M' && *(texto+3) == '\0')
        return 1;
    else
        return 0;
}


/**
* Cria uma nova string alocada dinamicamente com os caracteres invertidos.
*
* @param texto Ponteiro para a string original.
* @return Ponteiro char* para a nova área de memória contendo a string invertida.
*/
char* inverter(char* texto){
    char *invertido = (char*)malloc(1000*sizeof(char)), atual;
    int k;

    for(k=0; *(texto+k) != '\0'; k++);

    for(int i=0; i<k; i++){
        *(invertido+i) = *(texto +(k-1-i));
    }
    *(invertido+k) = '\0';

    return invertido;
}


/**
* Entrada do programa
*
*/
int main(){
    char *texto = (char*)malloc(1000*sizeof(char));

    while(scanf(" %[^\n]", texto) == 1 && !comparar(texto)){
        char *resp = inverter(texto);
        printf("%s\n", resp);
        free(resp);
    }

    free(texto);
}

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
* Aplica a Cifra de César com deslocamento de 3 posições de forma recursiva.
* Converte cada caractere somando 3 ao seu valor na tabela ASCII/Unicode.
*
* @param texto Ponteiro para a linha de entrada do programa.
*/
void ciframento(char *texto){
    if(*texto == '\0'){
        printf("\n");
        return;
    }
    else{
        printf("%c", *texto + 3);
        return ciframento(texto + 1);
    }
}

/**
 * Entrada do programa
 *
 */
int main(){
    char *texto = (char*)malloc(1000*sizeof(char));

    while(fgets(texto, 1000, stdin)){
        int tamanho=0;
        while(*(texto+tamanho) != '\0') tamanho++;
        if(tamanho > 0 && *(texto+tamanho-1) == '\n')
            *(texto+tamanho-1) = '\0';

        if(comparar(texto)) break;

        ciframento(texto);
    }

    free(texto);
}

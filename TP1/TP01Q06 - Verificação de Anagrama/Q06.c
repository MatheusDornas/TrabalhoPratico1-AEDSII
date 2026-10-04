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
* Converte um caractere maiúsculo para minúsculo.
* Substitui a função tolower() da biblioteca ctype.h.
*
* @param a Caractere a ser convertido.
* @return O caractere convertido para minúsculo, ou o caractere original, caso a conversão não seja necessária.
*/
char minusculo(char a){
    if(a >= 'A' && a <= 'Z') return a + ('a' - 'A');
    return a;
}


/**
* Verifica se duas strings sao anagramas uma da outra, ignorando
* diferenças entre maiúsculas e minúsculas.
*
* @param texto1 Ponteiro para a primeira string.
* @param texto2 Ponteiro para a segunda string.
* @return 1 se forem anagramas, 0 caso contrário.
*/
int anagrama(char *texto1, char *texto2){
    int coiso[256] = {0}, i=0;

    while(texto1[i] != '\0' && texto2[i] != '\0'){
        coiso[minusculo(texto1[i])]++;
        coiso[minusculo(texto2[i])]--;
        i++;
    }

    if(texto1[i] != '\0' || texto2[i] != '\0') return 0;

    for(int j=0; j<256; j++){
        if(coiso[j] != 0) return 0;
    }

    return 1;
}


/**
* Entrada do programa
*
*/
int main(){
    char *texto1 = (char*)malloc(1000*sizeof(char)), *texto2 = (char*)malloc(1000*sizeof(char));

    while(scanf(" %s", texto1) == 1 && !comparar(texto1)){
        scanf(" %s", texto2);
        if(anagrama(texto1, texto2)) printf("SIM\n");
        else printf("NAO\n");
    }

    free(texto1);
    free(texto2);;
}

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
 * Função que verifica o maior número. Criada somente para a organização do código.
 * 
 * @param a Um valor inteiro.
 * @param b Outro valor inteiro.
 * @return Retorna o maior valor.
 */
int maximo(int a, int b){
    if(a>=b) return a;
    else return b;
}


/**
 * Verifica qual o tamanho da maior substring utilizando um vetor de posição dos caractéres e uma janela deslizante.
 *
 * @param texto String enviada pela main.
 * @return comprimento Comprimento da maior substring possível.
 */
int substring(char *texto){
    int posicoes[26], inicio=0, fim=0, comprimento=1;
    
    for(int i=0; i<26; i++){
        posicoes[i] = -1;
    }

    for(fim=0; *(texto+fim) != '\0'; fim++){
        char atual = *(texto+fim);
        if(posicoes[atual - 'a'] < 0){
            inicio = maximo(inicio, posicoes[atual - 'a'] + 1);            
        }
        else{
            inicio = posicoes[atual - 'a'] + 1;
        }
        posicoes[atual - 'a'] = fim;
        comprimento = (fim-inicio+1)>comprimento?(fim-inicio+1):comprimento;
    }
    return comprimento;
}


/**
 * Ponto de entrada do programa
 */
int main(){
    char *texto = (char*)malloc(1000*sizeof(char));

    while(scanf(" %s", texto) == 1 && !comparar(texto)){
        printf("%d\n", substring(texto));
    }

    free(texto);
}

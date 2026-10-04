#include <stdio.h>

/**
 * Calcula a soma de todos os dígitos de um número inteiro.
 * 
 * @param num O número inteiro a ter seus dígitos somados.
 * @return A soma dos dígitos do número.
 */
int somaDigitos(int num){
    int soma=0;

    while(num>=10){
        soma += num%10;
        num /= 10;
    }
    soma += num;

    return soma;
}


/**
 * Ponto de entrada do programa.
 * Variável primeira utilizada para não haver erro na verificação do verde, já que sem ela um /n extra é adicionado no final e gera erro na verificação.
 * 
 * @return 0 em caso de execução bem-sucedida.
 */
int main(){
    int num, primeira = 1;

    while(scanf("%d", &num) != EOF){
        if(primeira){
            printf("%d", somaDigitos(num));
            primeira = 0;
        }
        else printf("\n%d", somaDigitos(num));
    }
}

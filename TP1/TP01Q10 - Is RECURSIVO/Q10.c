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
 * Verifica se a string é composta exclusivamente por vogais.
 *
 * @param texto A string analisada.
 * @param i Contador.
 * @return true se todos os caracteres forem vogais, false caso contrário.
 */
int vogais(char *texto, int i){
    if(*(texto+i) == '\0') return 1;
    else{
        char atual = *(texto+i);
        int ehvogal = (atual == 'a' || atual == 'e' || atual == 'i' || atual == 'o' || atual == 'u');
        return ehvogal && vogais(texto, i+1);
    }
}


/**
 * Função contadora.
 *
 * @param texto A string a ser analisada.
 * @return vogais Função.
 */
int contVogais(char *texto){
    return vogais(texto,0 );
}


/**
 * Verifica se a string é composta exclusivamente por consoantes.
 *
 * @param texto A string analisada.
 * @param i Contador.
 * @return true se todos os caracteres forem consoantes, false caso contrário.
 */
int consoantes(char *texto, int i){
   if(*(texto+i) == '\0') return 1;
   else{
        char atual = *(texto+i);
        int ehvogal = (atual == 'a' || atual == 'e' || atual == 'i' || atual == 'o' || atual == 'u');
        int ehletra = (atual >= 'a' && atual <= 'z');
        return (!ehvogal && ehletra) && consoantes(texto, i+1);
   }
}


/**
 * Função contadora.
 *
 * @param texto A string a ser analisada.
 * @return consoantes Função.
 */
int contConsoantes(char *texto){
    return consoantes(texto, 0);
}


/**
 * Verifica se a string representa um número inteiro formado apenas por dígitos.
 *
 * @param texto A string analisada.
 * @param i Contador.
 * @return true se for um número inteiro, ou seja, composto apenas pelos caracteres de 0 a 9, false caso contrário.
 */
int inteiro(char *texto, int i){
    if(*(texto+i) == '\0') return 1;
    else{
        char atual = *(texto+i);
        int ehnumero = (atual >= '0' && atual <= '9');
        return ehnumero && inteiro(texto, i+1);
    }
}


/**
 * Função contadora.
 *
 * @param texto A string a ser analisada.
 * @return inteiro Função.
 */
int contInteiro(char *texto){
    return inteiro(texto, 0);
}


/**
 * Verifica se a string representa um número real válido contendo dígitos
 * e, no máximo, um separador (ponto ou vírgula).
 *
 * @param texto A string analisada.
 * @param i Contador.
 * @param p Contador de pontos ou vírgulas
 * @return true se for um número real válido, false caso contrário.
 */        
int real(char *texto, int i, int p){
    if(*(texto+i) == '\0') return 1;
 
    char atual = *(texto+i);
 
    if(atual == '.' || atual == ','){
        p++;
        if(p>1) return 0;
        else return real(texto, i+1, p);
    }
    else if(atual >= '0' && atual <= '9'){
        return real(texto, i+1, p);
    }
    else return 0;
}


/**
 * Função contadora.
 *
 * @param texto A string a ser analisada.
 * @return real Função.
 */
int contReal(char *texto){
    return real(texto, 0, 0);
}


/**
* Entrada do programa.
*/
int main(){
    char *texto = (char*)malloc(1000*sizeof(char));
    
    while(scanf(" %[^\n]", texto) == 1 && !comparar(texto)){
        for(int i=0; texto[i] != '\0'; i++){
            if(texto[i] >= 'A' && texto[i] <= 'Z') texto[i] += 32;
        }
        
        if(contVogais(texto)) printf("SIM ");
        else printf("NAO ");

        if(contConsoantes(texto)) printf("SIM ");
        else printf("NAO ");

        if(contInteiro(texto)) printf("SIM ");
        else printf("NAO ");

        if(contReal(texto)) printf("SIM\n");
        else printf("NAO\n");
    }

    free(texto);
}

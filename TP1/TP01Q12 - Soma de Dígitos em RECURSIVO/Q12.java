import java.util.Scanner;

public class Q12{
    /**
     * Calcula recursivamente a soma de todos os dígitos de um número inteiro
     *
     * @param num O número inteiro a ter seus dígitos somados.
     * @return A soma dos dígitos do número.
     */
    public static int somaDigitos(int num){
        if(num<10){
            return num;
        }
        else{
            return (num%10) + somaDigitos(num/10);
        }
    }


    /**
     * Ponto de entrada do programa.
     * Variável primeira utilizada para não haver erro na verificação do verde, já que sem      ela um /n extra é adicionado no final e gera erro na verificação.
     * 
     * @return 0 em caso de execução bem-sucedida.
     */

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num;
        boolean primeira = true;

        while(sc.hasNextInt()){
            num = sc.nextInt();
            if(primeira){
                System.out.print(somaDigitos(num));
                primeira = false;
            }
            else
                System.out.print("\n" + somaDigitos(num));
        }
    }
}

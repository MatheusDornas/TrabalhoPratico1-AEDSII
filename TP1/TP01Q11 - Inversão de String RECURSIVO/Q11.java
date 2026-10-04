import java.util.Scanner;

public class Q11{
    /**
    * Compara as linhas de entrada com a palavra "FIM", que define o encerramento do programa.
    * Verifica primeiramente se o texto possui exatamente 3 caracteres antes de testar a igualdade.
    *
    * @param texto A linha de entrada lida do programa.
    * @return true se a linha for "FIM", false caso contrário.
    */
	public static boolean comparar(String texto){
		if(texto.length() == 3 && texto.charAt(0) == 'F' && texto.charAt(1) == 'I' && texto.charAt(2) == 'M') return true;
		else return false;
	}

   
    /**
    * Método para fazer o contador do inverter.
    *
    * @param texto Enviado pela main.
    * @return inverter Método inversor.
    */
    public static String chamaInverter(String texto){
        return inverter(texto, texto.length()-1);    
    }

    /**
    * Inverte a string de forma recursiva.
    *
    * @param texto A string a ser invertida.
    * @param contador Índice do contador.
    * @return A string invertida.
    */
    public static String inverter(String texto, int contador){
        if(contador < 0) return "";
        else return texto.charAt(contador) + inverter(texto, contador-1);
    }


    /**
    * Controla a leitura no while e processamento até que "FIM" seja lido.
    *
    * @param args Argumentos de linha de comando.
    */
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        String texto = sc.nextLine();

        while(!comparar(texto)){
            System.out.println(chamaInverter(texto));
            texto = sc.nextLine();
        }
    }
}

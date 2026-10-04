import java.util.Scanner;

public class Q01{
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
    * Aplica a Cifra de César com deslocamento de 3 posições.
    * Converte cada caractere somando 3 ao seu valor na tabela ASCII/Unicode.
    *
    * @param texto A string original a ser cifrada.
    * @return A nova string com todos os caracteres cifrados.
    */
	public static String cifra(String texto){
		String textocifra = "";
		for(int i=0; i<texto.length(); i++){
                                textocifra += (char) (texto.charAt(i) + 3);
                        }
		return textocifra;
	}


	/**
    * Controla a leitura no while e processamento até que "FIM" seja lido.
    *
    * @param args Argumentos de linha de comando.
    */
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String texto = sc.nextLine();
		
		while(!comparar(texto)){
			System.out.println(cifra(texto));			
			texto = sc.nextLine();
		}

		sc.close();
	}
}

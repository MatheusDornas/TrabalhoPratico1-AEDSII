import java.util.Scanner;
import java.util.Random;

public class Q02{
	/**
	* static do gerador aleatório utilizado para manter os sorteios corretos ao longo de toda a execução.
   	*/
	private static Random sorteia = new Random();


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
   	* Sorteia a letra que será substituída e a letra substituta, aplicando as alterações em todas as ocorrências encontradas no texto.
   	*
   	* @param texto A string original que sofrerá as alterações.
    * @return O texto modificado com as devidas substituições realizadas.
    */
	public static String substituicaoSorteada(String texto){
		String textonovo = "";

		char letra1 = ((char) ('a' + (Math.abs(sorteia.nextInt()) % 26))), letra2 = ((char) ('a' + (Math.abs(sorteia.nextInt()) % 26)));

		for(int i=0; i<texto.length(); i++){
			char atual = texto.charAt(i);
			if(atual == letra1) textonovo += letra2;
			else textonovo += atual;
		}
		
		return textonovo; 
	}

	
	/**
   	* Configura a semente do gerador aleatório e controla a leitura no while e processamento até que "FIM" seja lido.
    *
    * @param args Argumentos de linha de comando.
    */
	public static void main(String args[]){
		sorteia.setSeed(4);
		Scanner sc = new Scanner(System.in);
		
		String texto = sc.nextLine();
		
		while(!comparar(texto)){
			System.out.println(substituicaoSorteada(texto));
			texto = sc.nextLine();
		}

		sc.close();
	}
}

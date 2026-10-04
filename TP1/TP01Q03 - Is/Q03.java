import java.util.Scanner;

public class Q03{
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
    * Verifica se a string é composta exclusivamente por vogais.
    *
    * @param texto A string analisada.
    * @return true se todos os caracteres forem vogais, false caso contrário.
	*/
	public static boolean vogais(String texto){
		int count=0;
		char atual;
		boolean retorno;

		for(int i=0; i<texto.length(); i++){
			atual = texto.charAt(i);
			if(atual == 'a' || atual == 'e' || atual == 'i' || atual == 'o' || atual == 'u') count++;
		}

		return count == texto.length();
	}
	

	/**
    * Verifica se a string é composta exclusivamente por consoantes.
    *
    * @param texto A string analisada.
    * @return true se contiver apenas consoantes, false caso contrário.
    */
    public static boolean consoantes(String texto){
        int countletra=0, countvogal=0;
        char atual;
        boolean retorno;

        for(int i=0; i<texto.length(); i++){
            atual = texto.charAt(i);
            if(atual >= 'a' && atual <= 'z') countletra++;
			if(atual == 'a' || atual == 'e' || atual == 'i' || atual == 'o' || atual == 'u') countvogal++;
        }

		return (countletra-countvogal) == texto.length();
        }

	
	/**
    * Verifica se a string representa um número inteiro formado apenas por dígitos.
    *
    * @param texto A string analisada.
    * @return true se for um número inteiro, ou seja, composto apenas pelos caracteres de 0 a 9, false caso contrário.
    */
    public static boolean inteiro(String texto){
        int count=0;
        char atual;
        boolean retorno;

        for(int i=0; i<texto.length(); i++){
            atual = texto.charAt(i);
		    if(atual >= '0' && atual <= '9') count++;
        }

		return count == texto.length();
	}


	/**
    * Verifica se a string representa um número real válido contendo dígitos
    * e, no máximo, um separador (ponto ou vírgula).
    *
    * @param texto A string analisada.
    * @return true se for um número real válido, false caso contrário.
    */        
    public static boolean real(String texto){
        int count=0, ponto=0;
        char atual;
        boolean retorno;

        for(int i=0; i<texto.length(); i++){
            atual = texto.charAt(i);
			if(atual == '.' || atual == ','){
				ponto++;
				if(ponto > 1) return false;
			}
            else if(atual >= '0' && atual <= '9') count++;
		    else return false;
		}

        return count>0;
    }


	/**
    * Lê strings da entrada padrão até encontrar "FIM" e imprime a classificação de cada uma quanto a vogais, consoantes, inteiro e real, respectivamente.
    *
    * @param args Argumentos de linha de comando.
    */
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		String texto = sc.nextLine();
		
		while(!comparar(texto)){
            String novo = "";
            for(int i = 0; i < texto.length(); i++){
                char c = texto.charAt(i);
                if(c >= 'A' && c <= 'Z') c += 32;
                novo += c;
            }
            texto = novo;

			if(vogais(texto)) System.out.print("SIM ");
			else System.out.print("NAO ");

			if(consoantes(texto)) System.out.print("SIM ");
                        else System.out.print("NAO ");

			if(inteiro(texto)) System.out.print("SIM ");
                        else System.out.print("NAO ");

			if(real(texto)) System.out.println("SIM");
                        else System.out.println("NAO");

			texto = sc.nextLine();
		}

		sc.close();
	}
}

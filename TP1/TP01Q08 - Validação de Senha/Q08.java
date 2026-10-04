import java.util.Scanner;

public class Q08{
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
    * Valida se uma senha atende aos requisitos mínimos de segurança.
    * Para isso, usa o vetor valido[5], que armazena da seguinte forma se a senha possui os requisitos: 
    * 
    * 0. Conter no mínimo 8 caracteres.
    * 1. Conter pelo menos uma letra maiúscula.;
    * 2. Conter pelo menos uma letra minúscula.
    * 3. Conter pelo menos um dígito numérico.
    * 4. Conter pelo menos um caractere especial.
    *
    * Se todas essas posições do vetor forem maiores q 0, o requisito foi atingido.
    *
    * @param senha A String contendo a senha a ser validada.
    * @return true se a senha atender a todos os 5 critérios; false caso contrário.
    */
    public static boolean validacao(String senha){
        int[] valido = new int[5];
        
        if(senha.length() >= 8){
            valido[0]++;
            for(int i=0; i< senha.length(); i++){
                if(senha.charAt(i) >= 'A' && senha.charAt(i) <= 'Z') valido[1]++;
                if(senha.charAt(i) >= 'a' && senha.charAt(i) <= 'z') valido[2]++;
                if(senha.charAt(i) >= '0' && senha.charAt(i) <= '9') valido[3]++;
                if ((senha.charAt(i) >= 33 && senha.charAt(i) <= 47) || 
                    (senha.charAt(i) >= 58 && senha.charAt(i) <= 64) || 
                    (senha.charAt(i) >= 91 && senha.charAt(i) <= 96) || 
                    (senha.charAt(i) >= 123 && senha.charAt(i) <= 126)) valido[4]++;
            }
        }
        else return false;

        for(int i=0; i<5; i++){
            if(valido[i] == 0) return false;
        }

        return true;
    }

    /**
    * Controla a leitura no while e processamento até que "FIM" seja lido.
    *
    * @param args Argumentos de linha de comando.
    */
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String senha = sc.nextLine();
        boolean primeira = true;

        while(!comparar(senha)){
            if(primeira){
                if(validacao(senha)) System.out.print("SIM");
                else System.out.print("NAO");
                primeira = false;
                senha = sc.nextLine();
            }
            else{
                if(validacao(senha)) System.out.print("\nSIM");
                else System.out.print("\nNAO");
                senha = sc.nextLine();
            }
        }

        sc.close();
    }
}

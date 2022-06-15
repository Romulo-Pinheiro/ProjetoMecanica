import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ManipuladorDeArquivos {
    public static void leitor(String endereco) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(endereco));
        while (true){
            String linha = br.readLine();
            if (linha != null){
                System.out.println(linha);
            }else{
                break;
            }
        }
        br.close();
    }

    public static void escritor(String endereco) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(endereco, true));
        Scanner input = new Scanner(System.in);
        System.out.println("Escreva algo para inserir no arquivo");
        String linha = input.nextLine();
        bw.append(linha + '\n');
        bw.close();
    }
}



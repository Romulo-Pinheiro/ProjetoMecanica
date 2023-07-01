

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Arquivos {
    public static void escritor(String mensagem, String diretorio, boolean acrescenta) throws IOException{
        // Em algumas situações no projeto vamos precisar sobrescrever o arquivo 
        // (qnd deletarmos um funcionário ou cliente, por exemplo). Pra isso tem o boolean acrescenta
        BufferedWriter bw = new BufferedWriter(new FileWriter(diretorio, acrescenta));
        bw.append(mensagem+ "\n");
        bw.close();
        }


    public static ArrayList<String> percorreArquivo(String diretorio){
        // Vai ser bem comum percorrer o arquivo para fazer alterações, então pra não repetir o msm código
        // tem essa função.

        try {
            BufferedReader br = new BufferedReader(new FileReader(diretorio));

         
            ArrayList <String> result = new ArrayList<String>();
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha != null && !linha.isEmpty()) {
                    result.add(linha);
                }
            }
            br.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void deletarLinha(String diretorio, int indice) throws IOException{
        // Esse método vai servir para deletar qlqr linha de qlqr arquivo sem alterar o resto das linhas.
        ArrayList<String> linhas = percorreArquivo(diretorio);
        try{
            linhas.remove(indice);
            if (linhas != null && !linhas.isEmpty()){
                for(int i = 0; i < linhas.size(); i++){
                    if (i == 0){
                        escritor(linhas.get(i), diretorio, false);
                    } else {
                        escritor(linhas.get(i), diretorio, true);
                    }
                }
            }else{
                escritor("", diretorio, false);
            }
        } catch(IndexOutOfBoundsException e){
            System.out.println("Índice inválido:");
            e.getMessage();
        }

    }

    public static String retornaLeitura(String diretorio) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(diretorio));
        StringBuffer sb = new StringBuffer();
        int indice = 0;
        while (true) {            
            String linha = br.readLine();
         if (linha != null){
             sb.append("\n" + indice + "- ");
             sb.append(linha);
             indice++;
        } else{
             break;
         }
        }
        br.close();
        return sb.toString();
    }
    
    public static void exibeArquivo(String diretorio) throws IOException{
        String mensagem = retornaLeitura(diretorio);
        JOptionPane.showMessageDialog(null, mensagem);
    }
}

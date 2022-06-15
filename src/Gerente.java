
import java.io.IOException;

/**
 *
 * @author ALUNO
 */
public class Gerente extends Funcionario {
    
    public Gerente(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
    }
    
    public void CadastrarFuncionario(String nome, String cpf, String senha, int funcao) throws IOException{
       StringBuffer sb = new StringBuffer();
       sb.append(nome+";");
       sb.append(cpf+";");
       sb.append(senha+";");
       sb.append(funcao);
       Arquivos.escritor(sb.toString(), "src/funcionario.txt", true);
            
       
    }
    
    public void deletarOrdemServico(int indice) throws IOException{
        Arquivos.deletarLinha("src/ordemServico.txt", indice);
    }

    public void deletarCliente(int indice) throws IOException{
        Arquivos.deletarLinha("src/cliente.txt", indice);
    }

    public void deletarFuncionario(int indice) throws IOException{
        Arquivos.deletarLinha("src/funcionario.txt", indice);
    }
}

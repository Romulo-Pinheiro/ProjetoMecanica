import java.io.IOException;

public class Recepcionista extends Funcionario {
    protected int funcao = 2;
    public Recepcionista(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
    }

    public int getFuncao() {
        return funcao;
    }

    public void setFuncao(int funcao) {
        this.funcao = funcao;
    }

    public void CadastrarOrcamento(String cpfCliente, String cpfMecanico, Double valor, String servico) throws IOException{
        Orcamento orcamento = new Orcamento(cpfCliente, cpfMecanico, valor, servico);
        Arquivos.escritor(orcamento.toString(), "src/orcamento.txt", true);
    }
    
    public void CriarOrdemServico(String cpfCliente, String cpfMecanico, Double valor, String servico) throws IOException{
        OrdemServico ordemServico = new OrdemServico(cpfCliente, cpfMecanico, valor, servico);
        Arquivos.escritor(ordemServico.toString(), "src/ordemServico.txt", true);
    }

    public void cadastrarCliente(String nome, String cpf, String email, String telefone, String endereco, String placa) throws IOException{
        Cliente cliente = new Cliente(nome, cpf, email, telefone, endereco, placa);
        Arquivos.escritor(cliente.toString(), "src/cliente.txt", true);
    }

    public void deletarOrcamento(int indice) throws IOException{
        Arquivos.deletarLinha("src/orcamento.txt", indice);
    }
}

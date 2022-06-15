
public class Mecanico extends Funcionario{
    protected int funcao = 3;
    public Mecanico(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
    }

    public int getFuncao() {
        return funcao;
    }

    public void setFuncao(int funcao) {
        this.funcao = funcao;
    }
    
}

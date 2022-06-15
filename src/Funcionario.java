
public class Funcionario extends Pessoa {
    String senha;
    public Funcionario(String nome, String cpf, String senha) {
        super(nome, cpf);
        this.senha = senha;
    }
    
}

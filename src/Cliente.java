
public class Cliente extends Pessoa {
        String email;
        String telefone;
        String  endereco;
        String placa;
    public Cliente(String nome, String cpf, String email, String telefone, String endereco, String placa) {
        super(nome, cpf);
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.placa = placa;
     
        
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    @Override
    public String toString() {
        return "Cliente: " + "Nome -> " + super.nome + " -> CPF -> " + super.cpf + " -> E-mail -> " + email + " -> Telefone -> " + telefone + " -> Endereço -> " + endereco + " -> Placa -> " + placa;
    }
}

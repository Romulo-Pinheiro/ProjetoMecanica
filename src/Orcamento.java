
public class Orcamento {
    String CpfCliente;

    @Override
    public String toString() {
        return "Orcamento: " + "CPF do cliente -> " + CpfCliente + " -> CPF do mecanico -> " + CpfMecanico + " -> Valor do servico -> " + Valor + " -> Descricao do Servico -> " + Servico;
    }
    String CpfMecanico;
    double Valor;
    String Servico;

    public Orcamento(String CpfCliente, String CpfMecanico, Double Valor, String Servico) {
        this.CpfCliente = CpfCliente;
        this.CpfMecanico = CpfMecanico;
        this.Valor = Valor;
        this.Servico = Servico;
    }
     
    
    public String getCpfCliente() {
        return CpfCliente;
    }

    public void setCpfCliente(String CpfCliente) {
        this.CpfCliente = CpfCliente;
    }

    public String getCpfMecanico() {
        return CpfMecanico;
    }

    public void setCpfMecanico(String CpfMecanico) {
        this.CpfMecanico = CpfMecanico;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public String getServico() {
        return Servico;
    }

    public void setServico(String Servico) {
        this.Servico = Servico;
    }
}
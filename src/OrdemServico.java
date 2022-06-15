
public class OrdemServico extends Orcamento{

    public OrdemServico(String CpfCliente, String CpfMecanico, Double Valor, String Servico) {
        super(CpfCliente, CpfMecanico, Valor, Servico);
    }
    @Override
    public String toString() {
        return "Ordem de serviço: " + "CPF do cliente -> " + super.CpfCliente + " -> CPF do mecanico -> " + super.CpfMecanico + " -> Valor do servico -> " + super.Valor + " -> Descricao do Servico -> " + super.Servico;
    }
}

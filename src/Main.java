
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;




/**
 * 
 *
 * @author ALUNO
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        System.out.println("Seja bem vindo ao sistema Car!");
        Scanner scan = new Scanner(System.in);
        int escolha = 0;
        do {
            System.out.println("\nDigite 1 para Fazer Login\nDigite 0 para sair");
            escolha = Integer.parseInt(scan.nextLine());
            switch(escolha){
                case 1:
                    System.out.println("\nDigite seu nome");
                    String nome = scan.nextLine();
                    System.out.println("\nDigite sua senha");
                    String senha = scan.nextLine();
                    login(nome, senha);
                    break;
                case 0:
                    System.out.println("\nPrograma encerrado");
                    break;
                default:
                    System.out.println("\nOpção Inválida");
            }

        } while(escolha != 0);
        
    }
    
    private static void login(String nome, String senha) throws IOException{
            boolean loginEfetuado = false;
            ArrayList<String> result = Arquivos.percorreArquivo("funcionario.txt");

            for (String s : result) {
                //Usamos o método split da classe String
                //para separar as partes entre os ponto e vírgulas.
                //Guardamos o resultado em um array
                String[] funcionario = s.split(";");

                //Criamos um objeto Funcionario e setamos em seus atributos
                //as posições correspondentes do array
                
                if(funcionario[0].equals(nome) && funcionario[2].equals(senha)){
                    loginEfetuado = true;
                    switch(funcionario[3]){
                        case "1":
                            Gerente gerente = new Gerente(funcionario[0], funcionario[1], funcionario[2]);
                            telaGerente(gerente);
                            break;
                        case "2":
                            Mecanico mecanico = new Mecanico(funcionario[0], funcionario[1], funcionario[2]);
                            telaMecanico(mecanico);
                            break;
                        case "3":
                            Recepcionista recepcionista = new Recepcionista(funcionario[0], funcionario[1], funcionario[2]);
                            telaRecepcionista(recepcionista);
                            break;
                    }
                    break;
                } 
                
            }

            if(loginEfetuado == false){
                System.out.println("\nNome ou senha incorreto. Tente novamente.\n");
            }
    }
    
    private static void telaGerente(Gerente gerente) throws IOException {
        System.out.println("\nBem vindo!");
        int op = 0;
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("Digite a opção desejada: \n 1 - Gerenciar Funcionários \n 2 - Gerenciar Ordens de Serviço \n 3 - Gerenciar Clientes \n 4 - VOLTAR PARA TELA DE LOGIN");
            op = Integer.parseInt(input.nextLine());
            switch(op){
                case 1:
                    int opcGerente = 0;
                    do{
                        Arquivos.exibeArquivo("funcionario.txt");
                        System.out.println("\nDigite: \n 1- Para CADASTRAR funcionário \n 2 - Para DELETAR funcionário \n 3 - Para sair.");
                        opcGerente = Integer.parseInt(input.nextLine());
                        switch(opcGerente){
                            case 1:
                                System.out.println("Digite o NOME do funcionário: ");
                                String nome = input.nextLine();
                                System.out.println("Digite o CPF do funcionário: ");
                                String cpf = input.nextLine();
                                System.out.println("Digite a SENHA de acesso que o funcionário terá: ");
                                String senha = input.nextLine();
                                int funcao = 0;
                                do{
                                    System.out.println("Digite a FUNÇÃO do funcionário: ");
                                    System.out.println(" 1 - GERENTE \n 2 - MECÂNICO \n 3 - RECEPCIONISTA");
                                    funcao = Integer.parseInt(input.nextLine());
                                    if(funcao < 1 || funcao > 3){
                                        System.out.println("\n NÚMERO INVÁLIDO. TENTE NOVAMENTE \n");
                                    }
                                    
                                } while(funcao < 1 || funcao > 3);
                                gerente.CadastrarFuncionario(nome, cpf, senha, funcao);
                                System.out.println("FUNCIONÁRIO CADASTRADO COM SUCESSO");
                                break;

                            case 2:
                                ArrayList<String> arquivo = Arquivos.percorreArquivo("funcionario.txt");
                                if (arquivo != null && !arquivo.isEmpty()){
                                    System.out.println("Digite o índice do FUNCIONÁRIO que deseja deletar: ");
                                    int indice = Integer.parseInt(input.nextLine());
                                    if (1 <= indice && indice < arquivo.size()){ //Ele não pode deletar o índice 0 (ele msm)
                                        gerente.deletarFuncionario(indice);
                                    } else{
                                        System.out.println("Índice inválido.\n");
                                    }
                                } else{
                                    System.out.println("Não há FUNCIONÁRIO na lista.\n");
                                }
                                break;
                            
                            case 3:
                                System.out.println("\n SAINDO \n");
                                break;
                            
                            default:
                                System.out.println("Resposta inválida\n");
                        }
                    } while(opcGerente != 3);
                    break;

                case 2:
                    Arquivos.exibeArquivo("ordemServico.txt");
                    System.out.println("Digite: \n 1 - Para deletar uma ORDEM DE SERVIÇO. \n 2 - Para sair.");
                    int deletar = Integer.parseInt(input.nextLine());
                    if (deletar == 1){
                        ArrayList<String> arquivo = Arquivos.percorreArquivo("ordemServico.txt");
                        if (arquivo != null && !arquivo.isEmpty()){
                            System.out.println("Digite o índice da ORDEM DE SERVIÇO que deseja deletar: ");
                            int indice = Integer.parseInt(input.nextLine());
                            if (0 <= indice && indice < arquivo.size()){
                                gerente.deletarOrdemServico(indice);
                            } else{
                                System.out.println("Índice inválido.\n");
                            }
                        } else{
                            System.out.println("Não há ORDEM DE SERVIÇO na lista.\n");
                        }
                    } break;

                case 3:
                    Arquivos.exibeArquivo("cliente.txt");
                    deletar = 0;
                    System.out.println("Digite: \n 1 - Para deletar um CLIENTE. \n 2 - Para sair.");
                    deletar = Integer.parseInt(input.nextLine());
                    if (deletar == 1){
                        ArrayList<String> arquivo = Arquivos.percorreArquivo("cliente.txt");
                        if (arquivo != null && !arquivo.isEmpty()){
                            System.out.println("Digite o índice do CLIENTE que deseja deletar: ");
                            int indice = Integer.parseInt(input.nextLine());
                            if (0 <= indice && indice < arquivo.size()){
                                gerente.deletarCliente(indice);
                            } else{
                                System.out.println("Índice inválido.\n");
                            }
                        } else{
                            System.out.println("Não há CLIENTE na lista.\n");
                        }
                    } break;
                
                case 4:
                    System.out.println("\n VOLTANDO PARA TELA DE LOGIN. \n");
                    break;
                
                default:
                    System.out.println("OPÇÃO INVÁLIDA \n");
            }
        } while(op != 4);
    }

    private static void telaMecanico(Mecanico mecanico) throws IOException  {
        System.out.println("\nBem vindo!");
        int op = 0;
        Scanner input = new Scanner(System.in);
        do{
        System.out.println("\nDigite a opção Desejada: \n"+ "1 - Visualizar Orcamento\n"+"2- Visualizar Ordem de Serviço\n"+"3- VOLTAR PARA TELA DE LOGIN\n");
        op = Integer.parseInt(input.nextLine());
        switch(op){
            case 1:
                Arquivos.exibeArquivo("orcamento.txt");
                break;
            
            case 2:
                Arquivos.exibeArquivo("ordemServico.txt");
                break;
            
            case 3:
                System.out.println("\nVOLTANDO PARA TELA DE LOGIN.\n");
                break;

            default:
                System.out.println("Opção inválida.\n");
                break;
        }
        } while(op != 3);         
    }         

private static void telaRecepcionista(Recepcionista recepcionista) throws IOException{
    
    System.out.println("\nBem vindo.");
    int op = 0;
    Scanner input = new Scanner(System.in);
    do{
    System.out.println("\nDigite a sua opção\n 1: Criar Orcamento e Ordem de Serviço\n 2: Verificar Orçamento \n 3: Cadastrar Cliente \n 4: VOLTAR PRA TELA DE LOGIN");
    op = Integer.parseInt(input.nextLine());
    switch(op){
        case 1:
            int transfos = 0;
            System.out.println("\nDigite o CPF do Cliente:\n");
            String cpfCliente = input.nextLine();
            System.out.println("Digite o CPF do mecanico:\n");
            String cpfMecanico = input.nextLine();      
            System.out.println("Digite o valor do servico:\n");
            Double valor = Double.parseDouble(input.nextLine());
            System.out.println("Informe a descrição do serviço:\n");
            String servico = input.nextLine();
            System.out.println("\nDeseja transformar o orcamento em Ordem de serviço?\n 1 - Sim. Transformar em Ordem de serviço\n 2- Não. Manter em orcamento. ");
            transfos = Integer.parseInt(input.nextLine());
            if (transfos==1){
                    recepcionista.CriarOrdemServico(cpfCliente, cpfMecanico, valor, servico);
                    System.out.println("Ordem de Serviço Criada com Sucesso\n");
                    break;
            } else if (transfos == 2){
                    recepcionista.CadastrarOrcamento(cpfCliente, cpfMecanico, valor, servico);
                    System.out.println("Orçamento Criado com Sucesso \n");
                    break;
            } else{
                    System.out.println("Opção Inválida\n");
                    break;
            }

        case 2:
            transfos = 0;
            Arquivos.exibeArquivo("orcamento.txt");
            do{
            System.out.println("\nDigite: \n1- Para transformar um ORÇAMENTO em ORDEM DE SERVIÇO. \n2- Para deletar um ORÇAMENTO. \n3- Para sair");
            transfos = Integer.parseInt(input.nextLine());
            switch(transfos){
                case 1:
                    ArrayList<String> linhas = Arquivos.percorreArquivo("orcamento.txt");
                    if (linhas != null && !linhas.isEmpty()){
                        System.out.println("Digite o índice do orçamento que deseja alterar: ");
                        int indice = Integer.parseInt(input.nextLine());
                        if (0 <= indice && indice < linhas.size()){
                            String[] orcamento = linhas.get(indice).split(" -> ");
                            recepcionista.CriarOrdemServico(orcamento[1], orcamento[3], Double.parseDouble(orcamento[5]), orcamento[7]);
                            recepcionista.deletarOrcamento(indice);
                            System.out.println("ORDEM DE SERVIÇO CRIADA COM SUCESSO\n");
                            break;
                        } else{
                            System.out.println("Índice inválido\n");
                            break;
                        }
                    } else{
                    System.out.println("Não há orçamentos na lista.\n");
                    break;
                    }
                    

                case 2:
                    ArrayList<String> arquivo = Arquivos.percorreArquivo("orcamento.txt");
                    if (arquivo != null && !arquivo.isEmpty()){
                        System.out.println("Digite o índice do orçamento que deseja deletar: ");
                        int indice = Integer.parseInt(input.nextLine());
                        if (0 <= indice && indice < arquivo.size()){
                            recepcionista.deletarOrcamento(indice);
                        } else{
                            System.out.println("Índice inválido.\n");
                        }
                    } else{
                        System.out.println("Não há orçamentos na lista.\n");
                    }
                    break;
                        
                
                case 3:
                    System.out.println("\nSaindo...\n");
                    break;
    
                default:
                    System.out.println("Resposta inválida.\n");
                    break;
            }
            } while(transfos != 3);
            break;
        
        case 3:
            System.out.println("\nDigite o nome do Cliente: ");
            String nome = input.nextLine();
            System.out.println("Digite o CPF do Cliente: ");
            String cpf = input.nextLine();
            System.out.println("Digite o E-mail do Cliente: ");
            String email = input.nextLine();
            System.out.println("Digite o telefone do Cliente: ");
            String telefone = input.nextLine();
            System.out.println("Digite o endereço do Cliente: ");
            String endereco = input.nextLine();
            System.out.println("Digite a placa do Cliente: ");
            String placa = input.nextLine();
            recepcionista.cadastrarCliente(nome, cpf, email, telefone, endereco, placa);
            System.out.println("CLIENTE CADASTRADO COM SUCESSO.");
            break;

        case 4:
            System.out.println("\nSaindo da Tela\n");
            break;

        default:
            System.out.println("\nResposta inválida.\n");
            break;
        }

    }while(op != 4);

}
}
    
    
    

        
<h1 align='center'> Projeto Mecânica </h1>
Projeto realizado para treinar conceitos de orientação a objetos e manipulação de arquivos em Java  

## 💻 Descrição
O projeto trata-se de um sistema de uma oficina onde existem três acessos: gerente, mecânico e recepcionista. Foram utilizados conceitos de orientação a objetos na criação de classes que representam as entidades do sistema e seus métodos, bem como herança e polimorfismo.

### Gerente
- Cria e deleta acessos de funcionários
- Gerencia Ordens de Serviço
- Gerencia Clientes

### Mecânico
- Visualiza Orçamentos
- Visualiza Ordens de Serviço

### Recepcionista
- Cria Orçamento
- Cria Ordem de Serviço
- Cadastra Clientes

Os dados de login encontram-se em funcionario.txt.
Para utilizar o sistema deve-se executar o arquivo Main.java  

## 📁 Estrutura dos Arquivos
Os dados são armazenados através da manipulação de arquivos. Os arquivos utilizados estão estruturados da seguinte maneira:  

### funcionario.txt  
Campos separados por ponto e vírgula (;)
nome do usuário ; cpf ; senha ; nível de acesso (1, 2 ou 3)

### cliente.txt, orcamento.txt, ordemServico.txt  
Campos separados por setas para direita (->)  
Chave -> Valor

Aplicação dos Padrões Chain of Responsibility, Proxy e
Facade em um Sistema Bancário

Cenário

Você está desenvolvendo um sistema bancário onde clientes podem realizar operações
como saques, transferências e consultas de saldo. Este sistema deve validar múl
plas
condições de segurança e expor uma interface de uso simplificada para o cliente.

Parte 1 – Chain of Responsibility (Validação de
Operações)

Implemente uma cadeia de validação com os seguintes handlers:
1. AutenticacaoHandler : Verifica se o cliente está auten
cado.
2. SaldoHandler : Verifica se o cliente possui saldo suficiente.
3. LimiteDiarioHandler : Verifica se a operação não ultrapassa o limite diário.
Cada handler deve implementar uma interface Handler com o método:

boolean handle(RequisicaoOperacao req);

O úl
mo handler da cadeia deve autorizar a operação apenas se todas as validações
forem bem-sucedidas.

Parte 2 – Proxy (Controle de Acesso ao Serviço Bancário)

Crie a interface:

public interface ServicoBancario {
void realizarOperacao(String tipo, double valor);
}

A classe ServicoBancarioReal executa a operação bancária.
A classe ServicoBancarioProxy verifica se o usuário está auten

cado antes de

delegar a chamada para o serviço real.
Além disso, o proxy deve registrar no console todas as tenta

vas de acesso, com

sucesso ou não.

Parte 3 – Facade (Interface Simples para o Cliente)

Implemente uma classe BancoFacade com os seguintes métodos:
public class BancoFacade {
public void sacar(String clienteId, double valor);
public void transferir(String clienteId, String destinoId, double valor
public void consultarSaldo(String clienteId);
}

Essa fachada deve encapsular:
A criação da requisição de operação ( RequisicaoOperacao )
A montagem da cadeia de handlers
A criação e uso do proxy de serviço
O envio final da operação
Assim, o cliente da API precisa apenas chamar os métodos do BancoFacade .

Exemplo de Estrutura de Arquivos

src/
├── chain/
│ ├── Handler.java
│ ├── AutenticacaoHandler.java
│ ├── SaldoHandler.java
│ ├── LimiteDiarioHandler.java
├── proxy/
│ ├── ServicoBancario.java
│ ├── ServicoBancarioReal.java
│ ├── ServicoBancarioProxy.java
├── facade/
│ └── BancoFacade.java
├── model/
│ ├── Cliente.java
│ ├── ContaBancaria.java
│ ├── RequisicaoOperacao.java
├── main/
│ └── Main.java

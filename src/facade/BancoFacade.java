package facade;

import chain.AutenticacaoHandler;
import chain.Handler;
import chain.LimiteDiarioHandler;
import chain.SaldoHandler;
import model.Cliente;
import model.ContaBancaria;
import model.RequisicaoOperacao;
import proxy.ServicoBancario;
import proxy.ServicoBancarioProxy;

public class BancoFacade {

    public void sacar(String clienteId, double valor) {
        Cliente cliente = getCliente(clienteId); // Recupera cliente (simulação)
        RequisicaoOperacao requisicao = new RequisicaoOperacao(cliente, "Saque", valor);

        // Monta a cadeia de handlers
        Handler autenticacaoHandler = new AutenticacaoHandler();
        Handler saldoHandler = new SaldoHandler();
        Handler limiteDiarioHandler = new LimiteDiarioHandler();

        autenticacaoHandler.setNext(saldoHandler).setNext(limiteDiarioHandler);

        // Cria o proxy
        ServicoBancario servicoBancario = new ServicoBancarioProxy(cliente);

        // Processa a requisição e realiza a operação se autorizada
        if (autenticacaoHandler.handle(requisicao)) {
            servicoBancario.realizarOperacao("Saque", valor);
        }
    }

    public void transferir(String clienteId, String destinoId, double valor) {
        // Implementar lógica semelhante ao sacar, com adaptações para transferência
        System.out.println("Transferência não implementada.");
    }

    public void consultarSaldo(String clienteId) {
        // Implementar lógica para consultar saldo
        System.out.println("Consulta de saldo não implementada.");
    }

    // Método auxiliar para simular a recuperação de um cliente
    private Cliente getCliente(String clienteId) {
        // Lógica para buscar o cliente (pode ser de um banco de dados, etc.)
        // Aqui, criamos um cliente fictício para exemplo
        Cliente cliente = new Cliente(clienteId, "Cliente Exemplo", new ContaBancaria(1000));
        cliente.setAutenticado(true); // Simula cliente autenticado
        return cliente;
    }
}
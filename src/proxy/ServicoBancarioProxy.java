package proxy;

import model.Cliente;

public class ServicoBancarioProxy implements ServicoBancario {

    private ServicoBancarioReal servicoReal;
    private Cliente cliente;

    public ServicoBancarioProxy(Cliente cliente) {
        this.cliente = cliente;
        this.servicoReal = new ServicoBancarioReal();
    }

    @Override
    public void realizarOperacao(String tipo, double valor) {
        if (cliente.isAutenticado()) {
            System.out.println("Proxy: Usuário autenticado. Acessando serviço real.");
            servicoReal.realizarOperacao(tipo, valor);
        } else {
            System.out.println("Proxy: Usuário não autenticado. Acesso negado.");
        }
    }
}
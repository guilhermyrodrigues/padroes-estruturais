package chain;

import model.RequisicaoOperacao;

public class SaldoHandler implements Handler {

    private Handler nextHandler;

    @Override
    public Handler setNext(Handler handler) {
        this.nextHandler = handler;
        return handler;
    }

    @Override
    public boolean handle(RequisicaoOperacao req) {
        if (req.getCliente().getConta().getSaldo() < req.getValor()) {
            System.out.println("Saldo insuficiente.");
            return false;
        }
        System.out.println("Saldo verificado.");
        return (nextHandler == null) || nextHandler.handle(req);
    }
}
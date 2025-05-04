package chain;

import model.RequisicaoOperacao;

public class AutenticacaoHandler implements Handler {

    private Handler nextHandler;

    @Override
    public Handler setNext(Handler handler) {
        this.nextHandler = handler;
        return handler;
    }

    @Override
    public boolean handle(RequisicaoOperacao req) {
        if (!req.getCliente().isAutenticado()) {
            System.out.println("Falha na autenticação.");
            return false;
        }
        System.out.println("Autenticação verificada.");
        return (nextHandler == null) || nextHandler.handle(req);
    }
}
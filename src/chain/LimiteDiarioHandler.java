package chain;

import model.RequisicaoOperacao;

import java.time.LocalDate;

public class LimiteDiarioHandler implements Handler {

    private Handler nextHandler;
    private double limiteDiario = 1000; // Limite diário fixo para exemplo

    @Override
    public Handler setNext(Handler handler) {
        this.nextHandler = handler;
        return handler;
    }

    @Override
    public boolean handle(RequisicaoOperacao req) {
        // Simulação de verificação do limite diário (simplificado)
        if (req.getValor() > limiteDiario) {
            System.out.println("Limite diário excedido.");
            return false;
        }
        System.out.println("Limite diário verificado.");
        // Se for o último handler, autoriza a operação
        if (nextHandler == null) {
            System.out.println("Operação autorizada.");
            return true;
        }
        return nextHandler.handle(req);
    }
}
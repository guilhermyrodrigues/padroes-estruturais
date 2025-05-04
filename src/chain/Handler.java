package chain;

import model.RequisicaoOperacao;

public interface Handler {
    Handler setNext(Handler handler);
    boolean handle(RequisicaoOperacao req);
}
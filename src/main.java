import facade.BancoFacade;
import model.Cliente;
import model.ContaBancaria;

public class main {
    public static void main(String[] args) {

        BancoFacade bancoFacade = new BancoFacade();
        bancoFacade.sacar("123", 1000);
    }
}

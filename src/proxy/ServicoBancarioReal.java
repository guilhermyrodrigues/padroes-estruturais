package proxy;

public class ServicoBancarioReal implements ServicoBancario {
    @Override
    public void realizarOperacao(String tipo, double valor) {
        System.out.println("Realizando operação de " + tipo + " no valor de " + valor);
        // Lógica real da operação bancária aqui
    }
}
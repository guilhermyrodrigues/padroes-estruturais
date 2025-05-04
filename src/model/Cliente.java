package model;

public class Cliente {
    private String id;
    private String nome;
    private ContaBancaria conta;
    private boolean autenticado;

    public Cliente(String id, String nome, ContaBancaria conta) {
        this.id = id;
        this.nome = nome;
        this.conta = conta;
        this.autenticado = false;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public ContaBancaria getConta() {
        return conta;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }
}
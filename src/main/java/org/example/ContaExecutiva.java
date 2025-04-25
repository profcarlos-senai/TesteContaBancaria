package org.example;

public class ContaExecutiva extends ContaBancaria {

    private double limite;

    public ContaExecutiva(double limite){
        super(); // chama o construtor do ancestral
        this.limite = limite;
    }

    @Override
    public double sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }
        if (valor > getSaldo() + getLimite()) {
            throw new IllegalArgumentException("Saldo insuficiente para o saque.");
        }
        setSaldo(getSaldo() - valor);
        return getSaldo();
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}

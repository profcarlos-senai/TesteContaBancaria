package br.senai;

/**
 * Representa uma conta bancária e permite sacar,
 * depositar e verificar o saldo
 */
public class ContaBancaria {

    private Double saldo;

    public ContaBancaria(){
        saldo = 0.0d;
    }

    /**
     * Retorna o saldo
     * @return saldo da conta (double)
     */
    public double getSaldo() {
        return this.saldo;
    }

    /**
     * Deposita um valor na conta
     * @param valor valor em R$ a ser depositado
     * @return o saldo depois do depósito
     */
    public double depositar(double valor) {
        if(valor < 0){
            throw new IllegalArgumentException("Valor do depósito deve sempre ser positivo.");
        }
        this.saldo += valor;
        return getSaldo();
    }

    public double sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }
        if (valor > getSaldo()) {
            throw new IllegalArgumentException("Saldo insuficiente para o saque.");
        }
        saldo -= valor;
        return getSaldo();
    }
}

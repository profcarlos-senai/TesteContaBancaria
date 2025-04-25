package org.example;

public class ContaExecutiva extends ContaBancaria {

    private double limite;
    private boolean gambiarra = false;

    public ContaExecutiva(double limite){
        super(); // chama o construtor do ancestral
        this.limite = limite;
    }

    @Override
    public double sacar(double valor) {
        try{
            gambiarra = true; // sacaneia o getSaldo() só por agora
            return super.sacar(valor);
        } finally {
            gambiarra = false; // shhh não conta pra ninguém
        }
    }

    @Override
    public double getSaldo() {
        if (gambiarra) return super.getSaldo()+getLimite();
        return super.getSaldo();
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}

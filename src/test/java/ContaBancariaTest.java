import br.senai.ContaBancaria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContaBancariaTest {

    private ContaBancaria conta;

    /**
     * Prepara a variável {@code conta} para os testes
     */
    @BeforeEach
    void zeraConta(){
        conta = new ContaBancaria();
    }

    /**
     * testa se consegue criar o objeto
     */
    @Test
    void criaConta(){
        assertNotNull(conta, "Conta recém criada não deveria ser nula");
    }

    /**
     * Testa se a conta foi criada com saldo zerado
     */
    @Test
    void saldoZero(){
        assertEquals(0.0, conta.getSaldo(), "Saldo inicial deveria ser zero");
    }

    /**
     * Testa se consegue depositar
     */
    @Test
    void deposita(){
        double saldo = conta.depositar(100.0);
        assertEquals(100, saldo, "O saldo deveria ser 100 após o depósito");
        assertEquals(saldo, conta.getSaldo(), "o retorno de depositar() deveria ser igual getSaldo()");
        saldo = conta.depositar(100);
        assertEquals(200, saldo, "O saldo deveria ser 200 após dois depósitos de 100");
        assertEquals(200, conta.getSaldo(), "Saldo deveria ser igual a getSaldo() após dois depósitos"); // idem
    }

    /**
     * Testa se explode quando deposita negativo
     */
    @Test
    void depositaNegativo(){
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()-> {
            double saldo = conta.depositar(-100.0);
        }, "Não deveria permitir depositar valores negativos");
        assertEquals("Valor do depósito deve sempre ser positivo.", ex.getMessage(), "Mensagem de erro não é 'Erro: Valor do depósito deve sempre ser positivo.'");
    }


    @Test
    /**
     * testa se o saque funciona
     */
    void testSacarValorValido() {
        conta.depositar(200.0);
        double saldo = conta.sacar(150.0);
        assertEquals(50.0, saldo, "saldo deveria ser 50.0 após depositar 200.0 e sacar 150.0");
        assertEquals(50.0, conta.getSaldo(), "getSaldo() deveria ser 50.0 depois de depositar 200 e sacar 150");
    }

    /**
     * Testa exceção no saque maior que o saldo
     */
    @Test
    void testSacarValorMaiorQueSaldo() {
        conta.depositar(100.0);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            conta.sacar(200.0);
        }, "Deveria lançar exceção em saque maior que o saldo.");
        assertEquals("Saldo insuficiente para o saque.", ex.getMessage(), "Mensagem da exceção do saque maior que o saldo não é a esperada.");
    }

    /**
     * testa exceção no saque negativo
     */
    @Test
    void testSacarValorInvalido() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            conta.sacar(0.0);
        }, "Deveria lançar exceção em saque negativo.");
        assertEquals("O valor do saque deve ser positivo.", ex.getMessage(), "Mensagem da exceção de saque negativo não é a esperada.");
    }

}

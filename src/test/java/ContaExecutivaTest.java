import org.example.ContaExecutiva;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ContaExecutivaTest {

    private ContaExecutiva conta;

    @BeforeEach
    void setUp() {
        conta = new ContaExecutiva(500.0); // Conta com limite de crédito
    }

    @Test
    void testDepositar() {
        conta.depositar(1000.0);
        assertEquals(1000.0, conta.getSaldo());
    }

    @Test
    void testSacarDentroDoLimite() {
        conta.depositar(1000.0);
        conta.sacar(1200.0); // Permitido por causa do limite
        assertEquals(-200.0, conta.getSaldo());
    }

    @Test
    void testSacarAcimaDoLimite() {
        conta.depositar(1000.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            conta.sacar(1600.0);
        });
        assertEquals("Saldo insuficiente para o saque.", exception.getMessage());
    }

    @Test
    void testSacarValorNegativo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            conta.sacar(-100.0);
        });
        assertEquals("O valor do saque deve ser positivo.", exception.getMessage());
    }

    @Test
    void testDefinirLimite() {
        conta.setLimite(1000.0);
        assertEquals(1000.0, conta.getLimite());
    }

    @Test
    void testSaldoConsiderandoLimite() {
        conta.depositar(500.0);
        conta.sacar(700.0); // Deve ser possível por causa do limite
        assertEquals(-200.0, conta.getSaldo());
    }
}

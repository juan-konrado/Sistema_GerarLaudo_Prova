package model;

import org.junit.Test;
import static org.junit.Assert.*;

public class PeritoTest {

    // TU01: Testar a formatação da credencial (Resultado esperado no laudo)
    @Test
    public void formatarCredencialTest() {
        Perito p = new Perito("Alice Mendes", "123456", "Perito Criminal");
        String esperado = "Dr(a). Alice Mendes - Matrícula: 123456 (Perito Criminal)";
        assertEquals(esperado, p.formatarCredencial());
    }

    // TU02: Validação de nome não vazio
    @Test
    public void nomeNaoVazioTest() {
        Perito p = new Perito("Bob Silva", "654321", "Perito Criminal");
        assertFalse(p.getNomeCompleto().isEmpty());
    }

    // TU03: Verifica credencial com caracteres especiais
    @Test
    public void formatarCredencialComCaracteresEspeciaisTest() {
        Perito p = new Perito("Carol #1", "111", "Perito & Especial");
        String esperado = "Dr(a). Carol #1 - Matrícula: 111 (Perito & Especial)";
        assertEquals(esperado, p.formatarCredencial());
    }

    // TU04: Testa credencial nula
    @Test
    public void credencialNulaTest() {
        Perito p = new Perito("Daniel", "222", null);
        String esperado = "Dr(a). Daniel - Matrícula: 222 (null)";
        assertEquals(esperado, p.formatarCredencial());
    }

    // TU05: Testa credencial vazia
    @Test
    public void credencialVaziaTest() {
        Perito p = new Perito("Eva", "333", "");
        String esperado = "Dr(a). Eva - Matrícula: 333 ()";
        assertEquals(esperado, p.formatarCredencial());
    }
}

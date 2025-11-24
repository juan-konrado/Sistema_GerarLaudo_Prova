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
}

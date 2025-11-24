package model;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GeradorDocxTest {

    private GeradorDocx gerador = new GeradorDocx();

    // TF01: Teste Funcional - Geração correta do template (Verificação de saída)
    @Test
    public void gerarDocumentoTipoATest() {
        // Captura a saída do console
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        
        Perito p = new Perito("Cientista", "001", "PC");
        Laudo laudo = new Laudo("Tipo A", p);
        laudo.setCorpoLaudo("Corpo do laudo tipo A.");
        
        gerador.gerarDocumento(laudo);

        String saida = outContent.toString();
        // Verifica se o template correto foi usado
        assertTrue(saida.contains("Usando Template Tipo A. Inserindo dados formatados..."));
        
        // Restaura a saída
        System.setOut(originalOut); 
    }

    // TU04: Teste Unitário - Sanitarização remove tags HTML/XML
    @Test
    public void sanitarizarRemoveTagsHtmlTest() {
        String textoSujeira = "O texto possui <b>formatação</b> e <script>código malicioso</script>";
        String esperado = "O texto possui formatação e código malicioso";
        assertEquals(esperado, gerador.sanitizarTexto(textoSujeira));
    }

    // TU04: Teste Unitário - Sanitarização substitui quebras de linha
    @Test
    public void sanitarizarSubstituiQuebraDeLinhaTest() {
        String textoSujeira = "Linha 1\nLinha 2\nLinha 3.";
        String esperado = "Linha 1 Linha 2 Linha 3.";
        assertEquals(esperado, gerador.sanitizarTexto(textoSujeira));
    }
}

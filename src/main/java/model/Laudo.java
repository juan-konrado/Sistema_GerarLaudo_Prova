package model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Laudo {
    private String tipoLaudo;
    private String corpoLaudo;
    private LocalDate dataOcorrencia;
    private Perito peritoResponsavel;
    private String status = "Rascunho"; // Ex: Rascunho, Finalizado

    public Laudo(String tipoLaudo, Perito peritoResponsavel) {
        this.tipoLaudo = tipoLaudo;
        this.peritoResponsavel = peritoResponsavel;
    }

    public boolean podeExcluir() {
        return status.equals("Rascunho");
    }

    public void setDataOcorrencia(LocalDate dataOcorrencia) {
        if (dataOcorrencia.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("A data da ocorrência não pode ser futura.");
        }
        this.dataOcorrencia = dataOcorrencia;
    }
    
    public String getTipoLaudo() { return tipoLaudo; }
    public String getCorpoLaudo() { return corpoLaudo; }
    public void setCorpoLaudo(String corpoLaudo) { this.corpoLaudo = corpoLaudo; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

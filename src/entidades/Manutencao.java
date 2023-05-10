package entidades;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Manutencao {
    private static int ultimoId = 1;
    private int id;
    private Ferramenta ferramenta;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String descricao;

    public Manutencao(Ferramenta ferramenta, LocalDate dataInicio, String descricao) {
        this.id = ultimoId++;
        this.ferramenta = ferramenta;
        this.dataInicio = dataInicio;
        this.dataFim = null;
        setDescricao(descricao);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ferramenta getFerramenta() {
        return ferramenta;
    }

    public void setFerramenta(Ferramenta ferramenta) {
        this.ferramenta = ferramenta;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataFim = dataTermino;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao.toUpperCase();
    }

    @Override
    public String toString() {
        return "Manutenção ID: " + id +
                "\nFerramenta: " + ferramenta.getNome() +
                " (ID: " + ferramenta.getId() + ")" +
                "\nData de Início: " + dataInicio +
                "\nData de Fim: " + dataFim +
                "\nDescrição: " + descricao;
    }


}


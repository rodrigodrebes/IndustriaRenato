package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    private int id;
    private Funcionario funcionario;
    private String status; // "emprestado" ou "devolvido"
    private Ferramenta ferramenta;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(int id, Funcionario funcionario, Ferramenta ferramenta, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.id = id;
        this.funcionario = funcionario;
        this.ferramenta = ferramenta;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Ferramenta getFerramenta() {
        return ferramenta;
    }

    public void setFerramenta(Ferramenta ferramenta) {
        this.ferramenta = ferramenta;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "\n------------------------" +
                "\nID do Empréstimo: " + id +
                "\nFuncionário: " + funcionario.getNome() +
                "\nFerramenta: " + ferramenta.getNome() +
                "\nData do Empréstimo: " + dataEmprestimo.format(formatter) +
                "\nData da Devolução: " + (dataDevolucao == null ? "Não devolvido" : dataDevolucao.format(formatter)) +
                "\nStatus: " + (status == null ? "Não definido" : status) +
                "\n------------------------";
    }



}



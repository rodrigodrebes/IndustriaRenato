package menu_e_cadastros;

import entidades.Emprestimo;
import entidades.Ferramenta;
import entidades.Funcionario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class CadastroEmprestimos {
    private List<Emprestimo> emprestimos;
    private int ultimoId = 0;

    public CadastroEmprestimos() {
        this.emprestimos = new ArrayList<>();
    }

    public void cadastrarEmprestimo(List<Funcionario> funcionarios, List<Ferramenta> ferramentas) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o id do funcionario:");
        int idFuncionario = scanner.nextInt();
        Funcionario funcionario = null;
        for (Funcionario f : funcionarios) {
            if (f.getId() == idFuncionario) {
                funcionario = f;
                break;
            }
        }
        if (funcionario == null) {
            System.out.println("Funcionário não encontrado");
            return;
        }

        System.out.println("Ferramentas disponíveis para empréstimo:");
        List<Ferramenta> ferramentasDisponiveis = new ArrayList<>();
        int opcao = 1;
        for (Ferramenta f : ferramentas) {
            if (f.isEmprestavel()) {
                ferramentasDisponiveis.add(f);
                System.out.println(opcao + ". " + f.getNome());
                opcao++;
            }
        }

        if (ferramentasDisponiveis.isEmpty()) {
            System.out.println("Não há ferramentas disponíveis para empréstimo");
            return;
        }

        System.out.print("Digite o número correspondente à ferramenta ou objeto desejado: ");
        int escolhaFerramenta = scanner.nextInt();
        if (escolhaFerramenta < 1 || escolhaFerramenta > ferramentasDisponiveis.size()) {
            System.out.println("Opção inválida");
            return;
        }

        Ferramenta ferramenta = ferramentasDisponiveis.get(escolhaFerramenta - 1);

        LocalDate dataAtual = LocalDate.now();

        Emprestimo emprestimo = new Emprestimo(++ultimoId, funcionario, ferramenta, dataAtual, null);
        emprestimo.setStatus("Emprestado");
        emprestimos.add(emprestimo);

        // Atualizar status da ferramenta
        ferramenta.setEmprestado();

        System.out.println("Empréstimo cadastrado com sucesso!");
    }


    public void listarEmprestimos() {
        System.out.println("\nLista de Empréstimos:");
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo);
        }

    }

    public void listarEmprestimosPorData(LocalDate data) {
        System.out.println("Empréstimos na data " + data + ":");
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getDataEmprestimo().isEqual(data)) {
                System.out.println(emprestimo);
            }
        }
    }
    public void devolverEmprestimo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o id do empréstimo a ser devolvido:");
        int idEmprestimo = scanner.nextInt();
        Emprestimo emprestimo = null;
        for(Emprestimo e : emprestimos){
            if(e.getId() == idEmprestimo){
                emprestimo = e;
                break;
            }
        }
        if(emprestimo == null){
            System.out.println("Empréstimo não encontrado");
            return;
        }

        if (emprestimo.getStatus().equalsIgnoreCase("Devolvido ao setor")) {
            System.out.println("O Empréstimo já foi devolvido");
            return;
        }

        LocalDate dataAtual = LocalDate.now();
        emprestimo.setDataDevolucao(dataAtual); // define a data de devolução como a data atual
        emprestimo.setStatus("Devolvido ao setor"); // define o status do empréstimo como devolvido
        emprestimo.getFerramenta().setAtivo(); // muda o status da ferramenta para ativo novamente

        System.out.println("Empréstimo devolvido com sucesso!");
    }

}


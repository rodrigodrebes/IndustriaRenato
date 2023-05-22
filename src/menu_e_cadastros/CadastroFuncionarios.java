package menu_e_cadastros;

import entidades.Funcionario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroFuncionarios {
    private final List<Funcionario> funcionarios;

    public CadastroFuncionarios() {
        this.funcionarios = new ArrayList<>();
    }

    public void cadastrar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cadastro de Funcionários");

        System.out.println("Digite o nome do funcionário:");
        String nome = scanner.nextLine();
        System.out.println("Digite o setor do funcionário:");
        String setor = scanner.nextLine();

        Funcionario funcionario = new Funcionario(nome, setor);
        funcionarios.add(funcionario);

        System.out.println("Funcionário cadastrado com sucesso!");
    }

    public void listar() {
        System.out.println("\nLista de Funcionários cadastrados:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.toString());
        }
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}

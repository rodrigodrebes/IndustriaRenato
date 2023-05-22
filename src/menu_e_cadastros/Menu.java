package menu_e_cadastros;

import entidades.Ferramenta;
import entidades.Funcionario;
import entidades.TipoObjeto;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    private final CadastroFuncionarios cadastroFuncionarios = new CadastroFuncionarios();
    private final CadastroTiposObjetos cadastroTiposObjetos = new CadastroTiposObjetos();
    private final CadastroObjetos cadastroObjetos = new CadastroObjetos();
    private final CadastroManutencoes cadastroManutencoes = new CadastroManutencoes();

    private final CadastroEmprestimos cadastroEmprestimos = new CadastroEmprestimos();


    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        inicializarDados();

        do {
            System.out.println("\nMenu Principal");
            System.out.println("1. Funcionários");
            System.out.println("2. Objetos");
            System.out.println("3. Manutenções");
            System.out.println("4. Empréstimos");
            System.out.println("0. Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    exibirMenuFuncionarios();
                    break;
                case 2:
                    exibirMenuObjetos();
                    break;
                case 3:
                    exibirMenuManutencoes();
                    break;
                case 4:
                    exibirMenuEmprestimos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private void exibirMenuFuncionarios() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu de Funcionários");
            System.out.println("1. Cadastrar funcionário");
            System.out.println("2. Listar funcionários");
            System.out.println("0. Voltar");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastroFuncionarios.cadastrar();
                    break;
                case 2:
                    cadastroFuncionarios.listar();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    ;

    private void exibirMenuObjetos() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu de Objetos");
            System.out.println("1. Cadastrar tipo de objeto");
            System.out.println("2. Listar tipos de objetos");
            System.out.println("3. Cadastrar objeto");
            System.out.println("4. Listar objetos");
            System.out.println("5. Listar objetos por situação");
            System.out.println("0. Voltar");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastroTiposObjetos.cadastrarTipoObjeto();
                    break;
                case 2:
                    cadastroTiposObjetos.listarTiposObjetos();
                    break;
                case 3:
                    cadastroObjetos.cadastrarObjeto(cadastroTiposObjetos.getTiposObjetos());
                    break;
                case 4:
                    cadastroObjetos.listarObjetos();
                    break;
                case 5:
                    cadastroObjetos.listarObjetosPorSituacao();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    ;

    private void exibirMenuManutencoes() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu de Manutenções");
            System.out.println("1. Cadastrar manutenção");
            System.out.println("2. Encerrar manutenção");
            System.out.println("3. Listar manutenções");
            System.out.println("0. Voltar");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastroManutencoes.cadastrarManutencao(cadastroObjetos.getObjetos());
                    break;
                case 2:
                    cadastroManutencoes.encerrarManutencao();
                    break;
                case 3:
                    cadastroManutencoes.listarManutencoes();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    ;

    private void exibirMenuEmprestimos() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu de Empréstimos");
            System.out.println("1. Cadastrar empréstimo");
            System.out.println("2. Listar empréstimos");
            System.out.println("3. Gerar relatório de empréstimos por data");
            System.out.println("4. Devolver empréstimo");
            System.out.println("0. Voltar");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastroEmprestimos.cadastrarEmprestimo(cadastroFuncionarios.getFuncionarios(), cadastroObjetos.getObjetos());
                    break;
                case 2:
                    cadastroEmprestimos.listarEmprestimos();
                    break;
                case 3:
                    System.out.print("Digite a data (formato YYYY-MM-DD): ");
                    String data = scanner.next();
                    LocalDate localDate = LocalDate.parse(data);
                    cadastroEmprestimos.listarEmprestimosPorData(localDate);
                    break;
                case 4:
                    cadastroEmprestimos.devolverEmprestimo();  // Chamada do novo método para devolução de empréstimo
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }



    private void inicializarDados() {
        // Cadastrar 4 funcionários
        Funcionario func1 = new Funcionario("João Silva", "RH");
        Funcionario func2 = new Funcionario("Maria Souza", "Contabilidade");
        Funcionario func3 = new Funcionario("Carlos Andrade", "Marketing");
        Funcionario func4 = new Funcionario("Julia Menezes", "Vendas");

        cadastroFuncionarios.getFuncionarios().addAll(Arrays.asList(func1, func2, func3, func4));
    }
}



package menu_e_cadastros;

import java.util.Scanner;

public class Menu {
    private final CadastroFuncionarios cadastroFuncionarios = new CadastroFuncionarios();
    private final CadastroTiposObjetos cadastroTiposObjetos = new CadastroTiposObjetos();
    private final CadastroObjetos cadastroObjetos = new CadastroObjetos();
    private final CadastroManutencoes cadastroManutencoes = new CadastroManutencoes();

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu Principal");
            System.out.println("1. Cadastrar funcionário");
            System.out.println("2. Listar funcionários");
            System.out.println("3. Cadastrar tipo de objeto");
            System.out.println("4. Listar tipos de objetos");
            System.out.println("5. Cadastrar objeto");
            System.out.println("6. Listar objetos");
            System.out.println("7. Cadastrar manutenção");
            System.out.println("8. Encerrar manutenção");
            System.out.println("9. Listar manutenções");
            System.out.println("0. Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastroFuncionarios.cadastrar();
                    break;
                case 2:
                    cadastroFuncionarios.listar();
                    break;
                case 3:
                    cadastroTiposObjetos.cadastrarTipoObjeto();
                    break;
                case 4:
                    cadastroTiposObjetos.listarTiposObjetos();
                    break;
                case 5:
                    cadastroObjetos.cadastrarObjeto(cadastroTiposObjetos.getTiposObjetos());
                    break;
                case 6:
                    cadastroObjetos.listarObjetos();
                    break;
                case 7:
                    cadastroManutencoes.cadastrarManutencao(cadastroObjetos.getObjetos());
                    break;
                case 8:
                    cadastroManutencoes.encerrarManutencao();
                    break;
                case 9:
                    cadastroManutencoes.listarManutencoes();
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
}

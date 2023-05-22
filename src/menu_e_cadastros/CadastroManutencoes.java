package menu_e_cadastros;

import entidades.Manutencao;
import entidades.Ferramenta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroManutencoes {
    private List<Manutencao> manutencoes;

    public CadastroManutencoes() {
        this.manutencoes = new ArrayList<>();
    }

    public void cadastrarManutencao(List<Ferramenta> objetos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecione o objeto que precisa de manutenção:");
        for (int i = 0; i < objetos.size(); i++) {
            System.out.println((i + 1) + ". " + objetos.get(i).getNome());
        }
        int objetoIndex = scanner.nextInt() - 1;
        Ferramenta objeto = objetos.get(objetoIndex);

        scanner.nextLine(); // Consumir a linha restante
        System.out.println("Digite a descrição da manutenção:");
        String descricao = scanner.nextLine().toUpperCase();
        System.out.println("Digite a data de início da manutenção (formato: AAAA-MM-DD):");
        String dataInicioStr = scanner.nextLine();
        LocalDate dataInicio = LocalDate.parse(dataInicioStr);

        objeto.setEmManutencao();

        Manutencao manutencao = new Manutencao(objeto, dataInicio, descricao);
        manutencoes.add(manutencao);
        System.out.println("Manutenção cadastrada com sucesso!");
    }

    public void encerrarManutencao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecione a manutenção que deseja encerrar:");
        for (int i = 0; i < manutencoes.size(); i++) {
            System.out.println((i + 1) + ". " + manutencoes.get(i).getDescricao() + " - " + manutencoes.get(i).getFerramenta().getNome());
        }
        int manutencaoIndex = scanner.nextInt() - 1;
        Manutencao manutencao = manutencoes.get(manutencaoIndex);

        manutencao.getFerramenta().setAtivo();

        scanner.nextLine(); // Consumir a linha restante
        System.out.println("Digite a data de término da manutenção (formato: AAAA-MM-DD):");
        String dataTerminoStr = scanner.nextLine();
        LocalDate dataTermino = LocalDate.parse(dataTerminoStr);

        manutencao.getFerramenta().setAtivo();

        manutencao.setDataTermino(dataTermino);
        System.out.println("Manutenção encerrada com sucesso!");
    }

    public void listarManutencoes() {
        System.out.println("Lista de manutenções:");
        for (Manutencao manutencao : manutencoes) {
            System.out.println(manutencao);
        }
    }
}

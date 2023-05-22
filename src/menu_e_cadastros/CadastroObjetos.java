package menu_e_cadastros;

import entidades.Ferramenta;
import entidades.TipoObjeto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CadastroObjetos {
    private List<Ferramenta> ferramentas;

    public CadastroObjetos() {
        this.ferramentas = new ArrayList<>();
    }

    public void cadastrarObjeto(List<TipoObjeto> tiposObjetos) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do objeto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a descrição do objeto: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite o status do objeto (ativo/inativo): ");
        String status = scanner.nextLine();

        System.out.println("\nEscolha um tipo de objeto:");

        for (int i = 0; i < tiposObjetos.size(); i++) {
            System.out.println((i + 1) + ". " + tiposObjetos.get(i).getNome());
        }

        System.out.print("Digite a opção desejada: ");
        int opcao = scanner.nextInt() - 1;

        Ferramenta objeto = new Ferramenta(nome, descricao, status, tiposObjetos.get(opcao));
        ferramentas.add(objeto);

        System.out.println("\nObjeto cadastrado com sucesso!");
    }

    public List<Ferramenta> getObjetos() {
        return new ArrayList<>(ferramentas);
    }

    public void listarObjetos() {
        System.out.println("Lista de objetos:");
        for (Ferramenta objeto : ferramentas) {
            System.out.println(objeto.toString());
        }
    }

    public void listarFerramentasPorSituacao() {
        List<Ferramenta> ferramentasAtivas = new ArrayList<>();
        List<Ferramenta> ferramentasBaixadas = new ArrayList<>();

        for (Ferramenta ferramenta : ferramentas) {
            if (ferramenta.getStatus().equalsIgnoreCase("BAIXADO")) {
                ferramentasBaixadas.add(ferramenta);
            } else if (ferramenta.getStatus().equalsIgnoreCase("ATIVO")) {
                ferramentasAtivas.add(ferramenta);
            }
        }

        System.out.println("=== Ferramentas Ativas ===");
        ferramentasAtivas.sort(Comparator.comparing(Ferramenta::getNome));
        for (Ferramenta ferramenta : ferramentasAtivas) {
            System.out.println("Nome: " + ferramenta.getNome() + ", Status: " + ferramenta.getStatus());
        }

        System.out.println("=== Ferramentas Baixadas ===");
        ferramentasBaixadas.sort(Comparator.comparing(Ferramenta::getNome));
        for (Ferramenta ferramenta : ferramentasBaixadas) {
            System.out.println("Nome: " + ferramenta.getNome() + ", Status: " + ferramenta.getStatus());
        }
    }

    public void listarFerramentasPorTipo(String tipo) {
        List<Ferramenta> ferramentasDoTipo = new ArrayList<>();

        for (Ferramenta ferramenta : ferramentas) {
            if (ferramenta.getTipoObjeto().getNome().equals(tipo)) {
                ferramentasDoTipo.add(ferramenta);
            }
        }

        ferramentasDoTipo.sort(Comparator.comparing(Ferramenta::getNome));
        for (Ferramenta ferramenta : ferramentasDoTipo) {
            System.out.println("Nome: " + ferramenta.getNome() + ", Status: " + ferramenta.getStatus());
        }
    }
}

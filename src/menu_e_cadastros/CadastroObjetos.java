package menu_e_cadastros;

import entidades.Ferramenta;
import entidades.TipoObjeto;

import java.util.*;

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

        public void listarObjetosPorSituacao() {
            List<Ferramenta> emprestados = new ArrayList<>();
            List<Ferramenta> disponiveis = new ArrayList<>();
            List<Ferramenta> emManutencao = new ArrayList<>();

            for (Ferramenta ferramenta : ferramentas) {
                String status = ferramenta.getStatus();
                if (status.equalsIgnoreCase("Emprestado")) {
                    emprestados.add(ferramenta);
                } else if (status.equalsIgnoreCase("Ativo")) {
                    disponiveis.add(ferramenta);
                } else if (status.equalsIgnoreCase("Em Manutenção")) {
                    emManutencao.add(ferramenta);
                }
            }

            // Ordenar alfabeticamente
            Collections.sort(emprestados, Comparator.comparing(Ferramenta::getNome));
            Collections.sort(disponiveis, Comparator.comparing(Ferramenta::getNome));
            Collections.sort(emManutencao, Comparator.comparing(Ferramenta::getNome));

            System.out.println("Itens emprestados:");
            for (Ferramenta ferramenta : emprestados) {
                System.out.println(ferramenta.getNome() + " - " + ferramenta.getStatus());
            }

            System.out.println("\nItens disponíveis:");
            for (Ferramenta ferramenta : disponiveis) {
                System.out.println(ferramenta.getNome() + " - " + ferramenta.getStatus());
            }

            System.out.println("\nItens em manutenção:");
            for (Ferramenta ferramenta : emManutencao) {
                System.out.println(ferramenta.getNome() + " - " + ferramenta.getStatus());
            }
        }

}

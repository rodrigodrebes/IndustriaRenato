package menu_e_cadastros;

import entidades.Ferramenta;
import entidades.TipoObjeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroObjetos {
    private List<Ferramenta> objetos;

    public CadastroObjetos() {
        this.objetos = new ArrayList<>();
    }

    public void cadastrarObjeto(List<TipoObjeto> tiposObjetos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do objeto:");
        String nome = scanner.nextLine().toUpperCase();

        System.out.println("Digite a descrição do objeto:");
        String descricao = scanner.nextLine().toUpperCase();

        System.out.println("Digite o status do objeto:");
        String status = scanner.nextLine().toUpperCase();

        System.out.println("Selecione o tipo do objeto:");
        for (int i = 0; i < tiposObjetos.size(); i++) {
            System.out.println((i + 1) + ". " + tiposObjetos.get(i).getNome());
        }
        int tipoIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        TipoObjeto tipo = tiposObjetos.get(tipoIndex);

        Ferramenta objeto = new Ferramenta(nome, descricao, status, tipo);
        objetos.add(objeto);
        System.out.println("Objeto cadastrado com sucesso!");
    }

    public List<Ferramenta> getObjetos() {
        return new ArrayList<>(objetos);
    }

    public void listarObjetos() {
        System.out.println("Lista de objetos:");
        for (Ferramenta objeto : objetos) {
            System.out.println(objeto.toString());
        }
    }
}

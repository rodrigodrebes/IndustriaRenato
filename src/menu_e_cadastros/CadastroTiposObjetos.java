package menu_e_cadastros;

import entidades.TipoObjeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroTiposObjetos {
    private List<TipoObjeto> tiposObjetos;

    public CadastroTiposObjetos() {
        this.tiposObjetos = new ArrayList<>();
    }

    public void cadastrarTipoObjeto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do tipo de objeto:");
        String nome = scanner.nextLine().toUpperCase();

        TipoObjeto tipoObjeto = new TipoObjeto(nome);
        tiposObjetos.add(tipoObjeto);
        System.out.println("Tipo de objeto cadastrado com sucesso!");
    }

    public void listarTiposObjetos() {
        System.out.println("Lista de tipos de objetos:");
        for (TipoObjeto tipoObjeto : tiposObjetos) {
            System.out.println(tipoObjeto);
        }
    }

    public List<TipoObjeto> getTiposObjetos() {
        return new ArrayList<>(tiposObjetos);
    }

}

package entidades;
public class Funcionario {
    private static int nextId = 1;
    private int id;
    private String nome;
    private String setor;

    public Funcionario(String nome, String setor) {
        this.id = nextId++;
        this.nome = nome;
        this.setor = setor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor.toUpperCase();
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Nome: " + nome + "\n" +
                "Setor: " + setor + "\n\n";
    }
}

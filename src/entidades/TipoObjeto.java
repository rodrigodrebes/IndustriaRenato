package entidades;

public class TipoObjeto {
    private static int ultimoId = 1;

    private int id;
    private String nome;

    public TipoObjeto(String nome) {
        this.id = ultimoId++;
        this.nome = nome.toUpperCase();
    }

    // Getter e Setter
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

    @Override
    public String toString() {
        return "Tipo de Objeto [" +
                "ID: " + id +
                ", Nome: " + nome +
                "]";
    }

}


package entidades;

public class Ferramenta {
    private static int ultimoId = 1;

    private int id;
    private String nome;
    private String descricao;
    private String status;
    private TipoObjeto tipoObjeto;

    public Ferramenta(String nome, String descricao, String status, TipoObjeto tipoObjeto) {
        this.id = ultimoId++;
        setNome(nome);
        setDescricao(descricao);
        setStatus(status);
        this.tipoObjeto = tipoObjeto;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao.toUpperCase();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status.toUpperCase();
    }

    public TipoObjeto getTipoObjeto() {
        return tipoObjeto;
    }

        public void setTipoObjeto(TipoObjeto tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }

    @Override
    public String toString() {
        return "Ferramenta [" +
                "ID: " + id +
                ", Nome: " + nome +
                ", Descrição: " + descricao +
                ", Status: " + status +
                ", Tipo: " + tipoObjeto.getNome() +
                "]";
    }


    public boolean isEmprestavel() {
        return status.equalsIgnoreCase("ativo");
    }
}


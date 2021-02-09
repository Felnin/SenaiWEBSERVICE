package model;

public class Livro {

    private int id;
    private int quantidade;
    private String nome;
    private String area;
    private String resumo;
    private int anoPublicacao;
    private int edicao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Livro(int id, int quantidade, String nome, String area, String resumo, int anoPublicacao, int edicao) {
        this.id = id;
        this.quantidade = quantidade;
        this.nome = nome;
        this.area = area;
        this.resumo = resumo;
        this.anoPublicacao = anoPublicacao;
        this.edicao = edicao;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

}

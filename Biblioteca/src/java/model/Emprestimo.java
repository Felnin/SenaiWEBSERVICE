package model;

public class Emprestimo {
    
    private int id;
    private int idUsuario;
    private String dataInicio;
    private String dataFim;
    private int multa;
    private boolean ativo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public int getMulta() {
        return multa;
    }

    public void setMulta(int multa) {
        this.multa = multa;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public Emprestimo(int id, int idUsuario, String dataInicio, String dataFim, int multa, boolean ativo) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.multa = multa;
        this.ativo = ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}

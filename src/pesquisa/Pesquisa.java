package pesquisa;

import java.util.List;

public class Pesquisa {
	
	private int idPesquisa;
    private String nome;

    public int getIdPesquisa() {
        return idPesquisa;
    }
    public void setIdPesquisa(int idPesquisa) {
        this.idPesquisa = idPesquisa;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int pesquisar(List<String> lista, String conteudo){
        return 0;
    }

    protected Pesquisa(int idPesquisa, String nome) {
        this.idPesquisa = idPesquisa;
        this.nome = nome;
    }
}

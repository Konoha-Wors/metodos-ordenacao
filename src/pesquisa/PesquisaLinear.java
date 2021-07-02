package pesquisa;

import java.util.List;

public class PesquisaLinear extends Pesquisa{
	
	public PesquisaLinear(int idPesquisa, String nome) {
		super(idPesquisa, nome);
	}
	
	@Override
	public int pesquisar(List<String> lista, String conteudo) {
		for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(conteudo)) {
                return i;
            }
        }
        return -1;
	}
}

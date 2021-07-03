package pesquisa;

import java.util.List;

public class BinariaIterativa extends PesquisaBinaria{
	
	public BinariaIterativa(int idPesquisa, String nome) {
		super(idPesquisa, nome);
	}

	@Override
	public int pesquisar(List<String> lista, String conteudo) {
		int inicio = 0;
        int i = 0;
        int fim = Integer.parseInt(conteudo) -1;

        while(inicio <= fim) {
            i = (inicio + fim) / 2;

            if (lista.get(i).equals(conteudo)) {  
                return i;
            }

            if (!lista.get(i).equals(conteudo)) { 
                inicio = i + 1;
            } else {   
                fim = i;
            }
        }
        return -1;
	}
}

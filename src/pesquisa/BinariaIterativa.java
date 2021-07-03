package pesquisa;

import java.util.List;

public class BinariaIterativa extends PesquisaBinaria{
	
	public BinariaIterativa(int idPesquisa, String nome) {
		super(idPesquisa, nome);
	}

	@Override
	public int pesquisar(List<String> lista, String conteudo) {
		Long inicio = 0l;
        Long i = 0l;
        Long fim = Long.parseLong(conteudo) -1;

        while(inicio <= fim) {
            i = (inicio + fim) / 2;

            if (lista.get(i.intValue()).equals(conteudo)) {  
                return i.intValue();
            }

            if (!lista.get(i.intValue()).equals(conteudo)) { 
                inicio = i + 1;
            } else {   
                fim = i;
            }
        }
        return -1;
	}
}

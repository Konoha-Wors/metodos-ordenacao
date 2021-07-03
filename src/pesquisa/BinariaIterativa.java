package pesquisa;

import java.util.List;

public class BinariaIterativa extends PesquisaBinaria{
	
	public BinariaIterativa(int idPesquisa, String nome) {
		super(idPesquisa, nome);
	}

	@Override
	public int pesquisar(List<String> lista, String conteudo) {
		
		Long[] numeros = new Long[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
            numeros[i] = Long.parseLong(lista.get(i));
        }
		
		int fim = lista.size()-1;
		int meio = fim / 2;
		int i = meio;

        while(i <= fim) {
                		
        	if (numeros[i] == Long.parseLong(conteudo)) {  
        		return i;
        	}
            
            if(i == meio && Long.parseLong(conteudo) < numeros[meio]) {
            	i = -1;
            	fim = meio;
            }
            
            i++;
        }
        return -1;
	}
}

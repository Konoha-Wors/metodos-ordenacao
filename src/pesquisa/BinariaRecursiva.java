package pesquisa;

import java.util.List;

public class BinariaRecursiva extends PesquisaBinaria{

	public BinariaRecursiva(int idPesquisa, String nome) {
		super(idPesquisa, nome);
	}

	@Override
	public int pesquisar(List<String> lista, String conteudo) {
		Long[] numeros = new Long[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
            numeros[i] = Long.parseLong(lista.get(i));
        }

		int esquerda = 0;
		int direita = numeros.length - 1;

		int indice = binariaRecursiva(numeros, esquerda, direita, conteudo);
		
		return indice;
	}
	
	private static int binariaRecursiva(Long[] A, int esquerda, int direita, String x) {
		Long ind = Long.parseLong(x);
		
		if (esquerda > direita) {
			return -1;
		}

		int meio = (esquerda + direita) / 2;
		if (ind == A[meio]) {
			return meio;
		}

		else if (ind < A[meio]) {
			return binariaRecursiva(A, esquerda, meio - 1, x);
		}

		else {
			return binariaRecursiva(A, meio + 1, direita, x);
		}
	}
}

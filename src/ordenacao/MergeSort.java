package ordenacao;

import java.util.List;

public class MergeSort extends Ordenacao {

	public MergeSort(int id, String nome) {
		super(id, nome);
	}

	@Override
	public List<String> ordenar(List<String> listaOrdenacao) {
		return mergeSort(listaOrdenacao);
	}

	public static List<String> mergeSort(List<String> listaOrdenacao) {

		Long[] listaInteira = new Long[listaOrdenacao.size()];
		for (int i = 0; i < listaOrdenacao.size(); i++) {
			listaInteira[i] = Long.parseLong(listaOrdenacao.get(i));
		}

		Long[] lTemporario = new Long[listaInteira.length];

		Long[] listaOrdenada = mergeSortOrdem(listaInteira, lTemporario, 0, listaInteira.length - 1);

		listaOrdenacao.clear();
		for (int i = 0; i < listaOrdenada.length; i++) {
			listaOrdenacao.add(String.valueOf(listaOrdenada[i]));
		}

		return listaOrdenacao;
	}

	private static Long[] mergeSortOrdem(Long[] listaInteira, Long[] lTemporario, int esquerda, int direita) {
		if (esquerda < direita) {
			int centro = (esquerda + direita) / 2;
			mergeSortOrdem(listaInteira, lTemporario, esquerda, centro);
			mergeSortOrdem(listaInteira, lTemporario, centro + 1, direita);
			merge(listaInteira, lTemporario, esquerda, centro + 1, direita);
		}
		return listaInteira;
	}

	private static void merge(Long[] listaInteira, Long[] lTemporario, int posEsquerda, int posDireita, int fimDireita) {
		int fimEsquerda = posDireita - 1;
		int tempPos = posEsquerda;
		int num = fimDireita - posEsquerda + 1;

		while (posEsquerda <= fimEsquerda && posDireita <= fimDireita) {
			if (listaInteira[posEsquerda].compareTo(listaInteira[posDireita]) <= 0) {
				lTemporario[tempPos++] = listaInteira[posEsquerda++];
			} else {
				lTemporario[tempPos++] = listaInteira[posDireita++];
			}
		}

		while (posEsquerda <= fimEsquerda) {
			lTemporario[tempPos++] = listaInteira[posEsquerda++];
		}

		while (posDireita <= fimDireita) {
			lTemporario[tempPos++] = listaInteira[posDireita++];
		}

		for (int i = 0; i < num; i++, fimDireita--) {
			listaInteira[fimDireita] = lTemporario[fimDireita];
		}
	}
}

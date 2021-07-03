package ordenacao;

import java.util.List;

public class InsertionSort extends Ordenacao {

	public InsertionSort(int id, String nome) {
		super(id, nome);
	}

	@Override
	public List<String> ordenar(List<String> listaOrdenacao) {
	
		Long[] numeros = new Long[listaOrdenacao.size()];
		boolean entrou = true;
		
		for (int i = 0; i < listaOrdenacao.size(); i++) {
			numeros[i] = Long.parseLong(listaOrdenacao.get(i));
		}
		
		for (int i = 1; i < numeros.length; i++) {

			int indice = i;
			entrou = true;

			while (entrou) {
				entrou = false;

				if (indice > 0) {
					if (numeros[indice] < numeros[indice - 1]) {
						Long numTemp = numeros[indice];
						numeros[indice] = numeros[indice - 1];
						numeros[indice-1] = numTemp;
						entrou = true;
					}
				}
				indice--;
			}
		}
		
		listaOrdenacao.clear();
		for (int i = 0; i < numeros.length; i++) {
			listaOrdenacao.add(String.valueOf(numeros[i]));
		}
		
		return listaOrdenacao;
	}

}

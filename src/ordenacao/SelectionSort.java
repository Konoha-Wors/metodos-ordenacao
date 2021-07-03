package ordenacao;

import java.util.List;

public class SelectionSort extends Ordenacao{

	public SelectionSort(int id, String nome) {
		super(id, nome);
	}

	@Override
	public List<String> ordenar(List<String> listaOrdenacao) {

		Long[] numeros = new Long[listaOrdenacao.size()];
		for (int i = 0; i < listaOrdenacao.size(); i++) {
			numeros[i] = Long.parseLong(listaOrdenacao.get(i));
        }

		for (int i = 0; i < numeros.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < numeros.length; j++) {
				if (numeros[min] > numeros[j]) {
					min = j;
				}
			}

			Long temp = numeros[i];
			numeros[i] = numeros[min];
			numeros[min] = temp;
		}
		
		listaOrdenacao.clear();
        for (int i = 0; i < numeros.length; i++) {
            listaOrdenacao.add(String.valueOf(numeros[i]));
        }
        
		return listaOrdenacao;
	}
	
}

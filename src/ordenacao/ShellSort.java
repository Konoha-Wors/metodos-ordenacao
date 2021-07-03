package ordenacao;

import java.util.List;

public class ShellSort extends Ordenacao {

	public ShellSort(int id, String nome) {
		super(id, nome);
	}

	@Override
	public List<String> ordenar(List<String> listaOrdenacao) {
		int intervalo = calcularIntervalo(listaOrdenacao.size());

		int[] arr = new int[listaOrdenacao.size()];
		for (int i = 0; i < listaOrdenacao.size(); i++) {
		    arr[i] = Integer.parseInt(listaOrdenacao.get(i));
		}

		while (intervalo > 0) {
		    for (int externo = intervalo; externo < arr.length; externo++) {
			int valor = arr[externo];
			int interno = externo;
			while (interno > intervalo - 1 && arr[interno - intervalo] >= valor) {
			    arr[interno] = arr[interno - intervalo];
			    interno = interno - intervalo;
			}
			arr[interno] = valor;
		    }
		    intervalo = (intervalo - 1) / 3;
		}

		listaOrdenacao.clear();
		for (int i = 0; i < arr.length; i++) {
		    listaOrdenacao.add(String.valueOf(arr[i]));
		}

		return listaOrdenacao;
	}
	private int calcularIntervalo(int comprimento) {
		int intervalo = 0;
		while (intervalo < comprimento / 3) {
		    intervalo = intervalo * 3 + 1;
		}
        return intervalo;
    }
}

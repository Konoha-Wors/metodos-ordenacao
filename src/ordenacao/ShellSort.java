package ordenacao;

import java.util.List;

public class ShellSort extends Ordenacao {

	public ShellSort(int id, String nome) {
		super(id, nome);
	}

	@Override
	public List<String> ordenar(List<String> listaOrdenacao) {
		return null;
	}

	public int calcularIntervalo(int comprimento) {
		int intervalo = 0;
		while (intervalo < comprimento / 3) {
			intervalo = intervalo * 3 + 1;
		}
		return intervalo;
	}
}

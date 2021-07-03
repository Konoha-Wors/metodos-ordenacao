package tela;

import java.util.ArrayList;
import java.util.List;

import ordenacao.InsertionSort;

public class Main {
	
	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		lista.add("9");
		lista.add("1");
		lista.add("7");
		InsertionSort insertion = new InsertionSort(0, null);
		List<String> lista2 = insertion.ordenar(lista);
		System.out.println(lista2);
	}

}

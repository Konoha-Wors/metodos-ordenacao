package dado;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import arquivo.Arquivo;
import ordenacao.Ordenacao;
import pesquisa.Pesquisa;

public class Dado {

	private Arquivo arquivo;
	private Ordenacao ordenacao;
	private Pesquisa pesquisa;
	private Resultado resultado;
	
	public Arquivo getArquivo() {
		return arquivo;
	}
	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}
	public Ordenacao getOrdenacao() {
		return ordenacao;
	}
	public void setOrdenacao(Ordenacao ordenacao) {
		this.ordenacao = ordenacao;
	}
	public Pesquisa getPesquisa() {
		return pesquisa;
	}
	public void setPesquisa(Pesquisa pesquisa) {
		this.pesquisa = pesquisa;
	}
	public Resultado getResultado() {
		return resultado;
	}
	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	
	/**
	 * 
	 * Retorna o conteúdo do arquivo em uma lista 
	 *
	 * @author us
	 * @param caminho
	 * @return lista do Arquivo
	 * @throws IOException
	 */
	public List<String> listarDadosArquivo(String caminho) throws IOException{
		
		LocalTime inicioTempo = LocalTime.now();
		
		Arquivo arquivo = new Arquivo(caminho);
		setArquivo(arquivo);
		List<String> lResultado = arquivo.lerArquivo();
		
		LocalTime finalTempo = LocalTime.now();
		Resultado resultado = new Resultado(finalTempo.getNano()-inicioTempo.getNano());
		setResultado(resultado);
		
		return lResultado;
	}
	
	/**
	 * 
	 * Ordena a lista de strings informada 
	 *
	 * @author us
	 * @param lista
	 * @return lista Ordenada 
	 */
	public List<String> ordenar(List<String> lista){
		
		LocalTime inicioTempo = LocalTime.now();
		
		List<String> listaOrdenada = ordenacao.ordenar(lista);
		 
		LocalTime finalTempo = LocalTime.now();
		Resultado resultado = new Resultado(finalTempo.getNano()-inicioTempo.getNano());
		setResultado(resultado);
		
		return listaOrdenada;
	}
	
	/**
	 * 
	 * Realiza a pesquisa da linha onde está o conteúdo informado 
	 *
	 * @author us
	 * @param lista
	 * @param conteudo
	 * @return indice 
	 */
	public int pesquisar(List<String> lista, String conteudo) {
		
		LocalTime inicioTempo = LocalTime.now();
		
		int indice = pesquisa.pesquisar(lista, conteudo);
		
		LocalTime finalTempo = LocalTime.now();
		Resultado resultado = new Resultado(finalTempo.getNano()-inicioTempo.getNano());
		setResultado(resultado);
		
		return indice;
	}
}

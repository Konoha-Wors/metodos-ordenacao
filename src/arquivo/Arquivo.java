package arquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {
	
	private String caminho;

	public Arquivo(String caminho) {
		this.caminho = caminho;
	}

	public String getCaminho() {
		return caminho; 
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho; 
	}

	/**
	 * 
	 * Lendo arquivo e adicionando conteúdo na lista 
	 *
	 * @author Breno
	 * @return lnumeros
	 * @throws IOException 
	 */
	public List<String> lerArquivo() throws IOException{
		List<String> lNumero = new ArrayList<>();
		String numero;
		BufferedReader file = null;

		try {
			file = abrirArquivoLeitura();
			numero = file.readLine();
			while(numero != null) {
				lNumero.add(numero);
				numero = file.readLine();
			}
		}finally {
			fecharArquivoLeitura(file);
		}
		return lNumero;
	}
	
	/**
	 * 
	 * Coloca o conteúdo da lista no arquivo 
	 *
	 * @author Breno
	 * @param bufferdWriter
	 * @param lnumeros
	 */
	public void escreverArquivo(List<String> lnumeros){
		BufferedWriter file = abrirArquivoEscrita();
		try {
			for (int i = 0; i < lnumeros.size(); i++) {
				file.append(lnumeros.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			fecharArquivoEscrita(file);
		}
	}
	
	
	/**
	 * 
	 * Abre o arquivo para fazer leitura 
	 *
	 * @author Breno
	 * @return file
	 * @throws FileNotFoundException 
	 */
	private BufferedReader abrirArquivoLeitura() throws FileNotFoundException {
		BufferedReader file = null;
		file = new BufferedReader(new FileReader(caminho));
		return file;
	}
	
	/**
	 * 
	 * Fechar o arquivo de leitura 
	 *
	 * @author Breno
	 * @param file
	 */
	private void fecharArquivoLeitura(BufferedReader file) {
		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * Abrir arquivo para escrita
	 *
	 * @author Breno
	 * @return file
	 */
	private BufferedWriter abrirArquivoEscrita() {
		try{
			BufferedWriter file = null;
			file = new BufferedWriter(new FileWriter(caminho));
			return file;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * Fechar o arquivo de escrita 
	 *
	 * @author Breno
	 * @param file
	 */
	private void fecharArquivoEscrita(BufferedWriter file) {
		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

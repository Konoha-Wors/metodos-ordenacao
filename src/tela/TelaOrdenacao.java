package tela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dado.Dado;
import ordenacao.InsertionSort;
import ordenacao.MergeSort;
import ordenacao.QuickSort;
import ordenacao.SelectionSort;
import ordenacao.ShellSort;
import pesquisa.BinariaIterativa;
import pesquisa.BinariaRecursiva;
import pesquisa.PesquisaLinear;

public class TelaOrdenacao extends JFrame{

	private static final long serialVersionUID = 1090740499685551266L;
	private JPanel contentPane;
	private JTextField tfUrl;
	private JTextField tfCampoPesquisaLista;
	private JTextField tfIndiceBusca;
	private JTextField tfTempo;
	private JTextField tfStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaOrdenacao frame = new TelaOrdenacao();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaOrdenacao() {
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 750, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setBounds(10, 11, 46, 14);
		contentPane.add(lblUrl);
		
		tfUrl = new JTextField();
		tfUrl.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				tfUrl.setText("C:\\Users\\us\\Downloads\\ListaOrdenacao.txt");
			}
		});
		tfUrl.setBounds(38, 8, 686, 20);
		contentPane.add(tfUrl);
		tfUrl.setColumns(10);
		
		JList<Object> lConteudo = new JList<Object>();
		lConteudo.setBounds(10, 104, 714, 329);
		contentPane.add(lConteudo);
		
		JComboBox<String> cbTipoPesquisa = new JComboBox<String>();
		cbTipoPesquisa.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				cbTipoPesquisa.addItem("");
				cbTipoPesquisa.addItem("Binaria Iterativa (Num)");
				cbTipoPesquisa.addItem("Binaria Recursiva (Num)");
				cbTipoPesquisa.addItem("Pesquisa Linear (Alf)");
			}
		});
		cbTipoPesquisa.setBounds(567, 71, 157, 22);
		contentPane.add(cbTipoPesquisa);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String conteudoPesquisa = tfCampoPesquisaLista.getText();
					int tipoPes = cbTipoPesquisa.getSelectedIndex();
					
					if(conteudoPesquisa != "" && (tipoPes != -1 && tipoPes != 0)) {
						Dado dado = new Dado();
						List<String> listaExibicao = dado.listarDadosArquivo(tfUrl.getText());
						lConteudo.setListData(listaExibicao.toArray());
						switch (tipoPes) {
						case 1: {
							dado.setPesquisa(new BinariaIterativa(tipoPes, cbTipoPesquisa.getSelectedItem().toString()));
							break;
						}
						case 2: {
							dado.setPesquisa(new BinariaRecursiva(tipoPes, cbTipoPesquisa.getSelectedItem().toString()));
							break;
						}
						case 3: {
							dado.setPesquisa(new PesquisaLinear(tipoPes, cbTipoPesquisa.getSelectedItem().toString()));
							break;
						}
						default:
							throw new Exception();
						}
						int indicePesq = dado.pesquisar(listaExibicao, conteudoPesquisa);
						
						if(indicePesq != -1) {							
							tfIndiceBusca.setText(String.valueOf(indicePesq));
						}else {
							tfIndiceBusca.setText("NENHUM");
						}
						int tempo = dado.getResultado().getTempoExecucao();
						tfTempo.setText(String.valueOf(tempo)+" ns");
						tfStatus.setBackground(Color.GREEN);
						tfStatus.setText("OK");
					}else {
						throw new Exception();
					}
				}catch (Exception err) {
					tfStatus.setBackground(Color.RED);
					tfStatus.setText("FALHA");
				}
			}
		});
		btnBuscar.setBounds(10, 512, 714, 23);
		contentPane.add(btnBuscar);
		
		JComboBox<String> cbTipoOrdenacao = new JComboBox<String>();
		cbTipoOrdenacao.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				cbTipoOrdenacao.addItem("");
				cbTipoOrdenacao.addItem("Insertion Sort");
				cbTipoOrdenacao.addItem("Selection Sort");
				cbTipoOrdenacao.addItem("Quick Sort");
				cbTipoOrdenacao.addItem("Merge Sort");
				cbTipoOrdenacao.addItem("Shell Sort");
			}
		});
		cbTipoOrdenacao.setBounds(119, 39, 164, 22);
		contentPane.add(cbTipoOrdenacao);
		
		JButton btnOrdenar = new JButton("Ordenar");
		btnOrdenar.setBounds(10, 478, 714, 23);
		btnOrdenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int tipoOrd = cbTipoOrdenacao.getSelectedIndex();
					
					if(tipoOrd != -1 && tipoOrd != 0) {
						Dado dado = new Dado();
						List<String> listaExibicao = dado.listarDadosArquivo(tfUrl.getText());
						switch (tipoOrd) {
						case 1: {
							dado.setOrdenacao(new InsertionSort(tipoOrd, cbTipoPesquisa.getSelectedItem().toString()));
							break;
						}
						case 2: {
							dado.setOrdenacao(new SelectionSort(tipoOrd, cbTipoPesquisa.getSelectedItem().toString()));
							break;
						}
						case 3: {
							dado.setOrdenacao(new QuickSort(tipoOrd, cbTipoPesquisa.getSelectedItem().toString()));
							break;
						}
						case 4: {
							dado.setOrdenacao(new MergeSort(tipoOrd, cbTipoPesquisa.getSelectedItem().toString()));
							break;
						}
						case 5: {
							dado.setOrdenacao(new ShellSort(tipoOrd, cbTipoPesquisa.getSelectedItem().toString()));
							break;
						}
						default:
							throw new Exception();
						}
						List<String> listaOrd = dado.ordenar(listaExibicao);
						lConteudo.setListData(listaOrd.toArray());
						int tempo = dado.getResultado().getTempoExecucao();
						tfTempo.setText(String.valueOf(tempo)+" ns");
						tfStatus.setBackground(Color.GREEN);
						tfStatus.setText("OK");
					}else {
						throw new Exception();
					}
				}catch (Exception err) {
					tfStatus.setBackground(Color.RED);
					tfStatus.setText("FALHA");
				}
			}
		});
		contentPane.add(btnOrdenar);
		
		JLabel lblTipoOrdenacao = new JLabel("Tipo ordena\u00E7\u00E3o:");
		lblTipoOrdenacao.setBounds(10, 43, 99, 14);
		contentPane.add(lblTipoOrdenacao);
		
		JLabel lblTipoPesquisa = new JLabel("Tipo de pesquisa:");
		lblTipoPesquisa.setBounds(447, 75, 120, 14);
		contentPane.add(lblTipoPesquisa);
		
		JLabel lblStatus = new JLabel("Status: ");
		lblStatus.setBounds(613, 43, 55, 14);
		contentPane.add(lblStatus);
		
		tfCampoPesquisaLista = new JTextField();
		tfCampoPesquisaLista.setBounds(175, 72, 108, 20);
		contentPane.add(tfCampoPesquisaLista);
		tfCampoPesquisaLista.setColumns(10);
		
		JLabel lblCampoPesquisaLista = new JLabel("Campo de pesquisa da lista:");
		lblCampoPesquisaLista.setBounds(10, 75, 164, 14);
		contentPane.add(lblCampoPesquisaLista);
		
		tfIndiceBusca = new JTextField();
		tfIndiceBusca.setEditable(false);
		tfIndiceBusca.setBounds(355, 72, 74, 20);
		contentPane.add(tfIndiceBusca);
		tfIndiceBusca.setColumns(10);
		
		JLabel lblIndiceBusca = new JLabel("\u00CDndice:");
		lblIndiceBusca.setBounds(294, 75, 51, 14);
		contentPane.add(lblIndiceBusca);
		
		JLabel lblTempo = new JLabel("Tempo:");
		lblTempo.setBounds(337, 43, 65, 14);
		contentPane.add(lblTempo);
		
		tfTempo = new JTextField();
		tfTempo.setEditable(false);
		tfTempo.setBounds(407, 40, 150, 20);
		contentPane.add(tfTempo);
		tfTempo.setColumns(10);
		
		tfStatus = new JTextField();
		tfStatus.setEditable(false);
		tfStatus.setBounds(678, 39, 46, 20);
		contentPane.add(tfStatus);
		tfStatus.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(10, 444, 714, 23);
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Dado dado = new Dado();
					List<String> lista = dado.listarDadosArquivo(tfUrl.getText());
					lConteudo.setListData(lista.toArray());
					int tempo = dado.getResultado().getTempoExecucao();
					tfTempo.setText(String.valueOf(tempo)+" ns");
					tfStatus.setBackground(Color.GREEN);
					tfStatus.setText("OK");
				} catch (Exception e2) {
					tfStatus.setBackground(Color.RED);
					tfStatus.setText("FALHA");
				}
			}
		});
		contentPane.add(btnListar);
		
	}
}

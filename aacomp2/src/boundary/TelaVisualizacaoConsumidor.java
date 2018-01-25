package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.RenderingHints.Key;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;

import java.awt.Font;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

import entity.Consumidor;
import entity.Aluno;
import entity.Curso;
import entity.Departamento;
import entity.Funcionario;
import entity.Sexo;
import entity.Sistema;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import controller.SerializacaoDados;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaVisualizacaoConsumidor extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCodigo;
	private JTextField txtTipo;
	private JComboBox cbbSexo;
	private JButton btnNovo;
	private JButton btnVoltar;
	private JList<String> lstCPFconsumidor;
	private JButton btnEditar;
	private Sistema sistemaAtual;
	private JFrame TelaAtual;
	private JFormattedTextField txtMatricula;
	private JFormattedTextField txtAnoIngresso;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVisualizacaoConsumidor frame = new TelaVisualizacaoConsumidor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public TelaVisualizacaoConsumidor(final JFrame TelaAnterior, final Sistema sistema) {
		TelaAtual = this;
		setTitle("Consumidor");
		setDefaultCloseOperation(JFrame.NORMAL);
		setBounds(100, 100, 688, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		MaskFormatter maskAno = null;
		
		try
		{
			//com "#" sÃ³ Ã© permitida a entrada de nÃºmeros no campo 
			maskAno = new MaskFormatter("####");
			// colocar um '_' no espaÃ§o ainda nÃ£o preenchido. Eu acho que isso fica feio no Ubuntu
			maskAno.setPlaceholderCharacter('_');
			
		}
		catch(ParseException excp)
		{
			JOptionPane.showMessageDialog(null,"Erro na formataÃ§Ã£o: " + excp.getMessage());
		}
		
		txtAnoIngresso = new JFormattedTextField(maskAno);
		txtAnoIngresso.setEditable(false);
		txtAnoIngresso.setBounds(471, 90, 125, 27);
		contentPane.add(txtAnoIngresso);
		
		NumberFormat longFormat = NumberFormat.getIntegerInstance();

		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		numberFormatter.setValueClass(Long.class); //optional, ensures you will always get a long value
		numberFormatter.setAllowsInvalid(false); //this is the key!!
		numberFormatter.setMinimum(0l); //Optional
		
		txtMatricula = new JFormattedTextField(numberFormatter);
		txtMatricula.setEditable(false);
		txtMatricula.setBounds(319, 91, 140, 24);
		contentPane.add(txtMatricula);
		
		File f1 = new File("Consumidor.ser");
		File f2 = new File("Curso.ser");
		File f3 = new File("Departamento.ser");
		
		sistemaAtual = new Sistema();
		//ler o arquivo de consumidores
		if(!f1.exists())
			SerializacaoDados.salvarLista(sistemaAtual.getListaConsumidores(),"Consumidor.ser");
		
		if(!f2.exists())
			SerializacaoDados.salvarLista(sistemaAtual.getListaCursos(),"Curso.ser");
		
		if(!f3.exists())
			SerializacaoDados.salvarLista(sistemaAtual.getListaDepartamento(),"Departamento.ser");
			
		sistema.setListaConsumidores(((ArrayList<Consumidor>) SerializacaoDados.carregarLista("Consumidor.ser")));// metodo pra carregar a lista
		sistema.setListaCursos(((ArrayList<Curso>) SerializacaoDados.carregarLista("Curso.ser")));
		sistema.setListaDepartamento(((ArrayList<Departamento>) SerializacaoDados.carregarLista("Departamento.ser")));
		
		String itens [] = new String[sistema.getListaConsumidores().size()];
		for(int i = 0;i<sistema.getListaConsumidores().size();i++)
			itens[i] = sistema.getListaConsumidores().get(i).getCPF();
		

		
		lstCPFconsumidor = new JList(itens);
		lstCPFconsumidor.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				txtNome.setText(sistema.getListaConsumidores().get(lstCPFconsumidor.getSelectedIndex()).getNomeConsumidor());
				txtMatricula.setText(sistema.getListaConsumidores().get(lstCPFconsumidor.getSelectedIndex()).getMatricula());
				txtAnoIngresso.setText(Integer.toString(sistema.getListaConsumidores().get(lstCPFconsumidor.getSelectedIndex()).getAnoIngresso()));
				
				if(sistema.getListaConsumidores().get(lstCPFconsumidor.getSelectedIndex()).getSexo() == Sexo.MASCULINO)
					cbbSexo.setSelectedIndex(0);
				else
					cbbSexo.setSelectedIndex(1);
				
				if(sistema.getListaConsumidores().get(lstCPFconsumidor.getSelectedIndex()) instanceof Aluno)
				{
					Aluno a = (Aluno) sistema.getListaConsumidores().get(lstCPFconsumidor.getSelectedIndex());
					txtCodigo.setText(a.getCurso().getSiglaCurso());
					a = null;
					txtTipo.setText("ALUNO");
				}
				if(sistema.getListaConsumidores().get(lstCPFconsumidor.getSelectedIndex()) instanceof Funcionario)
				{
					Funcionario f = (Funcionario) sistema.getListaConsumidores().get(lstCPFconsumidor.getSelectedIndex());
					txtCodigo.setText(f.getDepartamento().getSiglaDepartamento());
					f = null;
					txtTipo.setText("FUNCIONARIO");
				}
				
			}
		});
		lstCPFconsumidor.setToolTipText("");
		lstCPFconsumidor.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "", TitledBorder.LEADING, TitledBorder.TOP, null, null), "CPF", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		lstCPFconsumidor.setFont(new Font("DejaVu Sans", Font.BOLD, 17));
		
		lstCPFconsumidor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstCPFconsumidor.setValueIsAdjusting(true);
		lstCPFconsumidor.setBounds(48, 16, 209, 312);
		contentPane.add(lstCPFconsumidor);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setBounds(319, 30, 315, 26);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(320, 12, 70, 15);
		contentPane.add(lblNome);
		
		JLabel lblMatricula = new JLabel("Matri­cula :");
		lblMatricula.setBounds(319, 75, 87, 15);
		contentPane.add(lblMatricula);
		
		JLabel lblAnoingresso = new JLabel("Ano de Ingresso :");
		lblAnoingresso.setBounds(475, 68, 131, 15);
		contentPane.add(lblAnoingresso);
		
		cbbSexo = new JComboBox();
		cbbSexo.setEnabled(false);
		cbbSexo.setModel(new DefaultComboBoxModel(new String[] {"MASCULINO", "FEMININO"}));
		cbbSexo.setBounds(319, 149, 131, 24);
		contentPane.add(cbbSexo);
		
		JLabel lblSexo = new JLabel("Sexo :");
		lblSexo.setBounds(319, 129, 51, 15);
		contentPane.add(lblSexo);
		
		JLabel lblCdigo = new JLabel("Sigla :");
		lblCdigo.setBounds(479, 129, 80, 15);
		contentPane.add(lblCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(475, 149, 114, 26);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					NovoConsumidor frame = new NovoConsumidor(TelaAtual, sistema);
					frame.setVisible(true);
					setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNovo.setBounds(293, 265, 93, 35);
		contentPane.add(btnNovo);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAnterior.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setBounds(413, 265, 93, 35);
		contentPane.add(btnVoltar);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnEditar.getText() == "Editar")
				{
					txtNome.setEditable(true);
					txtMatricula.setEditable(true);
					cbbSexo.setEnabled(true);
					txtAnoIngresso.setEditable(true);
					lstCPFconsumidor.setEnabled(false);
					btnEditar.setText("Confirmar");
				}
				else
				{
					btnEditar.setText("Editar");
					txtNome.setEditable(false);
					sistema.getListaConsumidores().get(lstCPFconsumidor.getSelectedIndex()).setNomeConsumidor(txtNome.getText());
					txtMatricula.setEditable(false);
					sistema.getListaConsumidores().get(lstCPFconsumidor.getSelectedIndex()).setMatricula(txtMatricula.getText());
					cbbSexo.setEnabled(false);
					if(cbbSexo.getSelectedIndex() == 0)
						sistema.getListaConsumidores().get(lstCPFconsumidor.getSelectedIndex()).setSexo(Sexo.MASCULINO);
					if(cbbSexo.getSelectedIndex() == 1)
						sistema.getListaConsumidores().get(lstCPFconsumidor.getSelectedIndex()).setSexo(Sexo.FEMININO);
					
					txtAnoIngresso.setEditable(false);
					
					SerializacaoDados.salvarLista(sistema.getListaConsumidores(), "Consumidor.ser");
					
					txtAnoIngresso.setEditable(false);
					//salvar as alteraÃ§Ãµes na lista lista do sistema
					lstCPFconsumidor.setEnabled(true);
				}
			}
		});
		
		btnEditar.setBounds(532, 265, 121, 35);
		contentPane.add(btnEditar);
		
		txtTipo = new JTextField();
		txtTipo.setEditable(false);
		txtTipo.setColumns(10);
		txtTipo.setBounds(476, 209, 114, 26);
		contentPane.add(txtTipo);
		
		JLabel lblTipo = new JLabel("Tipo :");
		lblTipo.setBounds(480, 189, 80, 15);
		contentPane.add(lblTipo);

		
	}
}

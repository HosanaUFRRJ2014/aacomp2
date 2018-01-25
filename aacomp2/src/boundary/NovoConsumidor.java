package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;

import controller.SerializacaoDados;
import entity.Aluno;
import entity.Consumidor;
import entity.Funcionario;
import entity.Sexo;
import entity.Sistema;
import entity.ValidarCPF;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;

public class NovoConsumidor extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private Sistema sistem;
	private ValidarCPF valida;
	private JFormattedTextField txtAnoDeIngresso;
	private JTextField txtMatricula;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public NovoConsumidor(final JFrame TelaAnterior, final Sistema sistema) {
		setTitle("Novo Consumidor");
		sistem = sistema;
		setDefaultCloseOperation(JFrame.NORMAL);
		setBounds(100, 100, 579, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNome = new JTextField();
		txtNome.setBounds(34, 36, 265, 25);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		MaskFormatter maskAno = null;

		try
		{
			//com "#" s√≥ √© permitida a entrada de n√∫meros no campo 
			maskAno = new MaskFormatter("####");
			// colocar um '_' no espa√ßo ainda n√£o preenchido. Eu acho que isso fica feio no Ubuntu
			maskAno.setPlaceholderCharacter('_');

		}
		catch(ParseException excp)
		{
			JOptionPane.showMessageDialog(null,"Erro na formataÁ„o: " + excp.getMessage());
			System.exit(-1);
		}

		final JComboBox cbbSexo = new JComboBox();
		cbbSexo.setModel(new DefaultComboBoxModel(new String[] {"MASCULINO", "FEMININO"}));
		cbbSexo.setSelectedIndex(0);
		cbbSexo.setBounds(405, 105, 129, 24);
		contentPane.add(cbbSexo);

		final JComboBox cbbTitulo = new JComboBox();
		cbbTitulo.setModel(new DefaultComboBoxModel(new String[] {"ESPECIALIZA«√O", "MESTRADO", "DOUTORADO"}));
		cbbTitulo.setSelectedIndex(0);
		cbbTitulo.setBounds(405, 184, 129, 24);
		contentPane.add(cbbTitulo);
		
		txtAnoDeIngresso = new JFormattedTextField(maskAno);
		txtAnoDeIngresso.setBounds(34, 100, 171, 25);
		contentPane.add(txtAnoDeIngresso);
		
	/*	NumberFormat longFormat = NumberFormat.getIntegerInstance();

		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		numberFormatter.setValueClass(Long.class); //optional, ensures you will always get a long value
		numberFormatter.setAllowsInvalid(false); //this is the key!!
		numberFormatter.setMinimum(0l); //Optional*/

		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(38, 9, 70, 15);
		contentPane.add(lblNome);

		JLabel lblMatricula = new JLabel("Matricula :");
		lblMatricula.setBounds(374, 9, 92, 15);
		contentPane.add(lblMatricula);

		JLabel lblAnoDeIngresso = new JLabel("Ano de Ingresso :");
		lblAnoDeIngresso.setBounds(34, 78, 129, 15);
		contentPane.add(lblAnoDeIngresso);

		txtMatricula = new JTextField();
		txtMatricula.setBounds(384, 38, 117, 22);
		contentPane.add(txtMatricula);

		try
		{
			//com "#" s√≥ √© permitida a entrada de n√∫meros no campo 
			maskAno = new MaskFormatter("####");
			// colocar um '_' no espa√ßo ainda n√£o preenchido. Eu acho que isso fica feio no Ubuntu
			maskAno.setPlaceholderCharacter('_');

		}
		catch(ParseException excp)
		{
			JOptionPane.showMessageDialog(null,"Erro na formataÁ„o: " + excp.getMessage());
			System.exit(-1);
		}

		/*final JFormattedTextField txtAnoDeIngresso = new JFormattedTextField(maskAno);
		txtAnoDeIngresso.setBounds(34, 100, 171, 25);
		contentPane.add(txtAnoDeIngresso);*/

		JLabel lblSexo = new JLabel("Sexo :");
		lblSexo.setBounds(408, 78, 70, 15);
		contentPane.add(lblSexo);

		JLabel lblCpf = new JLabel("CPF :");
		lblCpf.setBounds(38, 157, 70, 15);
		contentPane.add(lblCpf);

		MaskFormatter maskCPF = null;

		try
		{
			//com "#" s√≥ √© permitida a entrada de n√∫meros no campo 
			maskCPF = new MaskFormatter("###.###.###-##");
			// colocar um '_' no espa√ßo ainda n√£o preenchido. Eu acho que isso fica feio no Ubuntu
			//maskCPF.setPlaceholderCharacter('_');

		}
		catch(ParseException excp)
		{
			JOptionPane.showMessageDialog(null,"Erro na formataÁ„o: " + excp.getMessage());
		}

		final JFormattedTextField txtCPF = new JFormattedTextField(maskCPF);
		txtCPF.setBounds(34, 184, 171, 25);
		contentPane.add(txtCPF);

		valida = new ValidarCPF();


		JLabel lblTitulo = new JLabel("Titulo :");
		lblTitulo.setBounds(408, 157, 70, 15);
		contentPane.add(lblTitulo);

		final JComboBox cbbCurDep = new JComboBox();
		cbbCurDep.setBounds(238, 184, 129, 24);
		contentPane.add(cbbCurDep);



		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAnterior.setVisible(true);
				setVisible(false);
			}
		});
		btnCancelar.setBounds(238, 241, 117, 28);
		contentPane.add(btnCancelar);

		JLabel lblTipo = new JLabel("Tipo :");
		lblTipo.setBounds(229, 73, 70, 15);
		contentPane.add(lblTipo);

		final JLabel lblCurDep = new JLabel("Curso :");
		lblCurDep.setBounds(241, 157, 114, 15);
		contentPane.add(lblCurDep);

		final JComboBox cbbTipo = new JComboBox();
		cbbTipo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(cbbTipo.getSelectedIndex() == 1)
				{
					String [] listaDepartamentos = new String[100];
					lblCurDep.setText("Departamento :");
					for(int i = 0; i < sistem.getListaDepartamento().size(); i++)
					{
						listaDepartamentos[i] = sistem.getListaDepartamento().get(i).getSiglaDepartamento();
					}
					cbbCurDep.setModel(new DefaultComboBoxModel(listaDepartamentos));

				}
				if(cbbTipo.getSelectedIndex() == 0)
				{
					lblCurDep.setText("Curso :");	
					String [] listaCursos = new String[100];
					for(int i = 0; i < sistem.getListaCursos().size(); i++)
					{
						listaCursos[i] = sistem.getListaCursos().get(i).getSiglaCurso();
					}
					cbbCurDep.setModel(new DefaultComboBoxModel(listaCursos));
				}
			}
		});
		cbbTipo.setModel(new DefaultComboBoxModel(new String[] {"ALUNO", "PROFESSOR"}));
		cbbTipo.setSelectedIndex(0);
		cbbTipo.setBounds(226, 100, 129, 24);
		contentPane.add(cbbTipo);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNome.setText("");
				txtMatricula.setText("");
				txtAnoDeIngresso.setText("");
				txtCPF.setText("");
				cbbTipo.setSelectedIndex(0);
				cbbSexo.setSelectedIndex(0);
				cbbCurDep.setSelectedIndex(-1);
				cbbTitulo.setSelectedIndex(0);
			}
		});
		btnLimpar.setBounds(417, 239, 117, 28);
		contentPane.add(btnLimpar);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean algoEmBranco = (txtNome.getText().trim() == "" ||
						txtMatricula.getText().trim() == "" ||
						txtAnoDeIngresso.getText().trim() == "____" ||
						txtCPF.getText().trim() == "___.___.___-__" ||
						cbbCurDep.getSelectedIndex() == -1 ); 

				if(algoEmBranco)
				{
					JOptionPane.showMessageDialog(null, "h· campos obrigatÛrios em branco");
				}	

				if(valida.meuValidarCPF(txtCPF.getText()) == false)
				{
					JOptionPane.showMessageDialog(null,"CPF inv·lido!!!!");

				}
				if(sistema.compararCPFIguais(txtCPF.getText(),sistema.getListaConsumidores()) == true)
				{
					JOptionPane.showMessageDialog(null,"CPF j· cadastrado no sistema!!!!");
				}
				else
				{
					if(cbbTipo.getSelectedIndex() == 0)
					{

						if(cbbSexo.getSelectedIndex() == 0)
						{
							Aluno aluno = new Aluno(txtNome.getText(),txtMatricula.getText(),Integer.parseInt(txtAnoDeIngresso.getText()),sistem.getListaCursos().get(cbbCurDep.getSelectedIndex()));
							aluno.setSexo(Sexo.MASCULINO); 
							/*
							if(aluno.setCPF(txtCPF.getText()) == false)
							{

							}
							*/
							aluno.setCPF(txtCPF.getText());
							sistema.adicionarNovoConsumidor(aluno);
							SerializacaoDados.salvarLista(sistema.getListaConsumidores(), "Consumidor.ser");
						}
						else{

							Aluno aluno = new Aluno(txtNome.getText(),txtMatricula.getText(),Integer.parseInt(txtAnoDeIngresso.getText()),sistem.getListaCursos().get(cbbCurDep.getSelectedIndex()));
							aluno.setSexo(Sexo.FEMININO); 
							aluno.setCPF(txtCPF.getText());
							sistema.adicionarNovoConsumidor(aluno);
							SerializacaoDados.salvarLista(sistema.getListaConsumidores(), "Consumidor.ser");

						}
					}

					if(cbbTipo.getSelectedIndex() == 1)
					{

						if(cbbSexo.getSelectedIndex() == 0)
						{

							Funcionario funcionario = new Funcionario(txtNome.getText(),txtMatricula.getText(),Integer.parseInt(txtAnoDeIngresso.getText()),sistem.getListaDepartamento().get(cbbCurDep.getSelectedIndex()));
							funcionario.setCPF(txtCPF.getText());
							funcionario.setSexo(Sexo.MASCULINO);
							sistema.adicionarNovoConsumidor(funcionario);
							SerializacaoDados.salvarLista(sistema.getListaConsumidores(), "Consumidor.ser");

						}
						else{

							Funcionario funcionario = new Funcionario(txtNome.getText(),txtMatricula.getText(),Integer.parseInt(txtAnoDeIngresso.getText()),sistem.getListaDepartamento().get(cbbCurDep.getSelectedIndex()));
							funcionario.setCPF(txtCPF.getText());
							funcionario.setSexo(Sexo.FEMININO);
							sistema.adicionarNovoConsumidor(funcionario);
							SerializacaoDados.salvarLista(sistema.getListaConsumidores(), "Consumidor.ser");
						}

						TelaAnterior.setVisible(true);
						setVisible(false);
					}
				}
				;//salvar o novo consumidor


			}


		});
		btnConfirmar.setBounds(56, 239, 117, 28);
		contentPane.add(btnConfirmar);
	}
}

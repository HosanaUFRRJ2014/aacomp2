package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ItemListener;

import javax.swing.ListSelectionModel;

import controller.SerializacaoDados;
import entity.Curso;
import entity.Sistema;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NovoCurso extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSigla;

	private JFrame esteFrame;
	private JFrame frameAnterior;
	private Sistema sistem;

	/**
	 * Launch the application.
	 */
	/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoCurso frame = new NovoCurso();
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
	public NovoCurso(final JFrame TelaAnterior, final Sistema sistema) {
		setTitle("Novo Curso");
		esteFrame = this;
		frameAnterior = TelaAnterior;
		sistem = sistema;
		setDefaultCloseOperation(JFrame.NORMAL);
		setBounds(100, 100, 591, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNome = new JTextField();
		txtNome.setBounds(51, 39, 265, 25);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtSigla = new JTextField();
		txtSigla.setColumns(10);
		txtSigla.setBounds(391, 39, 100, 25);
		contentPane.add(txtSigla);

		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(55, 12, 70, 15);
		contentPane.add(lblNome);

		JLabel lblSigla = new JLabel("Sigla :");
		lblSigla.setBounds(391, 12, 92, 15);
		contentPane.add(lblSigla);

		JLabel lblDepartamento = new JLabel("Departamento :");
		lblDepartamento.setBounds(60, 93, 122, 15);
		contentPane.add(lblDepartamento);

		final JComboBox cbbDepart = new JComboBox();
		//cbbDepart.addItemListener(new ItemListener()  {

		//	public void itemStateChanged(ItemEvent arg0) 
		//		{
		String [] listaDepartamentos = new String[100];

		for(int i = 0; i < sistem.getListaDepartamento().size(); i++)
		{
			listaDepartamentos[i] = sistem.getListaDepartamento().get(i).getSiglaDepartamento();
		}
		cbbDepart.setModel(new DefaultComboBoxModel(listaDepartamentos));
		//	}
		//	});
		cbbDepart.setBounds(200, 88, 105, 24);
		contentPane.add(cbbDepart);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(sistema.compararSiglaCursos(txtSigla.getText(),sistema.getListaCursos()) == false)
				{
			         setVisible(false);
			         TelaAnterior.setVisible(true);

			         Curso curso = new Curso(sistem.getListaDepartamento().get(cbbDepart.getSelectedIndex()),txtNome.getText());
			         curso.setSiglaCurso(txtSigla.getText());
			         sistema.adicionarNovoCurso(curso);
			         SerializacaoDados.salvarLista(sistema.getListaCursos(), "Curso.ser");
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Essa sigla já está cadastrada no sistema");
				}


			}
		});
		btnConfirmar.setBounds(65, 146, 117, 28);
		contentPane.add(btnConfirmar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAnterior.setVisible(true);
				setVisible(false);
			}
		});
		btnCancelar.setBounds(247, 148, 117, 28);
		contentPane.add(btnCancelar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNome.setText("");
				txtSigla.setText("");
				cbbDepart.setSelectedIndex(0);
			}
		});
		btnLimpar.setBounds(426, 148, 117, 28);
		contentPane.add(btnLimpar);


	}
}

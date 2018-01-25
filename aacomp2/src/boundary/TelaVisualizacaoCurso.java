package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import javax.swing.JButton;

import controller.SerializacaoDados;
import entity.Curso;
import entity.Departamento;
import entity.Sistema;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class TelaVisualizacaoCurso extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSiglaDepart;
	private JFrame TelaAtual;
	private JList lstSiglaCurso;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaVisualizacaoCurso(final JFrame TelaAnterior, final Sistema sistema) {
		TelaAtual = this;
		setTitle("Curso");
		setDefaultCloseOperation(JFrame.NORMAL);
		setBounds(100, 100, 688, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSiglaDepart = new JTextField();
		txtSiglaDepart.setEditable(false);
		txtSiglaDepart.setColumns(10);
		txtSiglaDepart.setBounds(319, 108, 128, 26);
		contentPane.add(txtSiglaDepart);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setBounds(319, 30, 315, 26);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		
		File f1 = new File("Curso.ser");
		File f2 = new File("Departamento.ser");
		
		
		//ler o arquivo de consumidores
		if(!f1.exists())
			SerializacaoDados.salvarLista(sistema.getListaCursos(),"Curso.ser");
		
		if(!f2.exists())
			SerializacaoDados.salvarLista(sistema.getListaDepartamento(),"Departamento.ser");
			
		sistema.setListaCursos(((ArrayList<Curso>) SerializacaoDados.carregarLista("Curso.ser")));// metodo pra carregar a lista
		sistema.setListaDepartamento(((ArrayList<Departamento>) SerializacaoDados.carregarLista("Departamento.ser")));
		
		
		String itens [] = new String[sistema.getListaCursos().size()];
		for(int i = 0;i<sistema.getListaCursos().size();i++)
			itens[i] = sistema.getListaCursos().get(i).getSiglaCurso();
		
		lstSiglaCurso = new JList(itens);
		lstSiglaCurso.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				txtNome.setText(sistema.getListaCursos().get(lstSiglaCurso.getSelectedIndex()).getNomeCurso());
				txtSiglaDepart.setText(sistema.getListaCursos().get(lstSiglaCurso.getSelectedIndex()).getDepartamento().getSiglaDepartamento());
			}
		});
		lstSiglaCurso.setToolTipText("");
		lstSiglaCurso.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "", TitledBorder.LEADING, TitledBorder.TOP, null, null), "SIGLA", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lstSiglaCurso.setFont(new Font("Dialog", Font.BOLD, 14));

		lstSiglaCurso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstSiglaCurso.setValueIsAdjusting(true);
		lstSiglaCurso.setBounds(48, 16, 209, 312);
		contentPane.add(lstSiglaCurso);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(320, 12, 70, 15);
		contentPane.add(lblNome);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					NovoCurso frame = new NovoCurso(TelaAtual, sistema);
					frame.setVisible(true);
					setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNovo.setBounds(331, 293, 93, 35);
		contentPane.add(btnNovo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAnterior.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setBounds(451, 293, 93, 35);
		contentPane.add(btnVoltar);
		
		JLabel lblDepart = new JLabel("Sigla Departamento :");
		lblDepart.setBounds(319, 89, 161, 15);
		contentPane.add(lblDepart);
		
	}
}

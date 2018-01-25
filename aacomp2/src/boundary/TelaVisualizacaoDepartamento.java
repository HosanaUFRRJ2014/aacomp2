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

import entity.Departamento;
import entity.Sistema;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import controller.SerializacaoDados;

public class TelaVisualizacaoDepartamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private final JFrame TelaAtual;
	

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public TelaVisualizacaoDepartamento(final JFrame TelaAnterior, final Sistema sistema) {
		TelaAtual = this;
		setTitle("Departamento");
		setDefaultCloseOperation(JFrame.NORMAL);
		setBounds(100, 100, 688, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setBounds(319, 30, 315, 26);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(320, 12, 70, 15);
		contentPane.add(lblNome);
		
		File f1 = new File("Departamento.ser");
		//ler o arquivo de consumidores
		if(!f1.exists())
			SerializacaoDados.salvarLista(sistema.getListaDepartamento(),"Departamento.ser");
			
		sistema.setListaDepartamento(((ArrayList<Departamento>) SerializacaoDados.carregarLista("Departamento.ser")));// metodo pra carregar a lista
		String itens [] = new String[sistema.getListaDepartamento().size()];
		for(int i = 0;i<sistema.getListaDepartamento().size();i++)
			itens[i] = sistema.getListaDepartamento().get(i).getSiglaDepartamento();
		
		final JList lstSiglaDepart = new JList(itens);
		lstSiglaDepart.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				txtNome.setText(sistema.getListaDepartamento().get(lstSiglaDepart.getSelectedIndex()).getNomeDepartamento());
			}
		});
		lstSiglaDepart.setToolTipText("");
		lstSiglaDepart.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "", TitledBorder.LEADING, TitledBorder.TOP, null, null), "SIGLA", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lstSiglaDepart.setFont(new Font("Dialog", Font.BOLD, 14));
	/*	lstSiglaDepart.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});*/
		lstSiglaDepart.setSelectedIndex(0);
		lstSiglaDepart.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstSiglaDepart.setValueIsAdjusting(true);
		lstSiglaDepart.setBounds(48, 16, 209, 312);
		contentPane.add(lstSiglaDepart);
		
		
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					NovoDepartamento frame = new NovoDepartamento(TelaAtual, sistema);
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
	}
}

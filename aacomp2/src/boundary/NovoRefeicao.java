package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;

import controller.SerializacaoDados;
import entity.Almoco;
import entity.Dejejum;
import entity.Jantar;
import entity.Sistema;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class NovoRefeicao extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescricao;
	private JTextField txtOpVegetariana;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoRefeicao frame = new NovoRefeicao();
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
	public NovoRefeicao(final JFrame TelaAnterior, final Sistema sistema) {
		setTitle("Nova Refeição");
		setDefaultCloseOperation(JFrame.NORMAL);
		setBounds(100, 100, 594, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(51, 39, 265, 25);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descrição :");
		lblDescricao.setBounds(55, 12, 95, 15);
		contentPane.add(lblDescricao);
		
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAnterior.setVisible(true);
				setVisible(false);
			}
		});
		btnCancelar.setBounds(247, 148, 117, 28);
		contentPane.add(btnCancelar);
		
		JLabel lblTurno = new JLabel("Turno :");
		lblTurno.setBounds(396, 13, 122, 15);
		contentPane.add(lblTurno);
		
		final JComboBox cbbTurno = new JComboBox();
		cbbTurno.setModel(new DefaultComboBoxModel(new String[] {"MANHÃ", "TARDE", "NOITE"}));
		cbbTurno.setBounds(391, 39, 127, 24);
		contentPane.add(cbbTurno);
		
		txtOpVegetariana = new JTextField();
		txtOpVegetariana.setColumns(10);
		txtOpVegetariana.setBounds(51, 94, 265, 25);
		contentPane.add(txtOpVegetariana);
		
		JLabel lblOpVegetariana = new JLabel("Opção Vegetariana :");
		lblOpVegetariana.setBounds(55, 67, 169, 15);
		contentPane.add(lblOpVegetariana);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtDescricao.setText("");
				txtOpVegetariana.setText("");
				cbbTurno.setSelectedIndex(0);
			}
		});
		btnLimpar.setBounds(426, 148, 117, 28);
		contentPane.add(btnLimpar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				TelaAnterior.setVisible(true);
				
				if(cbbTurno.getSelectedIndex() == 0)
				{
					Dejejum d = new Dejejum(txtDescricao.getText(),txtOpVegetariana.getText());
					sistema.adicionarNovaRefeicao(d);
					SerializacaoDados.salvarLista(sistema.getListaRefeicoes(), "Refeicao.ser");
				}
				if(cbbTurno.getSelectedIndex() == 1)
				{
					Almoco a = new Almoco(txtDescricao.getText(),txtOpVegetariana.getText());
					sistema.adicionarNovaRefeicao(a);
					SerializacaoDados.salvarLista(sistema.getListaRefeicoes(), "Refeicao.ser");
				}
				if(cbbTurno.getSelectedIndex() == 2)
				{
					Jantar j = new Jantar(txtDescricao.getText(),txtOpVegetariana.getText());
					sistema.adicionarNovaRefeicao(j);
					SerializacaoDados.salvarLista(sistema.getListaRefeicoes(), "Refeicao.ser");
				}
				
			}
		});
		btnConfirmar.setBounds(65, 146, 117, 28);
		contentPane.add(btnConfirmar);
	}
}

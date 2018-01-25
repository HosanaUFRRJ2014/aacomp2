package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.ListSelectionModel;

import controller.SerializacaoDados;
import entity.Departamento;
import entity.Sistema;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NovoDepartamento extends JFrame {

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
					NovoDepartamento frame = new NovoDepartamento();
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
	public NovoDepartamento(final JFrame TelaAnterior, final Sistema sistema) {
		setTitle("Novo Departamento");
		esteFrame = this;
		frameAnterior = TelaAnterior;
		sistem = sistema;
		setDefaultCloseOperation(JFrame.NORMAL);
		setBounds(100, 100, 631, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNome = new JTextField();
		txtNome.setBounds(50, 51, 265, 25);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtSigla = new JTextField();
		txtSigla.setColumns(10);
		txtSigla.setBounds(395, 51, 100, 25);
		contentPane.add(txtSigla);

		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(54, 24, 70, 15);
		contentPane.add(lblNome);

		JLabel lblSigla = new JLabel("Sigla :");
		lblSigla.setBounds(390, 24, 92, 15);
		contentPane.add(lblSigla);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {



				if(sistema.compararSiglasDepartamentos(txtSigla.getText(),sistema.getListaDepartamento()) == false)
				{
					Departamento departamento = new Departamento(txtNome.getText());
					departamento.setSiglaDepartamento(txtSigla.getText());
					sistema.adicionarNovoDepartamento(departamento);
					setVisible(false);
					TelaAnterior.setVisible(true);
					SerializacaoDados.salvarLista(sistema.getListaDepartamento(), "Departamento.ser");
				}

				else
				{

					JOptionPane.showMessageDialog(null, "Essa sigla já está cadastrada no sistema");
				}

			}
		});

		btnConfirmar.setBounds(50, 120, 117, 28);
		contentPane.add(btnConfirmar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAnterior.setVisible(true);
				setVisible(false);
			}
		});
		btnCancelar.setBounds(232, 122, 117, 28);
		contentPane.add(btnCancelar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNome.setText("");
				txtSigla.setText("");
			}
		});
		btnLimpar.setBounds(411, 122, 117, 28);
		contentPane.add(btnLimpar);
	}
}

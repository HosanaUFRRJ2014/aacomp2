package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.sql.rowset.serial.SerialStruct;
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

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import controller.SerializacaoDados;
import entity.Curso;
import entity.Refeicao;
import entity.Sistema;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class TelaVisualizacaoRefeicao extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtOpVegetariana;
	private JTextField txtTurno;
	private JFrame TelaAtual;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVisualizacaoRefeicao frame = new TelaVisualizacaoRefeicao();
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
	public TelaVisualizacaoRefeicao(final JFrame TelaAnterior, final Sistema sistema) {
		TelaAtual = this;
		setTitle("Refeição");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setHorizontalAlignment(SwingConstants.LEFT);
		txtNome.setEditable(false);
		txtNome.setBounds(319, 30, 315, 48);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtOpVegetariana = new JTextField();
		txtOpVegetariana.setHorizontalAlignment(SwingConstants.LEFT);
		txtOpVegetariana.setEditable(false);
		txtOpVegetariana.setColumns(10);
		txtOpVegetariana.setBounds(319, 108, 315, 48);
		contentPane.add(txtOpVegetariana);
		
		txtTurno = new JTextField();
		txtTurno.setEditable(false);
		txtTurno.setBounds(373, 162, 131, 27);
		contentPane.add(txtTurno);
		txtTurno.setColumns(10);
		
		File f1 = new File("Refeicao.ser");
		//ler o arquivo de consumidores
		if(!f1.exists())
			SerializacaoDados.salvarLista(sistema.getListaRefeicoes(),"Refeicao.ser");
			
		sistema.setListaRefeicoes(((ArrayList<Refeicao>) SerializacaoDados.carregarLista("Refeicao.ser")));// metodo pra carregar a lista
		String itens [] = new String[sistema.getListaRefeicoes().size()];
		for(int i = 0;i<sistema.getListaRefeicoes().size();i++)
			itens[i] = "refeição " + i;
		
		final JList lstIndexRefeicoes = new JList(itens);
		lstIndexRefeicoes.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				txtNome.setText(sistema.getListaRefeicoes().get(lstIndexRefeicoes.getSelectedIndex()).getDescricao());
				txtOpVegetariana.setText(sistema.getListaRefeicoes().get(lstIndexRefeicoes.getSelectedIndex()).getOpcaoVegetariana());
				txtTurno.setText(sistema.getListaRefeicoes().get(lstIndexRefeicoes.getSelectedIndex()).getTurno());
			}
		});
		lstIndexRefeicoes.setToolTipText("");
		lstIndexRefeicoes.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "", TitledBorder.LEADING, TitledBorder.TOP, null, null), "REFEI\u00C7\u00C3O", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lstIndexRefeicoes.setFont(new Font("Dialog", Font.BOLD, 14));
	/*	lstIndexRefeicoes.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});*/
		lstIndexRefeicoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstIndexRefeicoes.setValueIsAdjusting(true);
		lstIndexRefeicoes.setBounds(48, 16, 209, 312);
		contentPane.add(lstIndexRefeicoes);
		
		JLabel lblNome = new JLabel("Descrição :");
		lblNome.setBounds(320, 12, 93, 15);
		contentPane.add(lblNome);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					NovoRefeicao frame = new NovoRefeicao(TelaAtual, sistema);
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
			public void actionPerformed(ActionEvent arg0) {
				TelaAnterior.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setBounds(451, 293, 93, 35);
		contentPane.add(btnVoltar);
		
		final JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnEditar.getText() == "Editar")
				{
					txtNome.setEditable(true);
					txtOpVegetariana.setEditable(true);
					lstIndexRefeicoes.setEnabled(false);
					btnEditar.setText("Confirmar");
				}
				else
				{
					txtNome.setEditable(false);
					sistema.getListaRefeicoes().get(lstIndexRefeicoes.getSelectedIndex()).setDescricao(txtNome.getText());
					txtOpVegetariana.setEditable(false);
					sistema.getListaRefeicoes().get(lstIndexRefeicoes.getSelectedIndex()).setOpcaoVegetariana(txtOpVegetariana.getText());
					SerializacaoDados.salvarLista(sistema.getListaRefeicoes(), "Refeicao.ser");
					//atualizar as informações no array
					lstIndexRefeicoes.setEnabled(true);
					btnEditar.setText("Editar");
				}
			}
		});
		btnEditar.setBounds(570, 293, 93, 35);
		contentPane.add(btnEditar);
		
		JLabel lblOpvegetariana = new JLabel("Opção vegetariana :");
		lblOpvegetariana.setBounds(320, 90, 140, 15);
		contentPane.add(lblOpvegetariana);
		
		JLabel lblTurno = new JLabel("Turno :");
		lblTurno.setBounds(319, 168, 60, 15);
		contentPane.add(lblTurno);
		
	}
}

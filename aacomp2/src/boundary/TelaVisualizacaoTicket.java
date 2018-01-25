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

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import controller.SerializacaoDados;
import entity.Consumidor;
import entity.Refeicao;
import entity.Sistema;
import entity.Ticket;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class TelaVisualizacaoTicket extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtMatricula;
	private JTextField txtValor;
	private JTextField txtTurno;
	private JFrame TelaAtual;
	private JComboBox cbbPago;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVisualizacaoTicket frame = new TelaVisualizacaoTicket();
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
	public TelaVisualizacaoTicket(final JFrame TelaAnterior, final Sistema sistema) {
		TelaAtual = this;
		setTitle("Ticket");
		setDefaultCloseOperation(JFrame.NORMAL);
		setBounds(100, 100, 698, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setBounds(319, 30, 326, 49);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtValor = new JTextField();
		txtValor.setEditable(false);
		txtValor.setBounds(504, 111, 114, 26);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		txtMatricula = new JTextField();
		txtMatricula.setEditable(false);
		txtMatricula.setBounds(329, 111, 143, 26);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		txtTurno = new JTextField();
		txtTurno.setEditable(false);
		txtTurno.setColumns(10);
		txtTurno.setBounds(508, 178, 114, 26);
		contentPane.add(txtTurno);
		
		cbbPago = new JComboBox();
		cbbPago.setModel(new DefaultComboBoxModel(new String[] {"NÃO", "SIM"}));
		cbbPago.setSelectedIndex(0);
		cbbPago.setEnabled(false);
		cbbPago.setBounds(326, 180, 131, 24);
		contentPane.add(cbbPago);
		
		File f1 = new File("Ticket.ser");
		File f2 = new File("Consumidor.ser");
		File f3 = new File("Refeicao.ser");
		
		//ler o arquivo de consumidores
		if(!f1.exists())
			SerializacaoDados.salvarLista(sistema.getListaTickets(),"Ticket.ser");
		
		if(!f2.exists())
			SerializacaoDados.salvarLista(sistema.getListaConsumidores(),"Consumidor.ser");
		
		if(!f3.exists())
			SerializacaoDados.salvarLista(sistema.getListaRefeicoes(),"Refeicao.ser");
			
		sistema.setListaTickets(((ArrayList<Ticket>) SerializacaoDados.carregarLista("Ticket.ser")));// metodo pra carregar a lista
		sistema.setListaConsumidores(((ArrayList<Consumidor>) SerializacaoDados.carregarLista("Consumidor.ser")));
		sistema.setListaRefeicoes(((ArrayList<Refeicao>) SerializacaoDados.carregarLista("Refeicao.ser")));
		
		String itens [] = new String[sistema.getListaTickets().size()];
		for(int i = 0;i<sistema.getListaTickets().size();i++)
			itens[i] = "Ticket " + i;
		
		final JList lstTickets = new JList(itens);
		lstTickets.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				txtNome.setText(sistema.getListaTickets().get(lstTickets.getSelectedIndex()).getRefeicaoConsumida().getDescricao());
				txtValor.setText(String.valueOf(sistema.getListaTickets().get(lstTickets.getSelectedIndex()).getValor()));
				txtMatricula.setText(sistema.getListaTickets().get(lstTickets.getSelectedIndex()).getConsumidor().getMatricula());
				txtTurno.setText(sistema.getListaTickets().get(lstTickets.getSelectedIndex()).getRefeicaoConsumida().getTurno());
				if(sistema.getListaTickets().get(lstTickets.getSelectedIndex()).isPago())
					cbbPago.setSelectedIndex(1);
				else
					cbbPago.setSelectedIndex(0);
			}
		});
		lstTickets.setToolTipText("");
		lstTickets.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "", TitledBorder.LEADING, TitledBorder.TOP, null, null), "Refei\u00E7\u00E3o", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lstTickets.setFont(new Font("Dialog", Font.BOLD, 14));

		lstTickets.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstTickets.setValueIsAdjusting(true);
		lstTickets.setBounds(48, 16, 209, 312);
		contentPane.add(lstTickets);
		
		JLabel lblDescricao = new JLabel("Descrição da Refeição :");
		lblDescricao.setBounds(320, 12, 176, 15);
		contentPane.add(lblDescricao);
		
		JLabel lblMatricula = new JLabel("Matrícula do Consumidor :");
		lblMatricula.setBounds(329, 91, 170, 15);
		contentPane.add(lblMatricula);
		
		JLabel lblSexo = new JLabel("Pago :");
		lblSexo.setBounds(326, 160, 51, 15);
		contentPane.add(lblSexo);
		
		JLabel lblValor = new JLabel("Valor :");
		lblValor.setBounds(508, 91, 80, 15);
		contentPane.add(lblValor);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					NovoTicket frame = new NovoTicket(TelaAtual, sistema);
					frame.setVisible(true);
					setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNovo.setBounds(333, 265, 93, 35);
		contentPane.add(btnNovo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAnterior.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setBounds(453, 265, 93, 35);
		contentPane.add(btnVoltar);
		
		final JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnEditar.getText() == "Editar")
				{
					cbbPago.setEnabled(true);
					lstTickets.setEnabled(false);
					btnEditar.setText("Confirmar");
				}
				else
				{
					cbbPago.setEnabled(false);
					if(cbbPago.getSelectedIndex() == 0)
					{
						sistema.getListaTickets().get(lstTickets.getSelectedIndex()).setPago(false);
						SerializacaoDados.salvarLista(sistema.getListaTickets(), "Ticket.ser");
					}
					else{
						sistema.getListaTickets().get(lstTickets.getSelectedIndex()).setPago(true);
						SerializacaoDados.salvarLista(sistema.getListaTickets(), "Ticket.ser");
					}
					
					lstTickets.setEnabled(true);
					btnEditar.setText("Editar");
				}
			}
		});
		btnEditar.setBounds(572, 265, 93, 35);
		contentPane.add(btnEditar);
		
		JLabel lblTurno = new JLabel("Turno :");
		lblTurno.setBounds(512, 158, 80, 15);
		contentPane.add(lblTurno);
	}
}

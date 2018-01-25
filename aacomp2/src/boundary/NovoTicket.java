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
import entity.Aluno;
import entity.Funcionario;
import entity.Sistema;
import entity.Ticket;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NovoTicket extends JFrame {

	private JPanel contentPane;
	private JTextField txtValor;
	
	private Sistema sistem;
	private JFrame esteFrame;
	
	private JComboBox cbbCPFconsumidor;
	private JComboBox cbbRefeicao;
	private double preco;

	private String CalcularPreco(String tipoConsumidor, String refeicao)
	{
		if(refeicao == "MANHA")
		{
			if(tipoConsumidor == "ALUNO")
				preco = 0.5;
			if(tipoConsumidor == "FUNCIONARIO")
				preco = 3.0;
		}
		if( (refeicao == "TARDE") || (refeicao == "NOITE"))
		{
			if(tipoConsumidor == "ALUNO")
				preco = 1.0;
			if(tipoConsumidor == "FUNCIONARIO")
				preco = 6.0;
		}
		
		return Double.toString(preco);
	}
	
	
	public NovoTicket(final JFrame TelaAnterior, final Sistema sistema) {
		setTitle("Nova Ticket");
		esteFrame = this;
		sistem = sistema;
		setDefaultCloseOperation(JFrame.NORMAL);
		setBounds(100, 100, 594, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRefeicao = new JLabel("Refeição :");
		 
		lblRefeicao.setBounds(55, 12, 95, 15);
		contentPane.add(lblRefeicao);
		
		cbbRefeicao = new JComboBox();
		cbbRefeicao.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(cbbCPFconsumidor.getSelectedIndex() != -1)
				{
					if(sistem.getListaConsumidores().get(cbbCPFconsumidor.getSelectedIndex()) instanceof Funcionario)
						txtValor.setText(CalcularPreco("FUNCIONARIO", sistem.getListaRefeicoes().get(cbbRefeicao.getSelectedIndex()).getTurno()));
					if(sistem.getListaConsumidores().get(cbbCPFconsumidor.getSelectedIndex()) instanceof Aluno)
						txtValor.setText(CalcularPreco("ALUNO", sistem.getListaRefeicoes().get(cbbRefeicao.getSelectedIndex()).getTurno()));
				}
			}
		});
		
		contentPane.add(cbbRefeicao);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAnterior.setVisible(true);
				setVisible(false);
			}
		});
		btnCancelar.setBounds(247, 148, 117, 28);
		contentPane.add(btnCancelar);
		
		JLabel lblConsumidor = new JLabel("CPF Consumidor :");
		
		lblConsumidor.setBounds(396, 13, 147, 15);
		contentPane.add(lblConsumidor);
		
		cbbCPFconsumidor = new JComboBox();
		cbbCPFconsumidor.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(cbbRefeicao.getSelectedIndex() != -1)
				{
					if(sistem.getListaConsumidores().get(cbbCPFconsumidor.getSelectedIndex()) instanceof Funcionario)
						txtValor.setText(CalcularPreco("FUNCIONARIO", sistem.getListaRefeicoes().get(cbbRefeicao.getSelectedIndex()).getTurno()));
					if(sistem.getListaConsumidores().get(cbbCPFconsumidor.getSelectedIndex()) instanceof Aluno)
						txtValor.setText(CalcularPreco("ALUNO", sistem.getListaRefeicoes().get(cbbRefeicao.getSelectedIndex()).getTurno()));
				}
			}
		});
		cbbCPFconsumidor.setSelectedIndex(-1);
		cbbCPFconsumidor.setBounds(391, 39, 138, 24);
		contentPane.add(cbbCPFconsumidor);
		
		 String [] cpf = new String[100];
			
			for(int i = 0; i < sistema.getListaConsumidores().size(); i++)
			{
				cpf[i] = sistem.getListaConsumidores().get(i).getCPF();
			}
			cbbCPFconsumidor.setModel(new DefaultComboBoxModel(cpf));
		
		
		JLabel lblValor = new JLabel("Valor :");
		lblValor.setBounds(61, 82, 100, 15);
		contentPane.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setEditable(false);
		txtValor.setColumns(10);
		txtValor.setBounds(51, 109, 104, 25);
		contentPane.add(txtValor);
		
		final JComboBox cbbPago = new JComboBox();
		cbbPago.setModel(new DefaultComboBoxModel(new String[] {"NÃO", "SIM"}));
		cbbPago.setBounds(229, 112, 138, 24);
		contentPane.add(cbbPago);
		
		JLabel lblPago = new JLabel("Pago :");
		lblPago.setBounds(220, 82, 147, 15);
		contentPane.add(lblPago);
		
	//	final JComboBox 
		
		String [] refeicao = new String[100];
		
		for(int i = 0; i < sistema.getListaRefeicoes().size(); i++)
		{
			refeicao[i] = sistem.getListaRefeicoes().get(i).getDescricao();
		}
		cbbRefeicao.setModel(new DefaultComboBoxModel(refeicao));
		cbbRefeicao.setBounds(55, 39, 299, 24);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbbRefeicao.setSelectedIndex(0);
				cbbCPFconsumidor.setSelectedIndex(0);
				cbbPago.setSelectedIndex(0);
				txtValor.setText("");
			}
		});
		btnLimpar.setBounds(426, 148, 117, 28);
		contentPane.add(btnLimpar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				boolean pago;
				if(cbbPago.getSelectedIndex() == 0)
				{
					pago = false;
					Ticket t = new Ticket(sistema.getListaConsumidores().get(cbbCPFconsumidor.getSelectedIndex()),sistema.getListaRefeicoes().get(cbbRefeicao.getSelectedIndex()),pago);
					sistema.adicionarNovoTicket(t);
					SerializacaoDados.salvarLista(sistema.getListaTickets(), "Ticket.ser");
					
				}
				if(cbbPago.getSelectedIndex() == 1)
				{
					pago = true;
					Ticket t = new Ticket(sistema.getListaConsumidores().get(cbbCPFconsumidor.getSelectedIndex()),sistema.getListaRefeicoes().get(cbbRefeicao.getSelectedIndex()),pago);
					sistema.adicionarNovoTicket(t);
					SerializacaoDados.salvarLista(sistema.getListaTickets(), "Ticket.ser");
				}
				
				setVisible(false);
				TelaAnterior.setVisible(true);
				
			}		
			
		});
		btnConfirmar.setBounds(65, 146, 117, 28);
		contentPane.add(btnConfirmar);
	}
}

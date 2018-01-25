package boundary;

import java.awt.EventQueue;
import entity.Sistema;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class TelaPrincipal {

	private JFrame frmInicio;
	private Sistema sistema;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmInicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		sistema = new Sistema();
		frmInicio = new JFrame();
		frmInicio.setVisible(true);
		frmInicio.setName("frmInicio");
		frmInicio.setResizable(false);
		frmInicio.setTitle("Inicio");
		frmInicio.setBounds(100, 100, 614, 435);
		frmInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInicio.getContentPane().setLayout(null);
		
		JButton btnConsumidor = new JButton("Consumidor");
		btnConsumidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TelaVisualizacaoConsumidor frame = new TelaVisualizacaoConsumidor(frmInicio, sistema);
							frame.setVisible(true);
							frmInicio.setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnConsumidor.setBounds(223, 28, 149, 43);
		frmInicio.getContentPane().add(btnConsumidor);
		
		JButton btnDepartamento = new JButton("Departamento");
		btnDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TelaVisualizacaoDepartamento frame = new TelaVisualizacaoDepartamento(frmInicio, sistema);
							frame.setVisible(true);
							frmInicio.setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnDepartamento.setBounds(223, 106, 149, 43);
		frmInicio.getContentPane().add(btnDepartamento);
		
		JButton btnCurso = new JButton("Curso");
		btnCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TelaVisualizacaoCurso frame = new TelaVisualizacaoCurso(frmInicio, sistema);
							frame.setVisible(true);
							frmInicio.setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnCurso.setBounds(223, 182, 149, 43);
		frmInicio.getContentPane().add(btnCurso);
		
		JButton btnRefeicao = new JButton("Refeição");
		btnRefeicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TelaVisualizacaoRefeicao frame = new TelaVisualizacaoRefeicao(frmInicio, sistema);
							frame.setVisible(true);
							frmInicio.setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnRefeicao.setBounds(223, 262, 149, 43);
		frmInicio.getContentPane().add(btnRefeicao);
		
		JButton btnTickets = new JButton("Ticket");
		btnTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TelaVisualizacaoTicket frame = new TelaVisualizacaoTicket(frmInicio, sistema);
							frame.setVisible(true);
							frmInicio.setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnTickets.setBounds(223, 338, 149, 43);
		frmInicio.getContentPane().add(btnTickets);
	}
}

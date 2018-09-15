package mineradora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import interfaces.Maquina;
import interfaces.Operario;
import maquinaThreads.MaquinaGrande;
import maquinaThreads.MaquinaPequena;
import operarioThreads.OperarioEnergia;
import operarioThreads.OperarioKg;
import recurso.DepositoMinerio;
import recurso.FonteEnergia;

import java.awt.Color;
import java.awt.Font;

public class MinerCraft2 {

	private JFrame frmMinercraft;
	private JLabel labelMaquinaGrande;
	private JLabel labelMaquinaPequena;
	private JLabel labelOperarioEnergia;
	private JLabel labelOperarioMaquina;
	private JLabel labelProducaoMaquinas;
	private JLabel labelGastoEnergiaMaquina;
	private JLabel labelEspacoLiberadoDeposito;
	private JLabel labelRecargaEnergia;
	private JTextArea textAreaConsole;
	private ArrayList<Maquina> maquinas;
	private ArrayList<OperarioEnergia> operariosEnergia;
	private ArrayList<OperarioKg> operariosMaquina;
	private DepositoMinerio depositoMinerio;
	private FonteEnergia fonteEnergia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MinerCraft2 window = new MinerCraft2();
					window.frmMinercraft.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MinerCraft2() {
		initialize();
		inicializarListaMaquinas();
		inicializarOperariosEnergia();
		inicializarOperariosMaquina();

	}

	private void inicializarOperariosEnergia() {

		if (operariosEnergia == null) {
			operariosEnergia = new ArrayList<OperarioEnergia>();
		}

	}

	private void inicializarOperariosMaquina() {
		if (operariosMaquina == null) {
			operariosMaquina = new ArrayList<OperarioKg>();
		}
	}

	private void inicializarListaMaquinas() {

		if (maquinas == null) {
			maquinas = new ArrayList<Maquina>();
			depositoMinerio = new DepositoMinerio(textAreaConsole);
			fonteEnergia = new FonteEnergia(textAreaConsole);
		}
	}

	private int getQuantidadeMaquinaTipo(String tipoMaquina) {

		int quantidadeMaquinaPequena = 0;
		int quantidadeMaquinaGrande = 0;

		int quantidade = 0;

		for (Maquina maquina : maquinas) {

			if (maquina instanceof MaquinaPequena) {
				quantidadeMaquinaPequena++;

			} else if (maquina instanceof MaquinaGrande) {
				quantidadeMaquinaGrande++;
			}

		}

		if ("MP".equals(tipoMaquina)) {
			quantidade = quantidadeMaquinaPequena;
		} else {
			quantidade = quantidadeMaquinaGrande;
		}

		return quantidade;
	}

	private int getQuantidadeOperarioTipo(String tipoOperario) {
		int quantidade = 0;

		if ("OKG".equals(tipoOperario)) {

			quantidade = operariosMaquina.size();

		} else {

			quantidade = operariosEnergia.size();

		}

		return quantidade;
	}

	private void atualizaStatusProducaoMaquinas() {

		int producaoMaquina = 0;

		for (Maquina maquina : maquinas) {

			producaoMaquina += maquina.getQtdMinerio();
		}

		labelProducaoMaquinas.setText("Produção Máquinas: " + producaoMaquina + " kg/s");
	}

	private void atualizarStatusConsumoEnergiaMaquinas() {
		int totalConsumoEnergia = 0;

		for (Maquina maquina : maquinas) {
			totalConsumoEnergia += maquina.getQtdEnergia();
		}

		labelGastoEnergiaMaquina.setText("Gasto Máquinas: " + totalConsumoEnergia + " kw/s");

	}
	
	private void atualizarEnergiaRecarregada() {
		
		int totalEnergiaRecarregada = 0;
		
		for(OperarioEnergia operario : operariosEnergia) {
			totalEnergiaRecarregada += operario.getRecursoReloaded();
		}
		
		labelRecargaEnergia.setText("Energia Recarregada: "+ totalEnergiaRecarregada +" kw/s");
	}
	
	private void atualizaEspacoLiberado() {
		byte totalEspacoLiberado = 0;
		
		for(OperarioKg operarioKg : operariosMaquina) {
			totalEspacoLiberado += operarioKg.getRecursoReloaded();
		}
		
		labelEspacoLiberadoDeposito.setText("Espaço Liberado: "+ totalEspacoLiberado +" kg/s");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMinercraft = new JFrame();
		frmMinercraft.setIconImage(
				Toolkit.getDefaultToolkit().getImage(MinerCraft2.class.getResource("/icons/gold-mine-icon.png")));
		frmMinercraft.setTitle("MinerCraft");
		frmMinercraft.setBounds(100, 100, 450, 300);
		frmMinercraft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMinercraft.getContentPane().setLayout(new BorderLayout(25, 0));
		frmMinercraft.setSize(new Dimension(820, 480));

		JPanel panel = new JPanel();
		panel.setBorder(null);
		frmMinercraft.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(20, 0));

		JPanel panelInformacoesMina = new JPanel();
		panelInformacoesMina.setBorder(null);
		panel.add(panelInformacoesMina, BorderLayout.WEST);
		panelInformacoesMina.setLayout(new GridLayout(10, 2, 0, 0));

		labelMaquinaGrande = new JLabel("M\u00E1quinas Grande: 0");
		panelInformacoesMina.add(labelMaquinaGrande);

		labelMaquinaPequena = new JLabel("M\u00E1quina Pequena: 0\t\t");
		panelInformacoesMina.add(labelMaquinaPequena);

		labelOperarioEnergia = new JLabel("Oper\u00E1rio Energia: 0\r\n");
		panelInformacoesMina.add(labelOperarioEnergia);

		labelOperarioMaquina = new JLabel("Oper\u00E1rio Kg: 0");
		panelInformacoesMina.add(labelOperarioMaquina);

		JLabel label_1 = new JLabel("");
		panelInformacoesMina.add(label_1);

		JLabel label = new JLabel("");
		panelInformacoesMina.add(label);

		labelProducaoMaquinas = new JLabel("Produ\u00E7\u00E3o M\u00E1quinas: 0  kg/s");
		panelInformacoesMina.add(labelProducaoMaquinas);

		labelGastoEnergiaMaquina = new JLabel("Gasto M\u00E1quinas: 0 kw/s");
		panelInformacoesMina.add(labelGastoEnergiaMaquina);

		labelEspacoLiberadoDeposito = new JLabel("Espa\u00E7o Liberado: 0 kg/s");
		panelInformacoesMina.add(labelEspacoLiberadoDeposito);

		labelRecargaEnergia = new JLabel("Energia Recarregada: 0 kw/s");
		panelInformacoesMina.add(labelRecargaEnergia);

		JPanel panelConsole = new JPanel();
		panel.add(panelConsole, BorderLayout.CENTER);
		panelConsole.setLayout(new BorderLayout(0, 15));

		JLabel lblConsole = new JLabel("Console");
		panelConsole.add(lblConsole, BorderLayout.NORTH);

		textAreaConsole = new JTextArea();
		textAreaConsole.setText("Inicializando MinerCraft.......");
		textAreaConsole.setFont(new Font("Calibri", Font.BOLD, 14));
		textAreaConsole.setBackground(Color.DARK_GRAY);
		textAreaConsole.setEditable(false);
		textAreaConsole.setLineWrap(true);
		textAreaConsole.setForeground(Color.WHITE);
		JScrollPane spDescricao = new JScrollPane(textAreaConsole);
		panelConsole.add(spDescricao, BorderLayout.CENTER);

		JPanel panelMenu = new JPanel();
		frmMinercraft.getContentPane().add(panelMenu, BorderLayout.WEST);
		panelMenu.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panelMenu.setLayout(new GridLayout(7, 1, 0, 15));

		JButton buttonAddMaquinaGrande = new JButton("[ + ] M\u00E1quina Grande");
		buttonAddMaquinaGrande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				MaquinaGrande maquinaGrande = new MaquinaGrande(depositoMinerio, fonteEnergia);
				maquinas.add(maquinaGrande);
				maquinaGrande.start();

				labelMaquinaGrande.setText("M�quinas Grande: " + getQuantidadeMaquinaTipo("MG"));
				atualizaStatusProducaoMaquinas();
				atualizarStatusConsumoEnergiaMaquinas();
			}
		});
		buttonAddMaquinaGrande.setHorizontalAlignment(SwingConstants.LEFT);
		panelMenu.add(buttonAddMaquinaGrande);

		JButton buttonAddMaquinaPequena = new JButton("[ + ] M\u00E1quina Pequena");
		buttonAddMaquinaPequena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				MaquinaPequena maquinaPequena = new MaquinaPequena(depositoMinerio, fonteEnergia);
				maquinas.add(maquinaPequena);
				maquinaPequena.start();

				labelMaquinaPequena.setText("M�quina Pequena: " + getQuantidadeMaquinaTipo("MP"));
				atualizaStatusProducaoMaquinas();
				atualizarStatusConsumoEnergiaMaquinas();
			}
		});
		buttonAddMaquinaPequena.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		buttonAddMaquinaPequena.setHorizontalAlignment(SwingConstants.RIGHT);
		panelMenu.add(buttonAddMaquinaPequena);

		JButton buttonRemoverMaquina = new JButton("[ - ] M\u00E1quina");
		buttonRemoverMaquina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (!maquinas.isEmpty()) {
					Maquina maquinaTemp = maquinas.get(maquinas.size() - 1);

					maquinas.remove(maquinas.size() - 1);

					if (maquinaTemp instanceof MaquinaPequena) {
						labelMaquinaPequena.setText("M�quina Pequena: " + getQuantidadeMaquinaTipo("MP"));
						((MaquinaPequena) maquinaTemp).stop();
					} else {
						labelMaquinaGrande.setText("M�quinas Grande: " + getQuantidadeMaquinaTipo("MG"));
						((MaquinaGrande) maquinaTemp).stop();
					}

					atualizaStatusProducaoMaquinas();
					atualizarStatusConsumoEnergiaMaquinas();

				}
			}

		});
		panelMenu.add(buttonRemoverMaquina);

		JButton buttonAddOperarioEnergia = new JButton("[ + ] Operario Energia");
		buttonAddOperarioEnergia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				OperarioEnergia operarioEnergia = new OperarioEnergia(fonteEnergia);
				operarioEnergia.start();
				operariosEnergia.add(operarioEnergia);
				labelOperarioEnergia.setText("Oper�rio Energia: " + getQuantidadeOperarioTipo("OEN"));
				atualizarEnergiaRecarregada();			
			}
		});
		panelMenu.add(buttonAddOperarioEnergia);

		JButton buttonAdicionarOperarioMaquina = new JButton("[ + ] Operario M\u00E1quina");
		buttonAdicionarOperarioMaquina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				OperarioKg operarioKg = new OperarioKg(depositoMinerio);
				operarioKg.start();
				operariosMaquina.add(operarioKg);
				labelOperarioMaquina.setText("Oper�rio Kg: " + getQuantidadeOperarioTipo("OKG"));
				atualizaEspacoLiberado();
			}
		});
		panelMenu.add(buttonAdicionarOperarioMaquina);

		JButton buttonRemoverOperarioEnergia = new JButton("[ - ] Operario Energia");
		buttonRemoverOperarioEnergia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Colocar cores nos textos do console de acordo com a mensagem.
				// Remover apenas OperarioEnergia
				if (!operariosEnergia.isEmpty()) {

					OperarioEnergia operarioTemp = operariosEnergia.get(operariosEnergia.size() - 1);
					operariosEnergia.remove(operarioTemp);

					labelOperarioEnergia.setText("Oper�rio Energia: " + getQuantidadeOperarioTipo("OEN"));
					operarioTemp.stop();
					atualizarEnergiaRecarregada();
				}

			}
		});
		panelMenu.add(buttonRemoverOperarioEnergia);

		JButton buttonRemoverOperarioMaquina = new JButton("[ - ] Oper\u00E1rio Maquina");
		buttonRemoverOperarioMaquina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (!operariosMaquina.isEmpty()) {

					OperarioKg operarioTemp = operariosMaquina.get(operariosMaquina.size() - 1);
					operariosMaquina.remove(operarioTemp);

					labelOperarioMaquina.setText("Oper�rio M�quina: " + getQuantidadeOperarioTipo("OKG"));
					operarioTemp.stop();
					
					atualizaEspacoLiberado();
				}
			}
		});
		panelMenu.add(buttonRemoverOperarioMaquina);
	}

}

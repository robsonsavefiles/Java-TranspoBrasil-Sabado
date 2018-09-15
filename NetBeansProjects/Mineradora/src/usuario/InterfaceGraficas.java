package usuario;

import java.awt.EventQueue;
import executor.Principal;
import threads.MaquilaGrande;
import usuario.MaquinaPequena;
import dados.Deposito;
import dados.Fonte;
import interfaces.Maquinas;
import interfaces.Operarios;
import interfaces.Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class InterfaceGraficas {

	private JFrame frame;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGraficas window = new InterfaceGraficas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceGraficas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblConsumoDaFonte = new JLabel("Consumo da fonte :" );
		lblConsumoDaFonte.setBounds(161, 83, 150, 14);
		panel.add(lblConsumoDaFonte);
		
		JLabel lblNewLabel = new JLabel("Quantidade no deposito :");
		lblNewLabel.setBounds(161, 33, 150, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quantidade na fonte :");
		lblNewLabel_1.setBounds(160, 58, 129, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade de maquinas grandes :");
		lblNewLabel_2.setBounds(161, 117, 205, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade de maquinas pequenas :");
		lblNewLabel_3.setBounds(140, 155, 215, 14);
		panel.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Maquina grande", "Maquina pequena", "Operario do estoque", "Operario da fonte"}));
		comboBox.setBounds(10, 46, 141, 20);
		panel.add(comboBox);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				if (JComboBox<MaquilaGrande>) {
//					
//					MaquinaGrande mg = new MaquilaGrande(deposito, fonte)
//					
//				}
			}
		});
                
                
		btnAdicionar.setBounds(10, 11, 89, 23);
		panel.add(btnAdicionar);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Maquina grande", "Maquina pequena", "Operario do estoque", "Operario da fon"}));
		comboBox_1.setBounds(10, 128, 141, 20);
		panel.add(comboBox_1);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(10, 94, 89, 23);
		panel.add(btnRemover);
		
		JLabel lblNewLabel_4 = new JLabel("Quantidade de operarios para fonte :");
		lblNewLabel_4.setBounds(86, 180, 259, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Quantidade de operarios para o deposito :");
		lblNewLabel_5.setBounds(86, 205, 259, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblqtdDeposito = new JLabel("New label");
		lblqtdDeposito.setBounds(339, 33, 85, 14);
		panel.add(lblqtdDeposito);
		
		JLabel lblqtdFonte = new JLabel("New label");
		lblqtdFonte.setBounds(339, 58, 85, 14);
		panel.add(lblqtdFonte);
		
		JLabel lblconsumoFonte = new JLabel("New label");
		lblconsumoFonte.setBounds(334, 83, 90, 14);
		panel.add(lblconsumoFonte);
		
		JLabel lblqtdMaquinasGrandes = new JLabel("New label");
		lblqtdMaquinasGrandes.setBounds(376, 117, 48, 14);
		panel.add(lblqtdMaquinasGrandes);
		
		JLabel lblqtdMaquinaspequenas = new JLabel("New label");
		lblqtdMaquinaspequenas.setBounds(365, 155, 59, 14);
		panel.add(lblqtdMaquinaspequenas);
		
		JLabel lblqtdOperariosFonte = new JLabel("New label");
		lblqtdOperariosFonte.setBounds(355, 180, 69, 14);
		panel.add(lblqtdOperariosFonte);
		
		JLabel lblqtdOperariosDeposito = new JLabel("New label");
		lblqtdOperariosDeposito.setBounds(355, 205, 69, 14);
		panel.add(lblqtdOperariosDeposito);
	}
}

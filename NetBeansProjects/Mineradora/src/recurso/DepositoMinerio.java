package recurso;

import javax.swing.JTextArea;

import interfaces.ManipularRecurso;

public class DepositoMinerio implements ManipularRecurso{

	public final int MAX_DEPOSITO = 1000;
	private int deposito = 0;
	private JTextArea textAreaConsole;
	
	public DepositoMinerio(JTextArea textAreaConsole) {
		this.textAreaConsole = textAreaConsole;
	}
	
	public DepositoMinerio() {
		
	}

	@Override
	public synchronized void adicionarRecurso(int qtdAdcionar) throws InterruptedException {
		
		while(deposito >= MAX_DEPOSITO){
			wait();
		}
		
		deposito += qtdAdcionar;
		notifyAll();
		
		textAreaConsole.setText(textAreaConsole.getText() + "\n" + "Depositado " + qtdAdcionar +" de minerio.");
		textAreaConsole.setText(textAreaConsole.getText() + "\n" + "$NÍVEL-DEPOSITO " + deposito );
		textAreaConsole.setCaretPosition( textAreaConsole.getText().length() );
	}
	
	public synchronized void removerRecurso(int qtdRemover) throws InterruptedException  {
		
		textAreaConsole.setText(textAreaConsole.getText() + "\n" + "Nível do depósito: " + deposito + " de minerio.");
		
		while(deposito <= 0 || qtdRemover > deposito) {
			wait();
		}
		
		deposito -= qtdRemover;
		notifyAll();
		
		textAreaConsole.setText(textAreaConsole.getText() + "\n" + "Removido " + qtdRemover + " de minerio.");
		textAreaConsole.setCaretPosition( textAreaConsole.getText().length() );
	}

	@Override
	public int getRecurso() {
		
		return deposito;
	}
	
}

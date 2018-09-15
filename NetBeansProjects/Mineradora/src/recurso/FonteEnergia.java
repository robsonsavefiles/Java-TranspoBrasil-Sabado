package recurso;

import javax.swing.JTextArea;

import interfaces.ManipularRecurso;

public class FonteEnergia implements ManipularRecurso {

	public final int MAX_CAPACIDADE_ENERGIA = 10000;
	private int energia;
	private JTextArea textAreaConsole;

	public FonteEnergia(JTextArea textAreaConsole) {
		this.textAreaConsole = textAreaConsole;
		carregarEnergiaInicial();
	}

	public FonteEnergia() {
		carregarEnergiaInicial();
	}

	@Override
	public synchronized void adicionarRecurso(int qtdAdicionar) throws InterruptedException {

		while (energia >= MAX_CAPACIDADE_ENERGIA) {
			wait();
		}

		energia += qtdAdicionar;
		
		if(energia >= 5000) {
			notifyAll();
		}
		
		textAreaConsole.setText(textAreaConsole.getText() + "\n" + "Recarregado " + qtdAdicionar + " de energia.");
		textAreaConsole.setText(textAreaConsole.getText() + "\n" + "$N�VEL-ENERGIA " + energia);
		textAreaConsole.setCaretPosition(textAreaConsole.getText().length());
	}

	@Override
	public synchronized void removerRecurso(int qtdRemover) throws InterruptedException {

		while (energia == 0 || qtdRemover > energia) {
			wait();
		}
		
		energia -= qtdRemover;
		notifyAll();

		textAreaConsole.setText(textAreaConsole.getText() + "\n" + "Comsumido " + qtdRemover + " de energia.");
		textAreaConsole.setText(textAreaConsole.getText() + "\n" + "$NÍVEL-ENERGIA " + energia);
		textAreaConsole.setCaretPosition(textAreaConsole.getText().length());
	}

	@Override
	public int getRecurso() {

		return energia;
	}

	private void carregarEnergiaInicial() {
		energia = MAX_CAPACIDADE_ENERGIA;
	}

}

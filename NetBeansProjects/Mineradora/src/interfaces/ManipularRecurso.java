package interfaces;

public interface ManipularRecurso {
	
	public void adicionarRecurso(int qtdAdicionar) throws InterruptedException;
	public void removerRecurso(int qtdRemover) throws InterruptedException;
	
	public int getRecurso();
}

package br.com.xti.threads;

/**
 * Uma <code>Ponte</code> representa o elo de ligaçao entres
 * objetos Produtores e consumidores de informaçoes. Os produtores[
 * utilizam as Pontes para gravar informaçoes e compartilhar essas 
 * informaçoes com os consumidores que lêem esses dados da ponte para 
 * fazer o processamento.
 * @author Robinho f.de melo
 * @author Ricardo.
 * @version 1.3
 * @since 1.0
 
 * @see PonteNaoSincronizada
 * @see PonteSincronizada
 * 
 */

public interface Ponte {
	/**
	 * Metodo: Armazena o valor informado na ponte.Geralmente sera chamado
	 * pelas classes Produtoras de dados.
	 *  
	 * @param valor
	 * @throws InterruptedException
	 */
	public void set(int valor) throws InterruptedException;
	
	/*
	 * Recupera a informação armazenada na ponte. esse metodo sera 
	 * chamado pelas consumidores de dados.
	 * 
	 * @return 
	 * @throws InterruptedException
	 */
	public int get() throws InterruptedException;
	
	
}

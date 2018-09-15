public class MensageiroApp{

	public static void main(String[] args){

	Mensageiro ask = new Mensageiro();
	Aluno aluno = new Aluno();
	Professor professor = new Professor();

	aluno.enviarMensagem(ask);
	professor.receberMensagem(ask);

	
	}

}


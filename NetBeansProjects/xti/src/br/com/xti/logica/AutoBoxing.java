package br.com.xti.logica;
//Aula 31 - AutoBoxing
	
	//Boxing- encaixotar;
	
	//Unboxing - Desencaixotar;
	
   public class AutoBoxing {
	
   public static void main(String[] args){
	   
	   
	//1   
	Integer x = new Integer(999);// empacotado;
	int a = x.intValue();//Desempacotar;
	
	//2
	a++;// incrementa
	x = new Integer(a);// Re-empacotar;
	System.out.println(x.intValue());
	
	//3
	Integer x1 = 555;
	x1++;// desempacota. incrementa, reempacota
	System.out.println(x);
	
	//acessando os metodos do objeto
	
	//x.intValue();
	
	Boolean v = new Boolean("True");
	if(v){
		System.out.println(v);
		
	}
	   
   }
}   
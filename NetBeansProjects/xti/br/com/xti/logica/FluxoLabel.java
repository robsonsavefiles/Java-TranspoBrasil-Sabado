package br.com.xti.logica;
//Aula 30 - Label,break,e continue;

	//Fluxo de Repetição
	
	//*break;(para o loop inteiro)
	//*Continue;(para a interaçao atual)
	//*Rotulos;(indicar qual loop voce quer continuar ou parar)

public class FluxoLabel {
	
   public static void main(String[] args){
	   
	   um:
	   for(;;){
	   dois:
	   for(int i=0; i<10; i++){
		   
		   if(i == 5 ){
			   break um;
			   
		   }
		   System.out.println(i);
	   }  
	   }
   
   }
   }
   
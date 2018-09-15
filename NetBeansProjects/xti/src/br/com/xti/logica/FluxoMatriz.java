package br.com.xti.logica;
//Aula 30 - Label,break,e continue;

	//Fluxo de Repetição
	
	//*break;(para o loop inteiro)
	//*Continue;(para a interaçao atual)
	//*Rotulos;(indicar qual loop voce quer continuar ou parar)

   public class FluxoMatriz {
	
   public static void main(String[] args){
	   
	   boolean[][] matrix =
	   {
		   {false,true,false,false,false},
		   {false,false,false,false,false}  
		   
	   };
	   busca:// rotulo 
	   for(int a=0; a < matrix.length; a++){
		   System.out.print("A  ");
	   for(int b=0; b < matrix[a].length; b++){
		   if(matrix[a][b]){
			   System.out.print(" TRUE ");
			   break busca;// pode ser usadao continue;
		   }
		   System.out.print("B  ");
		  
		   
		   
	   }
	   
   
   }
   }
}   
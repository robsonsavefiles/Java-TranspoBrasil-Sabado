package br.com.xti.logica;
// Aula 24 - Switch


public class Switch1 {
	
   public static void main(String[] args){
   
   String tecnologia = "postgresql";
   
   switch(tecnologia){
	   
		   case "java":
		   case "c++":
		   case "cobol":
	
	System.out.println("Linguagem de programação");
	break;
		   case "Oracle":
		   case "sqlserver":
		   case "postgresql":
		   
	System.out.println("Banco de Dados");
	break;
			
	
	
	default:
			 System.out.println("Tecnologia Desconhecida");
		   
	   }
	   
	   
   }
   
	   
   }
   
   
   

      
   


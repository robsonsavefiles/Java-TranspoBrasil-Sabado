//package Menu;
//import dados.Deposito;
//import dados.Fonte;
//import interfaces.Maquina;
//import interfaces.Operario;
//import java.util.ArrayList;
//import java.util.Scanner;
//import javax.swing.JOptionPane;
//import maquinaThreads.MaquinaGrande;
//import mineradora.Mineradora;
//import operarioThreads.OperarioKg;
//import recurso.DepositoMinerio;
//import recurso.FonteEnergia;
//
///**
// *
// * @author 89087
// */
//public class MenuMineradora {
//
//    private static ArrayList<Operario> operarios = new ArrayList<Operario>();
//    private static ArrayList<Maquina> maquinas = new ArrayList<Maquina>();
//    
//    private static Deposito deposito = new Deposito();
//    private static Fonte   fonte = new Fonte();
//        
//    public static void main(String[] args) {
//     
//        Scanner teclado = new Scanner(System.in);
//        String opcao = "";
//
//        do {
//            System.out.println("\t\t O Escolha uma opçao\n");
//            System.out.println("1-Criar e Remover Maquinas:");
//            System.out.println("2-Criar Remover Operarios:");
//            System.out.println("3-Visualizar a situaçao atual do Deposito e da Fonte:");
//            System.out.println("4-Visualizar uma lista de todos os operarios e maquinas ativos:");
//            System.out.println("5-Visualizar a produtividade e gasto das maquinas ativas no total:");
//            System.out.println("6-Visualizar a produtividade  dos operarios no Total:");
//            System.out.println("7-SAIR!!!");
//
//            System.out.println("Informe a Opção:");
//            opcao = teclado.nextLine();
//          
//               
//         while (opcao=!=7);
//        opcao = Integer.valueOf(JOptionPane.showInputDialog(teclado));
//
//        switch(opcao){
//            case 1:
//                criarMaquinaGrande();
//                break;
//            case 2:
//                criarMaquinaGrande();
//                break;
//            case 3:
//                criarMaquinaGrande();
//                break;
//            case 4:
//                criarMaquinaGrande();
//                break;
//            case 5:
//                criarMaquinaGrande();
//                break;
//            case 6:
//                criarMaquinaGrande();
//                break;
//        }
//
//        }
//    public static void CriarMaquinaGrande(){
//        MaquinaGrande nova = new MaquinaGrande(deposito,fonte);
//        nova.start();
//        maquinas.add(nova);
//    }
//    public  static void CriarMaquinaPequena(){
//        MaquinaPequena nova1 = new MaquinaPequena(deposito,fonte);
//        nova1.start();
//        maquinas.add(nova1);
//    }
//    public static void criarOperarioEnergia(){
//       OperarioEnergia novaOp = new OperarioEnergia(fonte);
//       novaOp.start();
//       operarios.add(novaOp);
//       
//    }
//    
//    public static void criarOperarioKg(){
//        OperarioKg novaKg = new OperarioKg(deposito);
//        novaKg.start();
//        operarios.add(novaKg);
//    }
//    public static void  removerMaquinaGrande(){
//        MaquinaGrande remover = null;
//        
//        for(Maquina m : maquinas){
//            if(m instanceof  MaquinaGrande){
//                remover = (MaquinaGrande) m;
//                remover.stop();
//                
//            }
//        }
//        
//        if (remover != null){
//            maquinas.remove(remover);
//        }else{
//            JOptionPane.showInputDialog(null,"Não existe Operarios")
//        }
//    }
//    public static void visualizar
//    
//}
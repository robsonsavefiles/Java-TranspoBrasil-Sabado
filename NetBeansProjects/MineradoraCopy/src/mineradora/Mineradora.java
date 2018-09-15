package mineradora;

import interfaces.Maquina;
import interfaces.Operario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import repositorios.Deposito;
import repositorios.Fonte;
import threads.MaquinaGrande;
import threads.MaquinaPequena;
import threads.OperarioEnergia;
import threads.OperarioKg;

public class Mineradora {
    
    private static ArrayList<Operario> operarios = new ArrayList<Operario>();
    private static ArrayList<Maquina> maquinas = new ArrayList<Maquina>();
    
    private static Deposito deposito = new Deposito();
    private static Fonte fonte = new Fonte();

    public static void main(String[] args) {
        int opcao = 0;
         String menu = "1 - Criar Máquina grande\n"
                    + "2 - Criar Máquina pequena\n"
                    + "3 - Criar Operário Kg\n"
                    + "4 - Criar Operário Energia\n"
                    + "5 - Remover Máquina grande\n"
                    + "6 - Remover Máquina pequena\n"
                    + "7 - Remover Operário Kg\n"
                    + "8 - Remover Operário Energia\n"
                    + "9 - Visualizar a situação atual do Deposito e da Fonte\n"
                    + "10 - Visualizar uma lista de todos os operários e máquinas ativos\n"
                    + "13 - Sair";
        
        while (opcao != 13) {
           opcao = Integer.valueOf(JOptionPane.showInputDialog(menu));
           
           switch (opcao) {
            case 1:
                criarMaquinaGrande();
                break;
            case 2:
                criarMaquinaPequena();
                break;
            case 3:
                criarOperarioKg();
                break;
            case 4:
                criarOperarioEnergia();
                break;
            case 5:
                removerMaquinaGrande();
                break;
            case 6:
                removerMaquinaPequena();
                break;
            case 7:
                removerOperarioKg();
                break;
            case 8:
                removerOperarioEnergia();
                break;
            case 9:
                visualizarSituacaoDepositoFonte();
                break;
            case 10:
                visualizarOperariosMaquinasAtivos();
                break;               
           }
 
        }
    }
    
    public static void criarMaquinaGrande() {
        MaquinaGrande novaMG = new MaquinaGrande(deposito, fonte);
        novaMG.start();
        maquinas.add(novaMG);
    }
    
    public static void criarMaquinaPequena() {
        MaquinaPequena novaMP = new MaquinaPequena(deposito, fonte);
        novaMP.start();
        maquinas.add(novaMP);
    }
    
    public static void criarOperarioEnergia() {
        OperarioEnergia novoOE = new OperarioEnergia(fonte);
        novoOE.start();
        operarios.add(novoOE);
    }
    
    public static void criarOperarioKg() {
        OperarioKg novoKg = new OperarioKg(deposito);
        novoKg.start();
        operarios.add(novoKg);
    }
    
    public static void removerMaquinaGrande() {
        MaquinaGrande remover = null;
        
        for (Maquina m : maquinas) {
            if (m instanceof MaquinaGrande) {
                remover = (MaquinaGrande) m;
                remover.stop();
                break;
            }
        }
        
        if (remover != null) {
            maquinas.remove(remover);
        } else {
            JOptionPane.showMessageDialog(null, "Não existem máquinas grandes");
        }
    }
    
    public static void removerMaquinaPequena() {
        MaquinaPequena remover = null;
        
        for (Maquina m : maquinas) {
            if (m instanceof MaquinaPequena) {
                remover = (MaquinaPequena) m;
                remover.stop();
                break;
            }
        }
        
        if (remover != null) {
            maquinas.remove(remover);
        } else {
            JOptionPane.showMessageDialog(null, "Não existem máquinas pequenas");
        }
    }
    
    public static void removerOperarioEnergia() {
        OperarioEnergia remover = null;
        
        for (Operario o : operarios) {
            if (o instanceof OperarioEnergia) {
                remover = (OperarioEnergia) o;
                remover.stop();
                break;
            }
        }
        
        if (remover != null) {
            operarios.remove(remover);
        } else {
            JOptionPane.showMessageDialog(null, "Não existem operários de energia");
        }
    }
    
    public static void removerOperarioKg() {
        OperarioKg remover = null;
        
        for (Operario o : operarios) {
            if (o instanceof OperarioKg) {
                remover = (OperarioKg) o;
                remover.stop();
                break;
            }
        }
        
        if (remover != null) {
            operarios.remove(remover);
        } else {
            JOptionPane.showMessageDialog(null, "Não existem operários de kg");
        }
    }

    
    
    private static void visualizarSituacaoDeposito() {
        JOptionPane.showMessageDialog(null,  "Deposito: " + deposito.getQtdKg());
    }
    
    private static void visualizarSituacaoFonte() {
        JOptionPane.showMessageDialog(null, "Fonte: " + fonte.getQtdEnergia());
    }

    public static void visualizarSituacaoDepositoFonte() {
        visualizarSituacaoDeposito();
        visualizarSituacaoFonte();
    }

    private static void visualizarOperariosMaquinasAtivos() {
        int qtdMGrande = 0;
        int qtdMPequena = 0;
        
        int qtdOEnergia = 0;
        int qtdOKg = 0;
        
        for (Maquina m : maquinas) {
            if (m instanceof MaquinaGrande) {
                qtdMGrande++;
            } else if (m instanceof MaquinaPequena) {
                qtdMPequena++;
            }
        }
        
        for (Operario o : operarios) {
            if (o instanceof OperarioEnergia) {
                qtdOEnergia++;
            } else if (o instanceof OperarioKg) {
                qtdOKg++;
            }
        }
        
        String str = "Quantidade: \n"
                + "Maquinas grandes: " + qtdMGrande + "\n"
                + "Maquinas pequenas: " + qtdMPequena + "\n"
                + "Operarios energia: " + qtdOEnergia + "\n"
                + "Operarios Kg: " + qtdOKg + "\n\n--------\n\n"
                
                + "Produtividade: \n"
                + "Maquinas grandes consumo: " + (qtdMGrande * MaquinaGrande.CONSUMO) + "\n"
                + "Maquinas grandes produção: " + (qtdMGrande * MaquinaGrande.PRODUCAO) + "\n\n"
                
                + "Maquinas pequenas consumo: " + (qtdMPequena * MaquinaPequena.CONSUMO) + "\n"
                + "Maquinas pequenas produção: " + (qtdMPequena * MaquinaPequena.PRODUCAO) + "\n\n"
                
                + "Operarios energia: " + (qtdOEnergia * OperarioEnergia.RECARGARREGA) + "\n"
                + "Operarios kg: " +  (qtdOKg * OperarioKg.LIBERA);
        
        JOptionPane.showMessageDialog(null, str);
                
    }
}

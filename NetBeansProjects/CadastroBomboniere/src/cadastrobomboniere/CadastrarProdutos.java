
package cadastrobomboniere;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
//Curso Desenvolvimento De Sistema Java
//Aula Java POO - Programação Orientada a Objetos
//Sistema De Cadastro De Produtos Bomboniere XYZ
public class CadastrarProdutos {
// Cadastro De Produtos: Bomboniere
public static void main(String[] args) {
// Pegando a data atual do sistema
// criamos um locale para o Brasil
Locale localBR = new Locale("pt", "BR");
// vamos obter a data e hora atual
Calendar agora = Calendar.getInstance();
// vamos formatar de acordo com o formato de
// data longa no português brasileiro
DateFormat formatoDeData = DateFormat.getDateInstance(DateFormat.FULL,
localBR);
// vamos exibir o resultado
// Pegas o país
// jlbPais.setText(localeBR.getDisplayCountry());
// Pegas a data
// jlbData.setText(formatoDeData.format(agora.getTime()));
// ********************************************************************
// Declaraçao da variavel menu do tipo integer
int menu = 0;
// Instanciando um novo objeto
// da classe produtos
Produtos novoItem = new Produtos();
do {
menu = Integer.parseInt(JOptionPane.showInputDialog(null,
" Sistema De Cadastro De Produtos: Bomboniere XYZ   \n\n"
+ formatoDeData.format(agora.getTime())
+ "\n\nQual item deseja escolher? "
+ "\n\n1 - Cadastrar Produtos "
+ "\n 2 - Exibir Produtos "
+ "\n 3 - Imprimir Produtos " + "\n 4 - Sair"));
if (menu == 1) {
try {
String codigo = JOptionPane.showInputDialog(null,
" Digite o código do produto: ");
String descricao = JOptionPane.showInputDialog(null,
" Digite o nome do produto: ").toUpperCase();
Double preco = Double.parseDouble(JOptionPane
.showInputDialog(null,
" Digite o preço do produto: "));
// Pega a data do do sistema
String data = JOptionPane.showInputDialog(null,
" Digite a data do cadastro: ",
new SimpleDateFormat("dd/MM/yyyy")
.format(new Date()));
// chamando o metodo
novoItem.cadastrarProdutos(codigo, descricao, preco, data);
} catch (Exception e) {
Toolkit.getDefaultToolkit().beep();
JOptionPane.showMessageDialog(null,
"Um dos dados está incorreto!",
"Cadastro De Produtos: Bomboniere XYZ",
JOptionPane.ERROR_MESSAGE);
}
} else if (menu == 2) {
// chamando o metodo mostrar Produtos
JOptionPane.showMessageDialog(
null,
"Lista do(s) produto(s) cadastrado(s): "
+ new SimpleDateFormat("dd/MM/yyyy")
.format(new Date()) + " \n"
+ novoItem.mostrarProdutos(),
" Cadastro De Produtos: Bomboniere XYZ",
JOptionPane.INFORMATION_MESSAGE);
} else if (menu == 3) {
int imprimir = JOptionPane.showConfirmDialog(null,
"Deseja imprimir produtos cadastrado?",
"Bomboniere XYZ", JOptionPane.OK_CANCEL_OPTION,
JOptionPane.QUESTION_MESSAGE);
if (imprimir == 0) {
// Esse metodo ele apenas salva o arquivo Bomboniere XYZ.txt
// para depois voce imprimir se assim quiser, se quiser usar
// esse comente o metodo novoItem.imprimir(); abaixo e
// descomente esse novoItem.imprimirDados();
// Esse é o metodo que chama a impresora para imprimir os
// dados cadastrados se houver dados cadastrados
// ATENÇAO: ELE IMPRIMI DIRETO SE TIVER IMPRESSORA INSTALADA
novoItem.imprimir();
}
} else if (menu == 4) {
int sair = JOptionPane.showConfirmDialog(null,
"Deseja realmente sair do programa?", "Bomboniere XYZ",
JOptionPane.OK_CANCEL_OPTION,
JOptionPane.QUESTION_MESSAGE);
if (sair == JOptionPane.YES_OPTION) {
System.exit(0);
}
} else if ((menu > 4) || (menu < 1)) {
Toolkit.getDefaultToolkit().beep();
JOptionPane.showMessageDialog(null,
"Por favor escolha uma opção correta \nentre 1 e 4!",
"Cadastro De Produtos: Bomboniere XYZ",
JOptionPane.ERROR_MESSAGE);
}
} while (menu != 0);
System.exit(0);
}
}

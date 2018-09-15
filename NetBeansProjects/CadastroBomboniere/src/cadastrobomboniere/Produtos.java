/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrobomboniere;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
//Cadastro De Produtos: Bomboniere XYZ
public class Produtos {
String dados = "";
ArrayList<Itens> Produtos = new ArrayList<Itens>();
// Metodo para cadastrar os produtos
public void cadastrarProdutos(String codigo, String descricao,
double preco, String data) {
Itens novoProduto = new Itens();
novoProduto.codigo = codigo;
novoProduto.descricao = descricao;
novoProduto.preco = preco;
novoProduto.data = data;
Produtos.add(novoProduto);
JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso.",
"Bomboniere XYZ", JOptionPane.INFORMATION_MESSAGE);
}// Fim do metodo para cadastrar os produtos
// Metodo para mostrar os produtos
public String mostrarProdutos() {
// String dados = "";
for (Itens produtos : Produtos) {
dados += " Código do produto: " + produtos.codigo
+ " Descrição do produto: " + produtos.descricao
+ " Preço do produto: R$: " + produtos.preco
+ " Data do cadastro: " + produtos.data + "\n";
}
return dados;
}// Fim do metodo para mostrar os produtos
// Esse metodo ele apenas salva o arquivo Bomboniere XYZ.txt para depois
// voce imprimir se assim quiser
public void imprimirDados() {
try {
// Abre arquivo para escrita
BufferedWriter texto = new BufferedWriter(new FileWriter(
"Bomboniere XYZ.txt", true));
// passa para a proxima linha
texto.newLine();
// escreve o texto
texto.write("Bomboniere XYZ - Cadastro de produtos: ");
// passa para a proxima linha
texto.newLine();
// escreve o texto
texto.write("===============================================");
// passa para a proxima linha
texto.newLine();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
// escreve a data do sistema
texto.write(sdf.format(new Date()));
// passa para a proxima linha
texto.newLine();
// escreve o texto
// texto.write(" ");
texto.newLine();
// escreve o texto da textarea com quebra de linha no txt
// texto.write(mostrarProdutos().replaceAll("\n", "\r\n"));
for (Itens produtos : Produtos) {
texto.write(("Código do produto: " + produtos.codigo
+ " Descrição do produto: " + produtos.descricao
+ " Preço do produto: R$: " + produtos.preco
+ " Data do cadastro: " + produtos.data + "\n")
.replaceAll("\n", "\r\n"));
}
// passa para a proxima linha
texto.newLine();
// Joga o conteúdo da memória
texto.flush();
// Fecha o arquivo e libera-o
texto.close();
JOptionPane.showMessageDialog(null, "Produto salvo com sucesso.",
"Bomboniere XYZ", JOptionPane.INFORMATION_MESSAGE);
} // fim try
catch (Exception ex) {
Toolkit.getDefaultToolkit().beep();
JOptionPane.showMessageDialog(null, "Erro ao salvar o documento!",
"Cadastro De Produtos: Bomboniere XYZ",
JOptionPane.ERROR_MESSAGE);
} // fim catch
}
// Esse é o método que chama a impressora para imprimir os
// dados cadastrados se houver dados cadastrados
// ATENÇÃO: ELE IMPRIMI DIRETO SE TIVER IMPRESSORA INSTALADA
public void imprimir() {
if (!Produtos.isEmpty()) {
// File arquivo = new
// File("C:/users/aluno/Desktop/Bomboniere.txt");
File arquivo = new File(System.getProperty("user.dir")
+ "Bomboniere XYZ.txt");
PrintWriter imprimir = null;
try {
imprimir = new PrintWriter(arquivo);
imprimir.println("Bomboniere XYZ - Cadastro de produtos: ");
imprimir.println("============================================");
imprimir.println(" ");
SimpleDateFormat sdf = new SimpleDateFormat(
"dd/MM/yyyy HH:mm:ss");
// escreve a data do sistema
imprimir.println(sdf.format(new Date()));
imprimir.println(" ");
for (Itens produtos : Produtos) {
imprimir.println("Código do produto: " + produtos.codigo
+ " Descrição do produto: " + produtos.descricao
+ " Preço do produto: R$: " + produtos.preco
+ " Data do cadastro: " + produtos.data);
}
// imprimir arquivo txt
Desktop.getDesktop().print(arquivo);
} catch (Exception e) {
// tratamento de erros aqui
Toolkit.getDefaultToolkit().beep();
JOptionPane.showMessageDialog(null,
"Erro ao imprimir o documento!",
"Cadastro De Produtos: Bomboniere XYZ",
JOptionPane.ERROR_MESSAGE);
} finally {
if (imprimir != null) {
// Fecha o arquivo txt
imprimir.close();
// Deleta o arquivo criado depois de fechar a aplicação
arquivo.deleteOnExit();
}
}
} else {
Toolkit.getDefaultToolkit().beep();
JOptionPane.showMessageDialog(null, "Não há produtos cadastrados!",
"Cadastro De Produtos: Bomboniere XYZ",
JOptionPane.ERROR_MESSAGE);
}
}
class Itens {
private String codigo;
private String descricao;
private double preco;
private String data;
}
}
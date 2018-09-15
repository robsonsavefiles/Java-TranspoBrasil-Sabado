
package use.acabeca.exercicios;

/**
 *
 * @author Robinho
 */
public class BooksTest {
    public static void main(String[] args) {
        Books [] myBooks = new Books[3];
        int x =0;
        myBooks[0] = new Books();
        myBooks[1] = new Books();
        myBooks[2] = new Books();
        
        myBooks[0].title = "The Grapes of java";
        myBooks[1].title ="The Java Gataby";
        myBooks[2].title ="The Java Cookbook";
        
        myBooks[0].author="Robson ferreira";
        myBooks[1].author="Felipe Oliveira";
        myBooks[2].author="Lane Alves";
        
        while(x <3){
            System.out.print(myBooks[x].title);
            System.out.print(" by ");
            System.out.println(myBooks[x].author);
            x = x+1;
        }
    }
    
}

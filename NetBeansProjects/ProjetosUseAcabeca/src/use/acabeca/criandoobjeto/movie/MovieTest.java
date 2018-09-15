/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//rating - classificaçao

package use.acabeca.criandoobjeto.movie;

/**
 * @author Robinho
 */
public class MovieTest {
    public static void main(String[] args) {
        
        Movie one = new Movie();
        one.title = "Gone with the stock";
        one.genre = "Tragic";
        one.rating = -2;
        one.playIt();
        
        Movie two = new Movie();
        two.title = "Lost in Cubicle Space";
        two.genre = "Comedy";
        two.rating = 5;
        two.playIt();
        
        Movie three = new Movie();
        three.title ="Byte Club";
        three.title = "Tragic but ultimately uplifting";
        three.rating = 127;
        three.playIt();
        
        
   
        
    }
    
}

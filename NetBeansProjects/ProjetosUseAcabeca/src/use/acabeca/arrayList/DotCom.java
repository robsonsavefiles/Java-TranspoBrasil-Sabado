/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package use.acabeca.arrayList;

import java.util.ArrayList;

/**
 *
 * @author Robinho
 */
public class DotCom {

    private ArrayList<String> locationCells;
    private String name;

    //private int numOfHits;
    //não precisamos disso agora
    public void setLocationsCells(ArrayList<String> loc) {
        locationCells = loc;
    }
    
    public void setName(String n){
        name = n;
    }

    public String checkYourSelf(String userInput) {
        String result = "errado";

        int index = locationCells.indexOf(userInput);

        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "eliminar";
                
                System.out.println("Ora!!, Você afundou "+name+":(");
            } else {
                result = "correto";

            }//encerra if
        }// encerra a instruçao if externa
        return result;
    }//encerra o método
}//encerra a classe
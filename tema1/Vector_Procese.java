/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

/**
 *
 * @author Cristi
 * @version 1.0
 */
public class Vector_Procese {
    
/**
 * Aceasta este clasa in care imi declar un vector de procese.
 */
    Procese[] myList;
    int n, elem = 0;

/**
 * 
 * @param n numarul maxim de numere ce vor fi procesate
 */
    public Vector_Procese(int n) {
        this.n = n;
        myList = new Procese[n];
    }
    
/**
 * Metoda adauga in vector procesul corespunzator.
 * @param proc procesul ce va fi adaugat
 */
    public void adaugare(Procese proc){
        myList[elem] = proc;
        elem++;
    }
    
/**
 * Aceasta metoda apeleaza pentru fiecare proces metoda de afisare a acestuia. 
 * Asa se realizeaza practic afisarea.
 */
    public void displayAll(){
        for (int i = 0; i < elem; i++)
            myList[i].display();
    }
   
}

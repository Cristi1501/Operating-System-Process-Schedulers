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
public abstract class Procese {

/**
 * Aceasta este clasa abstracta de procese.
 */
    public Procese() {
    }
    
/**
 * Metoda proces este executata in fiecare dintre cele 7 procese si returneaza
 * un rezultat de tip "int" in functie de cerinta procesului respectiv. 
 * @return int numar in functie de proces
 */
    abstract int proces();
/**
 * Metoda display este executata in fiecare dintre cele 7 procese si afiseaza
 * numarul, procesul, rezultatul si modul cum a fost obtinut acesta (Computed/
 * FromCache).
 */
    abstract void display();
}

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
public class Cube extends Procese{
/**
 * Aceasta este clasa corespunzatoare procesului Cube.
 */
    int n;
    HomeworkWriter fout;
    boolean exista;
/**
 * 
 * @param n numarul ce trebuie procesat
 * @param fout pointer catre fisierul de iesire (unde se realizeaza afisarea)
 * @param exista parametru folosit pentru a verifica daca n-a mai fost vreodata
 * apelat pe acest proces
 */
    public Cube(int n, HomeworkWriter fout, boolean exista) {
        this.n = n;
        this.fout = fout;
        this.exista = exista;
    }
    
/**
 * 
 * @return int numarul la puterea a 3a
 */
    @Override
    int proces() {
        return n*n*n;
    }

/**
 * Metoda afiseaza numarul, procesul, rezultatul si modul cum a fost obtinut
 * acesta (Computed/FromCache).
 */
    @Override
    void display() {
        String sir;
        if (exista)
            sir = "FromCache";
        else
            sir = "Computed";
        fout.println(n + " Cube " + proces() + " " + sir);
    }
    
}

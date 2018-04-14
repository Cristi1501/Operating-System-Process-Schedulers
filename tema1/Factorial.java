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
public class Factorial extends Procese{
/**
 * Aceasta este clasa corespunzatoare procesului Factorial.
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
    public Factorial(int n, HomeworkWriter fout, boolean exista) {
        this.n = n;
        this.fout = fout;
        this.exista = exista;
    }

/**
 * 
 * @return int factorialul numarului modulo 9973
 */
    @Override
    int proces() {
        if (n < 0)
            return 0;
        if (n == 0 || n == 1)
            return 1;
        
        int produs = 1;
        for (int i = 2; i <= n; i++){
            produs *= i;
            produs %= 9973;
        }
        
        return produs;
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
        fout.println(n + " Factorial " + proces() + " " + sir);
    }
    
}

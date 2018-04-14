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
public class Fibonacci extends Procese{
/**
 * Aceasta este clasa corespunzatoare procesului Fibonacci.
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
    public Fibonacci(int n, HomeworkWriter fout, boolean exista) {
        this.n = n;
        this.fout = fout;
        this.exista = exista;
    }
    
/**
 * 
 * @return int al n-lea numar din sirul Fibonacci modulo 9973
 */
    @Override
    int proces() {
        if (n < 0)
            return -1;
        if (n == 0 || n == 1)
            return n;
        if (n == 2)
            return 1;
        
        int i = 1, j = 1, aux, count;
        for (count = 3; count <= n; count++){
            aux = j;
            j += i;
            i = aux;
            
            i %= 9973;
            j %= 9973;
        }
        return j;
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
        fout.println(n + " Fibonacci " + proces() + " " + sir);
    }
    
}

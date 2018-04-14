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
public class NextPrime extends Procese{
/**
 * Aceasta este clasa corespunzatoare procesului NextPrime.
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
    public NextPrime(int n, HomeworkWriter fout, boolean exista) {
        this.n = n;
        this.fout = fout;
        this.exista = exista;
    }
    
/**
 * 
 * @return int urmatorul numar prim dupa n
 */
    @Override
    int proces(){
        if (n < 2)
            return 2;
        
        int i;
        while(true){
            n++;
            for (i = 2; i <= n/2; i++)
                if (n % i == 0)
                    break;
            if (i > n/2)
                return n;
        }
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
        fout.println(n + " NextPrime " + proces() + " " + sir);
    }
}

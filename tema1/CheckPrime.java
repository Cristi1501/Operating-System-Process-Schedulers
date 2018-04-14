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
public class CheckPrime extends Procese{
/**
 * Aceasta este clasa corespunzatoare procesului CheckPrime.
 */
    int n;
    HomeworkWriter fout;
    boolean exista;

/**
 * 
 * @param n numarul ce trebuie procesat (verificat daca e prim sau nu)
 * @param fout pointer catre fisierul de iesire (unde se realizeaza afisarea)
 * @param exista parametru folosit pentru a verifica daca n-a mai fost vreodata
 * apelat pe acest proces
 */
    public CheckPrime(int n, HomeworkWriter fout, boolean exista) {
        this.n = n;
        this.fout = fout;
        this.exista = exista;
    }
    
/**
 * Metoda verifica daca numarul este prim.
 * @return int 1/0 (true or false)
 */
    @Override
    int proces(){
        if (n < 2)
            return 0;
        
        for (int i = 2; i <= n/2; i++)
            if (n % i == 0)
                return 0;
        return 1;
    }

/**
 * Metoda afiseaza numarul, procesul, rezultatul si modul cum a fost obtinut
 * acesta (Computed/FromCache).
 */
    @Override
    void display(){
        String sir;
        if (exista)
            sir = "FromCache";
        else
            sir = "Computed";
        fout.println(n + " CheckPrime " + proces() + " " + sir);
    }
}

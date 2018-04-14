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
public class Sqrt extends Procese{
/**
 * Aceasta este clasa corespunzatoare procesului Sqrt.
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
    public Sqrt(int n, HomeworkWriter fout, boolean exista) {
        this.n = n;
        this.fout = fout;
        this.exista = exista;
    }
    
/**
 * 
 * @return int partea intreaga a radicalului numarului
 */
    @Override
    int proces(){
        if (n < 0)
            n *= -1;
        
        double x = Math.sqrt(n);
        
        return (int)x;
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
        fout.println(n + " Sqrt " + proces() + " " + sir);
    }
}

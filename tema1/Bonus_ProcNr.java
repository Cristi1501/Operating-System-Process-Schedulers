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
public class Bonus_ProcNr {
/**
 * Am creat aceasta clasa in scopul obtinerii unei structuri (echivalente in
 * C/C++). Aceasta ma ajuta in realizarea bonusului deoarece memoreaza
 * numarul procesat, tipul procesului si frecventa cu care cele mentionate 
 * anterior au fost apelate. Campul "folosire" ma ajuta in implementarea
 * ambelor cazurilor (LruCache si LfuCache).
 */
    int nr = 0;
    String tip_proces = "";
    int folosire = 0;

    public Bonus_ProcNr() {
    }

    public int getNr() {
        return nr;
    }

    public String getTip_proces() {
        return tip_proces;
    }

    public int getFolosire() {
        return folosire;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public void setTip_proces(String tip_proces) {
        this.tip_proces = tip_proces;
    }

    public void setFolosire(int folosire) {
        this.folosire = folosire;
    }
    
    
}

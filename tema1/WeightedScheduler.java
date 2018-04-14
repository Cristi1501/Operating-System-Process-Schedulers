/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristi
 * @version 1.0
 */
public class WeightedScheduler implements Planificari{
    
/**
 * Aceasta este clasa planificarii Weighted.
 */
    ProblemData result;
    HomeworkWriter fout;

/**
 * 
 * @param result datale citite din fisierul de intrare
 * @param fout pointer la fisierul de iesire
 */
    public WeightedScheduler(ProblemData result, HomeworkWriter fout) {
        this.result = result;
        this.fout = fout;
    }
    
/**
 * 
 * @param a un numar
 * @param b alt numar
 * @return int cel mai mare divizor comun dintre a si b
 */
    public int cmmdc(int a, int b){
        int t;
        while (b != 0){
            t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
    
/**
 * Aceasta metoda parcurge toate numerele citite si executa un proces astfel 
 * incat cerinta din enuntul temei sa fie respectata. Declar un vector de 
 * dimensiunea cache-ului si il folosesc doar in cazul bonusului. Parcurg 
 * numerele pe rand, imi pun in variabile scurte numele/valorile unora dintre 
 * elemente, verific daca sunt in cazul bonusului si fac modificarile aferente, 
 * iar apoi pentru a evita scrierea a 7 if-uri imi creez o instanta in functie 
 * de numele procesului (am aflat clasa, apoi am apelat constructorul si am 
 * obtinut instanta) pe care o adaug in vector. La final apelez metoda de 
 * afisare a tuturor actiunilor realizate.
 * @param verif_bonus verifica tipul bonusului
 * @throws NoSuchMethodException
 * @throws IllegalAccessException
 * @throws IllegalArgumentException
 * @throws InvocationTargetException 
 */
    @Override
    public void generare(int verif_bonus) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        int i, j, k, repetare, c = 0, suma = 0;
        Vector_Procese vector = new Vector_Procese(result.getNumbersToBeProcessed().length);
        
        Bonus_ProcNr[] bonus;
        bonus = new Bonus_ProcNr[result.getCacheCapacity()];
        int t, index = 0;
        
        for (i = 0; i < result.getProcesses().length; i++){
            suma += result.getProcesses()[i].getWeight();
            if (i == 0)
                c = suma;
            else
                c = cmmdc(c, result.getProcesses()[i].getWeight());
        }
        
        i = 0;
        while(i < result.getNumbersToBeProcessed().length){ 
            for (j = 0; j < result.getProcesses().length; j++){
                repetare = result.getProcesses()[j].getWeight();
                for (k = 0; k < repetare/c; k++){
                    int numar = result.getNumbersToBeProcessed()[i];
                    String tip_proces = result.getProcesses()[j].getType();
                    String nume_clasa = "tema1." + tip_proces;
                    boolean exista = false;
                    
                    if (verif_bonus == 1){
                        for (t = 0; t < index; t++)
                            if (bonus[t].getNr() == numar && bonus[t].getTip_proces().equals(tip_proces)){
                                bonus[t].setFolosire(bonus[t].getFolosire() + 1);
                                exista = true;
                                break;
                            }

                        if (!exista && index == result.getCacheCapacity()){
                            int min = bonus[0].getFolosire(), index_min = 0;
                            for (t = 1; t < index; t++)
                                if (min > bonus[t].getFolosire()){
                                    min = bonus[t].getFolosire();
                                    index_min = t;
                                }
                            if (index_min == index-1)
                                index--;
                            else{
                                index--;
                                for (t = index_min; t < index; t++)
                                    bonus[t] = bonus[t+1];
                            }            
                        }

                        if(!exista){
                            bonus[index] = new Bonus_ProcNr();
                            bonus[index].setFolosire(1);
                            bonus[index].setNr(numar);
                            bonus[index].setTip_proces(tip_proces);
                            index++;
                        }
                    }
                    
                    if (verif_bonus == 2){
                        for (t = 0; t < index; t++)
                            if (bonus[t].getNr() == numar && bonus[t].getTip_proces().equals(tip_proces)){
                                bonus[t].setFolosire(i);
                                exista = true;
                                break;
                            }
                        
                        if (!exista && index == result.getCacheCapacity()){
                            int min = bonus[0].getFolosire(), index_min = 0;
                            for (t = 1; t < index; t++)
                                if (min > bonus[t].getFolosire()){
                                    min = bonus[t].getFolosire();
                                    index_min = t;
                                }
                            index--;
                            for (t = index_min; t < index; t++)
                                bonus[t] = bonus[t+1];
                        }
                
                        if (!exista){
                            bonus[index] = new Bonus_ProcNr();
                            bonus[index].setFolosire(i);
                            bonus[index].setNr(numar);
                            bonus[index].setTip_proces(tip_proces);
                            index++;
                        }
                    }
                    
                    try {
                        Class<?> myClass = Class.forName(nume_clasa);
                        Constructor<?> constructor = myClass.getConstructor(int.class, HomeworkWriter.class, boolean.class);
                        Object instance = constructor.newInstance(numar, fout, exista);
                        vector.adaugare((Procese) instance);
                        } catch (ClassNotFoundException | InstantiationException ex) {
                        Logger.getLogger(RandomScheduler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    i++;
                    if (i == result.getNumbersToBeProcessed().length)
                    	break;
                }
                if (i == result.getNumbersToBeProcessed().length)
                	break;
            }
            if (i == result.getNumbersToBeProcessed().length)
            	break;
        }
        
        vector.displayAll();
    }
}

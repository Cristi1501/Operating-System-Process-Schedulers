/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristi
 * @version 1.0
 */
public class RandomScheduler implements Planificari{
    
/**
 * Aceasta este clasa planificarii Random.
 */
    ProblemData result;
    HomeworkWriter fout;
    
/**
 * 
 * @param result datale citite din fisierul de intrare
 * @param fout pointer la fisierul de iesire
 */
    public RandomScheduler(ProblemData result, HomeworkWriter fout) {
        this.result = result;
        this.fout = fout;
    }

/**
 * Aceasta metoda parcurge toate numerele citite si executa un proces la 
 * intamplare pe fiecare dintre acestea. Declar un vector de dimensiunea 
 * cache-ului si il folosesc doar in cazul bonusului. Parcurg numerele pe rand, 
 * imi pun in variabile scurte numele/valorile unora dintre elemente, verific
 * daca sunt in cazul bonusului si fac modificarile aferente, iar apoi pentru a 
 * evita scrierea a 7 if-uri imi creez o instanta in functie de numele 
 * procesului (am aflat clasa, apoi am apelat constructorul si am obtinut 
 * instanta) pe care o adaug in vector. La final apelez metoda de afisare a
 * tuturor actiunilor realizate.
 * @param verif_bonus verifica tipul bonusului
 * @throws NoSuchMethodException
 * @throws IllegalAccessException
 * @throws IllegalArgumentException
 * @throws InvocationTargetException 
 */
    @Override
    public void generare(int verif_bonus) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        
        Random nr_proces = new Random();
        Vector_Procese vector = new Vector_Procese(result.getNumbersToBeProcessed().length);
        
        Bonus_ProcNr[] bonus;
        bonus = new Bonus_ProcNr[result.getCacheCapacity()];
        int j, index = 0;
    
        for (int i = 0; i < result.getNumbersToBeProcessed().length; i++){
            
            int n = nr_proces.nextInt(result.getProcesses().length);
            int numar = result.getNumbersToBeProcessed()[i];
            String tip_proces = result.getProcesses()[n].getType();
            String nume_clasa = "tema1." + tip_proces;
            boolean exista = false;
            
            if (verif_bonus == 1){
                for (j = 0; j < index; j++)
                    if (bonus[j].getNr() == numar && bonus[j].getTip_proces().equals(tip_proces)){
                        bonus[j].setFolosire(bonus[j].getFolosire() + 1);
                        exista = true;
                        break;
                    }

                if (!exista && index == result.getCacheCapacity()){
                    int min = bonus[0].getFolosire(), index_min = 0;
                    for (j = 1; j < index; j++)
                        if (min > bonus[j].getFolosire()){
                            min = bonus[j].getFolosire();
                            index_min = j;
                        }
                    if (index_min == index-1)
                        index--;
                    else{
                        index--;
                        for (j = index_min; j < index; j++)
                            bonus[j] = bonus[j+1];
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
                for (j = 0; j < index; j++)
                    if (bonus[j].getNr() == numar && bonus[j].getTip_proces().equals(tip_proces)){
                        bonus[j].setFolosire(i);
                        exista = true;
                        break;
                    }
                
                if (!exista && index == result.getCacheCapacity()){
                    int min = bonus[0].getFolosire(), index_min = 0;
                    for (j = 1; j < index; j++)
                        if (min > bonus[j].getFolosire()){
                            min = bonus[j].getFolosire();
                            index_min = j;
                        }
                    index--;
                    for (j = index_min; j < index; j++)
                        bonus[j] = bonus[j+1];
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
            
        }
        
        vector.displayAll();
    }
}

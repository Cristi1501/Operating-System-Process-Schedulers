/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author Cristi
 * @version 1.0
 */
public interface Planificari {
/**
 * Metoda generare este executata in fiecare dintre cele 3 planificari.
 * @param verif_bonus verifica daca datele de intrare necesita o rezolvare
 * NoCache(0), LfuCache(1) sau LruCache(2)
 * @throws NoSuchMethodException
 * @throws IllegalAccessException
 * @throws IllegalArgumentException
 * @throws InvocationTargetException 
 */
    void generare(int verif_bonus)throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}

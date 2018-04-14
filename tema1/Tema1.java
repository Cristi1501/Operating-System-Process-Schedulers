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
public class Tema1 {

/**
 * 
 * Folosesc fisierele primite si citesc datele problemei, iar apoi verific in
 * care caz ma regasesc. Creez un obiect de tipul respectiv si apelez metoda 
 * de generare a output-ului.
 * @param args argumentele liniei de comanda
 * @throws NoSuchMethodException
 * @throws IllegalAccessException
 * @throws IllegalArgumentException
 * @throws InvocationTargetException 
 */
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // TODO code application logic here
        HomeworkReader fin = new HomeworkReader(args[0]);
        HomeworkWriter fout = new HomeworkWriter(args[1]);
        ProblemData result = fin.readData();
        fin.close();
        
        if ("NoCache".equals(result.getCacheType())){
            if ("RandomScheduler".equals(result.getSchedulerType())){
                RandomScheduler plan = new RandomScheduler(result, fout);
                plan.generare(0);
            }
            
            if ("RoundRobinScheduler".equals(result.getSchedulerType())){
                RoundRobinScheduler plan = new RoundRobinScheduler(result, fout);
                plan.generare(0);
            }
            
            if ("WeightedScheduler".equals(result.getSchedulerType())){
                WeightedScheduler plan = new WeightedScheduler(result, fout);
                plan.generare(0);
            }
        }
        if ("LfuCache".equals(result.getCacheType())){
            if ("RandomScheduler".equals(result.getSchedulerType())){
                RandomScheduler plan = new RandomScheduler(result, fout);
                plan.generare(1);
            }
            
            if ("RoundRobinScheduler".equals(result.getSchedulerType())){
                RoundRobinScheduler plan = new RoundRobinScheduler(result, fout);
                plan.generare(1);
            }
            
            if ("WeightedScheduler".equals(result.getSchedulerType())){
                WeightedScheduler plan = new WeightedScheduler(result, fout);
                plan.generare(1);
            }
        }
        	
        if ("LruCache".equals(result.getCacheType())){
            if ("RandomScheduler".equals(result.getSchedulerType())){
                RandomScheduler plan = new RandomScheduler(result, fout);
                plan.generare(2);
            }
            
            if ("RoundRobinScheduler".equals(result.getSchedulerType())){
                RoundRobinScheduler plan = new RoundRobinScheduler(result, fout);
                plan.generare(2);
            }
            
            if ("WeightedScheduler".equals(result.getSchedulerType())){
                WeightedScheduler plan = new WeightedScheduler(result, fout);
                plan.generare(2);
            }      
        }
             
        fout.close();
    }
    
}

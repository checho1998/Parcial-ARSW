package edu.eci.arsw.primefinder;

import edu.eci.arsw.mouseutils.MouseMovementMonitor;
import edu.eci.arsw.mouseutils.MouseMovementMonitorExample;
import java.io.IOException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import sun.management.Agent;

public class PrimesFinderTool {

	public static void main(String[] args) throws InterruptedException {
		            
            int maxPrim = 1000;
            List<Thread> hilos = new LinkedList<>();
            
            PrimesResultSet prs = new PrimesResultSet("john");
            
            PrimeFinderHilo h1,h2,h3,h4;
            h1 = new PrimeFinderHilo(new BigInteger("1"), new BigInteger("250"), prs);
            h2 = new PrimeFinderHilo(new BigInteger("250"), new BigInteger("500"), prs);
            h3 = new PrimeFinderHilo(new BigInteger("500"), new BigInteger("750"), prs);
            h4 = new PrimeFinderHilo(new BigInteger("750"), new BigInteger("1000"), prs);
            h1.start();
            
            h2.start();
            
            h3.start();
            
            h4.start();
            
            /**h1.join();
            h2.join();
            h3.join();
            h4.join();*/
            boolean flag = false;
            for (int i=0;i<100;i++){
                //System.out.println("tiempo transcurrido desde el último movimiento de mouse:");
                System.out.println("Prime numbers found:");
                System.out.println(i+"  Perra  "+flag);
                 System.out.println(prs.getPrimes());
                //System.out.println(MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement());
               
                System.out.println( h1.isAlive());
                if(MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement()>10000){
                    if(!flag){
			h1.suspend();
                        h2.suspend();
                        h3.suspend();
                        h4.suspend();
                        flag = true;
                    }
                }
                else{
                    if (flag ){
                        h1.resume();
                        h2.resume();
                        h3.resume();
                        h4.resume();
                        flag = false;
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MouseMovementMonitorExample.class.getName()).log(Level.SEVERE, null, ex);
                }
        }



            //PrimeFinder.findPrimes(new BigInteger("1"), new BigInteger("10"), prs);
            //PrimeFinder.findPrimes(new BigInteger("2500"), new BigInteger("5000"), prs);
            //PrimeFinder.findPrimes(new BigInteger("5000"), new BigInteger("7500"), prs);
            //PrimeFinder.findPrimes(new BigInteger("7500"), new BigInteger("10000"), prs);
            
            
            
            
            /*while(task_not_finished){
                try {
                    //check every 10ms if the idle status (10 seconds without mouse
                    //activity) was reached. 
                    Thread.sleep(10);
                    if (MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement()>10000){
                        System.out.println("Idle CPU ");
                    }
                    else{
                        System.out.println("User working again!");
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(PrimesFinderTool.class.getName()).log(Level.SEVERE, null, ex);
                }
            }*/
                        
            
            
            
            
	}
	
}



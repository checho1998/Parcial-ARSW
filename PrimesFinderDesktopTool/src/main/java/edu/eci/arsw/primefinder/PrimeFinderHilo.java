/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.primefinder;

import java.math.BigInteger;

/**
 *
 * @author 2130267
 */
public class PrimeFinderHilo extends Thread {
    BigInteger x;
    BigInteger y;
    PrimesResultSet prs;
    public PrimeFinderHilo(BigInteger x, BigInteger y,PrimesResultSet prs) {
		super();
		this.x = x;
		this.y = y;
                this.prs= prs;
	}
    
    @Override
    public void run() {
        
        System.out.println("lola");
    	PrimeFinder.findPrimes(x, y, prs);
        
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dijkrosoft.snippets.testjpacascading.portfolio;

/**
 *
 * @author dick
 */
public class Printer {
  
    public static void print(Pf pf2) {
    System.out.println("pf "+ pf2);
    System.out.println("aantal tds " + pf2.getPfTdList());
    for ( PfTd td : pf2.getPfTdList()) {
      System.out.println("td: " + td);
    }
  }
}

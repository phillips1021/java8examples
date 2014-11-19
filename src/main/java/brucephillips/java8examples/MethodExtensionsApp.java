/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucephillips.java8examples;

/**
 * See: http://winterbe.com/posts/2014/03/16/java-8-tutorial/
 * @author brucephillips
 */
public class MethodExtensionsApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        System.out.println(formula.calculate(100) );     // 100.0
        System.out.println(formula.sqrt(16) );           // 4.0

    }

}

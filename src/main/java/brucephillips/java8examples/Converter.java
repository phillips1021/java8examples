/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucephillips.java8examples;

/**
 *
 * @author brucephillips
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}


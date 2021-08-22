package site.wtfu.framework

import org.junit.Test;

/**
 *
 * Copyright 2021 wtfu.site Inc. All Rights Reserved.
 *
 * @author: 12302
 * @date: 2021-08-22
 *
 */
class Gvariable {
    static void main(String[] args) {

    }

    @Test
    void variableDemo(){
        def i = 10
        def str = "hello groovy"
        def str2 = 'single quote'
        def d = 1.25

        //println (i,str,str2,d)
        println String.format("%d,%s,%s,%f",i,str,str2,d)
        println i.getClass().getCanonicalName()
    }

    @Test
    void funDemo(){
        println showName()
        println showName2()
    }
    def showName(){
        'hello world'
    }
    String showName2(){
        def name = "xhsgg12302@gmail.com"
        "$name"
    }
}

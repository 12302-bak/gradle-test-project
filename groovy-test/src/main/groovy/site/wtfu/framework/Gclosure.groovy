package site.wtfu.framework

import org.junit.Test;

/**
 *
 * Copyright 2021 wtfu.site Inc. All Rights Reserved.
 *
 * @author: 12302
 * @date: 2021-08-23
 *
 */
class Gclosure {

    static void main(String[] args) {
        /* call error, not static */
        //cls('hello')
    }

    @Test
    void testClosure(){
        cls 'hello'
        cls('world')
        cls.call 'xhsgg12302@126.com'

        cls2('demo',12)

        fun({println 'this is closure'})
        fun { println 'this is no quote closure'}

        fun2 22, { println "$it" }
    }

    def cls = {
        params ->
            println params
    }

    def cls2 = {
        String p1, int p2 ->
            println String.format("$p1,$p2")
    }

    def fun(Closure closure){
        //call closure
        closure()
    }

    def fun2(int a , Closure closure){
        //closure(a,a,a)
        closure(a)
    }
}

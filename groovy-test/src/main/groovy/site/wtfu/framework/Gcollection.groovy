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
class Gcollection {
    static void main(String[] args) {

    }

    @Test
    void testList(){
        def myList = [5,'hello',true]
        myList.add(1.25)
        /* java.lang.IndexOutOfBoundsException: Index: 12, Size: 4 */
        //myList.add(12,55)
        myList[6] = true
        myList << 'world'
        println myList.size()
        println '==================='
        myList.forEach( e -> print "$e \t")
        /* 没有参数的时候要加括号 */
        println()
        myList.each { print "$it \t"}

        println()
        myList.eachWithIndex { Serializable entry, int i ->
            println "$i:$entry"
        }
    }

    @Test
    void testMap() {
        def map = ['key1': true, name: "str2", 3: "str3", 4: "str4"]
        println map.name
        println map.get(4)
        map.age = 15
        println map.age
        println map.getClass().getCanonicalName()

        map.forEach((k, v) -> println "$k:$v")
        map.each { println "$it.key,$it.value" }
        map.eachWithIndex { Map.Entry<Serializable, Serializable> entry, int i -> println "$i- name:$entry.key value:$entry.value" }

        println map.containsKey('key1')
        println map.containsValue(15)

        def rst = map.find { it.value instanceof String }
        def rstAll = map.findAll { it.value instanceof String }

        map.clear()
        println map.size()
    }

    @Test
    void testRange(){
        def range = 1..10
        println range.contains(10)
        println range.from + '---' + range.to
        def range2 = 1..<10
        println range2.contains(10)
        println range2.from + '---' + range2.to
        for ( i in 1..10) {
            print "$i \t"
        }
        println()

        (1..<10).each {print "$it \t"}
        println()

        def years = 23
        def interestRate
        switch (years) {
            case 1..10 : interestRate = 0.076; break;
            case 11..25 : interestRate = 0.052; break;
            default: interestRate = 0.037;
        }
        println interestRate
    }
}

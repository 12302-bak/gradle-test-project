package site.wtfu.framework

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.xml.XmlSlurper
import org.junit.Test;

/**
 *
 * Copyright 2021 wtfu.site Inc. All Rights Reserved.
 *
 * @author: 12302
 * @date: 2021-08-23
 *
 */
class Gfile {

    static void main(String[] args) {

    }

    @Test
    void testFile(){
        def path = Gfile.getClassLoader().getResource('in.txt')
        //def file = new File('classpath:/in.txt')
        def file = new File(path.getFile())
        file.eachLine('UTF-8') { println "$it"}
        println()

        def bytes = file.getBytes()
        file.withInputStream { ins -> /* operation  */ }

        // * 此处指的是类路径 也就是out
        def outPath = file.getParent() + '/out.txt'
        new File(outPath).withOutputStream { os -> os << bytes }

        // 追行写入
        /*new File(outPath).withWriter('UTF-8') {
            writer ->
                writer.writeLine 'i'
                writer.writeLine 'am'
                writer.writeLine 'elizabeth'
        }*/

        //new File(outPath) << ''' i love groovy'''

    }

    @Test
    void testXml(){
        def path = Gfile.getClassLoader().getResource('test.xml')
        def xmlPath = new File(path.getFile())
        def result = new XmlSlurper().parse(xmlPath)

        // 没有泛型支撑，强取也是可行的
        def p0 = result.value.persons.person[0]
        println p0['@id']
        println p0.name
        println p0.age
    }

    @Test
    void testJson(){
        //序列化
        def p = new Person( first: 'eli', last: 'maupassant', age: 12)
        def json = new JsonOutput().toJson(p)
        println json
        println new JsonOutput().prettyPrint(json)

        //反序列化
        def  result = new JsonSlurper().parseText(json)
        println("result is map ${result instanceof Map}")
    }

    class Person{
        def first
        def last
        def age
    }
}

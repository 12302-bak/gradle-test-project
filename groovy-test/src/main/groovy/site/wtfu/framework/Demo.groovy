package site.wtfu.framework

import org.junit.Test

/**
 * groovy demo
 */
class Demo {

    static void main(String[] args) {

        println 'hello world'

    }

    @Test
    void test() {
        print 'xhsgg12302@126.com'
    }

    @Test
    void testJavaFlag() {
        flag:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("outloopByBreakLikeGoto==j==" + j);
                if (j == 2) continue flag;
            }
            System.out.println("outloopByBreakLikeGoto==i====>>>" + i);
        }
        System.out.println("outloopByBreakLikeGoto======>>>END");
    }
}

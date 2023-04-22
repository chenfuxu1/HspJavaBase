package chapter13.biginteger;

import java.math.BigInteger;

public class BigInteger_ {
    public static void main(String[] args) {
        // 当我们编程中，需要处理很大的整数，long 不够用
        // 可以使用 BigInteger 的类来搞定
        // long l = 21414234233334234234234; // 超出范围
        // 用大数
        BigInteger bigInteger1 = new BigInteger("23442352355555555555555542342342342");
        BigInteger bigInteger2 = new BigInteger("54353333333333333355552342342342342342");
        System.out.println("bigInteger1     = " + bigInteger1);

        // 对BigInteger加减乘除时，必须两个都是BigInteger类型的数据，才能运算
        // 加 add
        BigInteger b3 = new BigInteger("2");
        BigInteger add = bigInteger1.add(b3);
        System.out.println("bigInteger1 + 2 = " + add);

        // 减 subtract
        BigInteger subtract = bigInteger1.subtract(b3);
        System.out.println("bigInteger1 - 2 = " + subtract);

        // 乘 multiply
        BigInteger multiply = bigInteger1.multiply(b3);
        System.out.println("bigInteger1 * 2 = " + multiply);

        // 除 divide
        BigInteger divide = bigInteger1.divide(b3);
        System.out.println("bigInteger1 / 2 = " + divide);
    }
}

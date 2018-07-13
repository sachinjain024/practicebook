package practice;

import java.util.Arrays;

/**
 * Created by sacjain on 13/07/18.
 */
public class ArrayFillTimeTest {
    public static void main(String[] args) {
        Long t1 = System.currentTimeMillis();
        System.out.println("t1 = " + t1);

        char[] chars = new char[12288];
        Arrays.fill(chars, 'a');
        String value = new String(chars);

        Long t2 = System.currentTimeMillis();
        System.out.println("t2 = " + t2);

        System.out.println(t2 - t1);
    }
}

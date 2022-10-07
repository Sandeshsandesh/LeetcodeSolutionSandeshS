package com.sign.problems.math.MultiplyStrings_43;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PrintStreamExample {
    public String multiply(String num1, String num2) {
        int n1=0 ,n2=0;

        for ( int i = 0; i < num1.length(); i++ ){
            int digit = num1.charAt(i) - 48;
            n1 = n1*10 + digit;
        }
        for ( int i = 0; i < num2.length(); i++ ){
            int digit = num2.charAt(i) - 48;
            n2 = n2*10 + digit;
        }
        System.out.println(n1+ " "+ n2);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos, true);
        System.setOut(ps);
        System.out.print(n1*n2);
        return baos.toString();
    }
}

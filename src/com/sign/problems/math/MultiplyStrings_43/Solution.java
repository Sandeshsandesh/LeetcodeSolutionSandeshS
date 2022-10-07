package com.sign.problems.math.MultiplyStrings_43;


/*
* Sandesh S 29-May-2019
*
* O(n2) Traditional multiplication
*
* Beats 100% in memory consumption
*
* */

import java.util.Arrays;

class Solution {
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length()+num2.length()];
        Arrays.fill(result, 0);
        int resultIndex = result.length-1;

        if (num1.length() == 1 && num1.charAt(0) == '0')
            return "0";

        if (num2.length() == 1 && num2.charAt(0) == '0')
            return "0";

        for (int i=num2.length()-1; i>=0; i--) {
            int k = resultIndex;
            int iValue = num2.charAt(i)-48;
            int carry=0;

            for (int j=num1.length()-1; j>=0; j--) {
                int jValue = num1.charAt(j)-48;
                int product = (iValue*jValue) + carry + result[k];
                result[k] = product % 10;
                carry = product / 10;
                k--;
            }
            resultIndex--;

            if (carry != 0)
                result[k] = carry;
        }

        String finalResult = Arrays.toString(result).replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
        if (result[0] != 0)
            return finalResult;
        else
            return finalResult.substring(1);
    }
}
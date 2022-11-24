package com.sign.problems.grind75.g20AddBinary_67;

public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return null;
        }

        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return a;
        }

        int i = a.length() - 1;
        int j = b.length() - 1;

        int k = Math.max(a.length(), b.length()) + 1;
        char[] res = new char[k];
        k--;
        char carry = '0';
        while (i >= 0 || j >= 0) {
            char ai;
            char bj;
            if (i < 0) {
                ai = '0';
            } else {
                ai = a.charAt(i);
            }
            if (j< 0) {
                bj = '0';
            } else {
                bj = b.charAt(j);
            }
            if (ai == '0' && bj == '0') {
                if (carry == '0') {
                    res[k] = '0';
                } else {
                    res[k] = '1';
                }
                carry = '0';
            } else if ((ai == '0' && bj == '1') || (ai == '1' && bj == '0')) {
                if (carry == '0') {
                    res[k] = '1';
                    carry = '0';
                } else {
                    res[k] = '0';
                    carry = '1';
                }
            } else if (ai == '1' && bj == '1') {
                if (carry == '0') {
                    res[k] = '0';
                    carry = '1';
                } else {
                    res[k] = '1';
                    carry = '1';
                }
            }

            i--;
            j--;
            k--;
        }
        if (carry == '1') {
            res[0] = '1';
        } else {
            res[0] = '0';
        }
        String result = new String(res);
        if (result.charAt(0) == '0') {
            return result.substring(1);
        }
        return result;
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("10", "1"));

    }
}

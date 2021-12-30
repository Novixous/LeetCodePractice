package com.practice.string.reverse;

public class ReverseString {
    public static void main(String[] args) {
        String string = "012345";
        System.out.println(reverseString(string));
        System.out.printf(reverseStringRec(string));
    }

    public static String reverseString(String string) {
        if(string == ""){
            return "";
        }
        char[] chars = string.toCharArray();
        if (chars.length % 2 == 0) {
            for (int i = 0; i < chars.length / 2; i++) {
                char temp = chars[i];
                chars[i] = chars[chars.length - 1 - i];
                chars[chars.length - 1 - i] = temp;
            }
        } else {
            for (int i = 0; i < Math.floor(chars.length / 2); i++) {
                char temp = chars[i];
                chars[i] = chars[chars.length - 1 - i];
                chars[chars.length - 1 - i] = temp;
            }
        }
        return String.copyValueOf(chars);
    }

    public static String reverseStringRec(String string){
        if (string == "") {
            return "";
        } else {
            return reverseStringRec(string.substring(1)) + string.charAt(0);
        }
    }
}

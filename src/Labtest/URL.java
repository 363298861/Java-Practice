package Labtest;

import java.util.Scanner;

public class URL {
    public String urlBinding(String prefix, String postfix){

        if(prefix.length() == 0 && postfix.length() == 0)
            return "/";
        if((prefix.charAt(prefix.length() - 1) == '/' && postfix.charAt(0) != '/')
            || (prefix.charAt(prefix.length() - 1) != '/' && postfix.charAt(0) == '/'))
            return prefix + postfix;
        if((prefix.charAt(prefix.length() - 1) == '/' && postfix.charAt(0) == '/'))
            return prefix + postfix.substring(1);
        return prefix + "/" + postfix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pre = sc.next();
        String[] test = pre.split(",");
        URL url = new URL();
        System.out.println(url.urlBinding(test[0], test[1]));
    }
}

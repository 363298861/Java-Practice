package Leetcode;

public class No171ColumnSheetNumber {
    public int titleToNumber(String s) {
        if(s.isEmpty()) return 0;
        return titleToNumber(s.substring(0, s.length() - 1)) * 26 + s.charAt(s.length() - 1) - 'A' + 1;
    }

    public static void main(String[] args) {
        No171ColumnSheetNumber n = new No171ColumnSheetNumber();
        System.out.println(n.titleToNumber("AAA"));
    }
}

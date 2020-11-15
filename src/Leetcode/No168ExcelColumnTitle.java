package Leetcode;

public class No168ExcelColumnTitle {
    public String convertToTitle(int n) {
        if(n == 0) return "";
        return convertToTitle((n - 1) / 26) + (char) ((n - 1) % 26 + 'A');
    }

    public static void main(String[] args) {
        No168ExcelColumnTitle n = new No168ExcelColumnTitle();
        System.out.println(n.convertToTitle(24568));
    }
}

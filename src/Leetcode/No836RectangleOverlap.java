package Leetcode;

public class No836RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x = Math.min(rec1[2], rec2[2]) - Math.max(rec1[0], rec2[0]);
        int y = Math.min(rec1[3], rec2[3]) - Math.max(rec1[1], rec2[1]);
        return x > 0 && y > 0;
    }

    public static void main(String[] args) {
        int[] r1 = {-193634870,-175701756,958697367,607619635};
        int[] r2 = {91619846,10349052,822028072,696611776};
        No836RectangleOverlap n = new No836RectangleOverlap();
        System.out.println(n.isRectangleOverlap(r1, r2));
    }
}

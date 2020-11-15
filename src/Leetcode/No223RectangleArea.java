package Leetcode;

public class No223RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x = Math.min(G, C) > Math.max(A, E) ? Math.min(G, C) - Math.max(A, E) : 0;
        int y = Math.min(D, H) > Math.max(B, F) ? Math.min(D, H) - Math.max(B, F) : 0;
        return (C - A) * (D - B) + (H - F) * (G - E) - x * y;
    }
}

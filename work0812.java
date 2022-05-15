package Leetcode.smart;

import static Leetcode.smart.LecoUtil.LecoPrint;
import static Leetcode.smart.LecoUtil.LecoNewNums;

/**
 * 0812 最大三角形面积
 */

public class work0812 {
    public static void main(String[] args) {
        work0812 w = new work0812();
        LecoPrint(LecoNewNums(2, 5,
                0, 0, 0, 1, 1, 0, 0, 2, 2, 0));
    }


    public double largestTriangleArea(int[][] points) {
        double max = 0;
        for (int[] point1 : points) {
            for (int[] point2 : points) {
                for (int[] point3 : points) {
                    if (point1 == point2 || point1 == point3 || point2 == point3) continue;
                    double area = triangleArea(point1[0], point1[1], point2[0], point2[1], point3[0], point3[1]);
                    if (area > max) max = area;
                }
            }
        }
        return max;
    }

    private double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);
    }

}
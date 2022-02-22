package Leetcode.smart;

import java.util.*;

/**
 * LeetCode0399 除法求值
 */
public class work0399 {

    public static void main(String[] args) {
        work0399 w = new work0399();
        ArrayList<List<String>> lists = new ArrayList<>();
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        double[][] map = new double[n * 2][n * 2];
        HashMap<String, Integer> idMap = new HashMap<>(); // 存储已经存在的未知数
        int id = 0;
        for (int i = 0; i < n; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if (!idMap.containsKey(a)) {
                map[id][id] = 1;
                idMap.put(a, id++);
            }
            if (!idMap.containsKey(b)) {
                map[id][id] = 1;
                idMap.put(b, id++);
            }
            Integer ai = idMap.get(a);
            Integer bi = idMap.get(b);
            map[ai][bi] = values[i];
            map[bi][ai] = 1 / values[i];
        }
        // floyd
        for (int k = 0; k < id; k++) {
            for (int i = 0; i < id; i++) {
                for (int j = 0; j < id; j++) {
                    if (map[i][j] != 0) continue;
                    if (map[i][k] != 0 && map[k][j] != 0) {
                        double times = map[i][k] * map[k][j];
                        map[i][j] = times;
                        map[j][i] = 1 / times;
                    }
                }
            }
        }
        double[] res = new double[queries.size()];
        int i = 0;
        for (List<String> query : queries) {
            String a = query.get(0);
            String b = query.get(1);
            Integer ai, bi;
            if ((ai = idMap.get(a)) == null || (bi = idMap.get(b)) == null || map[ai][bi] == 0) {
                res[i] = -1;
            } else {
                res[i] = map[ai][bi];
            }
            i++;
        }
        return res;
    }

    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        UnionFind unionFind = new UnionFind(2 * n);
        HashMap<String, Integer> idMap = new HashMap<>(2 * n); // 存储已经存在的未知数
        int id = 0;
        for (int i = 0; i < n; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if (!idMap.containsKey(a)) {
                idMap.put(a, id++);
            }
            if (!idMap.containsKey(b)) {
                idMap.put(b, id++);
            }
            unionFind.union(idMap.get(a), idMap.get(b), values[i]);
        }
        double[] res = new double[queries.size()];
        int i = 0;
        for (List<String> query : queries) {
            String a = query.get(0);
            String b = query.get(1);
            Integer ai, bi;
            if ((ai = idMap.get(a)) == null || (bi = idMap.get(b)) == null) {
                res[i] = -1;
            } else {
                res[i] = unionFind.calculate(ai, bi);
            }
            i++;
        }
        return res;
    }

    private class UnionFind {

        private int[] parent;
        private double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        public void union(int x, int y, double value) {
            // 将x联合到y中
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            parent[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x];
            // x / rx = w[x], y / ry = w[y], rx/ry = w[y]/w[x]*(x / y)
        }

        public int find(int x) {
            if (x != parent[x]) {
                // 递归查找根节点
                int p = parent[x];
                parent[x] = find(p); // 一边查找一边更新
                weight[x] *= weight[p];
            }
            return parent[x];
        }

        public double calculate(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }
}
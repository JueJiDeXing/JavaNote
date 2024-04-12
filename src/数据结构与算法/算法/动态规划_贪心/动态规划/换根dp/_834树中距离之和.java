package 数据结构与算法.算法.动态规划_贪心.动态规划.换根dp;

import java.util.*;

public class _834树中距离之和 {
    /*
    给定一个无向、连通的树。树中有 n 个标记为 0...n-1 的节点以及 n-1 条边 。
    给定整数 n 和数组 edges ， edges[i] = [ai, bi]表示树中的节点 ai 和 bi 之间有一条边。
    返回长度为 n 的数组 answer ，其中 answer[i] 是树中第 i 个节点与所有其他节点之间的距离之和。
     */

    /**
     <h1>换根dp</h1>
     <ul>
     <li>
     思路:<br>
     以顶点0为根,计算每个节点的子树个数size[i],以及顶点0的距离和ans[0]<br>
     那么切换到顶点0的孩子节点i,那么不在子树i中的距离都更远一格,在子树i中的距离都更近一格<br>
     在子树i中的节点个数为size[i], 不在子树i中的节点个数为n-size[i]<br>
     即: ans[i] = ans[0] + (n-size[i]) - size[i] = ans[0] + n-2*size[i]<br>
     所以有转移方程: ans[y] = ans[x] + n-2*size[y], 其中y是x的邻居节点<br>
     </li>
     <li>
     算法: <br>
     首先DFS一次,size数组和ans[0]<br>
     再第二次DFS进行换根dp,设c是p的孩子,则有ans[c]=ans[p]+n-x*size[p]<br>
     </li>
     </ul>
     */
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        //建图
        g = new ArrayList[n]; // g[x] 表示 x 的所有邻居
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }

        // 第一次 DFS,计算 size 和 ans[0]
        ans = new int[n];//ans[i]:节点i到其他节点的距离和
        size = new int[n];//size[i]:节点i的子树节点个数
        dfs(0, -1, 0); // 0 没有父节点
        // 换根dfs,根据换根后的变化量求ans
        reroot(0, -1); // 0 没有父节点
        return ans;
    }

    List<Integer>[] g;
    int[] ans, size;

    public void dfs(int x, int parent, int depth) {
        ans[0] += depth; // depth 为 0 到 x 的距离
        size[x] = 1;
        for (int y : g[x]) { // 遍历 x 的邻居 y
            if (y != parent) { // 避免访问父节点
                dfs(y, x, depth + 1); // x 是 y 的父节点
                size[x] += size[y]; // 累加 x 的儿子 y 的子树大小
            }
        }
    }

    public void reroot(int x, int parent) {
        for (int y : g[x]) { // 遍历 x 的邻居 y
            if (y != parent) { // 避免访问父节点
                ans[y] = ans[x] + g.length - 2 * size[y];
                reroot(y, x); // x 是 y 的父节点
            }
        }
    }
}

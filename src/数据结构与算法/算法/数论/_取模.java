package 数据结构与算法.算法.数论;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _取模 {
    /*
    T个询问
    每次询问给出一个整数n,和一个范围m
    判断在[1,m]上是否能找到 x!=y && n%x==n%y
     */
    static StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    static int Int() {
        try {
            tokenizer.nextToken();
        } catch (Exception ignore) {
        }
        return (int) tokenizer.nval;
    }

    public static void main(String[] args) {
        int T = Int();
        Set<Integer> set = new HashSet<>();//n%k
        out:
        for (int i = 0; i < T; i++) {
            int n = Int(), m = Int();
            set.clear();
            for (int j = 1; j <= m; j++) {
                if (!set.add(n % j)) {
                    System.out.println("Yes");
                    continue out;
                }
            }
            System.out.println("No");
        }
    }

    /**
     中国剩余定理
     如果找不到n mod x = n mod y,那么一定有n%1=0, n%2=1, n%3=2,...n%m=m-1
     */
    private static void solve2() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out:
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt(), m = sc.nextInt();

            for (int j = m; j > 0; j--) {
                if (n % j != (j - 1)) {
                    System.out.println("Yes");
                    continue out;
                }
            }
            System.out.println("No");
        }
    }

}

package 数据结构与算法.算法.数论;

//测试:src.java.数据结构与算法.算法.数论.TestCount1
public class 二进制1的个数 {

    public int count1(int n) {
        int count = 0;
        while (n != 0) {
            //每次左移一位,监控最低位是否为1
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public int count2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);//n=n&(n-1)会将n的最低位的1变成0
        }
        return count;
    }

    public int count3(int n) {
        return Integer.bitCount(n);
        /*
        # 内部实现
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
         */
    }

    public static void main(String[] args) {
        二进制1的个数 test = new 二进制1的个数();
        test.count4(126);
    }

    public int count4(int n) {
        n = (n & 0x55555555) + ((n & 0xaaaaaaaa) >> 1);
        n = (n & 0x33333333) + ((n & 0xcccccccc) >> 2);
        n = (n & 0x0f0f0f0f) + ((n & 0xf0f0f0f0) >> 4);
        n = (n & 0x00ff00ff) + ((n & 0xff00ff00) >> 8);
        n = (n & 0x0000ffff) + ((n & 0xffff0000) >> 16);
        return n;
    }
}

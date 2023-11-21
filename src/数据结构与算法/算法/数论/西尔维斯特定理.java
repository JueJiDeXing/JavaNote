package 数据结构与算法.算法.数论;

public class 西尔维斯特定理 {
    /*
    对于互质的两个正整数a,b
    ax+by=ab-a-b无非负整数解
     */
    /*
    反证法:
    假设ax+by=ab-a-b
    则ab=a(x+1)+b(y+1)
    因为a乘以某个数等于右边
    所以右边可以整除a,记为 a(x+1)+b(y+1) / a
    所以b(y+1) / a
    由于条件 a,b互质
    所以(y+1)/a
    那么y>=a-1
    同理x>=b-1
    则ax+by>=2ab-a-b>ab-a-b
    所以ax+by=ab-a-b无非负整数解
     */
}

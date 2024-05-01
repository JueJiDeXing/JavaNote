package 数据结构与算法.算法.博弈论;

import 数据结构与算法.算法OJ.蓝桥杯.真题卷.第12届.省赛.Java大学A组.H异或数列;

public class 异或数列 {
    /*
    A和B的初始值为0
    有长度为n公共序列X
    A先手
    每次可以选择一个数X[i],将A的值或B的值异或上X[i]
    最后判断A和B的值,大的赢
    A赢输出1,B赢输出-1,平局输出0

    游戏进行T次 T<2e5
    每行第一个整数为序列x的长度n,后面n个数为序列x
    n<2e5,x[i]<20e20
    */

    /**
     {@link H异或数列}
     /**
     最终的比较大小一定是看最高位, 一个为1, 一个为0, 这样才比较出大小<br>
     假设 序列X 中最高位是第k位(二进制)的有t个<br>
     <p><br>
     如果t有偶数个: <br>
       最终状态的第k位一定是(0,0)或(1,1),无法从该位判断大小<br>
     先看2个的情况:<br>
       假设a选了一个,对于令一个它一定会使用,不管对a还是对b使用,ab的第k位都为0,这一位无法比较出ab的大小<br>
     扩展到全体偶数的情况:<br>
       偶数的数一定都会使用,最后要么ab在第k位都为0,要么都为1<br>
     所以,在第k位上,如果有偶数个1,则无法从这位判断大小,需要去判断下一个位k-1<br>
     <p><br>
     如果t有奇数个:<br>
       最终状态的第k位一定是(1,0)或(0,1),可以从该位比较出大小<br>
     如果只有1个:<br>
       a会把它选走,b赢不了<br>
     如果n为偶数:<br>
         那么在第k位就有奇数个1和奇数个0<br>
         如果a选了一个1,那么b有必胜策略,可以选0,这样如果a选1会减小a或者增大b,所以a也只能选0<br>
         0有奇数个,b会选完最后一个0,a再选1,现在情况变为ab在第k位相同,还有奇数个1,没有0,b先手<br>
         那么最后b一定在第k位高于a<br>
     如果n为奇数:<br>
         那么在第k位就有奇数个1和偶数个0<br>
         ab拿走t-1个1后(如果中途b选了0,那a跟着选0即可),剩余1个1<br>
         情况变为ab在第k位相同,还有1个1,偶数个0(也可能没有0了),a先手<br>
         a拿走最后一个1,ab首位为0给a异或,ab首位为1给b异或,a赢<br>
     特殊情况:<br>
     每位都有偶数个1,平局, 全体数异或为0=>平局<br>
     */
    public static void main(String[] args) {

    }
}

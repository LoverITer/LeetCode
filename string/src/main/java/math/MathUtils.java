package math;

/**
 * @author ：huangxin
 * @modified ：
 * @since ：2020/02/21 00:11
 */
public class MathUtils {


    /**
     * 给定两个整数，被除数 dividend 和除数 divisor。
     * 将两数相除，要求不使用乘法、除法和 mod 运算符。
     * 返回被除数 dividend 除以除数 divisor 得到的商。
     *
     * @param dividend 被除数
     * @param divisor 除数
     * @return   商
     */
    public int divideWithOutOperator(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) {
                return -dividend;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        int sign = 1;
        boolean isOpposite = ((long) dividend > 0 && (long) divisor < 0) || ((long) dividend < 0 && (long) divisor > 0);
        if (isOpposite) {
            sign = -1;
        }
        long res = div(Math.abs((long) dividend), Math.abs((long) divisor));
        if (sign > 0) {
            return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
        }
        return (int) -res;

    }

    private int div(long dividend, long divisor) {
        if (divisor > dividend) {
            return 0;
        }
        //count保存被除数被整数的次数
        long count = 1;
        long temp = divisor;
        while ((temp + temp) < dividend) {
            temp += temp;
            count += count;
        }
        return (int) count + div(dividend - temp, divisor);
    }


    /**
     * 快慢指针解决 快乐数问题
     * 编写一个算法来判断一个数 n 是不是快乐数。
     *
     * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
     *
     * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
     *
     * 使用快慢指针，如果不是快乐数，最终会形成循环链表，
     * 当fast和slow相交并且不为1的时候就可以判断这个数不是快乐数
     *
     * <img src="https://assets.leetcode-cn.com/solution-static/202/1.jpg"/>
     *
     * @param num
     * @return
     */
    public boolean isHappyNumber(int num) {
        int slow = num, fast = getNext(num);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    public int getNext(int num) {
        int sum = 0;
        while (num > 0) {
            int t = num % 10;
            num /= 10;
            sum += t * t;
        }
        return sum;
    }




}

import java.util.*;


/*
* 一个淘宝的订单中包含n(10>=n>=1)种商品A1，A2，...，An，每种商品数量分别为a1，a2，...，an个，记做{a1,a2,...,an}(ak>0)。订单在仓库生产过程中，仓库为了提升作业效率，会提前对热门组合商品进行预包装。假设这n个商品有m(9>=m>=1)个商品组合，每个组合bomk包含A1，A2，...，An的数量分别为{b1,b2,...,bn}(bk>=0,至少存在一个bk>0)

举例如下：
订单包含A，B，C商品，数量为{2，3，1}，商品组合bom1{2，1，1}，bom2{1，1，0}，bom3{0，1，1}

对以上订单匹配给定商品组合，得到的可能匹配结果为：res1.匹配到组合1一套，剩余B商品；res2.匹配到组合2两套，组合3一套，不剩商品；
现要求订单的最优匹配，最优匹配的原则为：1.匹配组合后，剩余商品种类数越少越好；2.在剩余商品种类数相同的情况下，匹配到的组合种类数越少越好；
例如上面例子，我们认为res2优于res1。

现需要编写程序，输入格式为：
n,m
a1,a2,...,an
bom1,b11,b12,...,b1n
bom2,b21,b22,...,b2n
....
bomm,bm1,bm2,...,bmn

输入数据的格式说明（数据间使用英文逗号分隔）：
第一行数据：n个商品，m个预包方案
第二行数据：商品1个数，商品2个数，。。。，商品n个数
第三行数据：bom1，商品1个数，商品2个数，。。。，商品n个数
第n-1行数据：。。。。
第n行数据：bomn，商品1个数，商品2个数，。。。，商品n个数

针对输入数据找出最优匹配，输出最优匹配的组合及套数，比如针对上面的例子输出：
match result:
bom2*2，bom3*1


3,3
2,3,1
bom1,2,1,1
bom2,1,1,0
bom3,0,1,1

* */
public class Main {
    /** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.calculateII("1*2+3/4-4/4"));
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int signed = 1;
        int ret = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+') {
                signed = 1;
            } else if (c == '-') {
                signed = -1;
            } else if (Character.isDigit(c)) {
                int tmp = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    tmp = tmp * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                ret += signed * tmp;
            } else if (c == '(') {
                stack.push(ret);
                stack.push(signed);

                ret = 0;
                signed = 1;
            } else if (c == ')') {
                ret = ret * stack.pop() + stack.pop();
                signed = 1;
            }
        }

        return ret;
    }

    public int calculateII(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int tmp = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    tmp = tmp * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                if (!stack.isEmpty() && (stack.peek() == 2 || stack.peek() == 3)) {
                    int sign = stack.pop();
                    int val = stack.pop();
                    if (sign == 2) {
                        val *= tmp;
                    } else {
                        val /= tmp;
                    }
                    stack.push(val);
                } else {
                    stack.push(tmp);
                }
            } else {
                switch (c) {
                    case '+':
                        stack.push(0);
                        break;
                    case '-':
                        stack.push(1);
                        break;
                    case '*':
                        stack.push(2);
                        break;
                    case '/':
                        stack.push(3);
                        break;
                }
            }
        }
        Collections.reverse(stack);
        int tmp = stack.pop();
        while (!stack.isEmpty()) {
            int sign = stack.pop();
            int val = stack.pop();
            if (sign == 0) {
                tmp += val;
            } else {
                tmp -= val;
            }
        }
        return tmp;
    }
}
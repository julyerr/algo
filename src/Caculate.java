import java.util.Stack;

/*
 * 参考思路：http://itfish.net/article/33790.html
 * 优先级 '(' > '*'|'/' > '+'|'-' > ')' > '#'
 * 通过'#'结尾
 * */
public class Caculate {
    Stack<Integer> numStack = new Stack<>();
    Stack<Character> opsStack = new Stack<>();

    public int caculate(String string) {
        int num = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (Character.isDigit(c)) {
                while (i < string.length() && Character.isDigit(string.charAt(i))) {
                    c = string.charAt(i);
                    num = num * 10 + c - '0';
                    i++;
                }
                i--;
                numStack.push(num);
                num = 0;
            } else {
                if (c == ' ') {
                    continue;
                }
//                当前元素优先级比符号栈顶优先级低,将所有的元素计算出来
                while (!compare(c) && !opsStack.isEmpty()) {
                    int b = numStack.pop();
                    int a = numStack.pop();
                    char ops = opsStack.pop();
                    int tmp = 0;
                    switch (ops) {
                        case '+':
                            tmp = a + b;
                            numStack.push(tmp);
                            break;
                        case '-':
                            tmp = a - b;
                            numStack.push(tmp);
                            break;
                        case '*':
                            tmp = a * b;
                            numStack.push(tmp);
                            break;
                        case '/':
                            tmp = a / b;
                            numStack.push(tmp);
                            break;
                    }
                }
                if (c == '#') {
                    break;
                }
                opsStack.push(c);
//                    括号出栈
                if (c == ')') {
                    opsStack.pop();
                    opsStack.pop();
                }
            }
        }
        return numStack.pop();
    }

    //    当前元素和符号栈优先级比较
    private boolean compare(char c) {
        if (opsStack.isEmpty()) {
            return true;
        }
        char tmp = opsStack.peek();
        if (tmp == '(') {
            return true;
        }
        switch (c) {
            case '#':
                return false;
            case '(':
                return true;
//            优先级最低
            case ')':
                return false;
            case '*':
                if (tmp == '+' || tmp == '-') {
                    return true;
                }
                return false;
            case '/':
                if (tmp == '+' || tmp == '-') {
                    return true;
                }
                return false;
            case '+':
                return false;
            case '-':
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Caculate caculate = new Caculate();
        System.out.println(caculate.caculate("3 + 4*5#"));
        System.out.println(caculate.caculate("3+4*(4*10-10/2)#"));
    }
}
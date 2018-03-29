package com.julyerr.realInterview.dfs;

public class ReverseStack {
    public int[] reverseStackRecursively(int[] stack, int top) {
        if (top == 1) {
            return stack;
        }
        int tmp = stack[0];
        for (int i = 0; i < top - 1; i++) {
            stack[i] = stack[i + 1];
        }
        stack[top - 1] = tmp;
        reverseStackRecursively(stack, top - 1);
        return stack;
    }
}

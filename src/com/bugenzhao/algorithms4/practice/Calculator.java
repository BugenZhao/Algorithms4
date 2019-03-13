package com.bugenzhao.algorithms4.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// (5+6*(7+3)/3)/4+5
public class Calculator {
    private String exp;
    private double result;
    private Queue<Object> tokens;

    public Calculator(String exp) {
        this.exp = exp;
        try {
            this.result = getResult(getRPNTokens(getTokens(exp)));
        } catch (Exception e) {
            System.err.println("Wrong expression.");
            e.printStackTrace();
        }
    }

    static Queue<Object> getTokens(String exp) {
        Queue<Object> tokens = new LinkedList<>();
        char[] chars = exp.toCharArray();
        int i = 0, N = exp.length();

        while (i < N) {
            switch (chars[i]) {
                case '+':
                    tokens.offer(Operator.ADD);
                    break;
                case '-':
                    tokens.offer(Operator.SUB);
                    break;
                case '*':
                    tokens.offer(Operator.MULTI);
                    break;
                case '/':
                    tokens.offer(Operator.DIV);
                    break;
                case '^':
                    tokens.offer(Operator.EXP);
                    break;
                case '(':
                    tokens.offer(Bracket.LEFT);
                    break;
                case ')':
                    tokens.offer(Bracket.RIGHT);
                    break;
                case ' ':
                    break;
                default:
                    StringBuilder sb = new StringBuilder();
                    if (chars[i] >= '0' && chars[i] <= '9') {
                        sb.append(chars[i]);
                        while (i < N - 1 && (chars[i + 1] >= '0' && chars[i + 1] <= '9' || chars[i + 1] == '.')) {
                            sb.append(chars[++i]);
                        }
                    } else if (chars[i] == '.') {
                        sb.append("0.");
                        while (i < N - 1 && chars[i + 1] >= '0' && chars[i + 1] <= '9') {
                            sb.append(chars[++i]);
                        }
                    }
                    tokens.offer(Double.parseDouble(sb.toString()));
            }
            ++i;
        }

        return tokens;
    }

    static Queue<Object> getRPNTokens(Queue<Object> tokens) {
        Stack<Object> stack = new Stack<>();
        Queue<Object> rpn = new LinkedList<>();

        for (Object token : tokens) {
            // System.out.println(stack);
            if (token instanceof Double) {
                rpn.offer(token);
            } else if (token instanceof Bracket) {
                Object tmp;
                switch ((Bracket) token) {
                    case LEFT:
                        stack.push(token);
                        break;
                    case RIGHT:
                        while (!stack.isEmpty()) {
                            tmp = stack.pop();
                            if (tmp.equals(Bracket.LEFT)) break;
                            rpn.offer(tmp);
                        }
                        break;
                }
            } else if (token instanceof Operator) {
                Object tmp;
                switch ((Operator) token) {
                    case ADD:
                    case SUB:
                        while (!stack.isEmpty()) {
                            tmp = stack.peek();
                            if (tmp.equals(Bracket.LEFT)) break;
                            rpn.offer(tmp);
                            stack.pop();
                        }
                        stack.push(token);
                        break;
                    case MULTI:
                    case DIV:
                        while (!stack.isEmpty()) {
                            tmp = stack.peek();
                            if (tmp.equals(Operator.ADD) || tmp.equals(Operator.SUB) || tmp.equals(Bracket.LEFT))
                                break;
                            rpn.offer(tmp);
                            stack.pop();
                        }
                        stack.push(token);
                        break;
                    case EXP:
                        stack.push(token);
                        break;
                }
            }
        }
        while (!stack.isEmpty()) {
            rpn.offer(stack.pop());
        }
        return rpn;
    }

    static double getResult(Queue<Object> rpn) {
        Stack<Double> stack = new Stack<>();
        for (Object token : rpn) {
            if (token instanceof Double) {
                stack.push((Double) token);
            } else {
                double a, b;
                a = stack.pop();
                b = stack.pop();
                switch ((Operator) token) {
                    case ADD:
                        stack.push(b + a);
                        break;
                    case SUB:
                        stack.push(b - a);
                        break;
                    case MULTI:
                        stack.push(b * a);
                        break;
                    case DIV:
                        stack.push(b / a);
                        break;
                    case EXP:
                        stack.push(Math.pow(b, a));
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String exp = scanner.nextLine();
            /*Queue<Object> tokens = Calculator.getTokens(exp);
            Queue<Object> rpn = Calculator.getRPNTokens(tokens);
            System.out.println(tokens);
            System.out.println(rpn);
            System.out.println(Calculator.getResult(rpn));*/
            Calculator calc = new Calculator(exp);
            System.out.println(calc.getExp() + " = " + calc.getResult());
        }
    }

    public double getResult() {
        return result;
    }

    public String getExp() {
        return exp;
    }

    private enum Operator {
        ADD, SUB, MULTI, DIV, EXP,
    }

    private enum Bracket {
        LEFT, RIGHT,
    }
}

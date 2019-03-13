package com.bugenzhao.algorithms4.exercise.chapter1_4;

import java.util.Scanner;

public class HotOrCold {
    public static final int HOTTER = -1;
    public static final int IGNORE = 0;
    public static final int COOLER = 1;
    public static final int BINGO = 1018;

    private int ans;
    private int max;
    private int askCount = 0;
    private int lastAsk = 0;

    HotOrCold(int ans, int max) {
        this.ans = ans;
        this.max = max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*while (true) {
            HotOrCold hotOrCold = new HotOrCold(scanner.nextInt(), 100);
            hotOrCold.guessSlower();
        }*/
        for (int i = 1; i <= 100; i++) {
            HotOrCold hotOrCold = new HotOrCold(i, 100);
            hotOrCold.guess();
            hotOrCold.guessSlower();
        }
    }

    private int ask(int num) {
        if (num == ans)
            return BINGO;
        if (askCount++ == 0) {
            lastAsk = num;
            return IGNORE;
        }
        int ret;
        if (Math.abs(lastAsk - ans) >= Math.abs(num - ans))
            ret = HOTTER;
        else
            ret = COOLER;
        lastAsk = num;
        return ret;
    }

    public void guess() {
        int low = 1, high = max;
        int loopCount = 0;

        System.out.println("ask: " + 1);
        if (ask(1) == BINGO) {
            System.out.println("  BINGO." + ans);
            return;
        } else
            System.out.println("  IGNORE.");
        while (true) {
            if (loopCount++ == 100) {
                System.out.println(ans);
                return;
            }
            if (high - low <= 1) {
                System.out.println("ask: " + low);
                if (ask(low) == BINGO) {
                    System.out.println("  BINGO." + ans);
                    return;
                }
                System.out.println("ask: " + high);
                if (ask(high) == BINGO) {
                    System.out.println("  BINGO." + ans);
                    return;
                }
            }
            int toAsk = low + high - lastAsk;
            int lastAsk = this.lastAsk;
            System.out.println("ask: " + toAsk);
            switch (ask(toAsk)) {
                case BINGO:
                    System.out.println("  BINGO." + ans);
                    return;
                case HOTTER:
                    System.out.println("  HOTTER.");
                    if (toAsk >= lastAsk)
                        low = (low + high) / 2;
                    else
                        high = (low + high) / 2;
                    break;
                case COOLER:
                    System.out.println("  COOLER.");
                    if (toAsk < lastAsk)
                        low = (low + high) / 2;
                    else
                        high = (low + high) / 2;
                    break;
            }
            System.out.println("NOW: low=" + low + " high=" + high);
        }
    }

    public void guessSlower() {
        int low = 1, high = max;

        while (true) {
            if (high - low <= 1) {
                System.out.println("ask: " + low);
                if (ask(low) == BINGO) {
                    System.out.println("  BINGO." + ans);
                    return;
                }
                System.out.println("ask: " + high);
                if (ask(high) == BINGO) {
                    System.out.println("  BINGO." + ans);
                    return;
                }
            }
            System.out.println("ask: " + low + "\n  IGNORE.");
            if (ask(low) == BINGO) {
                System.out.println("  BINGO." + ans);
                return;
            }
            System.out.println("ask: " + high);
            switch (ask(high)) {
                case BINGO:
                    System.out.println("  BINGO." + ans);
                    return;
                case HOTTER:
                    System.out.println("  HOTTER.");
                    low = (low + high) / 2;
                    break;
                case COOLER:
                    System.out.println("  COOLER.");
                    high = (low + high) / 2;
                    break;

            }
            System.out.println("NOW: low=" + low + " high=" + high);
        }
    }
}

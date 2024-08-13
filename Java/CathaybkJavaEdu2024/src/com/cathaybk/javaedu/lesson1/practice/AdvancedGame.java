package com.cathaybk.javaedu.lesson1.practice;

import java.util.Random;

/**
 * <pre>
 * 練習四：雙人猜拳
 * </pre>
 */
public class AdvancedGame {

    public static void main(String[] args) {
        int aWin = 0;
        int bWin = 0;
        Random r = new Random();
        while (aWin < 2 && bWin < 2) {
            int a = r.nextInt(3);
            int b = r.nextInt(3);

            // DEMO ----------
//            if ((a == 0 && b == 2) || (a == 1 && b == 0) || (a == 2 && b == 1)) {
//                ++aWin;
//                System.out.printf("A 出拳：%s、B 出拳：%s，A 贏\n", guess(a), guess(b));
//            } else if ((b == 0 && a == 2) || (b == 1 && a == 0) || (b == 2 && a == 1)) {
//                ++bWin;
//                System.out.printf("A 出拳：%s、B 出拳：%s，B 贏\n", guess(a), guess(b));
//            } else {
//                System.out.printf("A 出拳：%s、B 出拳：%s，平手\n", guess(a), guess(b));
//            }

            // DEMO ----------
			int result = b - a;
			System.out.printf("A 出拳：%s、B 出拳：%s，", guess(a), guess(b));
			if (result == 2 || result == -1) {
				++aWin;
				System.out.println("A 贏");
			} else if (result == -2 || result == 1) {
				++bWin;
				System.out.println("B 贏");
			} else {
				System.out.println("平手");
			}
        }
        System.out.println("最後贏家：" + (aWin > bWin ? "A" : "B"));

    }

    private static String guess(int number) {
        if (number == 0) {
            return "剪刀";
        } else if (number == 1) {
            return "石頭";
        } else {
            return "布";
        }
    }

}

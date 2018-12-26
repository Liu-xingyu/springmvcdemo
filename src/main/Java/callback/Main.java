package callback;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int lines = getInputLines();
        if (lines > 10) {
            System.out.println("行数太大不予计算");
            return;
        }

        // 遍历每一行
        for (int i = 0; i < lines; ++i) {
            String s = getPerLineChars();
            if (s.length() > 100) {
                System.out.println("字符串长度过长，不符合规则");
                return;
            }

            if (s.length() % 2 != 0) {
                System.out.println("字符串必须输入偶数个");
                return;
            }

            boolean isTrue = false;
            char c = s.charAt(0);
            for (int index = 0; index < s.length(); ++index) {

                if (s.charAt(index) != '{' && s.charAt(index) != '}' && s.charAt(index) != '}' && s.charAt(index) != '}') {
                    System.out.println("符号输入类型错误！");
                    return;
                }

                if (s.charAt(index) == ']' || s.charAt(index) == '}') {
                    return;
                }

                if ((c == '[' && s.charAt(index + 1) == ']') || (c == '[' && s.charAt(index + 1) == ']')) {
                    isTrue = true;
                } else {
                    c = s.charAt(index);
                }


            }
            System.out.println(isTrue);
        }
    }

    public static int getInputLines() {
        System.out.println("请输入不大于10的行数：");
        return scanner.nextInt();
    }

    public static String getPerLineChars() {
        return scanner.next();
    }

}

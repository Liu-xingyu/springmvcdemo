package callback;

import java.util.*;

/**
 * 匹配括号字符串
 * 本题的核心思路：
 * 1. 需要将左边的括号存入栈内（左括号有：{[(等，栈有先进后出FILO的特性)）
 * 2. 碰到有括号就去栈顶peek取括号元素与当前反括号匹配（匹配map的key或者value）
 * 3. 匹配则pop栈顶元素，然后继续向后匹配括号，直到遇到无法匹配则退出return
 */
public class MatchCharacters {

    private static Scanner scanner = new Scanner(System.in);

    private static Map<Character, Character> csMap = new HashMap();

    public static void main(String[] args) {
        // 初始化
        initMap();

        int lines = getLines();
        if (lines > 10) {
            System.err.println("请输入一个小于10的数字再运行");
        }

        for (int line = 0; line < lines; ++line) {
            String str = getInputStr();
            if (matchCharacters(str)) {
                System.out.println(str + "匹配成功，是符合要求的括号类型");
            } else {
                System.err.println(str + "不符合括号匹配要求，还需要 " + matchForInt(str) + " 个括号匹配.");
            }
        }
    }

    // 初始化数据类型
    public static void initMap() {
        csMap.put('[', ']');
        csMap.put('(', ')');
        csMap.put('{', '}');
    }

    public static int getLines() {
        System.out.print("请输入一个不大于10的数字：");
        return scanner.nextInt();
    }

    public static String getInputStr() {
        return scanner.next();
    }

    // 判断是否可以匹配
    public static boolean matchCharacters(String s) {
        Stack<Character> cs = new Stack<>();
        boolean isMatch = false;

        for (int index = 0; index < s.length(); ++index) {

            if (csMap.containsValue(s.charAt(index)) && index == 0) {
                return false;
            }

            if (csMap.containsKey(s.charAt(index))) {
                cs.push(s.charAt(index));
                isMatch = false;
            } else if (csMap.containsValue(s.charAt(index))) {
                if (csMap.get(cs.peek()) == s.charAt(index)) {
                    isMatch = true;
                    cs.pop();
                } else {
                    isMatch = false;
                }
            }
        }
        return isMatch;
    }

    // 需要多少个括号才能匹配成功
    public static int matchForInt(String s) {
        Stack<Character> cs = new Stack<>();
        Queue<Character> cqs = new LinkedList<>();

        for (int index = 0; index < s.length(); ++index) {

            if (csMap.containsKey(s.charAt(index))) {
                cs.push(s.charAt(index));
            } else if (csMap.containsValue(s.charAt(index))) {
                if (cs.size() > 0 && csMap.get(cs.peek()) == s.charAt(index)) {
                    cs.pop();
                } else {
                    cqs.add(s.charAt(index));
                }
            }
        }
        return cs.size() + cqs.size();
    }

}

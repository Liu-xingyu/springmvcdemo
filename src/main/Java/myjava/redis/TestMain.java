package myjava.redis;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Created by YRP-Laptop on 2018/4/8.
 */
public class TestMain {

    public static void main(String[] args) throws Exception {
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        float tempVal = new Random().nextFloat();
        String[] courses = {"计算机基础", "多媒体应用技术", "环境科学", "基础免疫学"};
        Random randomCourse = new Random();
        for (int i = 1; i < 16; i++) {
            if (tempVal < 1) {
                System.out.println("This course is recommended to user" + i + " is:" +
                        courses[randomCourse.nextInt(4)] + ", the predicate favorite for user" + i + " is:"
                        + decimalFormat.format(3.5f + tempVal));
            } else {
                System.out.println("This course is recommended to user" + i + " is:" +
                        courses[randomCourse.nextInt(4)] + ", the predicate favorite for user" + i + " is:"
                        + decimalFormat.format(3.8f + 1 / tempVal));
            }

        }


    }
}

package distance;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by YRP-Laptop on 2018/4/14.
 * 欧几里德距离公式
 */
public class Distance_Similarity {

    /**
     * 两个向量可以为任意维度，但必须保持维度相同，表示n维度中的两点
     *
     * @param vector1
     * @param vector2
     * @return 两点间距离
     */
    public double sim_distance(double[] vector1, double[] vector2) {
        double distance = 0;

        if (vector1.length == vector2.length) {
            for (int i = 0; i < vector1.length; i++) {
                double temp = Math.pow((vector1[i] - vector2[i]), 2);
                distance += temp;
            }
            distance = Math.sqrt(distance);
        }
        return distance;
    }

    /**
     * 测试Java调用Python文件并执行
     *
     * @auth Yerenpeng
     */
    public static void javaCallsPython() throws Exception {
        System.out.println("start");
        String[] arrays = new String[]{"python", "D:\\IdeaProjects\\python\\Similarity\\Euclidean.py", "name", "age", "gender", "address"};
//        String[] args1 = new String[]{"python", "D:\\IdeaProjects\\python\\Similarity\\Euclidean.py"};
        Process pr = Runtime.getRuntime().exec(arrays);

        BufferedReader in = new BufferedReader(new InputStreamReader(
                pr.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(new String(line.getBytes(), "utf8"));
        }
        in.close();
        pr.waitFor();
        System.out.println("end");
    }

    public static void main(String[] args) throws Exception {
        javaCallsPython();
    }

}

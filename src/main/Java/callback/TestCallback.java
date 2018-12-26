package callback;


public class TestCallback {

    public static void main(String[] args) throws Exception {
        Student stu = new GraduationStu();
        Teacher teacher = new Teacher(stu, new int[]{1, 2, 3, 4}, "add");
        Teacher teacher1 = new Teacher(stu, new int[]{1, 2, 3, 4}, "sub");
        Teacher teacher2 = new Teacher(stu, new int[]{1, 2, 3, 4}, "mul");
        Teacher teacher3 = new Teacher(stu, new int[]{1, 2, 3, 4}, "div");
        teacher.askQuestion();
        teacher1.askQuestion();
        teacher2.askQuestion();
        teacher3.askQuestion();
    }

}

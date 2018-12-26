package callback;

public class Teacher implements CallBack {

    private Student student;
    private int[] nums;
    private String calType;

    public Teacher(Student student, int[] nums, String calType) {
        this.student = student;
        this.nums = nums;
        this.calType = calType;
    }

    public void askQuestion() {
        // 反过来Student的实例对象调用CallBack的实现方法
        student.resloveQuestion(this,nums,calType);
    }

    @Override
    public void tellAnswer(int answer) {
        System.out.println("老师已经收到你的答案是：" + answer);
    }
}

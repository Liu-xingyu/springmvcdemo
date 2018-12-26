package callback;

public class GraduationStu implements Student {

    @Override
    public void resloveQuestion(CallBack callBack, int[] nums, String calType) {
        int answer = 0;
        switch (calType) {
            case "add":
                answer = CalculateUtils.add(nums);
                break;
            case "sub":
                answer = CalculateUtils.sub(nums);
                break;
            case "mul":
                answer = CalculateUtils.mul(nums);
                break;
            case "div":
                answer = CalculateUtils.div(nums);
                break;
            default:
                System.err.println("The Calculator Method Is Not Exists");
                return;
        }
        // 调用回调方法实现结果回显
        callBack.tellAnswer(answer);
    }
}

package callback;

/**
 * 计算类，适用于接口回调计算
 */
public class CalculateUtils {

    /**
     * 加法
     *
     * @param nums
     * @return
     */
    public static int add(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        return total;
    }

    /**
     * 减法
     *
     * @param nums
     * @return
     */
    public static int sub(int[] nums) {
        int total = nums[0];
        for (int i = 1; i < nums.length; i++) {
            total -= nums[i];
        }
        return total;
    }

    /**
     * 乘法
     *
     * @param nums
     * @return
     */
    public static int mul(int[] nums) {
        int total = 1;
        for (int i = 0; i < nums.length; i++) {
            total *= nums[i];
        }
        return total;
    }

    /**
     * 除法
     *
     * @param nums
     * @return
     */
    public static int div(int[] nums) {
        int total = nums[0];
        for (int i = 1; i < nums.length; i++) {
            total /= nums[i];
        }
        return total;
    }

}

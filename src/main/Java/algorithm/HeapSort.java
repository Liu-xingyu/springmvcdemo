package algorithm;

import java.util.LinkedList;

/**
 * 堆排序：<p>
 * 1. 创建堆
 * 2. 根据要求调整堆（大顶堆、小顶对）
 * 3. 调整为有顺序（完全二叉树）
 * <p>
 * 大顶堆：N>2*N  && N>2*N+1
 * 小顶堆：N<2*N  && N<2*N+1
 */
public class HeapSort {

    private static final String HEAP_LARGE = "large";
    private static final String HEAP_SMALL = "small";


    public static void main(String[] args) {

//        int[] nums = new int[]{9, 5, 2, 1, 4, 6, 7, 12};
        int[] nums = new int[]{4, 3, 5, 9, 1};

        int[] resultNums = createHeap(nums, nums.length, HEAP_SMALL);
        /*for (int i = 0; i < adjustHeap(resultNums, resultNums.length).length; i++) {
            System.out.print(nums[i] + " ");
        }*/
        for (int i = 0; i < resultNums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();
        System.out.println("=============================================");

        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <= 20; i++) {
            linkedList.add(i);
        }

        // Lambda表达式
        linkedList.forEach((index) -> System.out.print(index + " "));
    }

    // 创建堆,大顶堆是对的，小顶堆有问题
    public static int[] createHeap(int[] nums, int len, String pattern) {
        switch (pattern) {
            case HEAP_LARGE:
                // 从最后一个元素开始遍历，从后向前遍历
                for (int i = len - 1; i > 0; --i) {
                    if (i % 2 == 0) {
                        if (nums[i] >= nums[i - 1]) {
                            if (nums[i] > nums[(i - 1) / 2]) {
                                switchNum(nums, i, (i - 1) / 2);
                            }
                        } else {
                            if (nums[i - 1] > nums[(i - 1) / 2]) {
                                switchNum(nums, i - 1, (i - 1) / 2);
                            }
                        }
                    } else {
                        if (nums[i] > nums[(i - 1) / 2]) {
                            switchNum(nums, i, (i - 1) / 2);
                        }
                    }
                }
                break;
            case HEAP_SMALL:
                // 从最后一个元素开始遍历，从后向前遍历
                for (int i = len - 1; i > 0; --i) {
                    if (i % 2 == 0) {
                        if (nums[i] <= nums[i - 1]) {
                            if (nums[i] < nums[(i - 1) / 2]) {
                                switchNum(nums, i, (i - 1) / 2);
                            }
                        } else {
                            if (nums[i - 1] < nums[(i - 1) / 2]) {
                                switchNum(nums, i - 1, (i - 1) / 2);
                            }
                        }
                    } else {
                        if (nums[i] < nums[(i - 1) / 2]) {
                            switchNum(nums, i, (i - 1) / 2);
                        }
                    }
                }
                break;
            default:
                break;
        }
        return nums;
    }

    // 调整堆
    public static int[] adjustHeap(int[] nums, int len) {
        if (len > 0) {
            switchNum(nums, 0, len - 1);
            createHeap(nums, len - 1, HEAP_LARGE);
            adjustHeap(nums, len - 1);
        }

        return nums;
    }

    public static void switchNum(int[] nums, int preIndex, int postIndex) {
        int temp = nums[preIndex];
        nums[preIndex] = nums[postIndex];
        nums[postIndex] = temp;
    }

}

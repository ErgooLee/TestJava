package com.xiaowuzei.test.algr.leet;

public class N215_KthLargestElement {

    public static void main(String[] args) {
        int[] array = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(new N215_KthLargestElement().findKthLargest(array, 4));
        System.out.println(new N215_KthLargestElement().findKthLargest(array, 0, array.length - 1, 9));
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums[0];
        }
        buildHeap(nums);
        int tmp;
        int i;
        for (i = nums.length - 1; i >= nums.length - k; i--) {
            tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            maxHeapify(nums, 0, i);
        }
        return nums[i + 1];
    }

    public void buildHeap(int[] array) {
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            maxHeapify(array, i, array.length);
        }
    }

    public void maxHeapify(int[] array, int start, int end) {
        int tmp, leftChi, rightChi, max, index;
        tmp = array[start];
        index = start;
        while (2 * index + 1 < end) {
            leftChi = 2 * index + 1;
            rightChi = 2 * index + 2;
            if (rightChi < end && array[leftChi] < array[rightChi]) {
                max = rightChi;
            } else {
                max = leftChi;
            }
            if (tmp < array[max]) {
                array[index] = array[max];
            } else {
                break;
            }
            index = max;
        }
        array[index] = tmp;
    }


    private int findKthLargest(int[] nums, int begin, int end, int k) {
        if (begin == end) {
            return nums[begin];
        }
        int index = partation(nums, begin, end);
        if (index == end + 1 - k) {
            return nums[index];
        } else if (index < end + 1 - k) {
            return findKthLargest(nums, index + 1, end, k);
        } else {
            return findKthLargest(nums, begin, index - 1, k - (end - index + 1));
        }
    }

    private int partation(int[] nums, int begin, int end) {
        if (begin >= end) {
            return begin;
        }
        int left = begin;
        int right = end;
        int tmp = nums[begin];
        while (left < right) {
            while (left <= right && tmp <= nums[right--]) ;
            right++;
            nums[left] = nums[right];
            left++;
            while (left <= right && tmp >= nums[left++]) ;
            left--;
            nums[right] = nums[left];
            right--;
        }
        nums[left] = tmp;
        return left;
    }

}

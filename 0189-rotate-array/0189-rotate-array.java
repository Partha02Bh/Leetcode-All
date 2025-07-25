class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int n=nums.length;
        if(n==1){
            return;
        }
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-k-1);
        reverse(nums,0,n-1);
    }
    public void reverse(int[] nums,int low, int high) {
        while(low<high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }
}
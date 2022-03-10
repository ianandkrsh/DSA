class CycleSort {

    public static void main(String[] args) {
        int arr[] = {7,8,9,11,12};

        System.out.print(firstMissingPositive(arr));
    }

    static void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int firstMissingPositive(int[] nums) {

        int i =0;
        while(i<nums.length)
        {
            int correct = nums[i]-1;

            if(correct>=0 && correct < nums.length && nums[correct]!=nums[i] )
            {
                swap(nums,i,correct);
            }

            else
            {
                i++;
            }
        }

        for(int j : nums)
            System.out.print(j + " ");

        System.out.println();

        // Iterate to see if any element is missing and return it.
        for(i=1;i<=nums.length;i++){
            if(nums[i-1] != i)
                return i;
        }

        // If nothing is found, then return the next biggest element  from the array.
        return nums[nums.length-1]+1;
    }
}
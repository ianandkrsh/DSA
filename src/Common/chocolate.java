package Common;

public class chocolate {
     public static void main(String args[])
     {
         int[] nums = {1,2,3,4,5,6,7,8,9};
          System.out.println(maximizeSweetness(nums, 6));
     }

   static int maximizeSweetness(int nums[] , int m )
   {
       int start = Integer.MAX_VALUE;
       int end = 0;
       for(int i =0;i<nums.length;i++)
       {
           start = Math.min(start,nums[i]);
           end = end + nums[i];
       }
     end = end /m;
       while(start<end)
       {
           int mid = start + (end-start)/2;
           int sum = 0; int pieces =0 ;
           for(int num: nums)
           {
               sum += num;
               if(sum>=mid)
               {
                   sum = 0;
                   pieces ++;
               }



           }

           if(pieces >= m)
               start = mid;
           else
               end = mid-1;
       }

       return start;
   }





}



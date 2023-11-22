using System;
using System.Collections.Generic;
public class Solution{
    static void Main(){
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        int[] result = TwoSum(nums, target);

        Console.WriteLine($"Output: [{result[0]}, {result[1]}]");
    }
    public static int[] TwoSum(int[] nums, int target) {
        //Need somewhere to store the remainders and also their index so a Dictionary seems like the best option
         Dictionary<int, int> numDict = new Dictionary<int, int>();

        //Loop through everything exactly once for O(n)
        for (int i = 0; i < nums.Length; i++)
        {
            //
            int remainder = target - nums[i];

            if (numDict.ContainsKey(remainder))
            {
                return new int[] { i, numDict[remainder] };
            }

            numDict[nums[i]] = i;
        }
        //This Problem says that each input has one solution but you could easily make one without a solution
        return null;
    }
}
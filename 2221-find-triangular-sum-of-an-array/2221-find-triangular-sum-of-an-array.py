class Solution(object):
    def triangularSum(self, nums):
        n = len(nums)

        while(n > 1):
            for j in range(n-1): 
                nums[j] = (nums[j] + nums[j+1]) % 10
            n = n -1

        return nums[0]
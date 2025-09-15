class Solution(object):
    def sortArrayByParity(self, nums):
        i = 0
        j = len(nums)

        li = []
        for n in nums:
            if n % 2 == 0:
                li.insert(0,n)
            else:
                li.append(n)
        return li
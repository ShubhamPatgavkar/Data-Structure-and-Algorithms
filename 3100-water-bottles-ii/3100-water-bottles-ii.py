class Solution(object):
    def maxBottlesDrunk(self, full, numExchange):
        """
        :type numBottles: int
        :type numExchange: int
        :rtype: int
        """
        ans = full
        empty = full

        while(empty >= numExchange):
            ans += 1
            empty -= numExchange
            empty += 1
            numExchange += 1

        
        return ans
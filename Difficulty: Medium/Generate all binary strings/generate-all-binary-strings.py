class Solution:
    def binstr(self, n):
        # calculate from 0 to 2^n - 1
        
        res = []
        for i in range (2**n):
            res.append(format(i,f"0{n}b"))
        return res
        
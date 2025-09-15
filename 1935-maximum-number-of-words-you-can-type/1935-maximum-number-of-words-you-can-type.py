class Solution(object):
    def canBeTypedWords(self, text, brokenLetters):
        bl_set = set(brokenLetters)
        words =  text.split()
        ans = len(words)

        for word in words:
            for ch in bl_set:
                if ch in word:
                    ans -= 1
                    break

        return ans

class ContainerWithMostWater(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        n= len(height)
        i = 0
        j= n-1

        #al = 0
        al =[]
        while i<j:
            area = min(height[i],height[j]) * (j-i)
            #al=max(al,area)
            al.append(area)
        
            if height[i]<height[j]:
                i+= 1
            else:
                j-=1

      
        return max(al)
        
            
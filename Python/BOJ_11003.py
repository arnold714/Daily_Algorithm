import sys
from collections import deque
input = sys.stdin.readline

n,l = map(int, input().split())
mydeque = deque()
a = list(map(int,input().split()))



for i in range(n):
    while mydeque and mydeque[-1][0] > a[i]:
        mydeque.pop()
    mydeque.append((a[i],i))
    if(i-l >= mydeque[0][1]):
        mydeque.popleft()
    print(mydeque[0][0], end=' ')
    
            

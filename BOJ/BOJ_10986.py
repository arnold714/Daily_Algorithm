import sys
input = sys.stdin.readline

n, m = map(int, input().split())
#원본배열 A
A = list(map(int,input().split()))
S = [0] * n
C = [0] * m
answer = 0
S[0] = A[0]

for i in range(1,n):
    S[i] = S[i-1] + A[i]


for i in range(n):
    reminder = S[i] % m
    S.append(reminder)
    if(reminder==0):
        answer = answer + 1
    C[reminder] = C[reminder] + 1
    
for i in range(m):
    answer = answer+ (C[i]*(C[i]-1)/2)
    
print(int(answer))
    
    
   
    
            
     
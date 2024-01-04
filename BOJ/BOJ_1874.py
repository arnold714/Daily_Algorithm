import sys
input = sys.stdin.readline

n = int(input())
a = [0] * n
stack = []
num = 1
answer =""

for i in range(n):
    a[i] = int(input())
    
for j in range(n):
    if(num <= a[j]):
        while num <= a[j]:
            stack.append(num)
            num += 1
            answer += "+\n"
        stack.pop()
        answer += "-\n"
        
    else:
        n = stack.pop()
        if(a[j] != n):
            print("NO")
            exit()
            
        else:
            answer += "-\n"
            
print(answer)
        
            
    

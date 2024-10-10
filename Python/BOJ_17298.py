n = int(input())
a = list(map(int,input().split()))
answer = [0] * n
stack = []

#스택에 새로들어오는 수가 top에 존재하는 수보다 크면 그 수는 오큰수가 된다
#오큰수를 구한후 수열에서 오큰수가 존재하지 않는 숫자에 -1 출력

for i in range(n):
    while stack and a[stack[-1]] < a[i]:
        answer[stack.pop()] =a[i]
    stack.append(i)
    
while stack:
    answer[stack.pop()] = -1
        
result = ""
    
for i in range(n):
    print(answer[i], end=" ")       

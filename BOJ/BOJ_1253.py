import sys
input = sys.stdin.readline

n = int(input())
S = list(map(int,input().split()))
S.sort()
count = 0
sum = 0
first_index = 0
last_index = n-1

for i in range(n):
    first_index = 0
    last_index = n-1
    while first_index < last_index:
        sum = S[first_index] + S[last_index]
        if(S[i] == sum):
            if(i != first_index and i != last_index):
                count += 1
                break
            elif(i == first_index):
                first_index += 1
            elif(i == last_index):
                last_index -= 1
        elif(S[i] < sum):
            last_index -= 1
        elif(S[i] > sum):
            first_index += 1
        
print(count)
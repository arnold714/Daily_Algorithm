import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
S = list(map(int,input().split()))
S.sort()
count = 0
sum = 0

first_index = 0
last_index = n-1

while first_index < last_index:
    sum = S[first_index] + S[last_index]
    if(sum == m):
        count += 1
        first_index += 1
        last_index -= 1
    elif(sum < m):
        first_index += 1
    elif(sum > m):
        last_index -= 1

print(count)
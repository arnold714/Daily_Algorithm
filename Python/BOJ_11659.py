import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))
sum_arr = []
sum_arr.append(arr[0])

for i in range(N-1):
    sum_arr.append(sum_arr[i]+arr[i+1])

for i in range(M):
    j , k = map(int, input().split())
    if(j==1):
        print(sum_arr[k-1])
    else:
        print(sum_arr[k-1]-sum_arr[j-2])

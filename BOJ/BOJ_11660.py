import sys
input = sys.stdin.readline

n, m = map(int, input().split())
A = [[0] * (n+1)]
D = [[0] * (n+1) for i in range(n+1)]

#원본 배열 저장
for i in range(n):
    A_row = [0] + [int(x) for x in input().split()]
    A.append(A_row)
    
#합 배열 저장
for j in range(n):
    for k in range(n):
        D[j+1][k+1] = A[j+1][k+1] + D[j+1][k] + D[j][k+1] - D[j][k]
        
#결과 출력
for _ in range(m):
    x1, y1, x2, y2 = map(int, input().split())
    result = D[x2][y2] - D[x2][y1 - 1] - D[x1 - 1][y2] + D[x1 - 1][y1 - 1]
    print(result)
    
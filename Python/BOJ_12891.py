import sys
input = sys.stdin.readline

s,p = map(int,input().split())
arr = list(input())
min_code = list(map(int, input().split()))
count = 0
code = [0] * 4

for i in range(s-p+1):
    if(i==0):
        for j in range(p):
            if(arr[j]=='A'):
                code[0] += 1
            elif(arr[j]=='C'):
                code[1] += 1
            elif(arr[j]=='G'):
                code[2] += 1
            elif(arr[j]=='T'):
                code[3] += 1
        
        if(code[0]>=min_code[0]):
            if(code[1]>=min_code[1]):
                if(code[2]>=min_code[2]):
                    if(code[3]>=min_code[3]):
                        count += 1
    elif(i!=0):
        if(arr[i-1]=='A'):
            code[0] -= 1
        elif(arr[i-1]=='C'):
            code[1] -= 1
        elif(arr[i-1]=='G'):
            code[2] -= 1
        elif(arr[i-1]=='T'):
            code[3] -= 1  
                      
        if(arr[p+i-1]=='A'):
            code[0] += 1
        elif(arr[p+i-1]=='C'):
            code[1] += 1
        elif(arr[p+i-1]=='G'):
            code[2] += 1
        elif(arr[p+i-1]=='T'):
            code[3] += 1
            
        if(code[0]>=min_code[0]):
            if(code[1]>=min_code[1]):
                if(code[2]>=min_code[2]):
                    if(code[3]>=min_code[3]):
                        count += 1

        
            

print(count)

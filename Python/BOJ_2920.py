import sys
input = sys.stdin.readline
S = list(map(int,input().split()))

for i in range(7):
    if(abs(S[i+1]-S[i])!=1):
        print("mixed")
        break;
    elif(i==6):
        if(S[i+1]==8):
            print("ascending")
            break;
        elif(S[i+1]==1):
            print("descending")
            break;
        

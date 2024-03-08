import sys
input = sys.stdin.readline
n,m = map(int,input().split())

i=1;


if(m%10 in (3,5,7,9)):
    i= -1;
    
while i!=-1:
    if(m%10==1):
        m = m-1;
        m = m/10;
        i = i+1;
    elif(m%2==0):
        m = m/2;
        i = i+1;
    else:
        i=-1;
        break;
        
    if(m==n):
        break;
    elif(m<n):
        i=-1;
        break;
    
print(i);
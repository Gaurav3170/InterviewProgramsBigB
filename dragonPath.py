n,t=map(int,input().split())
arr=list(map(int,input().split()))
rem=sum(arr)
max_slayed=0
time_travelled=0
reborn_dragons=0
index=0
while(t>=0):
    max_slayed += arr[index]
    rem-=arr[index];
    t-=1
    time_travelled+=1
    if(index==0):
        index+=1
    elif(index==n-1):
        index-=1
    else:
        index = (index-1) if arr[index-1]>arr[index+1] else (index+1)
    if(time_travelled==2):
        time_travelled=0
        reborn_dragons=rem*2
        rem+=reborn_dragons
print(max_slayed)
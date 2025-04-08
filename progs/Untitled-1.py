rows = int(input("Enter row no = "))
cols = int(input("Enter col no = "))
l=[]
for i in range(rows):
    g=list(map(int,input().split(" ")))
    l.append(g)


def check_neigh(r,c,rows,cols):
    rm = rows
    cm = cols
    count=0
    for i in range(r-1,r+2):
        for j in range(c-1,c+2):
            if i<0 or i>=rm or j<0 or j>=cm:
                continue
            if i==r and j==c:
                continue
            else:
                if l[i][j]==1:
                    count+=1
    prev = l[r][c]
    return calc_val(count,prev)

def calc_val(n,a):
    count=n
    prev = a
    if prev == 1:
        if count==2 or count==3:
            return 1
        else:
            return 0
    else:
        if count==3:
            return 1
        else:
            return 0


l2=[]
for i in range(rows):
    g=[]
    for j in range(cols):
        a = check_neigh(i,j,rows,cols)
        g.append(a)
    l2.append(g)
for i in l2:
    print(i)
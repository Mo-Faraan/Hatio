class currState:
    def __init__(self,rows,cols):
        self.rows = rows
        self.cols = cols
    def input_matrix():
        l=[]
        for i in range(self.rows):
            g=list(map(int,input().split(" ")))
            l.append(g)

class nextState:
    def __init__(self,rows,cols):
        self.rows=rows
        self.cols=cols
    def generate_state():
        l2=[]
        for i in range(self.rows):
            g=[]
            for j in range(self.cols):
                a = check_neigh(i,j,self.rows,self.cols)
                g.append(a)
            l2.append(g)
        for i in l2:
            print(i)
    def check_neigh(self,rows,cols):
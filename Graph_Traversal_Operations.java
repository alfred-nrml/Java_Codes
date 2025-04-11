import java.util.*;

class Main{
    public static void main(String args[]){
        Graph g=new Graph(6);
      /*  g.addvertex(1);
        g.addvertex(2);
        g.addvertex(3);
        g.addvertex(4);
        g.addvertex(5);
        g.print();*/
        System.out.println("============================");
        g.undirected(1,2,2);
        g.undirected(1,3,3);
        g.undirected(2,3,1);
        g.undirected(3,4,1);
        g.undirected(4,3,5);
        g.directed(5,1,1);
         g.print();
        System.out.println("============================");
        g.bfs(1);
        System.out.println();
        g.dfs(1);
         System.out.println();
         g.print();
        System.out.println("============================");
    }
}
class GraphEdge{
    int src;
    int des;
    int weight;
    GraphEdge(int s,int d,int w){
        this.src=s;
        this.des=d;
        this.weight=w;
    }
    public int getsrc(){
        return src;
    }
    public int getdes(){
        return des;
    }
    public int getw(){
        return weight;
    }
}

class Graph{
    int vertices;
    List<GraphEdge>[] adjlist;
    Graph(int vertices){
        this.vertices=vertices;
        adjlist=new ArrayList[vertices];
        for(int i=0;i<vertices;i++){
            adjlist[i]=new ArrayList<>();
        }
    }
    
    /*public void addvertex(int v){
        adjlist.add(v);
        
    }*/
    public void directed(int s,int e,int w){
        GraphEdge edge=new GraphEdge(s,e,w);
        adjlist[s].add(edge);
    }
    public void undirected(int s,int e,int w){
        GraphEdge edges=new GraphEdge(s,e,w);
        GraphEdge edgee=new GraphEdge(e,s,w);
        adjlist[s].add(edges);
        adjlist[e].add(edgee);
    }
    /*public void removevertex(int v){
        adjlist.remove(v);
        for(int i=0;i<vertices;i++){
            adjlist[i].remove(v);
        }
    }*/
    public void bfs(int s){
        Set<Integer> v=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()){
            int curr=q.poll();
            System.out.print(curr+" ");
            v.add(curr);
            for(GraphEdge e:adjlist[curr]){
                int d=e.getdes();
                if(!v.contains(d)){
                q.add(d);
                v.add(d);
                }
            }
        }
    }
    public void dfs(int s){
        Set<Integer> v=new HashSet<>();
        Stack<Integer> st=new Stack<>();
        st.push(s);
        while(!st.isEmpty()){
            int curr=st.pop();
            System.out.print(curr+" ");
            v.add(curr);
            for(GraphEdge e:adjlist[curr]){
                int d=e.getdes();
                if(!v.contains(d)){
                    st.push(d);
                    v.add(d);
                }
            }
        }
    }
    public void print(){
        for(int i=0;i<vertices;i++){
            for(GraphEdge edge:adjlist[i]){
                System.out.print("Source : "+edge.getsrc()+" -->");
                System.out.print("Destination : "+edge.getdes()+" -->");
                System.out.print("Weight : "+edge.getw()+" -->");
                System.out.println();
            }
        }
    }
}

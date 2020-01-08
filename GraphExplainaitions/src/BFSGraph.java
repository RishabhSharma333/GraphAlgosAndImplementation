import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;



public class BFSGraph {
 
	static class Graph<T>{
		HashMap<T,HashSet<T>> graph=new HashMap<>();
		 void addVertex(T v) {
			 
			 graph.put(v,new HashSet<T>());
			 }
		 
		 void addEdge(T source, T destination,boolean bidirectional) {// tells if we want a direacted or undirected graph
			 if(!graph.containsKey(source)) {addVertex(source);}
			 if(!graph.containsKey(destination)) {addVertex(destination);}
			 if(bidirectional) {
				graph.get(source).add(destination) ;
				graph.get(destination).add(source);
			 }
			 else {
				 graph.get(source).add(destination);
			 }
			  }
		 
		 int getVertexCount() {
			return this.graph.keySet().size();
		 }
		 
		 int getEdgesCount(boolean bidirectional) {
               //return graph.forEach((T HashSet<T>)->{graph.get(key).size();});
			 //don't  know how to do it this way now
			 int count =0;
			 for (T v :graph.keySet()) {//goes through all the keySet
				 count=count+graph.get(v).size();
			 }
			 return bidirectional?(count/2):count;
		 }
		 
		 boolean hasEdge(T s,T d,boolean bidirectional) {
			 if(bidirectional) {return graph.get(s).contains(d)||graph.get(d).contains(s);}
			 else return graph.get(s).contains(d);
					 }
		 
		 boolean hasVertex(T v) {
			 return graph.containsKey(v);
			 }
		 
		 public String toString() {
			 StringBuilder st=new StringBuilder();
			 for(T v:graph.keySet()) {
				 st.append(v.toString()+": ");
				 for(T w:graph.get(v)) {
					 st.append(w.toString()+" " );
				 }
				 st.append("\n");
			 }
			 return st.toString();
		 }
		 
		 void Bfs(T v){
			 ArrayDeque<T> q=new ArrayDeque<T>();
			 HashSet <T> visited=new HashSet <T>();
			 q.add(v);
			 visited.add(v);
			 while(!q.isEmpty()) {
				 T w=q.poll();
				 
				 System.out.println(w);
				  
				 for (T y:graph.get(w)) {
					 if(!visited.contains(y)) {
						 visited.add(y);
						 q.add(y);
						 }
					 }
			 }
         }
		 
		     
		 
		}
	
	public static void main(String[] args) {
		Graph<Integer> g=new Graph<Integer>();
		g.addEdge(0, 1, false); 
        g.addEdge(0, 4, false); 
        g.addEdge(1, 2, false); 
        g.addEdge(1, 3, false); 
        g.addEdge(1, 4, false); 
        g.addEdge(2, 3, false); 
        g.addEdge(3, 4, false); 
        g.addEdge(2, 0, false);
        System.out.println(g);
        g.Bfs(3);
        System.out.println();
        g.Bfs(0);
        System.out.println();
        g.Bfs(1);
        System.out.println();
        g.Bfs(2);
        System.out.println();
        g.Bfs(4);

	}

}

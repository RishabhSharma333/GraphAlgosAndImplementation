import java.util.HashMap;
import java.util.HashSet;

public class DFSGraph<T> {
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
		 void Dfs(T v) {
			 
			 HashSet<T> visited=new HashSet<T>();
			     
				 DfsUtil(v,visited);
			 
		 }
		 void DfsUtil(T v ,HashSet<T> visited) {
			 visited.add(v);
			 System.out.println(v +" ");
			 for (T w:graph.get(v)) {
				 if(!visited.contains(w)) {
					 DfsUtil(w,visited);
				 }
			 }
			     
		 }
		 
		}
	public static void main(String[] args) {
		Graph<Integer> g=new Graph<Integer>();
		//creating a directional graph
		g.addEdge(0, 1, true); 
        g.addEdge(0, 4, true); 
        g.addEdge(1, 2, true); 
        g.addEdge(1, 3, true); 
        g.addEdge(1, 4, true); 
        g.addEdge(2, 3, true); 
        g.addEdge(3, 4, true); 
        System.out.println(g);
          g.Dfs(2);
          System.out.println( );
          g.Dfs(3);
          System.out.println();
          g.Dfs(4);
          System.out.println();
          g.Dfs(0);
          System.out.println();
          g.Dfs(1);
		
	}
	
	
	  

}

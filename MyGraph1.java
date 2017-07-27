package Practice1DS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MyGraph1 {	
	
	public class Vertex{
		String label;
		ArrayList<Edge> neighbours;		
	
		public Vertex(String l){
			this.label=label;
			this.neighbours = new ArrayList<Edge>();			
		}		
		public void addNeighbour(Edge e){
			if(this.neighbours.contains(e)){
				return ;
			}
			 this.neighbours.add(e);			
		}		
		public int hashcode(){
			return (this.label.hashCode());			
		}		
		public Edge getNeighbours(int index){
			return this.neighbours.get(index);			
		}
		public ArrayList<Edge> getAllNeighbours(){
			return this.neighbours;
		}
		public int getNeighboursCount(){
			return this.neighbours.size();
		}
		public boolean containsNeighbour(Edge e){
			return this.neighbours.contains(e);
		}
		public Edge removeNeighbour(int index){
			return this.neighbours.remove(index);
		}
		public void removeNeighbour(Edge e){
			this.neighbours.remove(e);
		}		
		public String getLable(){
			return this.label;			
		}
		public String toString(){
			return "Vertex " + label;			
		}
		public boolean equals(Object v){
			if(!(v instanceof Vertex)){
				return false;
			}
			return this.label.equals((Vertex)v);
		}	
	}
	
	public class Edge implements Comparable<Edge>{			
		//one,two,wt
		Vertex one;
		Vertex two;
		int weight;
		//contructor - without wt default to 1
		public Edge(Vertex one, Vertex two){
			this.one=one;
			this.two=two;
			this.weight=1;
		}
		//contructor - with wt or without wt default to 1
		public Edge(Vertex one, Vertex two, int wt){
			this.one=one;
			this.two=two;
			this.weight=wt;
		}
		//getOne()
		public Vertex getOne(){
			return this.one;
		}
		//getTwo()
		public Vertex getTwo(){
			return this.two;
		}
		//getWeight()
		public int getWeight(){
			return this.weight;
		}
		//setWeight()
		public void setWeight(int weight){
			this.weight=weight;
		}		
		//getTheOtherVertex
		public Vertex getTheOtherVertex(Vertex v){
			if(!(v.equals(this.one) || v.equals(this.two))){
				return null;
				}			
			return(v.equals(this.one)) ? two:one;
		}
		//toString()
		public String toString(){
			return ("{" +one+ ","+ two + "-" +"}");
		}
		//hashCode
		public int hashCode(){
			return (this.one.getLable()+this.two.getLable()).hashCode();
		}
		//equals
		public boolean equals(Edge e){
			if(!(e instanceof Edge)) return false;
			return ((this.one == e.one || this.one == e.two ) && (this.two == e.one || this.two == e.two));			
		}
		//compareTo compares the wt
		@Override
		public int compareTo(Edge e) {
			// TODO Auto-generated method stub
			return this.weight = e.getWeight();
		}
	}
	public class Graph{			
		//HashMap vertices, edges
		HashMap<String, Vertex> vertices ;
		HashMap<Integer, Edge> edges ;
		//Constructor without vertices
		public Graph(){
			vertices = new HashMap<String, Vertex> ();
			edges = new HashMap<Integer, Edge>();
		}
		//Constructor with vertices
		public Graph(ArrayList<Vertex> vList){
			vertices = new HashMap<String, Vertex> ();
			edges = new HashMap<Integer, Edge>();
			for( Vertex v : vList){
				vertices.put(v.getLable(), v);
			}
		}
		//addVertex
		public boolean addVertex(Vertex v,boolean canBeOverwritten){
			//if already exists, return false
			if(this.vertices.get(v.getLable()) != null) {
				if(!canBeOverwritten)
				return false;
			else{
				while(v.getNeighboursCount()>0){
					this.vertices.remove(v.getNeighbours(0));
				}
			}				
			}
			//add
			vertices.put(v.getLable(), v);
			return true;
		}
		//containsVertex
		public boolean containsVertex(Vertex v){
			return (this.vertices.get(v.getLable()) != null);
		}
		//removeVertex
		public Vertex removeVertex(String label){
			Vertex v = this.vertices.remove(label);
			while(v.getNeighboursCount()>0){
				v.removeNeighbour(0);
				}
			return v;
		}
		//Vertex keys
		public Set<String> getVertexKeys(){
			return this.vertices.keySet();
		}
		//containsEdge
		public boolean containsEdge(Edge e){
			//not a valid Edge
			if((e.getOne() ==null || e.getTwo()== null)) return false;
			
			return this.edges.containsKey(e.hashCode());
		}
		//removeEdge
		public boolean removeEdge(Edge e){
			e.getOne().removeNeighbour(e);
			e.getTwo().removeNeighbour(e);
			return this.edges.remove(e.hashCode())!= null;
		}
		//getEdges()
		public Set<Edge> getEdges(){
			return new HashSet<Edge>(this.edges.values());
		}
		//addEdge	
		public boolean addEdge(Edge e){
			//if self loop
			if(e.getOne().getLable() == e.getTwo().getLable()){
				return false;
			}
			else{//if Edge already there
				if(this.edges.containsKey(e.hashCode())){
					return false;
				}
			}
			this.edges.put(e.hashCode(), e);
			e.getOne().addNeighbour(e);
			e.getTwo().addNeighbour(e);return true;
		}
	}

	public static void main(String[] args) {
		

	}

}

import java.util.ArrayList;

public class Graph<E> {
	ArrayList<E> edges = new ArrayList<E>();
	ArrayList<Node<E>> vertices = new ArrayList<Node<E>>();
	int numEd = 0;
	int numVe = 0;
	
	public Graph()  {
	}

	public void addNode(int id, E lfsr){
		vertices.add((Node<E>) new Node<>(id,lfsr));
		numVe++;
	}

	public void addNode(Node<E> v){
		vertices.add((Node<E>)v);
		numVe++;
	}

	public boolean hasNodeId(int id){
		boolean ret = false;
		if(id > numVe) 
			return false;
		if(vertices.contains(id)) ret = true;
		return ret;
	}

	public Node<E> getNode(int id){
		return (Node<E>) vertices.get(id);
	}

	@SuppressWarnings("unchecked")
	public void addEdge(int ida, int idb){
		Edge<E> ed = new Edge<E>(vertices.get(ida),vertices.get(idb),numEd);
		edges.add((E) ed);
	}

	public int numVertices(){
		return 0;
	}

	public boolean containsNode(Node<E> v) {
		return false;
	}

	public int numEdges() {
		return 0;
	}

	public Iterable<Node<E>> vertices() {
		return null;
	}
}
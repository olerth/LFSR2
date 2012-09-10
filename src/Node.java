import java.util.Iterator;
import java.util.ArrayList;

public class Node<E> implements Iterable<E> {
	E lf;
	int id;
	ArrayList<E> list = new ArrayList<E>();
	
	public Node(int id, E lf) {
		this.lf = lf;
		this.id = id;
	}

	public void addEdge(Edge<E> e){
		
	}

	public Node<E> getParent(){
		return null;
	}

	public void setParent(Node<E> p){
	}

	public Iterable<Edge<E>> incidentEdges() {
		return null;
	}

	public Iterable<Node<E>> neighbors() {
		return null;
	}

	public boolean isNeighbor(Node<E> v){
		return false;
	}

	public int getId() {
		return id;
	}

	public E getElement() {
		return lf;
	}

	public String toString() {
		return "Polynomial: "+((LFSR) lf).getMaskHex();
	}

	@Override
	public Iterator<E> iterator() {
		Iterator<E> iter = null;
		return iter;
	}

}

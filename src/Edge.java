//import exceptions.InvalidPositionException;

public class Edge<E>{
	int id;
	Node<E> a;
	Node<E> b;
	public Edge(Node<E> a, Node<E> b, int id) {
		this.a = a;
		this.b = b;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public Node<E> opposite(Node<E> v) {
		
		return null;
	}

	public Node<E>[] endVertices() {
		
		return null;
	}

	public Integer getElement() {
		
		return null;
	}

	public String toString() {
		
		return null;
	}
}
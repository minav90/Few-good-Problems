import java.util.ArrayList;

public class Node {

	int id;
	Node parent;
	int depth;
	float heur;
	
	int xCor;
	int yCor;
	
	ArrayList<Node> adjacents = new ArrayList<Node>();
	ArrayList<Node> traceback = new ArrayList<Node>();
	
	/* constructor accepting data */
	public Node(int data) {
		this.id = data;
	}

	/* constructor accepting data and parent Node*/
	public Node(int id, Node parent) {
		this.id = id;
		this.parent = parent;
	}

	public int getId() {
		return id;
	}

	public void setId(int data) {
		this.id = data;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public float getHeur() {
		return heur;
	}

	public void setHeur(float heur) {
		this.heur = heur;
	}

	public ArrayList<Node> getSuccessors() {
		return adjacents;
	}

	public void setSuccessors(ArrayList<Node> successors) {
		this.adjacents = successors;
	}

	public ArrayList<Node> getTraceback() {
		return traceback;
	}

	public void setTraceback(ArrayList<Node> traceback) {
		this.traceback = traceback;
	}

	public int getxCor() {
		return xCor;
	}
	
	public void setxCor(int xCor) {
		this.xCor = xCor;
	}
	
	public int getyCor() {
		return yCor;
	}
	
	public void setyCor(int yCor) {
		this.yCor = yCor;
	}
}

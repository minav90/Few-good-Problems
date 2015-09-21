import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GenerateNodes {

	static HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();
	static int number_of_vertices;
	static int number_of_edges;

	public static void main(String[] args) throws IOException {

		try {
			/** preparing graph from input file */
			prepareGraphFromFileInput();

			Scanner in = new Scanner(System.in);
			System.out.println("Welcome!!! to the Search Comparison");

			
				System.out.println("    ");
				System.out.println("Enter Start Vertex Co-ordinates x & y with space");
				StringTokenizer startVertex = new StringTokenizer(in.nextLine());
				int source_vertex_xCor = Integer.parseInt(startVertex.nextToken());
				int source_vertex_yCor = Integer.parseInt(startVertex.nextToken());
				int vertex = getVertex(source_vertex_xCor, source_vertex_yCor);
				if (vertex < 0) {
					System.out.println("Invalid Input : No Such Vertex start Again");
				}
				int source_vertex = vertex;

				System.out.println("Enter Goal Vertex Co-ordinates x & y with space");
				StringTokenizer goalVertex = new StringTokenizer(in.nextLine());
				int goal_vertex_xCor = Integer.parseInt(goalVertex.nextToken());
				int goal_vertex_yCor = Integer.parseInt(goalVertex.nextToken());
				int vertexGoal = getVertex(goal_vertex_xCor, goal_vertex_yCor);
				if (vertexGoal < 0) {
					System.out.println("Invalid Input : No Such Vertex start Again");
				}
				int goal_vertex = vertexGoal;

				Node root = nodes.get(source_vertex);
				Node goal = nodes.get(goal_vertex);

				int data = goal.getId();

				/** Computing Heuristic value for nodes */
				computeHeuristicVal(goal);
				System.out.println("-------------------------");
				/** BFS Search */
				doBFSSearch(root, data);
				System.out.println("-------------------------");

				/** DFS Search */
				doDFSSearch(root, data);
				System.out.println("-------------------------");

				/** GreedyBFS Search */
				doGreedyBFSSearch(root, data);
				System.out.println("   ");
				System.out.println("----------BYE-------------");
		} catch (Exception e) {
			System.out.println("Error in computing or Input");
			throw e;
		}
	}

	private static int getVertex(int xCor, int yCor) {
		for (int i = 0; i < nodes.size(); i++) {
			Node node = nodes.get(i);
			if (node.getxCor() == xCor && node.getyCor() == yCor) {
				return i;
			}
		}
		return -1;
	}

	private static void prepareGraphFromFileInput() throws FileNotFoundException, IOException {

		BufferedReader bIS = new BufferedReader(new FileReader("./Input.txt"));

		number_of_vertices = getNumberOfVertices(bIS);
		for (int i = 0; i < number_of_vertices; i++) {
			StringTokenizer vertice = new StringTokenizer(bIS.readLine());
			createNode(nodes, vertice);
		}

		number_of_edges = getNumerOfEdges(bIS);
		for (int i = 0; i < number_of_edges; i++) {
			StringTokenizer edge = new StringTokenizer(bIS.readLine());
			addEdgeToNodes(edge);
		}
	}

	private static void computeHeuristicVal(Node goal) {
		for (int i = 0; i < nodes.size(); i++) {
			Node source = nodes.get(i);
			source.setHeur(calculateHeuristicVal(goal, source));
		}
	}

	private static void doGreedyBFSSearch(Node root, int data) {
		GreedyBFS greedybfs = new GreedyBFS();
		System.out.println("Search Algorithm = GreedyBFS");
		System.out.println("Vertices = " + number_of_vertices + " Edges = " + number_of_edges);
		System.out.println("                          ");
		greedybfs.search(root, data);
	}

	private static void doDFSSearch(Node root, int data) {
		DFS dfs = new DFS();
		System.out.println("Search Algorithm = DFS");
		System.out.println("Vertices = " + number_of_vertices + " Edges = " + number_of_edges);
		dfs.search(root, data);
	}

	private static void doBFSSearch(Node root, int data) {
		BFS bfs = new BFS();
		System.out.println("Search Algorithm = BFS");
		System.out.println("Vertices = " + number_of_vertices + " Edges = " + number_of_edges);
		bfs.search(root, data);
		System.out.println("                          ");
	}

	private static float calculateHeuristicVal(Node goal, Node source) {
		return (float) Math.sqrt(Math.pow(Math.abs(source.getxCor() - goal.getxCor()), 2)
				+ Math.pow(Math.abs(source.getyCor() - goal.getyCor()), 2));
	}

	private static void addEdgeToNodes(StringTokenizer edge) {
		edge.nextToken();
		Node currentElement = nodes.get(Integer.parseInt(edge.nextToken()));
		Node successorElement = nodes.get(Integer.parseInt(edge.nextToken()));
		currentElement.adjacents.add(successorElement);
		successorElement.adjacents.add(currentElement);
	}

	private static int getNumerOfEdges(BufferedReader bIS) throws IOException {
		StringTokenizer st = new StringTokenizer(bIS.readLine());
		st.nextToken();
		return Integer.parseInt(st.nextToken());
	}

	private static void createNode(HashMap<Integer, Node> nodes, StringTokenizer vertice) {
		int id = Integer.parseInt(vertice.nextToken());
		Node node = new Node(id);
		node.setxCor(Integer.parseInt(vertice.nextToken()));
		node.setyCor(Integer.parseInt(vertice.nextToken()));
		nodes.put(id, node);
	}

	private static int getNumberOfVertices(BufferedReader bIS) throws IOException {
		StringTokenizer st = new StringTokenizer(bIS.readLine());
		st.nextToken();
		return Integer.parseInt(st.nextToken());
	}

}

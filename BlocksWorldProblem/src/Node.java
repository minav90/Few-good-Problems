import java.util.ArrayList;

public class Node {
	
	ArrayList<ArrayList<SubNode>> state;
	
	int heuristicVal;
	int distFromRoot;
    int finalFunctionalVal;
    String stateCondition;
    Node parent;
    int correctVal;
	
	

	public int getCorrectVal() {
		return correctVal;
	}

	public void setCorrectVal(int correctVal) {
		this.correctVal = correctVal;
	}

	public String getStateCondition() {
		return stateCondition;
	}

	public void setStateCondition(String stateCondition) {
		this.stateCondition = stateCondition;
	}

	public int getFinalFunctionalVal() {
		finalFunctionalVal = heuristicVal + distFromRoot;
		return finalFunctionalVal;
	}

	public int getHeuristicVal() {
		return heuristicVal;
	}

	public void setHeuristicVal(int heuristicVal) {
		this.heuristicVal = heuristicVal;
	}

	public int getDistFromRoot() {
		return distFromRoot;
	}

	public void setDistFromRoot(int distFromRoot) {
		this.distFromRoot = distFromRoot;
	}

	public ArrayList<ArrayList<SubNode>> getState() {
		return state;
	}

	public void setState(ArrayList<ArrayList<SubNode>> state) {
		this.state = state;
	}

	public Node(ArrayList<ArrayList<SubNode>> state) {
		super();
		this.state = state;
	}

		
	
	
	
	
}



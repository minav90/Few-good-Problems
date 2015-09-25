import java.util.ArrayList;

public class BlocksWorld {

	static int no_of_blocks = 10;
	public static void main(String[] args) {

		Node intialState = new Node(intialState());
		intialState.setStateCondition("#D#EFIJ#BG#CH#A");
		intialState.setDistFromRoot(0);
		intialState.setCorrectVal(0);
		intialState.setHeuristicVal(computeHeuristicVal(intialState));
		GreedyQueue queue = new GreedyQueue();
		queue.search(intialState);
	}

	private static ArrayList<ArrayList<SubNode>> intialState() {
		ArrayList<SubNode> target = new ArrayList<SubNode>();
		target.add(new SubNode("D", false));
		ArrayList<SubNode> arr1 = new ArrayList<SubNode>();
		arr1.add(new SubNode("E", false));
		arr1.add(new SubNode("F", false));
		arr1.add(new SubNode("I", false));
		arr1.add(new SubNode("J", false));
		ArrayList<SubNode> arr2 = new ArrayList<SubNode>();
		arr2.add(new SubNode("B", false));
		arr2.add(new SubNode("G", false));
		ArrayList<SubNode> arr3 = new ArrayList<SubNode>();
		arr3.add(new SubNode("C", false));
		arr3.add(new SubNode("H", false));
		ArrayList<SubNode> arr4 = new ArrayList<SubNode>();
		arr4.add(new SubNode("A", false));
		ArrayList<ArrayList<SubNode>> state = new ArrayList<ArrayList<SubNode>>();
		state.add(target);
		state.add(arr1);
		state.add(arr2);
		state.add(arr3);
		state.add(arr4);
		return state;
	}

	public static int computeHeuristicVal(Node state) {
		int finalHeuristic = 0;
		int carry = 0;
		ArrayList<ArrayList<SubNode>> stacks = state.getState();
		int number_of_element_on_targetStack = stacks.get(0).size();
		int correctnessOfState = state.getCorrectVal();
		if (number_of_element_on_targetStack == correctnessOfState) {
			carry = 0;
		} else {
			carry = number_of_element_on_targetStack - correctnessOfState;
		}
		for (int i = 0; i < stacks.size(); i++) {
			ArrayList<SubNode> stack = stacks.get(i);
			for (int j = 0; j < stack.size(); j++) {
				SubNode subNode = stack.get(j);
				if (subNode.isAtCorrectPosition()) {
					finalHeuristic = finalHeuristic + 0;
				} else {
					int previousElement = (int) subNode.getVal().charAt(0) - 65;
					if (j == stack.size() - 1) {
						finalHeuristic = finalHeuristic + 1 + carry + (previousElement - correctnessOfState);
					} else {
						finalHeuristic = finalHeuristic + (stack.size() - 1 - j) + carry + 1
								+ (previousElement - correctnessOfState);
					}

				}
			}
		}
		return finalHeuristic;
	}

}

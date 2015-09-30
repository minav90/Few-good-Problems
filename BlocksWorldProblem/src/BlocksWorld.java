import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BlocksWorld {

	static int no_of_blocks;
	static int no_of_stacks;

	public static void main(String[] args) {

		System.out.println("Welcome to the Blocks World");
		intialize();
		Node intialState = generateIntialState(initializeStack());
		System.out.println("Initial state :");
		new GreedyQueue().printElement(intialState);
		System.out.println("");

		GreedyQueue queue = new GreedyQueue();
		queue.search(intialState);
	}

	private static ArrayList<ArrayList<SubNode>> initializeStack() {
		ArrayList<ArrayList<SubNode>> stacks = new ArrayList<ArrayList<SubNode>>();
		for (int i = 0; i < no_of_stacks; i++) {
			ArrayList<SubNode> temp = new ArrayList<SubNode>();
			stacks.add(temp);
		}
		ArrayList<SubNode> targetStack = stacks.get(0);
		for (int i = 0; i < no_of_blocks; i++) {
			targetStack.add(new SubNode(((char) (65 + i)) + "", false));
		}
		return stacks;
	}

	private static void intialize() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of Blocks");
		no_of_blocks = sc.nextInt();
		System.out.println("Enter Number of Stacks");
		no_of_stacks = sc.nextInt();
		if (no_of_stacks == 1) {
			System.out.println("Goal State Cannot be Reached using only 1 Stack");
			System.exit(0);
		}
	}

	private static Node generateIntialState(ArrayList<ArrayList<SubNode>> stacks) {
		ArrayList<SubNode> targetStack = stacks.get(0);
		for (int i = 0; i < no_of_blocks; i++) {
			SubNode val = targetStack.get(targetStack.size() - 1);
			targetStack.remove(targetStack.size() - 1);
			stacks.get(randInt(1, no_of_stacks - 1)).add(val);
		}
		for (int i = 0; i < 20; i++) {
			ArrayList<SubNode> randomStack = stacks.get(randInt(0, no_of_stacks - 1));
			if (!randomStack.isEmpty()) {
				SubNode val = randomStack.get(randomStack.size() - 1);
				randomStack.remove(randomStack.size() - 1);
				stacks.get(randInt(0, no_of_stacks - 1)).add(val);
			}
		}
		Node intialState = new Node(stacks);
		updateElementsAtCorrectPosition(intialState);
		new GreedyQueue().computeConditionStateAndCorrectness(intialState);
		intialState.setDistFromRoot(0);
		intialState.setHeuristicVal(computeHeuristicVal(intialState));
		return intialState;
	}

	private static void updateElementsAtCorrectPosition(Node intialState) {

		ArrayList<SubNode> targetStack = intialState.getState().get(0);
		int i = 0;
		while (i < targetStack.size() && targetStack.get(i).getVal().equals(((char) (65 + i)) + "")) {
			targetStack.get(i).setAtCorrectPosition(true);
			i++;
		}
	}

	public static int randInt(int min, int max) {

		int randomNum = new Random().nextInt((max - min) + 1) + min;
		return randomNum;
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


public class SubNode {

	String val;
	boolean atCorrectPosition;
	
	public boolean isAtCorrectPosition() {
		return atCorrectPosition;
	}
	public SubNode(String val, boolean atCorrectPosition) {
		this.val = val;
		this.atCorrectPosition = atCorrectPosition;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	public void setAtCorrectPosition(boolean atCorrectPosition) {
		this.atCorrectPosition = atCorrectPosition;
	}
	
	
	
}

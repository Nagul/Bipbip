package pathfind;

public abstract class TypeNode {

	protected String id;
	protected Side s;
	
	public TypeNode(String i) {
		id = i;
		s = null;
	}
	
	public String getId() {
		return id;
	}
	
	public Side getSide() {
		return s;
	}

	public void setSide(Side s) {
		this.s = s;
	}
	
}

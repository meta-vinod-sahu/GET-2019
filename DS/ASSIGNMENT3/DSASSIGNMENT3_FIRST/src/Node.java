import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Node {
	private List<Node> children = new ArrayList<Node>();
	private Node parent = null;
	private String data = null;
	private Date dateOfCreation;

	public Node(String data, Node parent) {
		this.data = data;
		this.parent = parent;
		dateOfCreation = new Date();
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public List<Node> getChildren() {
		return children;
	}

	public Node getParent() {
		return parent;
	}

	public void addChild(Node child) {
		this.children.add(child);
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public boolean isRoot() {
		return (this.parent == null);
	}

	public boolean isLeaf() {
		return this.children.size() == 0;
	}

	public void removeParent() {
		this.parent = null;
	}
}
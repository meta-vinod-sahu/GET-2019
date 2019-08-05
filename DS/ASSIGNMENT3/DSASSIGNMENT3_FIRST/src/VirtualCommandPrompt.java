import java.util.ArrayList;
/**
 * command prompt with different functions
 */
import java.util.List;

public class VirtualCommandPrompt {
	Node root = new Node("R:\\", null);
	Node currentNode = root;
	String path = "R:\\";
	List<String> pathSearch = new ArrayList<>();

	/**
	 * Create a new directory
	 * 
	 * @param folderName
	 * @return
	 * @throws Exception
	 */
	public boolean mkdir(String folderName) throws Exception {
		for (Node node : currentNode.getChildren()) {
			if (node.getData().equals(folderName)) {
				throw new Exception("Folder Name already Exists");
			}
		}
		currentNode.addChild(new Node(folderName, currentNode));
		return true;
	}

	/**
	 * Change Directories
	 * 
	 * @param current path
	 * @return path with cd folder
	 */
	public String cd(String path) {
		for (int i = 0; i < currentNode.getChildren().size(); i++) {
			if (currentNode.getChildren().get(i).getData().equals(path)) {
				if (currentNode.getData().equals("R:\\")) {
					currentNode = currentNode.getChildren().get(i);
					this.path += path;
					break;
				}
				currentNode = currentNode.getChildren().get(i);
				this.path += "\\" + path;
				break;
			}
		}
		return this.path;
	}

	/**
	 * Move to parent directory
	 * 
	 * @return back to the current folder
	 * @throws CommandPromptException
	 */
	public String bk() throws Exception {
		if (currentNode.getParent() == null) {
			throw new Exception("Can't go to Parent Directory, already in Root");
		}
		currentNode = currentNode.getParent();
		String tokens[] = path.toString().split("\\\\");
		path = "";
		int i = 0;

		// Appending tokens to the path
		for (; i < tokens.length - 2; i++) {
			path += tokens[i] + "\\";
		}
		if (path.equals("")) {
			path += tokens[i] + "\\";
			return path;
		}
		path += tokens[i];
		return path;
	}

	/**
	 * Display list of all folders in the current folder along with their
	 * date-time of creation.
	 * 
	 * @return list of children folders
	 */
	public List<ListOfChildren> ls() {
		List<ListOfChildren> listOfSubNodes = new ArrayList<ListOfChildren>();
		List<Node> childrenOfNode = new ArrayList<Node>();
		childrenOfNode = currentNode.getChildren();
		for (int i = 0; i < childrenOfNode.size(); i++) {
			listOfSubNodes.add(new ListOfChildren(childrenOfNode.get(i)
					.getDateOfCreation(), childrenOfNode.get(i).getData()));
		}
		return listOfSubNodes;
	}

	/**
	 * Find a folder in current or sub-folders
	 * 
	 * @param folderName
	 * @param node
	 * @param pathToSearch
	 * @return
	 */
	public List<String> find(String folderName, Node node, String pathToSearch) {
		if (node == null) {
			throw new NullPointerException("Node can't be empty in find");
		}
		if (pathToSearch == null) {
			throw new NullPointerException("pathToSearch can't be Empty");
		}
		if (pathToSearch == "") {
			pathSearch.clear();
		}
		List<Node> childrenOfNode = new ArrayList<Node>();
		childrenOfNode = node.getChildren();
		for (int i = 0; i < childrenOfNode.size(); i++) {
			if (childrenOfNode.get(i).getData().equals(folderName)) {
				if (path.equals("R:\\")) {
					pathSearch.add(path + pathToSearch + folderName);
					find(folderName, childrenOfNode.get(i),
							childrenOfNode.get(i).getData() + "\\");
					continue;
				}
				pathSearch.add(path + "\\" + pathToSearch + folderName);
				find(folderName, childrenOfNode.get(i), childrenOfNode.get(i)
						.getData() + "\\");
			} else if (childrenOfNode.get(i).getChildren().size() > 0) {
				find(folderName, childrenOfNode.get(i), childrenOfNode.get(i)
						.getData() + "\\");
			}
		}
		return pathSearch;
	}

	/**
	 * To display the complete directory structure
	 * 
	 * @param current
	 * @param countLevels
	 */
	public void tree(Node current, int countLevels) {
		if (current == null) {
			throw new NullPointerException(
					"Current Node can't be empty in tree");
		}
		for (int i = 0; i < countLevels; i++) {
			System.out.print("\t");
		}
		System.out.println("|_____ " + current.getData());
		for (int j = 0; j < current.getChildren().size(); j++) {
			tree(current.getChildren().get(j), countLevels + 1);
		}
		return;
	}

	/**
	 * Exit the VCP
	 */
	public void exit() {
		System.exit(0);
	}
}
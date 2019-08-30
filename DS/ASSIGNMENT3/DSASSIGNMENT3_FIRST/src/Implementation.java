import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Implementation class describe as command prompt 
 *
 */
public class Implementation {

	public static void main(String[] args) {
		System.out.println("Welcome to Metacube Virtual Command Prompt");
		VirtualCommandPrompt vcp = new VirtualCommandPrompt();
		while (true) {
			System.out.print(vcp.path + ">");
			String command = new Scanner(System.in).nextLine();
			String commandTokens[] = command.split(" ");
			switch (commandTokens[0]) {
			case "mkdir":
				if (commandTokens.length == 1) {
					System.out.println("Folder Name can't be Empty");
					continue;
				}
				try {
					vcp.mkdir(commandTokens[1]);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "cd":
				if (commandTokens.length == 1) {
					System.out.println("Folder Name can't be Empty");
					continue;
				}
				vcp.cd(commandTokens[1]);
				break;
			case "ls":
				List<ListOfChildren> list = new ArrayList<ListOfChildren>();
				list = vcp.ls();
				for (ListOfChildren child : list) {
					System.out.println(child.getDateOfCreation() + "\t"
							+ child.getNodeData());
				}
				if (list.size() == 1) {
					System.out.println("\t" + list.size() + " Folder");
					break;
				}
				System.out.println("\t" + list.size() + " Folders");
				break;
			case "find":
				if (commandTokens.length == 1) {
					System.out.println("Folder Name can't be Empty");
					continue;
				}
				try {
					List<String> folders = new ArrayList<String>();
					folders = vcp.find(commandTokens[1], vcp.currentNode, "");
					for (String folderName : folders) {
						System.out.println(folderName);
					}
				} catch (NullPointerException e) {
					System.out.println(e.getMessage());
				}
				break;
			case "tree":
				vcp.tree(vcp.root, 0);
				break;
			case "bk":
				try {
					vcp.bk();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "exit":
				vcp.exit();
			default:
				System.out.println("Command doesn't Exist");
			}
		}

	}
}
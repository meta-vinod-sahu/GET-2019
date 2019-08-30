import java.util.Date;

public class ListOfChildren {
	private Date dateOfCreation;
	private String nodeData;

	/**
	 * @param dateOfCreation of directory when created store in it
	 * @param nodeData as folder name
	 */
	public ListOfChildren(Date dateOfCreation, String nodeData) {
		this.dateOfCreation = dateOfCreation;
		this.nodeData = nodeData;
	}

	/**
	 * @return Date of creation
	 */
	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	/**
	 * @return folder name
	 */
	public String getNodeData() {
		return nodeData;
	}
}
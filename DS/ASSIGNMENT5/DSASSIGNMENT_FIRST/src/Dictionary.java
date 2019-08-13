import java.util.List;

/**
 * interface for Dictionary provides abstract method for add,delete,getValue and
 * get all
 */
public interface Dictionary {

	public boolean add(String key, String value) throws Exception;

	public boolean delete(String key) throws Exception;

	public String getValue(String key);

	public List<Value> getAll();

	public int getSize();

	public List<Value> getBetween(String startKey, String endKey);

}

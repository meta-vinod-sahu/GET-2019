import static org.junit.Assert.*;
import org.junit.Test;


public class TestEmployee {

	@Test
	public void test() {
		int[] expected=new int[]{800,600,500};
		int[] result=new int[3];
		
		LinkedListEmployee list = new LinkedListEmployee();
		Employee e = new Employee(1, "ram", 500, 19);
		list = list.insert(list, e);
		Employee e1 = new Employee(2, "Shyam", 600, 18);
		list = list.insert(list, e1);
		Employee e2 = new Employee(3, "vinod", 800, 17);
		list = list.insert(list, e2);
		list = list.insertionSort(list);
		Node n=new Node(e);
		LinkedListEmployee expectedresult = new LinkedListEmployee();
		n=list.head;
		int i=0;
		while(n.next!=null)
		{
		result[i]=n.getData().getSalary();
		i++;
		n=n.next;
		
		}
		result[i]=n.getData().getSalary();
		assertArrayEquals(expected,result);
	}
	
	@Test
	public void test1() {
		int[] expected=new int[]{800,500,500};
		int[] result=new int[3];
		
		LinkedListEmployee list = new LinkedListEmployee();
		Employee e = new Employee(1, "ram", 500, 19);
		list = list.insert(list, e);
		Employee e1 = new Employee(2, "Shyam", 500, 18);
		list = list.insert(list, e1);
		Employee e2 = new Employee(3, "jyoti", 800, 17);
		list = list.insert(list, e2);
		list = list.insertionSort(list);
		Node n=new Node(e);
		LinkedListEmployee expectedresult = new LinkedListEmployee();
		n=list.head;
		int i=0;
		while(n.next!=null)
		{
		result[i]=n.getData().getSalary();
		i++;
		n=n.next;
		
		}
		result[i]=n.getData().getSalary();
		assertArrayEquals(expected,result);
	}
	
	@Test
	public void test3() {
		int[] expected=new int[]{800,800,800};
		int[] result=new int[3];
		
		LinkedListEmployee list = new LinkedListEmployee();
		Employee e = new Employee(1, "ram", 800, 19);
		list = list.insert(list, e);
		Employee e1 = new Employee(2, "Shyam", 800, 18);
		list = list.insert(list, e1);
		Employee e2 = new Employee(3, "vinod", 800, 17);
		list = list.insert(list, e2);
		list = list.insertionSort(list);
		Node n=new Node(e);
		LinkedListEmployee expectedresult = new LinkedListEmployee();
		n=list.head;
		int i=0;
		while(n.next!=null)
		{
		result[i]=n.getData().getSalary();
		i++;
		n=n.next;
		
		}
		result[i]=n.getData().getSalary();
		assertArrayEquals(expected,result);
	}
	

}



public class Element {
	Object element;
	int priority;
	
	public Element(Object ele,int prior){
		this.element=ele;
		this.priority=prior;
	}
	
	public Object getElement(){
		return element;
	}
	
	public int getPriority(){
		return priority;
	}

}

package pojo;

public class Vehicle {
	int vehicle_id ;
	String name ;
	String type ;
	int vehicle_number; 
	int employee_id ;
	String identification ;
	
	public Vehicle(int vehicle_id, String name, String type,
			int vehicle_number, int employee_id, String identification) {
		super();
		this.vehicle_id = vehicle_id;
		this.name = name;
		this.type = type;
		this.vehicle_number = vehicle_number;
		this.employee_id = employee_id;
		this.identification = identification;
	}

	public Vehicle(String name, String type,
			int vehicle_number, int employee_id, String identification) {
		super();
		this.name = name;
		this.type = type;
		this.vehicle_number = vehicle_number;
		this.employee_id = employee_id;
		this.identification = identification;
	}

	public int getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getVehicle_number() {
		return vehicle_number;
	}

	public void setVehicle_number(int vehicle_number) {
		this.vehicle_number = vehicle_number;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	
}
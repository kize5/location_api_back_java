package locationAPI.example.model;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
//@JsonFilter("monFiltreDynamique")
public class Client {
	private String id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String drivingLicenseNumber;
//	@JsonIgnore
	private String animal;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDrivingLicenseNumber() {
		return drivingLicenseNumber;
	}

	public void setDrivingLicenseNumber(String drivingLicenseNumber) {
		this.drivingLicenseNumber = drivingLicenseNumber;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}


	@Override
	public String toString() {
		return "Client{" +
				"id='" + id + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", dateOfBirth='" + dateOfBirth + '\'' +
				", drivingLicenseNumber='" + drivingLicenseNumber + '\'' +
				'}';
	}


//	public void forEach() {
////		FakeDataGenerator fakedata = new FakeDataGenerator();
////		List<Client> clients = fakedata();
//	}
}


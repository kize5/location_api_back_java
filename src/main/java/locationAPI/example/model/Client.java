package locationAPI.example.model;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Client {
	private String id;
	private String firstName;
	private String lastName;

//	public String toJson() {
//		ObjectMapper objectMapper = new ObjectMapper();
//		try {
//			return objectMapper.writeValueAsString(this);
//		} catch (Exception e) {
//			// Gérer l'exception ici si nécessaire
//			return null;
//		}
//	}
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

	private String dateOfBirth;
	private String drivingLicenseNumber;

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


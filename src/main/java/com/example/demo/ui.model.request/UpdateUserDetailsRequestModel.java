package ui.model.request;

public class UpdateUserDetailsRequestModel {
    @NotNull(message = " First name cannot be null")
    @Size(min=2, message="First name must not be less than 2 characters")
    private String firstName;

    @Size(min=2, message="Last name must not be less than 2 characters")
    @NotNull(message = " Last name cannot be null")
    private String lastName;


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

}
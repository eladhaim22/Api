package Model;

public class Role {
	private String RoleName;

	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

	public String getRoleName() {

		return RoleName;
	}

	public Role(String roleName){
		this.RoleName = roleName;
	}
}

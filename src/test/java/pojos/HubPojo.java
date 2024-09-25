package pojos;

import java.io.Serializable;

public class HubPojo implements Serializable {
	private String phone;
	private String address;

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	@Override
 	public String toString(){
		return 
			"HubPojo{" + 
			"phone = '" + phone + '\'' + 
			",address = '" + address + '\'' + 
			"}";
		}

	public HubPojo(String phone, String address) {
		this.phone = phone;
		this.address = address;
	}

	public HubPojo() {
	}
}
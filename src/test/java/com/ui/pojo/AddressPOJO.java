package com.ui.pojo;

public class AddressPOJO {
    private String companyName;
    private String address1;
    private String address2;
    private String city;
    private String postCode;
    private String homePhoneNumber;
    private String mobilePhoneNumber;
    private String otherInformation;
    private String addressAlias;
    private String state;
	public AddressPOJO(String companyName, String address1, String address2, String city, String postCode,
			String homePhoneNumber, String mobilePhoneNumber, String othreInformation, String addressAlias,
			String state) {
		super();
		this.companyName = companyName;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.postCode = postCode;
		this.homePhoneNumber = homePhoneNumber;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.otherInformation = othreInformation;
		this.addressAlias = addressAlias;
		this.state = state;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getAddress1() {
		return address1;
	}
	public String getAddress2() {
		return address2;
	}
	public String getCity() {
		return city;
	}
	public String getPostCode() {
		return postCode;
	}
	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}
	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}
	public String getOtherInformation() {
		return otherInformation;
	}
	public String getAddressAlias() {
		return addressAlias;
	}
	public String getState() {
		return state;
	}
	@Override
	public String toString() {
		return "AddressPOJO [companyName=" + companyName + ", address1=" + address1 + ", address2=" + address2
				+ ", city=" + city + ", postCode=" + postCode + ", homePhoneNumber=" + homePhoneNumber
				+ ", mobilePhoneNumber=" + mobilePhoneNumber + ", othreInformation=" + otherInformation
				+ ", addressAlias=" + addressAlias + ", state=" + state + "]";
	}
	
}

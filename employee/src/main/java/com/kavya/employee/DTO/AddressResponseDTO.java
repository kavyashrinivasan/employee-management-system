package com.kavya.employee.DTO;

public class AddressResponseDTO {
    private Long id;
    private String city;
    private String pincode;
    private String state;

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getCity(){return city;}
    public void setCity(String city){this.city = city;}
    public String getPincode(){return pincode;}
    public void setPincode(String pincode){this.pincode = pincode;}
    public String getState(){return state;}
    public void setState(String state){this.state = state;}

}

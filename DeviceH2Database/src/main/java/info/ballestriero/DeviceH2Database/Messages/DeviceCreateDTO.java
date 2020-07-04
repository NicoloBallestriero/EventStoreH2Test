package info.ballestriero.DeviceH2Database.Messages;

public class DeviceCreateDTO {

    private final String serialNumber;
    private String ipV4;
    
    
    public DeviceCreateDTO(String serialNumber , String ipv4){
    	this.serialNumber = serialNumber;
    	this.ipV4 = ipv4;
    }
    
    public String getIpV4() {
		return this.ipV4;
	}

	public String getSerialNumber() {
        return this.serialNumber;
    }

    public String setIpV4() {
    	return this.ipV4;
    } 

 
}
package info.ballestriero.DeviceH2Database.Event;

public class DeviceActivatedEvent extends BaseEvent<String>{

	public final boolean status;
	public DeviceActivatedEvent(String serialNumber, boolean status) {
		super(serialNumber);
		this.status= status;
	}
	

}

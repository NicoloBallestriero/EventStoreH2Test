package info.ballestriero.DeviceH2Database.Event;

public class DeviceCreatedEvent extends BaseEvent<String>{

	public final String message;
    public DeviceCreatedEvent(String serialNumber) {
        super(serialNumber);
        this.message = "CreatedEvent";
    }
}
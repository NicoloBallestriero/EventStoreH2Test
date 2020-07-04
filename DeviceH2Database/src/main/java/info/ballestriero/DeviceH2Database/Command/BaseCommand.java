package info.ballestriero.DeviceH2Database.Command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class BaseCommand<T> {

    @TargetAggregateIdentifier
    private final T serialNumber;

    public BaseCommand(T serialNumber) {
        this.serialNumber = serialNumber;
    }

	public T getSerialNumber() {
		return serialNumber;
	}
    
}
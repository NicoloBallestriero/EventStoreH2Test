package info.ballestriero.DeviceH2Database.Event;

public class BaseEvent<T> {

    public final T serialNumber;

    public BaseEvent(T serialNumber) {
        this.serialNumber = serialNumber;
    }
}
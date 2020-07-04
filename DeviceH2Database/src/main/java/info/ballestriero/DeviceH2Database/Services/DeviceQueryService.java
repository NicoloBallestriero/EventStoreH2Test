package info.ballestriero.DeviceH2Database.Services;

import java.util.List;

public interface DeviceQueryService {
	public List<Object> listEventsForDevice(String serialNumber);
}

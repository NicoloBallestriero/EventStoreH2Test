package info.ballestriero.DeviceH2Database.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

@Service
public class DeviceQueryServiceImpl implements DeviceQueryService{

	private final EventStore eventStore;

	public DeviceQueryServiceImpl(EventStore eventStore) {
	    this.eventStore = eventStore;
	}

	@Override
	public List<Object> listEventsForDevice(String serialNumber) {
	    return eventStore.readEvents(serialNumber).asStream().map( s -> s.getPayload()).collect(Collectors.toList());
	}
}

package info.ballestriero.DeviceH2Database.Rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import info.ballestriero.DeviceH2Database.Services.DeviceQueryService;

@RestController
public class DeviceQueryController {
	private final DeviceQueryService deviceQueryService;
	
	public DeviceQueryController(DeviceQueryService deviceQueryService) {
        this.deviceQueryService = deviceQueryService;
    }
	
	@GetMapping("/{serialNumber}/events")
    public List<Object> listEventsForAccount(@PathVariable(value = "serialNumber") String serialNumber){
        return deviceQueryService.listEventsForDevice(serialNumber);
    }
}

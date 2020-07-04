package info.ballestriero.DeviceH2Database.Rest;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import info.ballestriero.DeviceH2Database.DeviceAggregate;
import info.ballestriero.DeviceH2Database.Messages.DeviceCreateDTO;
import info.ballestriero.DeviceH2Database.Services.DeviceCommandService;



@RestController
public class DeviceCommandController {
	
    @Autowired
    DeviceService deviceService;
    
    private final DeviceCommandService deviceCommandService;

    public DeviceCommandController(DeviceCommandService deviceCommandService) {
        this.deviceCommandService = deviceCommandService;
    }

    @GetMapping("/devices")
    private List<DeviceAggregate> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping("/devices/{serialNumber}")
    private DeviceAggregate getDevice(@PathVariable("serialNumber") String serialNumber) {
        return deviceService.getDeviceById(serialNumber);
    }

    @DeleteMapping("/devices/{serialNumber}")
    private void deleteDevice(@PathVariable("serialNumber") String id) {
        deviceService.delete(id);
    }

//    @PostMapping("/devices")
//    private String saveDevice(@RequestBody DeviceAggregate device) {
//        deviceService.saveOrUpdate(device);
//        return device.getSerialNumber();
//    }
    @PostMapping("/devices")
    private CompletableFuture<String> createDevice(@RequestBody DeviceCreateDTO deviceCreateDTO) {
        //deviceService.saveOrUpdate(device);
        //return device.getSerialNumber();
    	return deviceCommandService.createDevice(deviceCreateDTO);
    }
}
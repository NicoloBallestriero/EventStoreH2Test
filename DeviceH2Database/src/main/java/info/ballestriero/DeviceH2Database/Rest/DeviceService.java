package info.ballestriero.DeviceH2Database.Rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.ballestriero.DeviceH2Database.DeviceAggregate;
import info.ballestriero.DeviceH2Database.DeviceRepository;

@Service
public class DeviceService {
	@Autowired
	DeviceRepository deviceRepository;
	
	public List<DeviceAggregate> getAllDevices() {
	    List<DeviceAggregate> devices = new ArrayList<DeviceAggregate>();
	    deviceRepository.findAll().forEach(device -> devices.add(device));
	    return devices;
	}

	public DeviceAggregate getDeviceById(String serialNumber) {
	    return deviceRepository.findById(serialNumber).get();
	}

	public void saveOrUpdate(DeviceAggregate device) {
	    deviceRepository.save(device);
	}

	public void delete(String id) {
	    deviceRepository.deleteById(id);
	}
}

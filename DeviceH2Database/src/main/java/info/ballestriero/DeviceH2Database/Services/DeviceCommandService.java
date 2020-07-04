package info.ballestriero.DeviceH2Database.Services;

import java.util.concurrent.CompletableFuture;

import info.ballestriero.DeviceH2Database.Messages.DeviceCreateDTO;

public interface DeviceCommandService {
	public CompletableFuture<String> createDevice(DeviceCreateDTO deviceCreateDTO);

}

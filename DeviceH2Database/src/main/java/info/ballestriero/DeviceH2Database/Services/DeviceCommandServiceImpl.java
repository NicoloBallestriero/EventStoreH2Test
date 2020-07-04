package info.ballestriero.DeviceH2Database.Services;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import info.ballestriero.DeviceH2Database.Command.CreateDeviceCommand;
import info.ballestriero.DeviceH2Database.Messages.DeviceCreateDTO;

@Service
public class DeviceCommandServiceImpl implements DeviceCommandService{

	private final CommandGateway commandGateway;

    public DeviceCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
    
	@Override
	public CompletableFuture<String> createDevice(DeviceCreateDTO deviceCreateDTO) {
		return commandGateway.send(new CreateDeviceCommand(deviceCreateDTO));
	}

	
}

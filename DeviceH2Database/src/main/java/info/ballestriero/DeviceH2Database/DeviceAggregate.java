package info.ballestriero.DeviceH2Database;

import java.net.InetAddress;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import info.ballestriero.DeviceH2Database.Command.CreateDeviceCommand;
import info.ballestriero.DeviceH2Database.Event.DeviceActivatedEvent;
import info.ballestriero.DeviceH2Database.Event.DeviceCreatedEvent;

@Entity
@Aggregate
public class DeviceAggregate {
	

	@Id
	@AggregateIdentifier
    private final String serialNumber;
	private final LocalDateTime firstDiscoveryTime;
    private String name;
    private boolean actived;
    private LocalDateTime lastModifyTime;
    private String ipV4;
    
    //public DeviceAggregate() {}
    
	public String getSerialNumber() {
		return serialNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	
	
	@CommandHandler
    public DeviceAggregate(CreateDeviceCommand createDeviceCommand){
        this.serialNumber = createDeviceCommand.getSerialNumber();
		this.firstDiscoveryTime = LocalDateTime.now();
		this.ipV4 = createDeviceCommand.getIpV4().getHostAddress();
		AggregateLifecycle.apply(new DeviceCreatedEvent(this.serialNumber));
    }

    @EventSourcingHandler
    protected void on(DeviceCreatedEvent deviceCreatedEvent){
        this.actived = true;
        this.lastModifyTime = this.firstDiscoveryTime;
        AggregateLifecycle.apply(new DeviceActivatedEvent(this.serialNumber, true));
    }
    
    @EventSourcingHandler
    protected void on(DeviceActivatedEvent deviceActivatedEvent){
        this.actived = deviceActivatedEvent.status;
    }

	
	

}

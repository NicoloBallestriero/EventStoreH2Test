package info.ballestriero.DeviceH2Database.Command;

import java.net.InetAddress;
import java.net.UnknownHostException;

import info.ballestriero.DeviceH2Database.Messages.DeviceCreateDTO;

public class CreateDeviceCommand  extends BaseCommand<String>{
	
		private InetAddress ipV4;
	    public CreateDeviceCommand(DeviceCreateDTO deviceCreateDTO) {
	        super(deviceCreateDTO.getSerialNumber());
	        try {
				this.ipV4 = InetAddress.getByName(deviceCreateDTO.getIpV4());
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		public InetAddress getIpV4() {
			return ipV4;
		}
		public void setIpV4(InetAddress ipV4) {
			this.ipV4 = ipV4;
		}
}

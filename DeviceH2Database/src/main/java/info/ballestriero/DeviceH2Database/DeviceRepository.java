package info.ballestriero.DeviceH2Database;

import org.springframework.data.repository.CrudRepository;

public interface DeviceRepository extends CrudRepository<DeviceAggregate, String>{

}

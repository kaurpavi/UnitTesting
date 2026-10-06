package DriverCapability;

import java.sql.Driver;
import java.util.Collection;
import java.util.LinkedList;

/*
Driver 1:
    CAR       active
    SCOOTER   active
    TRUCK     inactive

Driver 2:
    SCOOTER   active
 */
public class CapabilityService {

    Collection<DriverCapabilities> capabilities;
   public CapabilityService(Collection<DriverCapabilities> d)
   {
       this.capabilities=d;
   }

   public Collection<String> filterCapabilities(int driverId) {
       Collection<String> results = new LinkedList<>();
       for (DriverCapabilities cap : capabilities)
           if (cap.getDriverId() == driverId) {
               for (Capability c : cap.getCapabilities()) {
                   if (c.IsActive()) {
                       results.add(c.getName());
                   }
               }
           }
       return results;
   }
   public boolean canDrive(int driverId,Capability c)
   {
      return filterCapabilities(driverId).contains(c.getName());
   }
}

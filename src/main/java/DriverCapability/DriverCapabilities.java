package DriverCapability;

import java.util.Collection;
import java.util.LinkedList;

public class DriverCapabilities {
    private int driverId;
    private Collection<Capability> capabilities;

    public DriverCapabilities(int driverId)
    {
        this.driverId=driverId;
        capabilities=new LinkedList<>();
    }

    public int getDriverId()
    {
        return driverId;
    }
    public Collection<Capability> getCapabilities()
    {
        return capabilities;
    }

    public void addCapability(Capability c)
    {
        capabilities.add(c);
    }

}


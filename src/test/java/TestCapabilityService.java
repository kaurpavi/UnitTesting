import DriverCapability.Capability;
import DriverCapability.CapabilityService;
import DriverCapability.DriverCapabilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*; // For hasItems, contains, etc.
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestCapabilityService {

    Collection<DriverCapabilities> capabilities;
    DriverCapabilities d1,d2,d3;
    Capability capability1,capability2,capability3;

    CapabilityService cs;

    @BeforeEach
    public void setUp()
    {
        d1=new DriverCapabilities(567);
        d2=new DriverCapabilities(890);
        d3=new DriverCapabilities(900);
        capability1=new Capability("CAR",true);
        capability2=new Capability("Scooter",true);
        capability3=new Capability("TRUCK",false);
        capabilities=new LinkedList<>();

        d1.addCapability(capability1);
        d1.addCapability(capability2);
        d1.addCapability(capability3);
        d2.addCapability(capability2);

        capabilities.add(d1);
        capabilities.add(d2);
        cs=new CapabilityService(capabilities);

        System.out.println("Setup Completed");

    }

    @Test
    public void filterCapabilities()
    {
        Collection<String> results=new LinkedList<>();
        results.add("CAR");
        results.add("SCOOTER");

       Collection<String> expected= cs.filterCapabilities(567);
        assertThat("FilterCapabilities",results,equalTo( expected.stream().map(String::toUpperCase).collect(Collectors.toList())));

    }

    @Test
    public void checkCandriveCar(){
        boolean result=cs.canDrive(567,capability1);
        assertTrue(result);
    }

    @Test
    public void checkCandriveTruck()
    {
        boolean result=cs.canDrive(567,capability3);
        Assertions.assertFalse(result);
    }


}

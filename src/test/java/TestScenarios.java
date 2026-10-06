import PermissionServicesQuestionWoven.PermissionService;
import PermissionServicesQuestionWoven.Permissions;
import PermissionServicesQuestionWoven.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class TestScenarios {
    //PermissionServicesQuestionWoven.Permissions permissions;
    private PermissionService permissionService;
    User user,user1,user2,user3;

    @BeforeEach
    public void setUp()
    {   user=new User(1);
        user1=new User(2);
        user2=new User(7);
        user3=new User(11);
        user.addPermission(new Permissions("View_order",true));
        user.addPermission(new Permissions("View_Details",false));
        user1.addPermission(new Permissions("View_locations",true));
        user1.addPermission(new Permissions("View_scooters",true));
        user2.addPermission(new Permissions("View_profile",true));
        user2.addPermission(new Permissions("View_scooters",true));


        Collection<User> users=new LinkedList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);

        permissionService=new PermissionService(users);
        System.out.println("Setup completed");
    }

    @Test
    public void checkPermissionUser()
    {
        Collection<String>  expected=new LinkedList<>();
        expected.add("View_order");
        //expected.add("View_details");
        Collection<String> actual=permissionService.filterPermission(1);
        assertIterableEquals(expected,actual,"Test failed: The actual permissions do not match the expected permissions.");
    }

    @Test
    public void checkPermissionUser2()
    {
        Collection<String> expected=new LinkedList<>();
        expected.add("View_locations");
        expected.add("View_scooters");
        Collection<String> actual=permissionService.filterPermission(2);
        assertIterableEquals(expected,actual,"Test failed: The actual permissions do not match the expected permissions.");
    }

    @Test
    public void checkPermissionUser3()
    {
        Collection<String> expected=new LinkedList<>();
        expected.add("View_profile");
        expected.add("View_scooters");
        Collection<String> actual=permissionService.filterPermission(7);
        assertIterableEquals(expected,actual,"Test failed: The actual permissions do not match the expected permissions.");
    }
    @Test
    public void checkPermittedInactiveUser()
    {
        assertFalse(permissionService.checkPermitted(1,"View_Details"),"Test failed: The permission should not be active for the user.");
    }

    @Test
    public void checkInactivePermittedExcluded()
    {
        assertFalse(permissionService.filterPermission(1).contains("View_Details"),"Test failed: The permission should not be active for the user.");
    }
}

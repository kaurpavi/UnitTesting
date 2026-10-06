import UserRolePermission.Permission;
import UserRolePermission.PermissionService;
import UserRolePermission.Role;
import UserRolePermission.User;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.LinkedList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.CoreMatchers.equalTo;

public class TestUserRolePermission {

    /*
    User 1
 |
 +-- admin
       |
       +-- VIEW       active
       +-- EDIT       active
       +-- DELETE     inactive


       User 2
 |
 +-- rider
 |     |
 |     +-- VIEW       active
 |
 +-- charter
       |
       +-- LOCATION   active
     */

    Collection<User> users=new LinkedList<>();
    User user1,user2;
    Role role1,role2,role3;
    //Permission p1,p2,p3;
    PermissionService permissionService;

    @BeforeEach
    public void setUp()
    {
        role1=new Role("admin");
        role2=new Role("rider");
        role3=new Role("charter");
        user1=new User(10);
        user2=new User(130);
        role1.addPermission(new Permission("VIEW",true));
        role1.addPermission(new Permission("EDIT",true));
        role1.addPermission(new Permission("DELETE",false));
        role2.addPermission(new Permission("VIEW",true));
        role3.addPermission(new Permission("LOCATION",true));
        user1.addRole(role1);
        user2.addRole(role2);
        user2.addRole(role3);
        users.add(user1);
        users.add(user2);
        permissionService=new PermissionService(users);
        System.out.println("Setup Complete");
        System.out.println(permissionService.filterPermissions(130));
    }

    @Test
    public void checkPermission()
    {
        Collection<String> results=new LinkedList<>();
        results.add("VIEW");
        results.add("EDIT");

        Collection<String> verify=permissionService.filterPermissions(10);
        assertThat("Test Failed" +verify +"not matching" +results,verify,equalTo(results));

    }
}

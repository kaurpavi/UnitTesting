import VehicleOperations.OperationPermission;
import VehicleOperations.Operations;
import VehicleOperations.User;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.LinkedList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestVehicleOperations {

    /*
    User 1:

START_VEHICLE       permitted
STOP_VEHICLE        permitted
DELETE_VEHICLE      not permitted

User 2:

START_VEHICLE       permitted
     */
    private User user,user1;

    private OperationPermission operationPermission;

    @BeforeEach
    public void setUp()
    {
        user=new User(100);
        user1=new User(201);
        user.addOperationName(new Operations("START_VEHICLE",true));
        user.addOperationName(new Operations("STOP_VEHICLE",true));
        user.addOperationName(new Operations("DELETE_VEHICLE",false));

        user1.addOperationName(new Operations("START_VEHICLE",true));
        Collection<User> users=new LinkedList<>();
        users.add(user);
        users.add(user1);
        operationPermission=new OperationPermission(users);
        System.out.println("Added data");
    }

    @Test
    public void filterPermissions()
    {
        Collection<String> results=new LinkedList<>();
        results.add("START_VEHICLE");
        results.add("STOP_VEHICLE");
        Collection<String> actual= operationPermission.filterPermittedOperations(100);
        assertThat("Test failed" +actual +"not equal"+results,results,equalTo(actual));

    }

    @Test
    public void isPermitted()
    {
        assertTrue(operationPermission.filterPermittedOperations(100).contains("START_VEHICLE"));
    }

    @Test
    public void isNotPermitted()
    {
        assertFalse(operationPermission.filterPermittedOperations(100).contains("DELETE_VEHICLE"));
    }


}

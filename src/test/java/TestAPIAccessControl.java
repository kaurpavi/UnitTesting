import APIAccessControl.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestAPIAccessControl {

    Collection<User> user;
    User user1,user2;
    APIAccessControl apiAccessControl,apiAccessControl2,apiAccessControl3,apiAccessControl4;
    APIAccessControlService apiAccessControlService;


    @BeforeEach
    public void setUp()
    {
        user1=new User(101);
        user2=new User(102);
        apiAccessControl=new APIAccessControl("GET_USERS",true);
        apiAccessControl2=new APIAccessControl("CREATE_USER",true);
        apiAccessControl3=new APIAccessControl("DELETE_USER",false);
        apiAccessControl4=new APIAccessControl("GET_USERS",true);


        user1.addAccessControl(apiAccessControl);
        user1.addAccessControl(apiAccessControl2);
        user1.addAccessControl(apiAccessControl3);
        user1.addAccessControl(apiAccessControl4);
        user=new LinkedHashSet<>();
        user.add(user1);
        user.add(user2);
        apiAccessControlService=new APIAccessControlService(user);

    }

    @Test
    public void filterAccess()
    {
        Collection<String> results=new LinkedHashSet<>();
        results.add("GET_USERS");
        results.add("CREATE_USER");
        Collection<String> output=apiAccessControlService.filterAccessApiControl(101);
        assertThat("API access control",results,equalTo(output));
    }
}

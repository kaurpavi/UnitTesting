import AccountPermission.Account;
import AccountPermission.PermissionService;
import AccountPermission.Permissions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*; // For hasItems, contains, etc.
import org.junit.jupiter.api.Test;


public class TestAccountPermissions {

    Collection<Account> account=new LinkedList<>();
    Account acct,acct1;
    PermissionService ps;
    Permissions permissions,p1,p2,p3;
    @BeforeEach
    public void setup()
    {
        acct=new Account(11);
        acct1=new Account(12);
        permissions=new Permissions("READ",false);
        p1=new Permissions("WRITE",true);
        p2=new Permissions("EDIT",true);
        p3=new Permissions("READ",true);
        acct.addPermission(p1);
        acct.addPermission(p2);
        acct.addPermission(permissions);
        acct1.addPermission(p3);
        account.add(acct);
        account.add(acct1);
        ps=new PermissionService(account);
       System.out.println("Setup completed");

    }

    @Test
    public void checkaccountpermissions()
    {
        Collection<String> upperlist;
        Collection<String> results=new LinkedList<>();
        results.add("write");
        results.add("edit");
        upperlist=results.stream().map(String::toUpperCase).collect(Collectors.toList());
       Collection<String> expected= ps.getActivePermissions(11);
     //  Assertions.assertIterableEquals(upperlist,expected,"Test Failed----------"+upperlist+ "  not matching:---- "+expected);
        assertThat("Test failed---" +upperlist+" ---not matching"+expected ,upperlist,equalTo(expected));
    }

}

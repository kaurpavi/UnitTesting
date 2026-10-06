package AccountPermission;

import java.util.Collection;
import java.util.LinkedList;

public class Account {
    private int accountId;
    private Collection<Permissions> permissions;

    public Account(int acccountId)
    {
        this.accountId=acccountId;
        this.permissions=new LinkedList<>();
    }

    public int getAccountId()
    {
        return accountId;
    }
    public Collection<Permissions> getPermissions()
    {
        return permissions;
    }

    public void addPermission(Permissions permissions)
    {
        this.permissions.add(permissions);
    }
}

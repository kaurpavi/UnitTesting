package PermissionServicesQuestionWoven;

import java.util.Collection;
import java.util.LinkedList;

public class User {

    private int userId;
    private Collection<Permissions> permissions;

    public User(int userId)
    {
        this.userId=userId;
        this.permissions=new LinkedList<>();
    }

    public Collection<Permissions> getPermissions() {
        return permissions;
    }
    public void addPermission(Permissions permission)
    {
        this.permissions.add(permission);
    }
    public int getUserId() {
        return userId;
    }
}

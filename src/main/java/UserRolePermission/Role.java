package UserRolePermission;

import java.util.Collection;
import java.util.LinkedList;

public class Role {

    String name;
    Collection<Permission> permissions;

    public Role(String name)
    {
        this.name=name;
        permissions=new LinkedList<>();
    }

    public String getRoleName()
    {
        return name;
    }
    public Collection<Permission> getPermissions()
    {
        return permissions;
    }
    public void addPermission(Permission e)
    {
        permissions.add(e);
    }
}

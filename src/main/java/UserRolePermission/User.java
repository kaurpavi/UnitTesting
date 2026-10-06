package UserRolePermission;

import java.util.Collection;
import java.util.LinkedList;

public class User {

    int userId;
    Collection<Role> roles;

    public User(int userId)
    {
        this.userId=userId;
        roles=new LinkedList<>();
    }

    public int getUserId()
    {
        return userId;
    }
    public Collection<Role> getRoles()
    {
        return roles;
    }
    public void addRole(Role role)
    {
        roles.add(role);
    }
}

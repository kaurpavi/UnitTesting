package UserRolePermission;

import java.util.Collection;
import java.util.LinkedList;

public class PermissionService {

    Collection<User> user;

   public  PermissionService(Collection<User> users)
    {
        user=users;
    }

    public Collection<String> filterPermissions(int userId)
    {
        Collection<String> results=new LinkedList<>();
        for(User user:user)
        {
            if(user.getUserId()==userId)
            {
                for(Role role:user.getRoles())
                {
                    for(Permission p:role.getPermissions())
                    {
                        if(p.isActive())
                        {
                            results.add(p.getPermissionName());
                        }
                    }
                }
            }
        }
        return results;
    }

    public boolean isPermitted(int userId,String permission)
    {
        return filterPermissions(userId).contains(permission);
    }
}

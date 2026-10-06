package PermissionServicesQuestionWoven;

import java.util.Collection;
import java.util.LinkedList;

public class PermissionService {

    public Collection<User> users;
    public PermissionService(Collection<User> users)
    {
        this.users=users;
    }


    public Collection<String> filterPermission(int userid) {
        Collection<String> results = new LinkedList<>();
        for (User user : users) {
            if (user.getUserId() == userid) {
                for (Permissions permission : user.getPermissions()) {
                    if (permission.isActive()) {
                        results.add(permission.getName());
                    }
                }
            }
        }
        return results;
    }

    public boolean checkPermitted(int userId, String permissionName) {
        return filterPermission(userId).contains(permissionName);

    }
}
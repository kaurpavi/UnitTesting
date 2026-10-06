package UserRolePermission;

public class Permission {

    String name;
    boolean active;

    public Permission(String name,boolean active)
    {
        this.name=name;
        this.active=active;
    }
    public String getPermissionName()
    {
        return name;
    }

    public boolean isActive()
    {
        return active;
    }

}

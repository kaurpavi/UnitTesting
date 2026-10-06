package AccountPermission;

import java.util.Collection;

public class Permissions {

    private String name;
    private boolean active;

    public Permissions(String name,boolean active)
    {
        this.name=name;
        this.active=active;
    }

    public String getName()
    {
        return name;
    }

    public boolean isActive()
    {
        return active;
    }
}

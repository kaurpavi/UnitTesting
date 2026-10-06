package APIAccessControl;

import java.util.Collection;
import java.util.LinkedHashSet;

public class User {

    private int userId;
    private Collection<APIAccessControl> accesses;

    public User(int userId)
    {
        this.userId=userId;
        accesses=new LinkedHashSet<>();
    }

    public Collection<APIAccessControl> getAPIAccessControlList()
    {
        return accesses;
    }

    public int getUserId()
    {
        return userId;
    }

    public void addAccessControl(APIAccessControl e)
    {
        accesses.add(e);
    }

}

package APIAccessControl;

import java.util.Collection;
import java.util.LinkedHashSet;

public class APIAccessControlService {

    Collection<User> usercontrols;


    public APIAccessControlService(Collection<User> users)
    {
        usercontrols=users;

    }
    public Collection<String> filterAccessApiControl(int userid) {
        Collection<String> results = new LinkedHashSet<>();
        for (User control : usercontrols) {
            if (control.getUserId() == userid) {
                for (APIAccessControl e : control.getAPIAccessControlList()) {
                    if (e.isActive()) {
                        results.add(e.getApiName());
                    }
                }
                break;
            }
        }
        return results;
    }

    public boolean canAccessApi(int userId, String apiName)
    {
        return filterAccessApiControl(userId).contains(apiName);
    }
}

package UserFeaturesScenario;

import java.util.Collection;
import java.util.LinkedList;

public class FeatureService {

    public Collection<User> user;
    public FeatureService(Collection<User> user)
    {
        this.user=user;
    }

    public Collection<String> filterEnabledFeatures(int userId){
        Collection<String> results = new LinkedList<>();
            for(User user : user) {
                if (user.getUserId() == userId) {
                    for (UserFeatures feature : user.getFeatures()) {
                            if(feature.isEnabled())
                        results.add(feature.getFeatureName());
                    }
                }
            }
        return results;
    }

    public boolean hasFeature(int userId, String featureName) {
        return filterEnabledFeatures(userId).contains(featureName);
    }
}

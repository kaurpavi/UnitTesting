package UserFeaturesScenario;

import java.util.Collection;
import java.util.LinkedList;

public class User {

    private int userId;
    private Collection<UserFeatures> features;

    public User(int userId) {
        this.userId = userId;
        this.features = new LinkedList<>();
    }

    public Collection<UserFeatures> getFeatures() {
        return features;
    }
    public void addFeature(UserFeatures feature) {
        features.add(feature);
    }
    public int getUserId() {
        return userId;
    }

}

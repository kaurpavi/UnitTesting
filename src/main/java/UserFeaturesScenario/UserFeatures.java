package UserFeaturesScenario;

import java.util.Collection;

public class UserFeatures {

    private String featureName;
    private boolean isEnabled;
    private Collection<UserFeatures> features;

    public UserFeatures(String featureName, boolean isEnabled) {
        this.featureName = featureName;
        this.isEnabled = isEnabled;
    }

    public String getFeatureName() {
        return featureName;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}

import UserFeaturesScenario.FeatureService;
import UserFeaturesScenario.User;
import UserFeaturesScenario.UserFeatures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.LinkedList;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class TestUserFeatureScenarios {

   /* User 101
    DASHBOARD   → enabled
    REPORTS     → disabled

    User 102
    DASHBOARD   → enabled
    EXPORT      → enabled*/

    private User user, user1;
    private FeatureService featureService;

    @BeforeEach
    public void setup() {
        User user = new User(101);
        User user1 = new User(102);
        user.addFeature(new UserFeatures("DASHBOARD", true));
        user.addFeature(new UserFeatures("REPORTS", false));
        user1.addFeature(new UserFeatures("DASHBOARD", true));
        user1.addFeature(new UserFeatures("EXPORT", true));

        Collection<User> users = new LinkedList<>();
        users.add(user);
        users.add(user1);

        featureService = new FeatureService(users);
        System.out.println("Setup completed for User Feature Scenarios");
    }

    @Test
    public void checkenabledfeatureforUser() {
        Collection<String> expected = new LinkedList<>();
        expected.add("DASHBOARD");
        Collection<String> actual = featureService.filterEnabledFeatures(101);
        assertIterableEquals(expected, actual, "Test failed: The actual features do not match the expected features.");

    }

    @Test
    public void checkenabledfeatureforUser1() {
        Collection<String> expected = new LinkedList<>();
        expected.add("DASHBOARD");
        expected.add("EXPORT");
        Collection<String> actual = featureService.filterEnabledFeatures(102);
        assertIterableEquals(expected, actual, "Test failed: The actual features do not match the expected features.");
    }

    @Test
    public void checkhasFeatureforUser() {
        boolean actual = featureService.hasFeature(101, "DASHBOARD");
        assert(actual);
        System.out.println(actual);
    }

    @Test
    public void checkhasFeaturedisableUser()
    {
        boolean actual=featureService.hasFeature(102,"REPORTS");
        assertFalse(actual);
        System.out.println(actual);
    }

}


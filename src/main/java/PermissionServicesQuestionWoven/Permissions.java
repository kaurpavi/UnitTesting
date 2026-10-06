package PermissionServicesQuestionWoven;

public class Permissions {

    private final String name;
    private final boolean isActive;

    public Permissions(String name,boolean isActive)
    {
        this.name=name;
        this.isActive=isActive;
    }
    public String getName()
    {
        return name;
    }

    public boolean isActive()
    {
        return isActive;
    }
}

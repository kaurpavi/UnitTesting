package APIAccessControl;

public class APIAccessControl {

    private String apiName;
    private boolean active;

    public APIAccessControl(String apiName,boolean active)
    {
        this.apiName=apiName;
        this.active=active;
    }

    public String getApiName()
    {
        return apiName;
    }

    public boolean isActive()
    {
        return active;
    }
}


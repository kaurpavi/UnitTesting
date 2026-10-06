package VehicleOperations;

public class Operations {
    private String name;
    private boolean permitted;

    public Operations(String name,boolean permitted)
    {
        this.name=name;
        this.permitted=permitted;
    }

    public String getOperationName()
    {
        return name;
    }

    public boolean isPermitted()
    {
        return permitted;
    }


}

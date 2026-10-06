package VehicleOperations;

import java.util.Collection;
import java.util.LinkedHashSet;

public class User {

    private int userId;
    private Collection<Operations> operations;

    public User(int userId)
    {
        this.userId=userId;
        operations=new LinkedHashSet<>();
    }

    public int getUserId()
    {
        return userId;
    }

    public Collection<Operations> getOperations()
    {
        return operations;
    }

    public void addOperationName(Operations vehicleOperation)
    {
        operations.add(vehicleOperation);
    }
}

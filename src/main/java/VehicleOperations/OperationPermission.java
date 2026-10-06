package VehicleOperations;

import java.util.Collection;
import java.util.LinkedList;

public class OperationPermission {

   Collection<User>  user;
  //  Operations vehicle_operations;

    public OperationPermission(Collection<User> user)
    {
       this.user=user;
    }



    public Collection<String> filterPermittedOperations(int userId)
    {
        Collection<String> results=new LinkedList<>();
        for(User user:user)
        {
        if(user.getUserId()==userId)
        {
            for(Operations o :user.getOperations())
            {
                if(o.isPermitted())
                    results.add(o.getOperationName());
            }
            }
        }
        return results;

    }

    boolean isOperationPermitted(int userId, String operation)
    {
        return filterPermittedOperations(userId).contains(operation);

    }

}

package AccountPermission;

import java.util.Collection;
import java.util.LinkedList;

public class PermissionService {

  Collection<Account> accounts;

  public PermissionService(Collection<Account> accounts)
  {
      this.accounts=accounts;
  }

  public Collection<String> getActivePermissions(int acctId)
  {
      Collection<String> results=new LinkedList<>();
      for(Account acct:accounts)
      {
          if(acct.getAccountId()==acctId)
          {
              for(Permissions p: acct.getPermissions())
              {
                  if(p.isActive())
                  {
                      results.add(p.getName());
                  }
              }
          }
      }
      return results;
  }
   public boolean canPerform(int accountId, String permission)
    {
        return getActivePermissions(accountId).contains(permission);
    }
}

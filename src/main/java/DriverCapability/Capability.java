package DriverCapability;

public class Capability {
        private String name;
        private boolean active;

        public Capability(String name,boolean active)
        {
            this.name=name;
            this.active=active;
        }

        public String getName()
        {
            return name;
        }
        public boolean IsActive()
        {
            return active;
        }
}

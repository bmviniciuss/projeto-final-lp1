package social;


import java.io.Serializable;
import java.util.UUID;

public abstract class Unique implements Serializable {
    private final String uuid;
    
    public Unique(){
        this.uuid = UUID.randomUUID().toString();
    }

    /**
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }
}
package social;


import java.io.Serializable;
import java.util.UUID;

public abstract class Uid implements Serializable {
    private final String uuid;
    
    public Uid(){
        this.uuid = UUID.randomUUID().toString();
    }

    /**
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }
}
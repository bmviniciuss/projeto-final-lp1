package social;

import java.io.Serializable;
import java.util.UUID;

/**
 * Unique Id Generator
 *
 * @author bmvin
 */
public abstract class Uid implements Serializable {

    private final String uuid;

    /**
     * Create a Uid object
     */
    public Uid() {
        this.uuid = UUID.randomUUID().toString();
    }

    /** Get Uuid
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }
}

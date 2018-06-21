
package social;

import java.io.File;

/**
 *
 * @author bmvin
 */
public class PhotoPost extends Post {

    private File file;

    /**
     *
     * @param owner
     * @param inGroup
     * @param isPublic
     * @param file
     */
    public PhotoPost(User owner, Group inGroup, boolean isPublic, File file) {
        super(owner, inGroup, isPublic);
        this.file = file;
    }

    /**
     *
     * @return
     */
    public File getFile() {
        return this.file;
    }
}

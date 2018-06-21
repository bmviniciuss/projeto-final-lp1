/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package social;

import java.io.File;

/**
 *
 * @author bmvin
 */
public class PhotoPost extends Post {

    private File file;

    public PhotoPost(User owner, Group inGroup, boolean isPublic, File file) {
        super(owner, inGroup, isPublic);
        this.file = file;
    }

    public File getFile() {
        return this.file;
    }
}
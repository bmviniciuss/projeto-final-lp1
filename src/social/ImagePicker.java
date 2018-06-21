package social;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Create a Image File Picker
 * @author bmvin
 */
public class ImagePicker {

    private final JFrame parent;

    /**
     *
     * @param parent
     */
    public ImagePicker(JFrame parent) {
        this.parent = parent;
    }

    /**
     * Create a File Picker.
     * @return selected file
     */
    public File pickImage() {
        // Filter
        FileNameExtensionFilter filters = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png");

        // FileChooser
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(filters);
        fc.showOpenDialog(parent);

        return fc.getSelectedFile();
    }
}

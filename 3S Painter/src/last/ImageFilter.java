/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package last;

/**
 *
 * @author shanto
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Hira
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hira
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Hira_IIT_DU
 */

class ImageFilter extends FileFilter {
    String GIF = "gif";
    String PNG = "png";
    String JPG = "jpg";
    String BMP = "bmp";
    String JPEG = "jpeg";

    public boolean accept(File file) {
        if(file != null) {
            if(file.isDirectory())
                return true;
           String extension = getExtension(file);
            if(extension != null && isSupported(extension))
                return true;
        }
        return false;
    }

    public String getDescription() {
        return GIF + ", " + PNG + ", " + JPG + ", " + BMP + " images";
    }

    private String getExtension(File file) {
        if(file != null) {
            String filename = file.getName();
            int dot = filename.lastIndexOf('.');
            if(dot > 0 && dot < filename.length()-1)
                return filename.substring(dot+1).toLowerCase();
        }
        return null;
    }

    private boolean isSupported(String ext) {
        return ext.equalsIgnoreCase(GIF) || ext.equalsIgnoreCase(PNG) ||
                ext.equalsIgnoreCase(JPG) || ext.equalsIgnoreCase(BMP) ||
                ext.equalsIgnoreCase(JPEG);
    }
}

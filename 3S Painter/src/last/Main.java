/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package last;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/** A demonstration of anti-aliasing */
public class Main {
 
  public static void main(String[] a) {
   

          JFrame frm=new JFrame("SSS Paint");
          Painter imagePane = new Painter();
           
        try {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 

       frm.getContentPane().add(new JScrollPane(imagePane));
          frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setSize(new Dimension(1000,700));
       frm.setJMenuBar(imagePane.getMenuBar());

        frm.setVisible(true);
       Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screen = tk.getScreenSize();
       // System.out.println("bhv  "+screen.width+"  "+frm.getWidth());

        int x = Math.max(0, (screen.width - frm.getWidth()) / 2);
        int y = Math.max(0, (screen.height - frm.getHeight()) / 2);
        frm.setLocation(x, y);
        
    }

}





  
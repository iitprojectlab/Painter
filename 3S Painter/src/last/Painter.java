/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


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



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * 
 */
public class Painter  extends JPanel{
//JButton b;
    public int calll=12;

         class BrightnessListener implements ChangeListener{
         public void stateChanged(ChangeEvent e) {
                 System.out.println("StateChanged()");
             setBrightnessFactor(
               (float)(bright.getValue())/10);
         }
       }


    private class MenuHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
            String command=e.getActionCommand();
            if(command.equals("Open   ")){
 slider2.setEnabled(false);
             slider_Erase.setEnabled(false);
                
if(flag_dragged==true || flag_load==true){

           JFrame frame=new JFrame();
Object[] options = {"Save","Don't Save","Cancle"};
int n = JOptionPane.showOptionDialog(frame,"Do you want to save changes ?","Paint",
    JOptionPane.YES_NO_CANCEL_OPTION,
    JOptionPane.PLAIN_MESSAGE,null,options,options[2]);
if(n==0)
{
    saveAs();
      Open();
}
else if(n==1)
{

 OSC1 = new BufferedImage(panl_width,panl_height,BufferedImage.TYPE_INT_RGB);
            if (OSC1 != null) {
               //backgroundColor= newColor;
               Graphics osg1 = OSC.getGraphics();
               osg1.setColor(backgroundColor);
               osg1.fillRect(0,0,OSC.getWidth(),OSC.getHeight());
               Painter.this.repaint();
}
   Open();
}

else
    System.out.println("Sorry");


}
else 
    Open();
          
            }
            else if(command.equals("Load")){
           slider2.setEnabled(false);
             slider_Erase.setEnabled(false);
                
if(flag_dragged==true || flag_load==true){

           JFrame frame=new JFrame();
Object[] options = {"Save","Don't Save","Cancle"};
int n = JOptionPane.showOptionDialog(frame,"Do you want to save changes ?","Paint",
    JOptionPane.YES_NO_CANCEL_OPTION,
    JOptionPane.PLAIN_MESSAGE,null,options,options[2]);
if(n==0)
{
    saveAs();
      Open();
}
else if(n==1)
{

 OSC1 = new BufferedImage(panl_width,panl_height,BufferedImage.TYPE_INT_RGB);
            if (OSC1 != null) {
               //backgroundColor= newColor;
               Graphics osg1 = OSC.getGraphics();
               osg1.setColor(backgroundColor);
               osg1.fillRect(0,0,OSC.getWidth(),OSC.getHeight());
               Painter.this.repaint();
}
   Open();
}

else
    System.out.println("Sorry");


}
else 
    Open();
          
            }
        
            else  if (command.equals("Edit Color")) {
        Color newColor = JColorChooser.showDialog(Painter.this,"Select Drawing Color", currentColor);
            if (newColor != null)
               currentColor = newColor;
         }
      //   if(command.equals("Deep"))

        


        
         else if(command.equals("Help Content")){
        Help_line p=new Help_line();
        p.setVisible(true);
        p.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         }

         
         else if(command.equals("Exit"))
         {
         System.exit(0);
         }

      
         else if(command.equals("Select Background color")){
              slider2.setEnabled(true);
             bright.setEnabled(false);
             boolean flag_save=false;
             if(flag_dragged==true || flag_load==true){
                 flag_dragged=false;
                 flag_load=false;
             JFrame frame=new JFrame();
Object[] options = {"Save","Don't Save","Cancel"};
int n = JOptionPane.showOptionDialog(frame,"Do you want to save changes ?","Paint",
    JOptionPane.YES_NO_CANCEL_OPTION,
    JOptionPane.PLAIN_MESSAGE,null,options,options[2]);
if(n==0)
{
    saveAs();
     Color newColor1 = JColorChooser.showDialog(Painter.this,"Select Background Color", currentColor);
            if (newColor1 != null)
               backgroundColor = newColor1;
      OSC = new BufferedImage(panl_width,panl_height,BufferedImage.TYPE_INT_RGB);
    //  OSC1=new BufferedImage(800,850,BufferedImage.TYPE_INT_RGB);
      System.out.print("Create OSC\n");
      Graphics2D osg = (Graphics2D) OSC.getGraphics();
      osg.setColor(backgroundColor);
      osg.fillRect(0,0,panl_width,panl_height);
    
    
}
else if(n==1)
{
Color newColor1 = JColorChooser.showDialog(Painter.this,"Select Background Color", currentColor);
            if (newColor1 != null)
               backgroundColor = newColor1;
    
 OSC1 = new BufferedImage(panl_width,panl_height,BufferedImage.TYPE_INT_RGB);
            if (OSC1 != null) {
               //backgroundColor= newColor;
               Graphics osg1 = OSC.getGraphics();
               osg1.setColor(backgroundColor);
               osg1.fillRect(0,0,OSC.getWidth(),OSC.getHeight());
               Painter.this.repaint();
}
}

else
    System.out.println("Sorry");
         }
             
         }
             

         

          else if(command.equals("Zoom In")){     

              if(zoom_100_zoom==1){
                 System.out.println("Sorry can zoom");
                }
              else if(count_zoom_in<2)
             {
                 count_zoom_in++;
                 count_zoom_out--;
                 if(count_zoom_in==2){
                 zoom_100_zoom=1;
                 }
           zoom();
             }
                
             else
                 System.out.println("Sorry");

         }            
         else if(command.equals("Zoom Out")){
             /*scale*= 2.0/3.0;
             System.out.print("zoom out\n"+OSC);
            // OSC1=OSC;
         //    applyTransform(OSC);*/

              /*if(!(zoom_width<=300 && zoom_height<=300)){
                //count_zoom_out++;
                //count_zoom_in--;
           layoutImage();
        OSC=zoomOut(OSC,2);
            }
              else
                  System.out.print("Sorry");*/
               if(count_zoom_out<2){
                   zoom_100_zoom=0;
                count_zoom_out++;
                count_zoom_in--;
           layoutImage();
        OSC=zoomOut(OSC,2);
               }

         }
         /*else if(command.equals("100% Zoom")){
             //zoom_100_zoom=zoom_100_zoom+count_zoom_in;
             System.out.println("count_zoom_out "+count_zoom_out);
             if(zoom_100_zoom==0 && count_zoom_in==0)
             {
         count_zoom_out=count_zoom_out-2;
         zoom_100_zoom=1;
         OSC=zoomIn(OSC,4);
             }
             else if(zoom_100_zoom==1){
             System.out.println("Sorry");
             }
             else if(count_zoom_in==1){
                  count_zoom_out--;
             OSC=zoomIn(OSC,2);
             }
             else if(count_zoom_out==2){
             OSC=zoomIn(OSC,6);
             }
             else if(count_zoom_out==1){
             OSC=zoomIn(OSC, 6);
             }
             else if(count_zoom_out==0){
             OSC=zoomIn(OSC, 4);
             }

             layoutImage();
             //count_zoom_out=-1;
            repaint();
         }*/

    
       
         else if(command.equals("New   ")){
         slider2.setEnabled(true);
             bright.setEnabled(false);
             boolean flag_save=false;
             if(flag_dragged==true || flag_load==true){
                 flag_dragged=false;
                 flag_load=false;
             JFrame frame=new JFrame();
Object[] options = {"Save","Don't Save","Cancel"};
int n = JOptionPane.showOptionDialog(frame,"Do you want to save changes ?","Paint",
    JOptionPane.YES_NO_CANCEL_OPTION,
    JOptionPane.PLAIN_MESSAGE,null,options,options[2]);
if(n==0)
{
   // osg.setColor(backgroundColor);
    saveAs();
}
else if(n==1)
{

 OSC1 = new BufferedImage(panl_width,panl_height,BufferedImage.TYPE_INT_RGB);
            if (OSC1 != null) {
               //backgroundColor= newColor;
               Graphics osg1 = OSC.getGraphics();
               osg1.setColor(Color.WHITE);
              
               osg1.fillRect(0,0,OSC.getWidth(),OSC.getHeight());
               Painter.this.repaint();
}
}

else
    System.out.println("Sorry");
         }
         }
     else if(command.equals("Clear")){
             Graphics g = OSC.getGraphics();
              g.fillRect(0, 0,panl_width,panl_height);
               paintComponent(g);
               repaint();

         }
                
                else if(command.equals("Save")){
                if(flag_save==true){
                    try {
                        System.out.print("dsf Save" +filename);
                        save(filename);
                    } catch (IOException ex) {
                        Logger.getLogger(Painter.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    }
                else{
                    flag_save=true;
                    saveAs();
                }
            }

         else if(command.equals("Save As     ")){
             flag_save=true;
         saveAs();
         }
         else if(command.equals("Rotate Left")){
        angle = (angle- 1) % 2;
        System.out.print("\nRotate left \n"+OSC);
        applyTransform(OSC);
         }
             else if(command.equals("Rotate Right")){
        angle = (angle + 1) % 2;
        applyTransform(OSC);
         }
      

         else if (command.equals("Curve"))
         {
             bright.setEnabled(false);
             slider2.setEnabled(true);
             slider_Erase.setEnabled(false);
         
            currentTool = Painter.Tool.CURVE;
         }
         else if (command.equals("Line"))
            currentTool = Painter.Tool.LINE;
         else if (command.equals("Rectangle"))
            currentTool = Painter.Tool.RECT;
         else if (command.equals("Oval"))
            currentTool = Painter.Tool.OVAL;
         else if (command.equals("Filled Rectangle"))
            currentTool = Painter.Tool.FILLED_RECT;
         else if (command.equals("Filled Oval"))
            currentTool = Painter.Tool.FILLED_OVAL;
         else if (command.equals("Smudge"))
         {

            currentTool = Painter.Tool.SMUDGE;
         }
         else if (command.equals("Erase"))
         {
             slider_Erase.setEnabled(true);
             slider2.setEnabled(false);
            currentTool = Painter.Tool.ERASE;
         }
         else if(command.equals("Filled Round Rect")){
             System.out.print("Round");
         currentTool=Painter.Tool.Filled_RoundRect;
         }
        

            else if (e.getActionCommand().equals("About")) {
         About a= new About();
         a.setVisible(true);
         a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        }
    }
    private class MouseHandler implements MouseListener, MouseMotionListener {

      int prevX, prevY;  // Previous position of mouse during a drag.

   double[][] smudgeRed, smudgeGreen, smudgeBlue;

      void Eraser(int x1, int y1, int x2, int y2) {
         Graphics g = OSC.getGraphics();
           g.setColor(backgroundColor);    // (for ERASE only)
          int w = OSC.getWidth();   // (for SMUDGE only)
         int h = OSC.getHeight();

         int dist = Math.max(Math.abs(x2-x1),Math.abs(y2-y1));
             // dist is the number of points along the line from
             // (x1,y1) to (x2,y2) at which the tool will be applied.
         double dx = (double)(x2-x1)/dist;
         double dy = (double)(y2-y1)/dist;
         for (int d = 1; d <= dist; d++) {
                // Apply the tool at one of the points (x,y) along the
                // line from (x1,y1) to (x2,y2).
            int x = (int)Math.round(x1 + dx*d);
            int y = (int)Math.round(y1 + dy*d);
            if (currentTool == Painter.Tool.ERASE) {

               g.fillRect(x-width1,y-width1,width1,width1);
               repaint(x-width1,y-width1,width1,width1);
            }
             else if(currentTool == Painter.Tool.SMUDGE){
                  for (int i = 0; i < 7; i++)
                  for (int j = 0; j < 7; j++) {
                     int r = y + j - 3;
                     int c = x + i - 3;
                     if (!(r < 0 || r >= h || c < 0 || c >= w || smudgeRed[i][j] == -1)) {
                        int curCol = OSC.getRGB(c,r);
                        int curRed = (curCol >> 16) & 0xFF;
                        int curGreen = (curCol >> 8) & 0xFF;
                        int curBlue = curCol & 0xFF;
                        int newRed = (int)(curRed*0.7 + smudgeRed[i][j]*0.3);
                        int newGreen = (int)(curGreen*0.7 + smudgeGreen[i][j]*0.3);
                        int newBlue = (int)(curBlue*0.7 + smudgeBlue[i][j]*0.3);
                        int newCol = newRed << 16 | newGreen << 8 | newBlue;
                        OSC.setRGB(c,r,newCol);
                        smudgeRed[i][j] = curRed*0.3 + smudgeRed[i][j]*0.7;
                        smudgeGreen[i][j] = curGreen*0.3 + smudgeGreen[i][j]*0.7;
                        smudgeBlue[i][j] = curBlue*0.3 + smudgeBlue[i][j]*0.7;
                     }
                  }
               repaint(x-3,y-3,7,7);
            }

         }

      }


      public void mousePressed(MouseEvent evt) {
         
         startX = prevX = currentX = evt.getX();
         startY = prevY = currentY = evt.getY();
         dragging = true;
         if (currentTool == Painter.Tool.ERASE) {
               // Erase a 10-by-10 block around the starting mouse position.
            Graphics g = OSC.getGraphics();
            g.setColor(backgroundColor);

            g.fillRect(startX-width1,startY-width1,width1,width1);
            repaint(startX-width1,startY-width1,width1,width1);
         }
         else if (currentTool == Painter.Tool.SMUDGE) {
                 if (smudgeRed == null) {
                  // Create the arrays, if they have not already been created.
               smudgeRed = new double[7][7];
               smudgeGreen = new double[7][7];
               smudgeBlue = new double[7][7];
            }
            int w = OSC.getWidth();
            int h = OSC.getHeight();
            int x = evt.getX();
            int y = evt.getY();
            for (int i = 0; i < 7; i++)
               for (int j = 0; j < 7; j++) {
                  int r = y + j - 3;
                  int c = x + i - 3;
                  if (r < 0 || r >= h || c < 0 || c >= w) {
                        // A -1 in the smudgeRed array indicates that the
                        // corresponding pixel was outside the canvas.
                     smudgeRed[i][j] = -1;
                  }
                  else {
                     int color = OSC.getRGB(c,r);
                     smudgeRed[i][j] = (color >> 16) & 0xFF;
                     smudgeGreen[i][j] = (color >> 8) & 0xFF;
                     smudgeBlue[i][j] = color & 0xFF;
                  }
               }
            
            
            
         }
        
      }


      public void mouseDragged(MouseEvent evt) {
           flag_dragged=true;
         currentX = evt.getX();
         currentY = evt.getY();
         if (currentTool == Painter.Tool.CURVE) {
            Graphics2D g = (Graphics2D) OSC.getGraphics();
            g.setColor(currentColor);
            g.setStroke(new BasicStroke(value));
            g.drawLine(prevX,prevY,currentX,currentY);
            g.dispose();
            g.setStroke(new BasicStroke(value));
            repaintRect(prevX,prevY,currentX,currentY);
         }
         else if (SHAPE_TOOLS.contains(currentTool)) {
//g.setStroke(new BasicStroke(70));
            repaintRect(startX,startY,prevX,prevY);
            repaintRect(startX,startY,currentX,currentY);
         }
        else {
               // Tool has to be ERASE or SMUDGE
            // g.setStroke(new BasicStroke(70));
            Eraser(prevX,prevY,currentX,currentY);
         }
         prevX = currentX;
         prevY = currentY;
      }


      public void mouseReleased(MouseEvent evt) {
         dragging = false;
         if (SHAPE_TOOLS.contains(currentTool)) {
            Graphics2D g = (Graphics2D) OSC.getGraphics();
            g.setColor(currentColor);
            System.out.print("putCurrentShape(Graphics g)\n");
            putCurrentShape(g);

            g.dispose();
            repaint();
         }
      }

      public void mouseMoved(MouseEvent evt) { }
      public void mouseClicked(MouseEvent evt) { }
      public void mouseEntered(MouseEvent evt) { }
      public void mouseExited(MouseEvent evt) { }

   } // end nested class MenuHandler

 //   private BufferedImage image =null;
  //  private JFileChooser fileChooser=null ;



    /*public Painterreviewer() {

    }*/

JFrame frame1;
    private String saveAsHelper(String extension){
        // use file chooser dialog to get filename to save into
        checkChooser();
        if (chooser.showSaveDialog(frame1) != JFileChooser.APPROVE_OPTION) {

            return null;
        }

       selectedFile = chooser.getSelectedFile();
        System.out.println("jsdgh"+selectedFile);
        String filename = selectedFile.toString();
        //  System.out.println(filename.toLowerCase().endsWith(extension));
        if (!filename.toLowerCase().endsWith(extension)) {
            // Windows is dumb about extensions with file choosers
            //System.out.print("hmm");
            filename += "." + extension;
        }

        // confirm overwrite of file
        if (new File(filename).exists() && JOptionPane.showConfirmDialog(
                frame1, "File exists.  Overwrite?", "Overwrite?",
                JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return null;
        }

        return filename;
    }


    private void checkChooser() {
        if (chooser == null) {
            // TODO: fix security on applet mode
            chooser = new JFileChooser(System.getProperty("u"));
            chooser.setMultiSelectionEnabled(false);

        }
    }
File selectedFile ;
    boolean flag_dragged=false;
    boolean flag_load=false;
    boolean flag_save=false;
    int zoom_width=1200;
    int zoom_height=700;
   int zoom_100_zoom=0;
    
String filename;
private Container container;
JScrollPane sp;
 private double scale = 1.0;
 // private int    angle = 0;
 private JLabel canvas = new JLabel();

private enum Tool {CURVE, LINE, RECT, OVAL, FILLED_RECT, FILLED_OVAL, ERASE,Clear,SMUDGE,EXIT,Filled_RoundRect
 }
private boolean _canDrag  = false;
JFrame frame21;
int count_zoom_in=0,count_zoom_out=0;
private final static EnumSet<Painter.Tool> SHAPE_TOOLS = EnumSet.range(Painter.Tool.LINE, Painter.Tool.FILLED_OVAL);
private Painter.Tool currentTool = Painter.Tool.CURVE;
JFileChooser fileChooser1,fileChooser;
double widthload=1100,heightload=700;
private Color currentColor = Color.BLACK;
private Color backgroundColor = Color.WHITE;
private BufferedImage OSC1,OSC2,OSC,originalImage,OSC_load;
BufferedImage OSC22 = null ;
Graphics2D osg2;
int panl_width=1000,panl_height=700;
private int angle = 0;


JSlider slider_Erase;
JSlider slider2;
//public Pen cropPane;
   boolean algStarted = false, algFin = false;
   int w=500, h=500, mx, my, poc, c_old, count = 0;
Graphics bgr;
 Dimension imgSize,iniSize;
int[] main_pixels = new int[w*h];
int[] sub_pixels = new int[w*h];

   int width1=1;
   private boolean dragging;
   private int startX, startY;
   private int currentX, currentY;
//private int currentZoom=1;
JSlider bright;
JPanel panel12;
//JSli
double rotateTheta = 0.0;
int value=1;
  double rotateX = 150.0;
 JPanel controlPanel ;
  double rotateY = 150.0;
   private JFileChooser chooser;

    public Painter() {
super(new BorderLayout());

    System.out.print("Ami picmanagerLayout()\n");
  //sp=new JScrollPane(this);
    //sp.setSize(400,275);
//this.add(sp);
    //sp.add(pN);
  fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));

        fileChooser.setFileFilter(new ImageFilter());



//setPreferredSize(new Dimension(1200,700));
        this.setSize(1400,700);
Painter.MouseHandler mouseHandler = new Painter.MouseHandler();
      addMouseListener(mouseHandler);
      addMouseMotionListener(mouseHandler);
      panel12=new JPanel();
      panel12.setLayout(new GridLayout(13, 7));
      JLabel label=new JLabel("Pencil");
      panel12.add(label);


      slider2=new JSlider(SwingConstants.HORIZONTAL,0,100,10);
     slider2.setMajorTickSpacing(20);
     slider2.setMinorTickSpacing(4);
     slider2.setPaintTicks(true);
     slider2.setPaintLabels(true);
     slider2.addChangeListener(
             new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                 value = (slider2.getValue())/4;
            }
        });
     panel12.add(slider2,BorderLayout.SOUTH);
     this.add(panel12,BorderLayout.EAST);
     Color myColor = new Color(150,200,255);
   panel12.setBackground(myColor);


   
JLabel label_erase=new JLabel("Eraser");
panel12.add(label_erase);
 slider_Erase=new JSlider(SwingConstants.HORIZONTAL,0,100,10);
slider_Erase.setMajorTickSpacing(20);
slider_Erase.setMinorTickSpacing(4);
slider_Erase.setPaintLabels(true);
slider_Erase.setPaintTicks(true);
slider_Erase.setEnabled(false);
slider_Erase.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                width1=(slider_Erase.getValue())/4;
            }
        });
panel12.add(slider_Erase,BorderLayout.WEST);

bright=new JSlider(SwingConstants.HORIZONTAL,2,80,10);
JLabel brightness=new JLabel("Brightness");
bright.setMajorTickSpacing(10);
bright.setPaintTicks(true);
bright.setEnabled(false);
bright.setPaintLabels(true);
   bright.addChangeListener(
           new BrightnessListener());
   panel12.add(brightness);
   panel12.add(bright,BorderLayout.WEST);
   }


    private void center(Window frame){
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screen = tk.getScreenSize();
        System.out.println(screen.width+"  "+frame.getWidth());

        int x = Math.max(0, (screen.width - frame.getWidth()) / 2);
        int y = Math.max(0, (screen.height - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }


   public void paintComponent(Graphics g){
 
       Graphics2D g2d=(Graphics2D) g;
      if (OSC == null)
         createOSC();

        //  g2d.setStroke(new BasicStroke(value));
      g.drawImage(OSC,0,0,this);
      repaint();
      if (dragging && SHAPE_TOOLS.contains(currentTool)){
        
         g.setColor(currentColor);
         setBackground(backgroundColor);
         putCurrentShape(g2d);
      }
   }
   private void createOSC() {

      OSC = new BufferedImage(panl_width,panl_height,BufferedImage.TYPE_INT_RGB);
    //  OSC1=new BufferedImage(800,850,BufferedImage.TYPE_INT_RGB);

      Graphics2D osg = (Graphics2D) OSC.getGraphics();
      osg.setColor(backgroundColor);
      osg.fillRect(0,0,panl_width,panl_height);
      //osg.setColor(currentColor);
   }


    private void putCurrentShape(Graphics2D g) {
      switch (currentTool){
      case LINE:
          g.setStroke(new BasicStroke(value));
         g.drawLine(startX, startY, currentX, currentY);
         break;
      case OVAL:
         putOval(g,false,startX, startY, currentX, currentY);
         break;
      case RECT:
         putRect(g,1,startX, startY, currentX, currentY);
         break;
      case FILLED_OVAL:
         putOval(g,true,startX, startY, currentX, currentY);
         break;
      case FILLED_RECT:
         putRect(g,0,startX, startY, currentX, currentY);
         break;
          case Filled_RoundRect:
          {
               putRect(g,2,startX, startY, currentX, currentY);
               break;
          }
          //case Arc:
          //    g.setColor(Color.PINK);
        //g.fillArc(BORDER, BORDER, w - 2*BORDER, h - 2*BORDER, 30, 300);
      //  break;
      }
   }

    private void putRect(Graphics2D g,int filled, int x1, int y1, int x2, int y2) {
      if (x1 == x2 || y1 == y2)
         return;
      if (x2 < x1) {  // Swap x1,x2 if necessary to make x2 > x1.
         int temp = x1;
         x1 = x2;
         x2 = temp;
      }
      if (y2 < y1) {  // Swap y1,y2 if necessary to make y2 > y1.
         int temp = y1;
         y1 = y2;
         y2 = temp;
      }
      if (filled==0)
      {
 g.setStroke(new BasicStroke(value));
         g.fillRect(x1,y1,x2-x1,y2-y1);
      }
      else if(filled==1)
      {
           g.setStroke(new BasicStroke(value));
         g.drawRect(x1,y1,x2-x1,y2-y1);
      }
      else
      {
           g.setStroke(new BasicStroke(value));
          g.fillRoundRect(x1, y1,x2,y2,20,20);
      }
   }

      private void putOval(Graphics2D g, boolean filled, int x1, int y1, int x2, int y2) {
      if (x1 == x2 || y1 == y2)
         return;
      if (x2 < x1) {  // Swap x1,x2 if necessary to make x2 > x1.
         int temp = x1;
         x1 = x2;
         x2 = temp;
      }
      if (y2 < y1) {  // Swap y1,y2 if necessary to make y2 > y1.
         int temp = y1;
         y1 = y2;
         y2 = temp;
      }
      if (filled)
      {
         g.setStroke(new BasicStroke(value));
         g.fillOval(x1,y1,x2-x1,y2-y1);
      }
      else
      {
          g.setStroke(new BasicStroke(value));
         g.drawOval(x1,y1,x2-x1,y2-y1);
      }
   }

     private void repaintRect(int x1, int y1, int x2, int y2) {
      if (x2 < x1) {  // Swap x1,x2 if necessary to make x2 >= x1.
         int temp = x1;
         x1 = x2;
         x2 = temp;
      }
      if (y2 < y1) {  // Swap y1,y2 if necessary to make y2 >= y1.
         int temp = y1;
         y1 = y2;
         y2 = temp;
      }
      x1--;
      x2++;
      y1--;
      y2++;
      repaint(x1,y1,x2-x1,y2-y1);
   }



     public JMenuBar getMenuBar() {
      JMenuBar menubar = new JMenuBar();
      JMenu fileMenu=new JMenu("File");
      fileMenu.setMnemonic('F');
      fileMenu.setToolTipText("This is File Menu");
      JMenu colorMenu = new JMenu("Color");
      colorMenu.setMnemonic('C');
      colorMenu.setToolTipText("This is color Menu");
      JMenu toolMenu = new JMenu("Shape");
      toolMenu.setMnemonic('S');
      toolMenu.setToolTipText("This is Shape Menu");
      JMenu tool1Menu=new JMenu("Tool");
      tool1Menu.setMnemonic('T');
      tool1Menu.setToolTipText("This is Tool Menu");

     
      JMenu image=new JMenu("Image");
      image.setMnemonic('i');

      
      JMenu help=new JMenu("Help");
      help.setMnemonic('h');
      help.setToolTipText("This is help Menu");
      //JMenu select=new JMenu("Select");


      menubar.add(fileMenu);
      menubar.add(colorMenu);
      menubar.add(toolMenu);
      menubar.add(tool1Menu);
     
      menubar.add(image);
      menubar.add(help);
       //menubar.add(select);
ActionListener listener = new Painter.MenuHandler();
       JMenuItem item;
       JCheckBoxMenuItem check;
      boolean secure = (System.getSecurityManager() != null);
        try {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Painter.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Painter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Painter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Painter.class.getName()).log(Level.SEVERE, null, ex);
        }
      item=new JMenuItem("New   ");
      item.addActionListener(listener);
      item.setAccelerator(KeyStroke.getKeyStroke("ctrl A"));
      item.setEnabled(!secure);
      fileMenu.add(item);

      item=new JMenuItem("Open   ");
      item.addActionListener(listener);
      item.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
      item.setEnabled(!secure);
      fileMenu.add(item);

    item = new JMenuItem("Save As     ", 'A');
       item.addActionListener(listener);
        item.setEnabled(!secure);
        fileMenu.add(item);
        fileMenu.addSeparator();

        item=new JMenuItem("Save");
        item.addActionListener(listener);
         item.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
        item.setEnabled(!secure);
        fileMenu.add(item);
        fileMenu.addSeparator();

        item=new JMenuItem("About");
        item.addActionListener(listener);
        help.add(item);
        
        item=new JMenuItem("Help Content");
        item.addActionListener(listener);
        help.add(item);


      item = new JMenuItem("Edit Color");
      item.addActionListener(listener);
      colorMenu.add(item);
      

      item=new JMenuItem("Select Background color");
      item.addActionListener(listener);
      colorMenu.add(item);
      
      item = new JMenuItem("Curve");
      item.addActionListener(listener);
      toolMenu.add(item);
      toolMenu.addSeparator();
      item = new JMenuItem("Line");
      item.addActionListener(listener);
      toolMenu.add(item);
      item = new JMenuItem("Rectangle");
      item.addActionListener(listener);
      toolMenu.add(item);
      item = new JMenuItem("Oval");
      item.addActionListener(listener);
      toolMenu.add(item);
      item = new JMenuItem("Filled Rectangle");
      item.addActionListener(listener);
      toolMenu.add(item);
      item = new JMenuItem("Filled Oval");
      item.addActionListener(listener);
      toolMenu.add(item);  

      item = new JMenuItem("Erase");
      item.addActionListener(listener);
      tool1Menu.add(item);

  


      item=new JMenuItem("Clear");
      item.addActionListener(listener);
      fileMenu.add(item);

      item=new JMenuItem("Smudge");
      item.addActionListener(listener);
      tool1Menu.add(item);
tool1Menu.addSeparator();
     

 item=new JMenuItem("Zoom In");
       item.addActionListener(listener);
         item.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
        item.setEnabled(!secure);
        tool1Menu.add(item);
        item=new JMenuItem("Zoom In");
       item.addActionListener(listener);
         item.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
        item.setEnabled(!secure);     
        image.add(item);

        item=new JMenuItem("Zoom Out");
         item.addActionListener(listener);
         item.setAccelerator(KeyStroke.getKeyStroke("ctrl M"));
        item.setEnabled(!secure);
        tool1Menu.add(item);
        
        item=new JMenuItem("Zoom Out");
         item.addActionListener(listener);
         item.setAccelerator(KeyStroke.getKeyStroke("ctrl M"));
        item.setEnabled(!secure);
        image.add(item);
        
      item=new JMenuItem("Rotate Left");
      item.setAccelerator(KeyStroke.getKeyStroke("ctrl L"));
      item.addActionListener(listener);
      tool1Menu.add(item);
      image.add(item);

      item=new JMenuItem("Rotate Right");
      item.setAccelerator(KeyStroke.getKeyStroke("ctrl R"));
      item.addActionListener(listener);
      tool1Menu.add(item);
      image.add(item);

       

    
      item=new JMenuItem("Exit");
      item.addActionListener(listener);
      fileMenu.add(item);


    
      return menubar;
   }
      private BufferedImage getImage() {
        // create second image so we get the background color
        BufferedImage image2;
        image2 = new BufferedImage(panl_width, panl_height,OSC.getType());
        Graphics g = image2.getGraphics();
        g.setColor(backgroundColor);
        g.drawImage(OSC, 0, 0, this);
        return image2;
    }
        public void save(String filename) throws IOException {
        BufferedImage image2 = getImage();
        int lastDot = filename.lastIndexOf(".");
        System.out.println(filename+"vgf\n"+ lastDot);
        String extension = filename.substring(lastDot + 1);

        ImageIO.write(image2, extension, new File(filename));
    }
    public  void saveAs() {
    filename = saveAsHelper("png");
        System.out.print("filename\n"+filename);
        if (filename != null) {
            try {
                save(filename);  // save the file
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame1, "Unable to save image:\n" + ex);
            }
        }
    }

 public void call(int y){
 //    call2(y);
     calll=y;

 }
public  int get(){
return calll;
}
   // public void actionPerformed(ActionEvent e) {
    public void Open(){
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));

        fileChooser.setFileFilter(new ImageFilter());

        int choice = fileChooser.showOpenDialog(container);

        if(choice == JFileChooser.APPROVE_OPTION) {
           String name = fileChooser.getSelectedFile().getPath();
             loadImage(name);
           // layoutImage();
        }
     }

    private void loadImage(String file){
        bright.setEnabled(true);
        try {
     OSC_load= OSC  = ImageIO.read(new File(file));
      widthload= OSC.getWidth(null);
      heightload = OSC.getHeight(null);
      int fitWidth = this.getWidth();
      int fitHeight = this.getWidth();
      System.out.println(fitWidth+" height shanto "+fitHeight);

        if(widthload > fitWidth){
            widthload = fitWidth;
        }
        else if(widthload<fitWidth){
        widthload=widthload;
        }
        if(heightload > fitHeight)
        {
            heightload = 700;
        }
        else if(heightload<fitHeight){
        heightload=heightload;
        }
            
        
    } catch (IOException ioex) {
      System.out.println("Cannot load image: \"" + file + "\"");
      System.exit(-1);
    }

         originalImage
           = new BufferedImage(OSC_load.getWidth(null),
            OSC.getHeight(null),
             BufferedImage.TYPE_INT_RGB);
         OSC= new BufferedImage(OSC_load.getWidth(null),
             OSC_load.getHeight(null),
             BufferedImage.TYPE_INT_RGB);
         Graphics g = originalImage.createGraphics();
         g.drawImage(OSC_load, 0, 0, null);
         setBrightnessFactor(1);
layoutImage();
     labelIcon(OSC);
    scale = 1.0;
    angle = 0;
    applyTransform(OSC);
    flag_load=true;
    flag_save=false;
    }

     private void setBrightnessFactor(float multiple) {
           System.out.println("setBrightnessFactor()");
         float[] brightKernel = {multiple};
         BufferedImageOp bright
           = new ConvolveOp(
               new Kernel(1, 1, brightKernel));
         bright.filter(originalImage,OSC);
         repaint();
       }


    private void applyTransform(BufferedImage image) {
    AffineTransform at = new AffineTransform();
    at.scale(scale, scale);
    at.rotate(0.5 * angle * Math.PI, widthload/2, heightload/2);

    int w_im = Math.min(2000, (int) (scale * widthload));
    int h_im = Math.min(2000, (int) (scale * heightload));
//affineTransform.rotate(Math.toRadians(angle), m_imageWidth/2, m_imageHeight/2);
    OSC = new BufferedImage(w_im, h_im, BufferedImage.TYPE_INT_RGB);
    Graphics2D  graphics = (Graphics2D) OSC.getGraphics();
   
    graphics.drawImage(image, at, this);
    labelIcon(OSC);
  }

 private void zoom() {
             OSC=zoomIn(OSC,2);
             layoutImage();
            repaint();
        }
public BufferedImage zoomIn(BufferedImage OSC, int scale)
	{
            //System.out.println("\nwidth"+w+"height"+OSC.getHeight()+"\n");
		int width = scale * OSC.getWidth();
		int height = scale * OSC.getHeight();
                System.out.println("\nwidth"+width+"height"+height+"\n");
               
		BufferedImage biScale = new BufferedImage(width, height, OSC.getType());
System.out.println("\nwidth"+width+"height"+height+"\n");
		for(int i=0; i<width; i++)
			for(int j=0; j<height; j++)
				biScale.setRGB(i, j, OSC.getRGB(i/scale, j/scale));
		repaint();
		return biScale;
	}

 private void layoutImage() {
        int x = OSC.getWidth();
        int y = OSC.getHeight();
        setPreferredSize(new Dimension(x , y));
        revalidate();
    }

 public BufferedImage zoomOut(BufferedImage OSC, int scale)
	{
		int width =OSC.getWidth() / scale;
		int height =OSC.getHeight() / scale;

		BufferedImage biScale = new BufferedImage(width, height, OSC.getType());

		for(int i=0; i<width; i++)
			for(int j=0; j<height; j++)
				biScale.setRGB(i, j, OSC.getRGB(i*scale, j*scale));
		repaint();
		return biScale;
	}

     public void labelIcon(Image image){
         System.out.println("lllllllllllllllllaaaaaaaaaabeeeeeeel");
    canvas.setHorizontalAlignment(JLabel.CENTER);
    canvas.setVerticalAlignment(JLabel.CENTER);
    canvas.setIcon(new ImageIcon(image));
  }


}





//Importojm� paketat qe na duhen per te ekzekutuar detyren.
import javax.swing.*;  // javax.swing per shkak te JPanel dhe JFrame.
import java.awt.*;  // Java.awt per shkak te (Graphics g).
import java.awt.event.ActionEvent;  // java.awt.event.ActionEvent per shkak te ActionEvent dhe ActionListener
import java.awt.event.ActionListener; // java.awt.event.ActionListener per shkak te ActionListener
/**
Klasa Home per te shkruar modelin e sht�pis�.

*/
public class Home extends JPanel implements ActionListener { 
	
    private Die die = new Die(); // Die per te thirrur objektin nga klasa Die.
    private int d1; // Deklarimi i nje numri te plote.
    private int d2;
    
    // Deklarimi i tipeve boolean.
    private boolean house1; 
    private boolean roof1;
    private boolean door1;
    private boolean window1;
    private boolean house2;
    private boolean roof2;
    private boolean door2;
    private boolean window2;
    
    // Deklarimi i buton�ve t� cil�t na nevoiten n� vazhdim t� detyr�s.
    JButton retry;
    JButton retry1;
    private int turn = 1; 
 
    /**
     * Konstruktori Home krijon korniz�n
     * dhe inicializon ndryshoret retry dhe retry1.
     * Shton retry dhe retry1 ne korniz�.
     */
    public Home() {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setTitle("Shtepia1");
        frame.getContentPane().add(this);
       frame.setBackground(Color.orange);
        retry = new JButton("Lojtari 1");
        retry1 = new JButton("Lojtari 2");
        retry.addActionListener(this);
        retry1.addActionListener(this);
        add(retry);
        add(retry1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
    }
    /**
     * Metoda actionPerformed kontrollon butonat q� dy lojtar�t te gjuajn me rend.
     * Dhe shtyp ne console vler�n e zarit.
     */
      public void actionPerformed(ActionEvent e)
    {
    
    if(e.getSource() == retry){
    if(turn == 1){
      d1 = die.throwFuncP1();
      System.out.println("Lojtari 1"
      		+ " :" +d1);
      turn++;
      }else
      {
       System.out.println("Radhen e ka Lojtari 2");
      }
      }
      if(e.getSource() == retry1){
      if(turn == 2){
      d2 = die.throwFuncP2();
      System.out.println("Lojtari 2 :" +d2);
      turn--;
      }else
      {
       System.out.println("Radh�n e ka Lojtari 1");
      }
     
      }
      this.repaint();
    }
      /**
       * Metoda paintComponent b�n� thirrjen e metodave tjera private. 
       * @param g lapsi grafik qe b�n� vizatimin.
       */
    public void paintComponent(Graphics g) {
     g.setColor(Color.black);
     regulations(g);
     square(g);
     roof(g);
     door(g);
     window(g);
     drawing(g);
    }
    /**
     * 
     * Metoda drawing shkruan ne flete vendin se ku do te vizatohet shtepia e Lojtari 1 dhe Lojtari 2.
     * @param g lapsi grafik qe b�n� vizatimin.
     */
    private void drawing(Graphics g) {
    	
    	 g.setColor(Color.orange);
         g.fillRect(0,0,100,30);
         g.setColor(Color.red);
         g.drawString("Lojtari 1", 35, 250);
         g.setColor(Color.blue);
         g.drawString("Lojtari 2", 140, 250);
         g.setColor(Color.black);
         g.drawRect(0, 60, 110, 200);
         g.setColor(Color.black);
         g.drawRect(110, 60, 120, 200);
    }
    
    /**
     * 
     * Metoda regulations vizaton nje tabel� qe tregon rregullat e loj�s.
     * @param g lapsi grafik qe b�n� vizatimin.
     */
    private void regulations(Graphics g) {
    	g.setColor(Color.black);
    	g.fillRect(230, 60, 150, 201);
    	
    	g.setColor(Color.orange);
    	g.drawString("Rregullat e lojes:",240,85);
    	g.drawString("6 - Ndertesa", 250, 120);
    	g.drawRect(240,100,130,30);
    	g.drawString("5 - Kulmi", 250, 150);
    	g.drawRect(240,130,130,30);
    	g.drawString("4 - Dera", 250, 180);
    	g.drawRect(240,160,130,30);
    	g.drawString("3 - Dritaret", 250, 210);
    	g.drawRect(240,190,130,30);
    	g.drawString("2 dhe 1 - asgje", 250, 240);
    	g.drawRect(240,220,130,30); 
    
   
    }
    
    /**
    * Metoda square shikon vler�n e gjuajtes dhe n�se ajo gjuajtje e plot�son kushtin, kjo metod� do t� ekzekutoj ndertes�n.
     * @param g lapsi grafik qe b�n� vizatimin.
     */
    private void square(Graphics g) {
        while(d1 == 6 && house1==false && roof1==false && door1==false && window1==false) {
        	g.setColor(Color.red);
        	g.fillRect(30, 160, 60, 60);
            
            house1=true;
            break;
        
        }
         while(d2 == 6 && house2==false && roof2==false && door2==false && window2==false) {
        	 g.setColor(Color.blue);
     		g.fillRect(140, 160, 60, 60);
            
            house2=true;
            break;
        }
    }

    /**
     * Metoda roof shikon vler�n e gjuajtes dhe n�se ajo gjuajtje e plot�son kushtin, kjo metod� do t� ekzekutoj kulmin.
     * 
     * @param g lapsi grafik qe b�n� vizatimin.
     */

    private void roof(Graphics g) {
        while (d1 == 5 && house1 && roof1==false && door1==false && window1==false) {
        	g.setColor(Color.red);
        
         g.drawLine(30, 160, 60, 100);
         g.drawLine(89, 160, 60, 100);
            roof1=true;
            break;
        }
         while (d2 == 5 && house2 && roof2==false && door2==false && window2==false) {
        	 g.setColor(Color.blue);
        	 g.drawLine(140, 160, 170, 100);
             g.drawLine(199, 160, 170, 100);
            roof2=true;
             break;
        }
    }
    /**
     * Metoda door shikon vler�n e gjuajtes dhe n�se ajo gjuajtje e plot�son kushtin, kjo metod� do t� ekzekutoj der�n.
     * @param g lapsi grafik qe b�n� vizatimin.
     */
    private void door(Graphics g) {
      while (d1== 4 && house1 && roof1 && door1==false && window1==false) {
    	  g.setColor(Color.black);
      	g.drawRect(53, 199, 15, 20);
            door1 = true;
            break;
        }
        while (d2== 4 && house2 && roof2 && door2==false && window2==false) {
        	g.setColor(Color.black);
        	g.drawRect(163, 199, 15, 20);
            door2 = true;
            break;
        }
    }
   /**
    *  Dhe metoda e fundit metoda window shikon vler�n e gjuajtes dhe n�se ajo gjuajtje e plot�son kushtin, kjo metod� do t� 
    *  ekzekutoj dritar�n dhe do t� percaktoj fituesin e loj�s.
    * 
    * @param g lapsi grafik qe b�n� vizatimin.
    */
    private void window(Graphics g) {
        while(d1==3 && house1 && roof1 && door1 && window1==false)
        {
        	g.setColor(Color.black);
        	g.drawRect(35,175,12,12);
        	g.setColor(Color.black);
        	g.drawRect(70,175,12,12);
        	g.setColor(Color.black);
        	g.fillRect(0, 290, 250, 50);
        	g.setColor(Color.orange);
        	g.drawString("Loja perfundoi.", 5, 310);
        	g.drawString("Lojtari 1 eshte fitues. Urime.", 5, 330);
            break;
           
        }
        while(d2==3 && house2 && roof2 && door2 && window2==false)
        {
        	g.setColor(Color.black);
        	g.drawRect(145,175,12,12);
        	g.setColor(Color.black);
        	g.drawRect(180,175,12,12);
        	g.setColor(Color.black);
        	g.fillRect(0, 290, 250, 50);
        	g.setColor(Color.orange);
        	g.drawString("Loja perfundoi.", 5, 310);
        	g.drawString("Lojtari 2 eshte fitues. Urime.", 5, 330);
            break;
        }
    }
}


/**
 * Klasa Die �sht� klas� q� ka dy metoda t� cilat i shfrytezon klasa Home. 
 */

public class Die {
	/**
	 * Metoda throwFuncP1 b�n� hudhjen e zarit te cilin e perdor butoni i Lojtarit 1.
	 * @return kthen vleren e die;
	 */
   public int throwFuncP1() {
      int die=(int)(Math.random()*6) + 1;
      return die;
   }
   /**
    * Metoda throwFuncP1 b�n� hudhjen e zarit te cilin e perdor butoni i Lojtarit 2.
    * @return kthen vleren e die;
    */
    public int throwFuncP2() {
      int die=(int)(Math.random()*6) + 1;
      return die;
   }
}
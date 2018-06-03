package UncertainException;

public class UncertainException {

   private int i = 0;

   public static void uncertain(int number) {
      UncertainException uncertain = new UncertainException();
      int result = 0;

      try {
         System.out.println("uncertain" + number + "()");
         switch (number) {
            case 1:
               result = uncertain.uncertain1();
               break;
            case 2:
               result = uncertain.uncertain2();
               break;
            case 3:
               result = uncertain.uncertain3();
               break;
            case 4:
               result = uncertain.uncertain4();
               break;
            case 5:
               result = uncertain.uncertain5();
               break;
            case 6:
               result = uncertain.uncertain6();
               break;
            case 7:
               result = uncertain.uncertain7();
               break;
            case 8:
               result = uncertain.uncertain8();
               break;
            case 9:
               result = uncertain.uncertain9();
               break;
            case 10:
               result = uncertain.uncertain10();
               break;
         }
         System.out.println("result = " + result + ", i = " + uncertain.i);
      } catch (Exception e) {
         System.out.println("i = " + uncertain.i + " Exception (" + e.getClass()
               .getName() + ")");
      } finally {
      }
   }

   //main Methode
   public static void main(String args[]) {
      for (int i = 1; i <= 10; ++i) {
         uncertain(i);
      }
   }

   public int uncertain1() {
      try {
         throw new RuntimeException();
      } catch (RuntimeException e) {
         i++;
         throw new ClassCastException();
      } finally {
         i++;
         throw new NumberFormatException();
      }
    //es werden schrittweise der try Block, dann der catch und dann der finally aufgerufen
	   //finally überschreibt die vorherigen Exceptions, i ist dann 2

   }

   public int uncertain2() {
      for (; ; ) {
         try {
            break;
         } catch (RuntimeException e) {
            i++;
         } finally {
            i++;
            throw new RuntimeException();
         }
      }
    //unendlich Schleife,tritt aber durch das break sofort wieder aus
      //springt ins finally und führt dieses aus
      
      //return i++;
      //kommt nie hier rein, da außerhalb der Schleife

   }

   public int uncertain3() {
      do {
         try {
            throw new RuntimeException();
         } catch (RuntimeException e) {
            i++;
            continue;
         } finally {
            i++;
         }
      } while (false);
      return i++;
   }
 //fußgesteuerte Schleife, geht einmal durch und merkt dann, ist false
   //gibt durch return zurück

   public int uncertain4() {
      try {
         return i++;
      } catch (RuntimeException e) {
         i++;
      } finally {
         i++;
      }
      return i++;
   }
   //gibt mit dem 1. return schon das "i" zurück, sprich 0
   //danach wird hochgezählt und im finally Block nochmal. deswegen i=2

   public int uncertain5() {
      try {
         return i;
      } finally {
         throw new RuntimeException();
      }
   }
   //geht erst in try und gibt i = 0 wieder , danach im finally Block kommt die RuntimeException()

   public int uncertain6() {
      try {
         throw new RuntimeException();
      } finally {
         return ++i;
      }
   }
   //überspringt den try Block und springt sofort in den finally Block
   
   

   public int uncertain7() {
      try {
         throw new java.io.IOException();
      } catch (RuntimeException e) {
         i++;
      } finally {
         return i++;
      }
   }
 //schmeißt die java.io.IOException() zurück, jedoch wird dies vom finally Block
   //immer überschrieben, deswegen result = 0, i = 1

   public int uncertain8() {
      try {
         throw new NumberFormatException();
      } catch (RuntimeException e) {
         i++;
         throw new RuntimeException();
      } finally {
         i++;
      }
   }
    // er schmeißt die Exception im try Block
   //diese wird aufgefangen durch die >RuntimeException, da die Nu...Exception davon erbt
   //i ist durch den catch Block und dem finally Block "2"

   public int uncertain9() {
      try {
         throw new ClassCastException();
      } catch (RuntimeException e) {
         return i++;
      } finally {
         return i++;
      }
   }
   
 //durch den catch Block wird die geworfene Exception im try Teil aufgefangen
   //i wird dann eig schon zurück gegeben, da im finally block aber auch i zurück-
   //gegeben wird, wird dieser wieder überschrieben, sprich 1 übergeben anstatt 0


   public int uncertain10() {
      try {
         throw new java.io.IOException();
      } catch (RuntimeException e) {
      } finally {
      return 1;

   }
}
   //finally Block hat gefehlt
   //i = 0 , result ist durch return = 1
}
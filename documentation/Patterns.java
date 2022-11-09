package documentation;

public class Patterns {

    public static void main(String[] args) {
        int COLS = 9, ROWS=5 ;
        rectangularPattern(COLS,ROWS);
    }



    static void star(int number) {
        for (int outer = 1; outer <= number; outer++) {
            for (int inner = outer; inner <= number; inner++) {
                System.out.print(" ");
            }
            for (int runner = 1; runner <= 2 * outer - 1; runner++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int outer = number - 1; outer >= 1; outer--) {
            for (int inner = number; inner >= outer; inner--) {
                System.out.print(" ");
            }
            for (int runner = 1; runner <= 2 * outer - 1; runner++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // The outer loops iterate once for all the iteration of the inner loop.
    static void rectangularPattern(int COLS, int ROWS){
       for (int row=0; row<ROWS; row++){
           for (int col=0; col< COLS; col++){
               System.out.print("*");
           }
           System.out.println();
       }
    }

    // The outer loops iterate once for all the iteration of the inner loop which add one each time.
    static void triangleLikePattern(int BASE){
        for (int outer=0; outer<BASE; outer++){
            for (int inner=0; inner<(outer+1); inner++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void stairStepPattern(int numOfSteps){
       for (int i=0; i<numOfSteps; i++){
           for (int j=0; j<i; j++){
               System.out.print(" ");
           }
           System.out.println("J");
       }
    }


}

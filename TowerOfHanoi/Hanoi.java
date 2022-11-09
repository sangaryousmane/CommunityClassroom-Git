package TowerOfHanoi;

public class Hanoi {
    private int numOfDiscs;

    public Hanoi(int num){
        this.numOfDiscs=num;

        // Moving the disc from peg 1 to 3 using peg 2 as the temporary storage location
        hanoi(numOfDiscs, 1, 3, 2);
    }

    private void hanoi(int num, int fromPeg, int toPeg, int tempPeg){

        if (num  == 1){
            System.out.println("Move disc from peg "+fromPeg+ " to peg "+toPeg);
        }

        if (num >1){
            hanoi(num -1, fromPeg, tempPeg, toPeg);
            System.out.println("Move disc from peg "+fromPeg+ " to peg "+toPeg);
            hanoi(num-1, tempPeg, toPeg, fromPeg);
        }
    }


    public static void towerOfHanoi(int numberOfDisc, int fromPeg,
                                    int destinationPeg, int temporaryPeg) throws Exception {
        if (numberOfDisc < 0 || numberOfDisc == 0) {
            throw new Exception("There are no discs available");
        }
        if (numberOfDisc == 1) {
            System.out.println("Move disc From Peg " + fromPeg + " to Peg " + destinationPeg);
        }

        if (numberOfDisc > 1){
            towerOfHanoi(numberOfDisc-1, fromPeg, temporaryPeg, destinationPeg);
            System.out.println("Move disc from Peg "+fromPeg+ " to Peg "+destinationPeg);
            towerOfHanoi(numberOfDisc-1, temporaryPeg, destinationPeg, fromPeg);
        }
    }

    @Override
    public String toString() {
        return "Hanoi{" +
                "Total Number of discs=" + numOfDiscs +
                '}';
    }

    public static void main(String[] args) throws Exception {
        int numOfDisc=2;
       towerOfHanoi(numOfDisc, 1, 3, 2);
    }
}

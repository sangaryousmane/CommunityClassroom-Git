package exceptionhandlings;
/*
https://remote.co/
https://angel.co/
https://justremote.co/
https://www.flexjobs.com/
https://boards.greenhouse.io/protocollabs
https://wikimediafoundation.org/about/jobs/
https://careers.airbnb.com/
https://www.studysmarter.de/en/career/
https://www.toptal.com/careers#positions
https://modsquad.com/careers/
https://polygon.technology/careers/
https://polygon.technology/careers/
https://consensys.net/open-roles/
 */
import java.io.Serializable;

public class TestScores extends
        oops.challenge.TestScores implements Serializable {

    private int a;
    private int b;
    private int c;

    public TestScores(int[] array, int a, int b, int c) throws InvalidTestScore {
        super(a, b, c);

        for (int i: array){
            if (i >=100)
                throw new InvalidTestScore("Illegal argument..");
        }
    }


}

import util.Eight;
import util.Five;
import util.Four;
import util.Nine;
import util.One;
import util.Seven;
import util.Six;
import util.Three;
import util.Two;
import util.Zero;

import java.util.ArrayList;
import java.util.Scanner;

public class WordGenerator {

    public void start() {

        System.out.print("Please enter your phone number -> ");
        Scanner scanner = new Scanner(System.in);
        String inputNumber = scanner.nextLine();


        if (inputNumber.matches("[0-9]+") && inputNumber.length() > 0) {

            ArrayList<String[]> workingArray = new ArrayList<>();

            for (int i = 0; i < inputNumber.length(); i++) {

                String digit = String.valueOf(inputNumber.charAt(i));

                switch (digit) {
                    case "0":
                        workingArray.add(new Zero().getLetterArray());
                        break;
                    case "1":
                        workingArray.add(new One().getLetterArray());
                        break;
                    case "2":
                        workingArray.add(new Two().getLetterArray());
                        break;
                    case "3":
                        workingArray.add(new Three().getLetterArray());
                        break;
                    case "4":
                        workingArray.add(new Four().getLetterArray());
                        break;
                    case "5":
                        workingArray.add(new Five().getLetterArray());
                        break;
                    case "6":
                        workingArray.add(new Six().getLetterArray());
                        break;
                    case "7":
                        workingArray.add(new Seven().getLetterArray());
                        break;
                    case "8":
                        workingArray.add(new Eight().getLetterArray());
                        break;
                    case "9":
                        workingArray.add(new Nine().getLetterArray());
                        break;
                }
            }

            System.out.println("Printing the combinations");
            print(workingArray);
            System.out.println("Finish");

        } else {
            throw new InvalidInputException("The input should include numbers from 0 to 9");
        }

    }

    private void print(ArrayList<String[]> workingArray) {
        // array for indexes
        int indexArraySize = workingArray.size();
        int[] indexes = new int[indexArraySize];

        // initializing indexes
        for (int i = 0; i < indexArraySize; i++) {
            indexes[i] = 0;
        }

        while (true) {

            // printing current combinations
            for (int i = 0; i < indexArraySize; i++) {
                System.out.print(workingArray.get(i)[indexes[i]]);
            }
            System.out.println();

            // find array which has the most elements after current element
            int next = indexArraySize - 1;
            while (next >= 0 && (indexes[next] + 1 >= workingArray.get(next).length)) {
                next--;
            }

            // if there is no such an array, you've checked all the arrays
            if (next < 0) {
                return;
            }

            // if found move to next element of that array
            indexes[next]++;

            // index to first element
            for (int i = next + 1; i < indexArraySize; i++) {
                indexes[i] = 0;
            }
        }
    }
}

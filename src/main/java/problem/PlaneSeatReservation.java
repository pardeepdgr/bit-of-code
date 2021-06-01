package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  A B C   D E F G   H J K
 * |R|A|R| |A|A|A|A| |A|A|A|
 * |R|A|R| |A|A|R|A| |A|A|A|
 *
 * Book tickets for a family of 4 but they should get adjacent seats in below combinations
 *  - BCDE
 *  - DEFG
 *  - FGHJ
 */
public class PlaneSeatReservation {

    public int reserve(int totalCabinRows, String alreadyReserved) {
        int possibleSeatAllocation = 0;
        List<String> reservedSeats = new ArrayList<>(Arrays.asList(alreadyReserved.split(" ")));

        for (int currentRow = 1; currentRow <= totalCabinRows; currentRow++) {
            if (!reservedSeats.contains(currentRow + "B")
                    && !reservedSeats.contains(currentRow + "C")
                    && !reservedSeats.contains(currentRow + "D")
                    && !reservedSeats.contains(currentRow + "E")) {
                reservedSeats.addAll(Arrays.asList(
                        currentRow + "B",
                        currentRow + "C",
                        currentRow + "D",
                        currentRow + "E"));
                possibleSeatAllocation++;
            }

            if (!reservedSeats.contains(currentRow + "F")
                    && !reservedSeats.contains(currentRow + "G")
                    && !reservedSeats.contains(currentRow + "H")
                    && !reservedSeats.contains(currentRow + "J")) {
                reservedSeats.addAll(Arrays.asList(
                        currentRow + "F",
                        currentRow + "G",
                        currentRow + "H",
                        currentRow + "J"));
                possibleSeatAllocation++;
            }

            if (!reservedSeats.contains(currentRow + "D")
                    && !reservedSeats.contains(currentRow + "E")
                    && !reservedSeats.contains(currentRow + "F")
                    && !reservedSeats.contains(currentRow + "G")) {
                reservedSeats.addAll(Arrays.asList(
                        currentRow + "D",
                        currentRow + "E",
                        currentRow + "F",
                        currentRow + "G"));
                possibleSeatAllocation++;
            }
        }

        return possibleSeatAllocation;
    }

}
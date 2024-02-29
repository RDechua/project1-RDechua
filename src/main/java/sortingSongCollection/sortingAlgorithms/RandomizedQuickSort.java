package sortingSongCollection.sortingAlgorithms;

import sortingSongCollection.songs.Song;

import java.util.Arrays;
import java.util.Random;

public class RandomizedQuickSort implements SortingAlgorithm {

    private static int computePivot(Song[] songs, int low, int high){
        Random rand = new Random();
        int[] pivots = new int[3];
        if(high - low <= 1){
            return rand.nextInt(high - low + 1) + low;
        }
        for(int i = 0; i < pivots.length; i++){
            pivots[i] = rand.nextInt(high - low + 1) + low;
            while((pivots[0] == pivots[1]) || (i == 2 && (pivots[0] == pivots[2] || pivots[1] == pivots[2]))){
                pivots[i] = rand.nextInt(high - low + 1) + low;

            }
        }
        if((songs[pivots[0]].compareTo(songs[pivots[1]]) < 0 && songs[pivots[0]].compareTo(songs[pivots[2]]) > 0) ||
                (songs[pivots[0]].compareTo(songs[pivots[1]]) > 0 && songs[pivots[0]].compareTo(songs[pivots[2]]) < 0)){
            //System.out.println("0 : " + songs[pivots[0]].getTitle() + " " + songs[pivots[1]].getTitle() + " " + songs[pivots[2]].getTitle());
            //System.out.println("0 : " + pivots[0] + " " + pivots[1] + " " + pivots[2]);

            return pivots[0];
        }else if((songs[pivots[1]].compareTo(songs[pivots[0]]) < 0 && songs[pivots[1]].compareTo(songs[pivots[2]]) > 0) ||
                (songs[pivots[1]].compareTo(songs[pivots[0]]) > 0 && songs[pivots[1]].compareTo(songs[pivots[2]]) < 0)){
            //System.out.println("1 : " + songs[pivots[1]].getTitle() + " " + songs[pivots[0]].getTitle() + " " + songs[pivots[2]].getTitle());
            //System.out.println("1 : " + pivots[1] + " " + pivots[0] + " " + pivots[2]);

            return pivots[1];
        }else{
            //System.out.println("2 : " + songs[pivots[2]].getTitle() + " " + songs[pivots[0]].getTitle() + " " + songs[pivots[1]].getTitle());
            //System.out.println("2 : " + pivots[2] + " " + pivots[0] + " " + pivots[1]);

            return pivots[2];
        }
    }


    private static int partition(Song[] songs, int low, int high, boolean isAscending){
        /*
        Song pivot;
        int max = high;
        Song tmp;
        int pivotindex = computePivot(songs, low, high);

        tmp = songs[pivotindex];
        songs[pivotindex] = songs[high];
        songs[high] = tmp;

        pivot = songs[high];
        while (low <= high) {
            while ((low <= high) && (((songs[low].compareTo(pivot) < 0) && isAscending) ||
                    (songs[low].compareTo(pivot) >= 0) && !isAscending)) {
                low++;
            }
            while ((low <= high) && (((songs[high].compareTo(pivot) >= 0) && isAscending) ||
                    ((songs[high].compareTo(pivot) < 0)) && !isAscending)){
                high--;
            }
            if (low <= high) {
                tmp = songs[low];
                songs[low] = songs[high];
                songs[high] = tmp;
                low++;
                high--;
            }
        }
        tmp = songs[low];
        songs[low] = songs[max];
        songs[max] = tmp;
        return low;

         */

        Song pivot;
        Song tmp;
        int max = high;
        int pivotI = computePivot(songs, low, high);

        tmp = songs[pivotI];
        songs[pivotI] = songs[high];
        songs[high] = tmp;

        pivot = songs[high];
        while (low <= high) {
            while ((low <= high) && (
                    ((songs[low].compareTo(pivot) < 0) && isAscending) ||
                            (songs[low].compareTo(pivot) > 0) && !isAscending))
                low++;
            while ((low <= high) && (((songs[high].compareTo(pivot) >= 0) && isAscending) ||
                    (songs[high].compareTo(pivot) <= 0) && !isAscending))
                high--;
            if (low <= high) {
                tmp = songs[low];
                songs[low] = songs[high];
                songs[high] = tmp;
                low++;
                high--;
            }
        }
        tmp = songs[low];
        songs[low] = songs[max];
        songs[max] = tmp;
        //System.out.println("AFTER " + low + ": " + arr[low]);
        return low;

    }


    // FILL IN CODE: Add helper methods partition and computePivot to this class.
    // In computePivot, the pivot value should be computed as the median of values at three random indices of the subarray from low to high

    /**
     * Sort the given subarray of songs from low to high using randomized quick sort (recursive), where the pivot
     * is picked as the median of values at three random indices from low to high.
     * @param songs array of songs
     * @param low index of the first element of the subarray we need to sort
     * @param high index of the last element of the subarray we need to sort
     * @param isAscending if true, sort in increasing order, otherwise in decreasing order
     * @param sb StringBuilder that should store the string showing the array after each partition of randomized quick sort.
     *           Show only the first letter of the title of each song in the songs array,
     *           and "highlight" the pivot element that was used for the partition
     *           by showing it in lower case.
     * For instance, for input UCFWHABOVPRL and low = 0, high = 11, your result *may* look like this (assuming that we print only the first letter of the title of each song):
     * AbFWHULOVPRC
     * ABFRHCLOPuWV
     * ABCfHPLORUWV
     * ABCFHLoRPUWV
     * ABCFHlORPUWV
     * ABCFHLOpRUWV
     * ABCFHLOPRUVw
     *
     * Note that your result will likely be different from what is shown here, since the randomized quicksort algorithm chooses 3 indices randomly before deciding on the "median" pivot.
     * The first line shows the result after partitioning the array by b;
     * the second line shows the result after partitioning the right subarray by u
     * (since the left subarray has only one element which is the base case), and so on.
     */
    @Override
    public void sort(Song[] songs, int low, int high, boolean isAscending, StringBuilder sb) {
        int pivot;
        if(low < high){
            pivot = partition(songs, low, high, isAscending);
            /*
            for(int i = 0; i < songs.length; i++){
                if(i == low || i == high){
                    System.out.print(" || ");
                }
                if(i == pivotindex){
                    System.out.print("  " + songs[i].getTitle() + "  ");
                }else {
                    System.out.print(songs[i].getTitle());
                }
            }
            System.out.println("");
            System.out.println("Used pivot " + songs[pivotindex].getTitle());
            */
            for(int i = 0; i < songs.length; i++){
                System.out.print(songs[i].getTitle());
            }
            System.out.println("");
            sort(songs, low, pivot - 1, isAscending, sb);
            sort(songs, pivot + 1, high, isAscending, sb);
        }
        // FILL IN CODE

    }

}

package sortingSongCollection.sortingAlgorithms;

import sortingSongCollection.songs.Song;

import java.util.Random;

public class RandomizedQuickSort implements SortingAlgorithm {

    //Generates the random index within the low and high range, and finds the median of the characters of the indexes
    private static int computePivot(Song[] songs, int low, int high){
        Random rand = new Random();
        int[] pivots = new int[3];

        if(high - low <= 1){ //If there's less than 2 songs within low and high, randomizes between the two (or one)
            return rand.nextInt(high - low + 1) + low;
        }
        for(int i = 0; i < pivots.length; i++){ //Generates the random index and placed in an array
            pivots[i] = rand.nextInt(high - low + 1) + low;
            while((pivots[0] == pivots[1]) || (i == 2 && (pivots[0] == pivots[2] || pivots[1] == pivots[2]))){ //If any of the index are the same, regenerate random
                pivots[i] = rand.nextInt(high - low + 1) + low;
            }
        }

        //Returns the median of the characters of the 3 index previously generated.
        if((songs[pivots[0]].compareTo(songs[pivots[1]]) < 0 && songs[pivots[0]].compareTo(songs[pivots[2]]) > 0) ||
                (songs[pivots[0]].compareTo(songs[pivots[1]]) > 0 && songs[pivots[0]].compareTo(songs[pivots[2]]) < 0)){
            return pivots[0];
        }else if((songs[pivots[1]].compareTo(songs[pivots[0]]) < 0 && songs[pivots[1]].compareTo(songs[pivots[2]]) > 0) ||
                (songs[pivots[1]].compareTo(songs[pivots[0]]) > 0 && songs[pivots[1]].compareTo(songs[pivots[2]]) < 0)){
            return pivots[1];
        }else{
            return pivots[2];
        }
    }

    //Parts songs to left or right depending on its value in comparison to the pivot value
    private static int partition(Song[] songs, int low, int high, boolean isAscending){
        Song pivot;
        Song tmp;
        int MAX = high;
        int pivotI = computePivot(songs, low, high);

        //Stores the pivot in the last index (high) by swapping
        tmp = songs[pivotI];
        songs[pivotI] = songs[high];
        songs[high] = tmp;
        pivot = songs[high];

        while(low <= high){
            while((low <= high) && (((songs[low].compareTo(pivot) < 0) && isAscending) ||
                            (songs[low].compareTo(pivot) > 0) && !isAscending))
                low++;
            while((low <= high) && (((songs[high].compareTo(pivot) >= 0) && isAscending) ||
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

        //Places the pivot in correct index by swapping
        tmp = songs[low];
        songs[low] = songs[MAX];
        songs[MAX] = tmp;

        return low;
    }

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
            pivot = partition(songs, low, high, isAscending); //Finds and sorts the songs

            //Appends to string builder after every partition
            for(int i = 0; i < songs.length; i++){
                if(i == pivot){
                    sb.append(Character.toLowerCase(songs[i].getTitle().charAt(0))); //Prints the pivot character in lowercase
                }else{
                    sb.append(songs[i].getTitle().charAt(0));
                }
            }
            sb.append("\n");

            //Recursive steps by iterating low and high
            sort(songs, low, pivot - 1, isAscending, sb);
            sort(songs, pivot + 1, high, isAscending, sb);
        }
    }

}

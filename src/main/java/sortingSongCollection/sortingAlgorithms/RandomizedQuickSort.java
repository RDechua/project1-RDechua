package sortingSongCollection.sortingAlgorithms;

import sortingSongCollection.songs.Song;

public class RandomizedQuickSort implements SortingAlgorithm {

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
        // FILL IN CODE

    }

}

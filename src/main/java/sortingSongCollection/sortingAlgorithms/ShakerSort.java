package sortingSongCollection.sortingAlgorithms;

import sortingSongCollection.songs.Song;

public class ShakerSort implements SortingAlgorithm {

    /**
     * Sorts the subarray of the given array (from low to high)
     *  using the shaker sort (see pdf for description)
     * @param songs array of songs
     * @param low the beginning index of a subarray
     * @param high the end index of a subarray
     * @param isAscending if true, sort in ascending order, otherwise in descending
     * @param sb StringBuilder that contains a string that shows the array of songs after each pass of shaker sort.
     * Show only the first letter of each song's title. Show each pass of the shaker sort on a new line.
     * Assume that we print only the first letter of the title of each song, and that we do not print spaces while printing the array of songs.
     * Then for the input array UCFWHABOVPRL, if we sort the array from low = 0 to high = 11 in ascending order, we should see the following intermediate results:
     * ACFUHBLOVPRW
     * ABCFHLOPURVW
     * ABCFHLOPRUVW
     * ABCFHLOPRUVW
     * ABCFHLOPRUVW
     * ABCFHLOPRUVW
     *
     * The first line shows the array after we bubbled up "A" to the front
     * and bubbled down "W" to the end of the list.
     * The second line shows the array after we bubbled up "B" to the front and "V" to the end, and so on.
     *
     */
    //@Override
    public void sort(Song[] songs, int low, int high, boolean isAscending, StringBuilder sb) {
        while(low < high){
            for (int i = high; i > low; i--) {
                if ((songs[i].compareTo(songs[i - 1]) < 0 && isAscending) ||
                        (songs[i].compareTo(songs[i - 1]) > 0 && !isAscending)) { //Bubbles the selected song to the front
                    Song tmp = songs[i];
                    songs[i] = songs[i - 1];
                    songs[i - 1] = tmp;
                }
            }
            low++;
            for (int i = low; i < high; i++) {
                if ((songs[i].compareTo(songs[i + 1]) > 0 && isAscending) ||
                (songs[i].compareTo(songs[i + 1]) < 0 && !isAscending)) { //Bubbles the selected song to the end
                    Song tmp = songs[i];
                    songs[i] = songs[i+1];
                    songs[i + 1] = tmp;
                }
            }
            high--;

            //Appends to string builder after every 2 pass (to the front and end)
            for(int i = 0; i < songs.length; i++){
                sb.append(songs[i].getTitle().charAt(0));
            }
            sb.append("\n");
        }


    }
}

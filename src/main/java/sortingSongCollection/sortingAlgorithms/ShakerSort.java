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
        // FILL IN CODE
        /*if(low+1 < high){
            for(int i = 0; i < songs.length; i++){
                System.out.print(songs[i].getTitle());
            }
            System.out.println("");

            Song min = songs[low];
            Song max = songs[low];
            int minindex = 0;
            int maxindex = 0;
            for(int i = low; i <= high; i++){
                if(songs[i].compareTo(min) < 0){
                    min = songs[i];
                    minindex = i;
                }else if(songs[i].compareTo(max) > 0){
                    max = songs[i];
                    maxindex = i;
                }
            }
            for(int i = 0; i < low; i++){
                System.out.print(" ");
            }
            System.out.println("^ low " + low);
            for(int i = 0; i < high; i++){
                System.out.print(" ");
            }
            System.out.println("^ high " + high);


            System.out.println(min.getTitle() + " " + minindex);
            System.out.println(max.getTitle() + " " + maxindex);

            if(isAscending) {
                for (int j = minindex; j > low; j--) {
                    songs[j] = songs[j - 1];
                }
                songs[low] = min;
                for (int k = maxindex; k < high; k++) {
                    songs[k] = songs[k + 1];
                }
                songs[high] = max;
            }else{
                for (int j = maxindex; j > low; j--) {
                    songs[j] = songs[j - 1];
                }
                songs[low] = max;
                for (int k = minindex; k < high; k++) {
                    songs[k] = songs[k + 1];
                }
                songs[high] = min;
            }
            for(int i = 0; i < songs.length; i++){
                System.out.print(songs[i].getTitle());
            }
            System.out.println("");
            System.out.println("END");

            sort(songs, low+1, high-1, isAscending, sb);
        }

         */
        boolean check = true;
        while(check){

            for(int i = low; i < high; i++){
                System.out.print(songs[i].getTitle());
            }
            System.out.println(" START");

            check = false;
            for (int i = high; i > low; i--) {
                if ((songs[i].compareTo(songs[i-1]) < 0 && isAscending) ||
                        (songs[i].compareTo(songs[i-1]) > 0 && !isAscending)) {
                    Song tmp = songs[i];
                    songs[i] = songs[i-1];
                    songs[i-1] = tmp;
                    check = true;
                }
            }

            for(int i = low; i < high; i++){
                System.out.print(songs[i].getTitle());
            }
            System.out.println(" Small");


            low++;
            if(!check){
                break;
            }
            check = false;

            for (int i = low; i < high; i++) {
                if ((songs[i].compareTo(songs[i+1]) > 0 && isAscending) ||
                (songs[i].compareTo(songs[i+1]) < 0 && !isAscending)) {
                    Song tmp = songs[i];
                    songs[i] = songs[i+1];
                    songs[i+1] = tmp;
                    check = true;
                }
            }
            for(int i = low; i < high; i++){
                System.out.print(songs[i].getTitle());
            }
            System.out.println(" Big");
            high--;


            /*
            System.out.println("");
            for(int i = 0; i < low; i++){
                System.out.print(" ");
            }
            System.out.println("^ low " + low);
            for(int i = 0; i < high; i++){
                System.out.print(" ");
            }
            System.out.println("^ high " + high);
            */
        }


    }
}

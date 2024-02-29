package sortingSongCollection.sortingAlgorithms;

import sortingSongCollection.songs.Song;

public class InsertionSort implements SortingAlgorithm {

    /**
     * Sorts a subarray of songs from index low to index high (inclusive).
     * using insertion sort. The rest of the array should not change.
     *
     * @param songs       array of songs
     * @param low         index of the first element of the subarray we need to sort
     * @param high        index of the last element of the subarray we need to sort
     * @param isAscending if true, sort in ascending order, otherwise in descending
     * @param sb StringBuilder. After the function executes, it should contain a string that shows the array of songs after each pass of insertion sort.
     * Show only the first letter of each song's title. Show each pass on a new line.
     * For instance, if low = 0, high = n - 1, and isAscending = true,
     * then for the following array of songs UCFWHABOVPRL (where the title of the first song starts with "U", the title of the second one starts with "C" and so on), we should get the following intermediate results showing each pass of the insertion sort:
    CUFWHABOVPRL
    CFUWHABOVPRL
    CFUWHABOVPRL
    CFHUWABOVPRL
    ACFHUWBOVPRL
    ABCFHUWOVPRL
    ABCFHOUWVPRL
    ABCFHOUVWPRL
    ABCFHOPUVWRL
    ABCFHOPRUVWL
    ABCFHLOPRUVW
     */
    @Override
    public void sort(Song[] songs, int low, int high, boolean isAscending, StringBuilder sb) {
        int mark = low;
        int a = low;
        int b = high;
        /*
        while(low < high){
            while(songs[low].getTitle().charAt(0) > songs[low+1].getTitle().charAt(0)){
                Song tmp = songs[low+1];
                songs[low+1] = songs[low];
                while(low-1 >= a  && tmp.getTitle().charAt(0) < songs[low-1].getTitle().charAt(0)){
                    songs[low] = songs[low-1];
                    low--;
                }
                songs[low] = tmp;
            }
            low++;
        }

        while (low < high) {
                if (songs[low].getTitle().charAt(0) > songs[low + 1].getTitle().charAt(0)) {
                    Song tmp = songs[low + 1];
                    songs[low + 1] = songs[low];
                    a = low;
                    while ((a - 1 >= mark) && (tmp.getTitle().charAt(0) < songs[a - 1].getTitle().charAt(0))) {
                        songs[a] = songs[a - 1];
                        a--;
                    }
                    songs[a] = tmp;
                    low = a;
                }
                low++;
                for (int i = mark; i < b; i++) {
                    System.out.print(songs[i].getTitle());
                }
                System.out.println("");
            }

        */


        while (low < high) {
            if ((songs[low].compareTo(songs[low + 1]) > 0 && isAscending) ||
                    (songs[low].compareTo(songs[low + 1]) < 0 && !isAscending)) {
                Song tmp = songs[low + 1];
                songs[low + 1] = songs[low];
                a = low;
                while ((a - 1 >= mark) && ((tmp.compareTo(songs[a - 1]) < 0 && isAscending) ||
                        (tmp.getTitle().charAt(0) > songs[a - 1].getTitle().charAt(0) && !isAscending))) {
                    songs[a] = songs[a - 1];
                    a--;
                }
                songs[a] = tmp;
                low = a;
            }
            low++;
            for (int i = 0; i < songs.length; i++) {
                System.out.print(songs[i].getTitle());
            }
            System.out.println("");
        }
        System.out.println("END 1");



        // FILL IN CODE


    }

}

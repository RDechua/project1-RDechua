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
        if(songs.length == 1){
            sb.append(songs[0].getTitle().charAt(0));
        }else if(songs.length == 0){
            System.out.println("Empty song list");
        }else{
            int MARK = low; //Fixed constant to ensure that values outside the range low and high does not get modified
            int a;
            low++; //Starts in the index after low

            while(low <= high){
                Song tmp = songs[low];
                a = low; //Change variable to decrement
                while((a - 1 >= MARK) && ((tmp.compareTo(songs[a - 1]) < 0 && isAscending) ||
                        (tmp.compareTo(songs[a - 1]) > 0 && !isAscending))){
                    songs[a] = songs[a - 1];
                    a--;
                }
                songs[a] = tmp;
                low++;

                //Appends to string builder after every pass
                for(int i = 0; i < songs.length; i++){
                    sb.append(songs[i].getTitle().charAt(0));
                }
                sb.append("\n");
            }
        }
    }
}

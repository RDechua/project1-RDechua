package sortingABC;

import org.w3c.dom.ls.LSOutput;

public class ABCPartition {

    /**
     * Suppose some city has n people, and these people need to vote to select a mayor of the city. There are three candidates for a mayor: "A",  "B" and "C".
     * We are given an array of n Strings where each element represents a vote for either candidate "A" or candidate "B", or candidate "C". For the purpose of this problem, let's assume there is a clear winner (so one candidate has more votes than the other two),
     * and each candidate has at least one vote for them.
     * Design and implement (in Java) an in-place algorithm for (1) sorting this array and (2) determining who wins the election, "A", "B" or "C".
     *  The algorithm must satisfy the following requirements:
     - Use the variation of the partition method of quicksort)
     - Should run in linear time
     - Use no extra memory (except for three integer indices and a tmp variable for swapping).
     - Run in two passes
     * Important: Do NOT just iterate over the array and count the number of "A"s, "B"s and "C"s  - such solutions will get 0 points.
     * Do NOT use counting sort.
     * Example: if we are given the following array that represents votes of 11 people:
     *      *             ["A", "B", "A", "C", "A", "A", "A", "B", "C", "A", "B"],
     *      *     your method should return "A" and change the array so that it is sorted while satisfying other requirements listed above:
     *      *             ["A", "A", "A", "A", "A", "A", "B", "B", "B",  "C", "C"]
     *
     * @param votes input array of votes
     * @return winner
     */
    public String sortAndFindWinner (String[] votes) {
        if(votes == null){
            return null;
        }

        int i = 0;
        int j = votes.length - 1;
        int abc = 65; //ASCII value to iterate through ABC
        String tmp;
        int[] freq = new int[3]; //frequency of A, B, and C

        while(abc < 67){
            while(i <= j && i < votes.length) {
                if (votes[i].equals(String.valueOf((char)abc))) {
                    i++;
                } else if (!votes[i].equals(String.valueOf((char)abc)) && !votes[j].equals(String.valueOf((char)abc))){
                    j--;
                } else if (votes[j].equals(String.valueOf((char)abc))){ //if votes[i] is not x and votes[j] is x, swap
                    tmp = votes[i];
                    votes[i] = votes[j];
                    votes[j] = tmp;
                    i++;
                    j--;
                }
            }
            j = votes.length-1;
            if(abc-65 == 0){ //Counts the frequency of A
                freq[0] = i;
            }else{ //Counts the frequency of B and C
                freq[1] = i - freq[0];
                freq[2] = votes.length - (freq[0] + freq[1]) ;
            }
            abc++;
        }

        //Decides the winner based on the frequency previously recorded
        if(freq[0] >= freq[1] && freq[0] >= freq[2]){
            return("A");
        }else if (freq[1] >= freq[0] && freq[1] >= freq[2]){
            return("B");
        }else{
            return("C");
        }
    }
}

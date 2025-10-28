class Solution {
    public List<Integer> findDisappearedNumbers(int[] seats) {
        List<Integer> emptySeats = new ArrayList<>();
        
        // Step 1: Mark occupied seats with magic invisible ink
        for(int ticket : seats){
            seats[Math.abs(ticket)-1] = -Math.abs(seats[Math.abs(ticket)-1]);
        }
        
        // Step 2: Find seats that weren't marked
        for(int i = 0; i < seats.length; i++){
            if(seats[i] > 0) {
                emptySeats.add(i + 1);
            }
        }
        return emptySeats;
    }
}
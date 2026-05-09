class leetcontestQ1 {
    public int[] scoreValidator(String[] events) {
        int score = 0;
        int counter = 0;
        for (String event : events) {

            if (counter == 10) {
                break;
            }

            if (event.equals("W")) {
                counter++;
            } 
            else if (event.equals("WD") || event.equals("NB")) {
                score += 1;
            } 
            else {
                score += Integer.parseInt(event);
            }
        }

        return new int[]{score, counter};
    }
}
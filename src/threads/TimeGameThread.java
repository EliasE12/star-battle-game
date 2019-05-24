package threads;

import model.Match;

public class TimeGameThread extends Thread {

    private Match match;

    public TimeGameThread(Match match) {
        this.match = match;
    }

    @Override
    public void run() {

    }
}

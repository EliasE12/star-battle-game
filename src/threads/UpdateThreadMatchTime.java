package threads;

import javafx.application.Platform;
import model.Match;

public class UpdateThreadMatchTime extends Thread {

    private static final int SLEEP_TIME = 1000;

    private Match match;

    public UpdateThreadMatchTime(Match match) {
        this.match = match;
    }

    @Override
    public void run() {
        while(true){
            TimeGameThread timeGameThread = new TimeGameThread(match);
            Platform.runLater(timeGameThread);

            try {
                sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

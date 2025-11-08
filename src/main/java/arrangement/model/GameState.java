package arrangement.model;

public class GameState {
    private boolean isRunning = true;

    public boolean getState() {
        return isRunning;
    }

    public void off() {
        isRunning = false;
    }
}

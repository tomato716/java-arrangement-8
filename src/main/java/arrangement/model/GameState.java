package arrangement.model;

public class GameState {
    private boolean isRunning;

    public GameState() {
        on();
    }

    private void on() {
        isRunning = true;
    }

    public boolean getState() {
        return isRunning;
    }

    public void off() {
        isRunning = false;
    }
}

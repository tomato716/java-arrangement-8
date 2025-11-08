package arrangement.controller.option;

import arrangement.model.Shutdown;

public class ShutdownOption implements Option {
    private final Shutdown shutdown;

    public ShutdownOption(Shutdown shutdown) {
        this.shutdown = shutdown;
    }

    @Override
    public void play() {
        shutdown.off();
    }
}

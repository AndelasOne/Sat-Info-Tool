package outputs;

import dhbw.swe.AbstractNode;
import dhbw.swe.IOutput;
import javafx.application.Application;

/**
 * Singleton pattern
 */
public class GUIOutput implements IOutput {
    private boolean running = false;

    /**
     * App should only run once
     * @param input Filtered data as composite
     */
    @Override
    public void output(AbstractNode<String> input) {
        if (!running) {
            App.setData(input);
            Application.launch(App.class);
            running = true;
        }
    }
}

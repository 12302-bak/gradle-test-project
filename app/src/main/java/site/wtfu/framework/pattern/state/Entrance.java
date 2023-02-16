package site.wtfu.framework.pattern.state;

import site.wtfu.framework.pattern.state.impl.StopState;
import site.wtfu.framework.pattern.state.impl.StartState;

public class Entrance {

    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }
}

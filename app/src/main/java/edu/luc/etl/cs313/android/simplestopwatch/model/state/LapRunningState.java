package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

class LapRunningState implements StopwatchState {

    public LapRunningState(final StopwatchSMStateView sm) {
        this.sm = sm;
    }

    private final StopwatchSMStateView sm;

    @Override
    public void onStartStop() {
        sm.actionInc();
        sm.toLapRunningState();
    }

    @Override
    public void onTick() {
        int d = sm.getDelay();
        sm.setDelay(++d);
        if (d == 3 || sm.reachMax()) {
            sm.actionNotifBeep();
            sm.toRunningState();
        }
    }

    @Override
    public void updateView() {
        sm.updateUIRuntime();
    }

    @Override
    public int getId() {
        return R.string.LAP_RUNNING;
    }
}

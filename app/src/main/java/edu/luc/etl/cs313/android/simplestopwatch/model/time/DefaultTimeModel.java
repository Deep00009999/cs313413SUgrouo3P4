package edu.luc.etl.cs313.android.simplestopwatch.model.time;

import static edu.luc.etl.cs313.android.simplestopwatch.common.Constants.*;

/**
 * An implementation of the stopwatch data model.
 */
public class DefaultTimeModel implements TimeModel {

    private int runningTime = 0;

    private int lapTime = -1;

    protected final int low = 0;

    protected final int high = 99;


    @Override
    public void resetRuntime() {
        runningTime = 0;
    }

    @Override
    public void incRuntime() {
        runningTime = (runningTime + SEC_PER_TICK) % SEC_PER_HOUR;
    }

    @Override
	public void decRuntime() {
		if (!isEmpty()){
            runningTime -= 1 ;
        }
	}

    @Override
    public int getRuntime() {
        return runningTime;
    }

    @Override
    public void setLaptime() {
        lapTime = runningTime;
    }

    @Override
    public int getLaptime() {
        return lapTime;
    }

    @Override
    public boolean isFull() {
        return runningTime >= high;
    }

    @Override
    public boolean isEmpty() {
        return runningTime <= low;
    }

}
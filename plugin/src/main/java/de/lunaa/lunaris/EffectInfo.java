package de.lunaa.lunaris;

public class EffectInfo {

    private long duration;
    private int level;
    private int taskId;

    EffectInfo(long duration, int level, int taskId) {
        this.duration = duration;
        this.level = level;
        this.taskId = taskId;
    }


    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}

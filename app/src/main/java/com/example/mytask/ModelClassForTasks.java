package com.example.mytask;

public class ModelClassForTasks {

    private String tasks;
    private Boolean checked_or_not;

    public ModelClassForTasks(String tasks, Boolean checked_or_not) {
        this.tasks = tasks;
        this.checked_or_not = checked_or_not;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    public Boolean getChecked_or_not() {
        return checked_or_not;
    }

    public void setChecked_or_not(Boolean checked_or_not) {
        this.checked_or_not = checked_or_not;
    }
}

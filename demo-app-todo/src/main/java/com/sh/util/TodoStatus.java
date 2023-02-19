package com.sh.util;

public enum TodoStatus {

    COMPLETED(1), INCOMPLETED(2);

    private final Integer value;

    TodoStatus(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}

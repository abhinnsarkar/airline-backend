package com.sarkar.airlinebackend.Responses;

public enum ReturnCode {
    SUCCESS(0),
    WARNING(1),
    ERROR(2);

    private final int code;

    ReturnCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

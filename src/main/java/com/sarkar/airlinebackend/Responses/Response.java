package com.sarkar.airlinebackend.Responses;

import com.sarkar.airlinebackend.Responses.ReturnCode;
import java.util.ArrayList;
import java.util.List;

public class Response<T> {
    private T data;
    private List<String> messages;
    private ReturnCode returnCode;


    public Response() {
        this.messages = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void addMessage(String message) {
        this.messages.add(message);
    }

    public ReturnCode getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(ReturnCode returnCode) {
        this.returnCode = returnCode;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
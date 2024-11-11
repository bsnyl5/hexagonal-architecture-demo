package vn.softwaredesign.architecture.hexagonalarc.domain.model;

import java.util.ArrayList;
import java.util.List;

public class AccountValidationNotificationHandler implements ValidationNotificationHandler {
    List<String> messages = new ArrayList<>();

    @Override
    public void handleError(String message) {
        this.messages.add(message);
    }

    public List<String> messages() {
        return messages;
    }

    public String concatenatedMessage() {
        return String.join("\n", messages);
    }
}

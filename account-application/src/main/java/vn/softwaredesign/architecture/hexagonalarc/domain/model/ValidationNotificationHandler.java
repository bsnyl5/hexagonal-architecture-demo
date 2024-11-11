package vn.softwaredesign.architecture.hexagonalarc.domain.model;

public interface ValidationNotificationHandler {
    void handleError(String message);
}

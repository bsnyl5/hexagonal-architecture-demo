package vn.softwaredesign.architecture.hexagonalarc.domain.model;

public abstract class Validator {
    protected ValidationNotificationHandler validationNotificationHandler;

    public Validator(ValidationNotificationHandler validationNotificationHandler) {
        this.validationNotificationHandler = validationNotificationHandler;
    }

    public abstract void validate();

    protected ValidationNotificationHandler validationNotificationHandler() {
        return validationNotificationHandler;
    }
}

package vn.softwaredesign.architecture.hexagonalarc.application.ports.inbound;

import vn.softwaredesign.architecture.hexagonalarc.domain.model.InvalidCredentialsException;

public interface AccountLogin {
    LoginOutput login(LoginInput loginInput) throws InvalidCredentialsException;
}

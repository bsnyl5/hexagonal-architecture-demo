package vn.softwaredesign.architecture.layeredarc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.softwaredesign.architecture.layeredarc.service.AccountDto;
import vn.softwaredesign.architecture.layeredarc.service.AccountService;

@SpringBootTest
class LayeredArcApplicationTests {
    @Autowired
    private AccountService accountService;

    @Test
    public void givenTheUserEmailAlreadyExistsAnExceptionIsThrown() throws Exception {
        var userDto = new AccountDto("Name", "password", "test@davivieira.dev");
        accountService.createAccount(userDto);

        Assertions.assertThrows(
                Exception.class,
                () -> accountService.createAccount(userDto)
        );
    }
}

package cryss.dev.estrutura_de_dados_java.patterns.revisiting.chainofreponsability.service;

import cryss.dev.estrutura_de_dados_java.patterns.revisiting.chainofreponsability.domain.UserProfile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class NotifierServiceTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream ();

    @InjectMocks
    private NotifierService service;

    @BeforeEach
    public void setUp() {
        System.setOut (new PrintStream (outputStreamCaptor));
    }

    /*
     * output stream is a shared static resource   we should take care of restoring it to its original state when our test terminates:
    */
    @AfterEach
    public void tearDown() {
        System.setOut (standardOut);
    }

    @Test
    void sendNotificationByEmail() {
        UserProfile userEmail = UserProfile
                .builder ()
                .allowsEmail (true)
                .build ();

        service.sendNotification (userEmail);

        Assertions.assertEquals ("Email notification sent.", outputStreamCaptor.toString ()
                .trim ());
    }

    @Test
    void sendNotificationBySMS() {

        UserProfile userSMS = UserProfile
                .builder ()
                .allowsSMS (true)
                .build ();

        service.sendNotification (userSMS);

        Assertions.assertEquals ("SMS notification sent.", outputStreamCaptor.toString ()
                .trim ());

    }


}
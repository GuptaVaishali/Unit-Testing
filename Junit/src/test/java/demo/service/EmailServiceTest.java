package test.java.demo.service;

import main.java.demo.service.EmailService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class EmailServiceTest {
    @Test
    public void testSingleton() {
        EmailService instance1 = EmailService.getInstance();
        EmailService instance2 = EmailService.getInstance();
        System.out.println("checking singleton objects equality");
        boolean actualValue = (instance1 == instance2);
        assertEquals(true, actualValue);
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceeds(){
        demo.domain.Order order = new demo.domain.Order();
        Executable executable = () -> EmailService.getInstance().sendEmail(order);

        Exception exception = assertThrows(RuntimeException.class, executable);
    }

    @Test
    void isEmailSent(){
        String emailStatus = "Email sent successfully";
        demo.domain.Order order = new demo.domain.Order();
        assertTrue(EmailService.getInstance().sendEmail((demo.domain.Order) order,emailStatus));
    }
}

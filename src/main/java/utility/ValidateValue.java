package utility;

import sun.jvm.hotspot.debugger.AddressException;

import javax.mail.internet.InternetAddress;

public class Validate {

   //I took it from here:
  //https://stackoverflow.com/questions/624581/what-is-the-best-java-email-address-validation-method

    public static boolean isValidEmailAddress(String email) throws javax.mail.internet.AddressException {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}

package testing;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class PasswordEncoderTest {

	public static void main(String[] args) {
		String rawPassword = "phatnguyen123";
		PasswordEncoder encoder = new BCryptPasswordEncoder(12);
		/*for(int i = 0; i < 10; i++) {
			System.out.println(encoder.encode(rawPassword));
		}*/
		//System.out.println("$2a$12$DXQEXIRGrmcAlIn2QYLVm.nw606P7TyQ.e2.6tx8n90lV6EAQXLBO".length());
		System.out.println(encoder.encode(rawPassword));
	}
}

package co.ceiba.parking.dominio;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import co.ceiba.parking.testdatabuilder.UserTestDataBuilder;

public class UserTest {

	private static final String NAME = "Carlos";
	private static final String LASTNAME = "Diaz";
	private static final String DOCUMENT = "11022201522";
	private static final String USER = "cardia01";

	@Test
	public void createUserTest() {
		// Arrange
		UserTestDataBuilder userTestDataBuilder =  new UserTestDataBuilder()
				.conName(NAME)
				.conLastName(LASTNAME)
				.conDocument(DOCUMENT)
				.conUser(USER);
		
		// Act
		User user = userTestDataBuilder.build();
		
		// Assert
		assertEquals(NAME, user.getName());
		assertEquals(LASTNAME, user.getLastName());
		assertEquals(DOCUMENT, user.getDocument());
		assertEquals(USER, user.getUser());
	}

}

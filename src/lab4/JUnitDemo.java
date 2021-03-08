package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnitDemo {
	static private Directory directory = new Directory();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		String s = directory.addOrChangeEntry("Jonathan", "123-432-4325");
		s = directory.addOrChangeEntry("Billiam", "679-143-1432");
		s = directory.addOrChangeEntry("Caleb", "586-345-2453");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddOrChangeEntry() {
		assertNull(directory.addOrChangeEntry("Daniel", "342-435-7534")); // Checking Add
		assertEquals(directory.addOrChangeEntry("Jonathan",  "543-435-5434"), "123-432-4325"); // Checking Change
	}

	@Test
	void testRemoveEntry() {
		assertNull(directory.removeEntry("Jamison")); // Test nonexistent entry
		DirectoryEntry personToBeRemoved = directory.removeEntry("Daniel");
		assertEquals(personToBeRemoved.getName(), "Daniel"); // Test removing directoryEntry
		assertEquals(personToBeRemoved.getNumber(), "342-435-7534");
	}

}

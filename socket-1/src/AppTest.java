import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;;

public class AppTest {
    @Test
    public void testAdd() {
        App app = new App();
        assertEquals(3, app.add(1, 2));
    }

}

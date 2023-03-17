package actions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionsTest {


    class TestActionTest implements Actions {

        @Override
        public String getNameOfAction() {
            return "name";
        }

        @Override
        public double getPercents() {
            return 10;
        }

        @Override
        public int getCountOfProduct() {
            return 3;
        }


    }


    @Test
    void testGetNameOfAction() {
        Actions action = new TestActionTest();
assertEquals("name",action.getNameOfAction());

    }

    @Test
    void getPercents() {
        Actions action = new TestActionTest();
        assertEquals(10,action.getPercents());
    }

    @Test
    void getCountOfProduct() {
        Actions action = new TestActionTest();
        assertEquals(3,action.getCountOfProduct());
    }
}
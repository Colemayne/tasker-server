package com.coleman.tasker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestableControllerTest {

    @Test
    public void helloWorld() {
        int id = 1;
        assertEquals(1, id);
    }
}

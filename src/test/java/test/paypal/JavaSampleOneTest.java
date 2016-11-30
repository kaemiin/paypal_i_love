package test.paypal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Ignore;

import static org.junit.Assert.assertTrue;


@RunWith(JUnit4.class)
public class JavaSampleOneTest {
    
    @Test
    @Ignore
    public void testGetUserConsent() {

        JavaSampleOne test = new JavaSampleOne();

        test.getUserConsent();

    }           
    
}

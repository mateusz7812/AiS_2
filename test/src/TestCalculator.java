import org.junit.Assert;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TestCalculator {
    @org.junit.Test
    public void testAdding() throws Exception {
        var data = new ArrayList<String>(){{
            add("{");
            add("2");
            add("2");
            add("+");
            add("}");
        }};
        var calculator = new Calculator(data);
        float calc = calculator.Calc();
        Assert.assertEquals(4, calc, 1);
    }

    @org.junit.Test
    public void testExpandedAdding() throws Exception {
        var data = new ArrayList<String>(){{
            add("{");
                add("{");
                    add("{");
                    add("2");
                    add("2");
                    add("+");
                    add("}");
                add("2");
                add("+");
                add("}");
            add("2");
            add("+");
            add("}");
        }};
        var calculator = new Calculator(data);
        float calc = calculator.Calc();
        Assert.assertEquals(8, calc, 1);
    }

    @org.junit.Test
    public void testMultiplication() throws Exception {
        var data = new ArrayList<String>(){{
            add("{");
                add("{");
                    add("{");
                    add("2");
                    add("2");
                    add("*");
                    add("}");
                add("2");
                add("*");
                add("}");
            add("2");
            add("*");
            add("}");
        }};
        var calculator = new Calculator(data);
        float calc = calculator.Calc();
        Assert.assertEquals(16, calc, 1);
    }

    @org.junit.Test
    public void testDividing() throws Exception {
        var data = new ArrayList<String>(){{
            add("{");
                add("{");
                    add("{");
                    add("2.2");
                    add("2.2");
                    add("/");
                    add("}");
                add("2");
                add("/");
                add("}");
            add("2");
            add("/");
            add("}");
        }};
        var calculator = new Calculator(data);
        float calc = calculator.Calc();
        Assert.assertEquals(1.0/4, calc, 0.01);
    }

    @org.junit.Test
    public void testSubtracting() throws Exception {
        var data = new ArrayList<String>(){{
            add("{");
                add("{");
                    add("{");
                    add("2.2");
                    add("2.2");
                    add("-");
                    add("}");
                add("2");
                add("-");
                add("}");
            add("2");
            add("-");
            add("}");
        }};
        var calculator = new Calculator(data);
        float calc = calculator.Calc();
        Assert.assertEquals(-4, calc, 1);
    }

    @org.junit.Test
    public void testFinal() throws Exception {
        var data = new ArrayList<String>(){{
            add("{");
                add("{");
                    add("{");
                    add("2.2");
                    add("2.5");
                    add("*");
                    add("}");
                    add("{");
                    add("5.2");
                    add("4");
                    add("*");
                    add("}");
                add("+");
                add("}");
                add("{");
                    add("{");
                    add("2.2");
                    add("2.9");
                    add("-");
                    add("}");
                add("2");
                add("/");
                add("}");
            add("+");
            add("}");
        }};
        var calculator = new Calculator(data);
        float calc = calculator.Calc();
        Assert.assertEquals(25.85, calc, 1);
    }
}

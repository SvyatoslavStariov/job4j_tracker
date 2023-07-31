package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(2);
    }

    @Test
    public void whenManyValidInput() {
        Output out = new StubOutput();
        Input in1 = new StubInput(
                new String[]{"1"}
        );
        Input in2 = new StubInput(
                new String[]{"2"}
        );
        Input in3 = new StubInput(
                new String[]{"3"}
        );
        ValidateInput input1 = new ValidateInput(out, in1);
        ValidateInput input2 = new ValidateInput(out, in2);
        ValidateInput input3 = new ValidateInput(out, in3);
        int selected1 = input1.askInt("Enter menu:");
        int selected2 = input2.askInt("Enter menu:");
        int selected3 = input3.askInt("Enter menu:");
        assertThat(selected1).isEqualTo(1);
        assertThat(selected2).isEqualTo(2);
        assertThat(selected3).isEqualTo(3);
    }

    @Test
    public void whenMinus1Input() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}
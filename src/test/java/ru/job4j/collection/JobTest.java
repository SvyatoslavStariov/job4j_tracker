package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenDescCompatorByNameAndDescPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenAscCompatorByNameAndAscPrority() {
        Comparator<Job> cmpPriorityName = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpPriorityName.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenDescCompatorByProrityAndDescName() {
        Comparator<Job> cmpPriorityName = new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpPriorityName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 0)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenDescCompatorByPrority() {
        Comparator<Job> cmpPriority = new JobDescByPriority();
        int rsl = cmpPriority.compare(
                new Job("Impl task", 1),
                new Job("Impl task", 2)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenAscCompatorByPrority() {
        Comparator<Job> cmpPriority = new JobAscByPriority();
        int rsl = cmpPriority.compare(
                new Job("Impl task", 1),
                new Job("Impl task", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenDescCompatorByName() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("B", 1),
                new Job("A", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenAscCompatorByName() {
        Comparator<Job> cmpName = new JobAscByName();
        int rsl = cmpName.compare(
                new Job("A", 1),
                new Job("B", 1)
        );
        assertThat(rsl).isLessThan(0);
    }
}
package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int sum = 0;
        int size = 0;
        for (Pupil pupil : pupils) {
            size += pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
        }
        return (double) sum / size;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int size = 0;
            for (Subject subject : pupil.subjects()) {
                size += subject.score();
            }
            Label label = new Label(pupil.name(), (double) size / pupil.subjects().size());
            labels.add(label);
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int sum = map.get(subject.name()) != null ? map.get(subject.name()) : 0;
                map.put(subject.name(), subject.score() + sum);

            }
        }
        List<Label> labels = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Label label = new Label(entry.getKey(), (double) entry.getValue() / pupils.size());
            labels.add(label);
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            Label label = new Label(pupil.name(), score);
            labels.add(label);

        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int sum = map.get(subject.name()) != null ? map.get(subject.name()) : 0;
                map.put(subject.name(), subject.score() + sum);

            }
        }
        List<Label> labels = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Label label = new Label(entry.getKey(), entry.getValue());
            labels.add(label);
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}
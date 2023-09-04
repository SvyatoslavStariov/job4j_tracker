package ru.job4j.stream;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.map(Pupil::subjects)
                .flatMap(Collection::stream)
                .mapToDouble(Subject::score)
                .average()
                .orElse(0.0);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.map(pupil -> {
                    double score = pupil.subjects().stream()
                            .mapToDouble(Subject::score)
                            .sum();
                    return new Tuple(pupil.name(), score / pupil.subjects().size());
                })
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        LinkedHashMap<String, Double> subjectsMap = stream
                .map(Pupil::subjects)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Subject::name, LinkedHashMap::new, Collectors.averagingDouble(Subject::score)));
        return subjectsMap.entrySet()
                .stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> {
                    double score = pupil.subjects().stream()
                            .mapToDouble(Subject::score)
                            .sum();
                    return new Tuple(pupil.name(), score);
                })
                .max(Comparator.comparingDouble(Tuple::score))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        Map<String, Double> subjectsMap = stream
                .map(Pupil::subjects)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Subject::name, Collectors.summingDouble(Subject::score)));
        return subjectsMap.entrySet()
                .stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .max(Comparator.comparingDouble(Tuple::score))
                .orElse(null);
    }
}
package com.cytech.data;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Set;

public class GestionEvaluation {
    
    private HashSet<Evaluation> evaluations;
    
    public GestionEvaluation() {
        this.evaluations = new HashSet<>();
    }
    
    public void setEvaluation(Evaluation evaluation) {
        evaluations.add(evaluation);
    }

    public HashSet<Evaluation> getEvaluations() {
        return evaluations;
    }

    public HashSet<Evaluation> getEvaluationsTrieesParNoteCroissante() {
        return evaluations.stream()
                .sorted(Comparator.comparingInt(Evaluation::getNote))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public HashSet<Evaluation> getEvaluationsTrieesParNoteDecroissante() {
        return evaluations.stream()
                .sorted(Comparator.comparingInt(Evaluation::getNote).reversed())
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
    
    public HashSet<Evaluation> getEvaluationsTrieesParDateRecente() {
        return evaluations.stream()
                .sorted(Comparator.comparing(Evaluation::getDate).reversed())
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public HashSet<Evaluation> getEvaluationsTrieesParDateAncienne() {
        return evaluations.stream()
                .sorted(Comparator.comparing(Evaluation::getDate))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}

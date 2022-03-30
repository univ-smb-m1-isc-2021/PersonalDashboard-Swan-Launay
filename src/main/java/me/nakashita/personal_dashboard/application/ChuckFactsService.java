package me.nakashita.personal_dashboard.application;

import me.nakashita.personal_dashboard.infrastructure.persistence.ChuckFact;
import me.nakashita.personal_dashboard.infrastructure.persistence.ChuckFactsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChuckFactsService {

    private final ChuckFactsRepository repository;

    public ChuckFactsService(ChuckFactsRepository repository) {
        this.repository = repository;
    }

    public List<ChuckFact> facts() {
        return repository.findAll();
    }

    public void delete(Long factId) {
        Optional<ChuckFact> fact = repository.findById(factId);
        fact.ifPresent(repository::delete);
    }

    public void create(String fact, String author) {
        // FIXME : check if not already present
        repository.save(new ChuckFact(fact, author));
    }
}

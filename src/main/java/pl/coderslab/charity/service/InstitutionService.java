package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstitutionService {

    private final InstitutionRepository institutionRepository;

    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    public Institution findById(long id) {
        Optional<Institution> institutionOptional = institutionRepository.findById(id);
        return resolveOptional(institutionOptional);
    }

    public void save(Institution institution) {
        institutionRepository.save(institution);
    }

    private Institution resolveOptional(Optional<Institution> optional) {
        if (optional.isEmpty())
            throw new EntityNotFoundException();
        return optional.get();
    }
}

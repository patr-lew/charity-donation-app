package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonationService {

    private final DonationRepository donationRepository;

    public long countAll() {
        return donationRepository.count();
    }

    public long countAllQuantities() {
        Long sum = donationRepository.sumQuantities();
        return (sum != null) ? sum : 0;
    }

    public void save(Donation donation) {
        donationRepository.save(donation);
    }

}

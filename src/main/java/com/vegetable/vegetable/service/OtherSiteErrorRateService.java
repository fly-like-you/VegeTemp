package com.vegetable.vegetable.service;

import com.vegetable.vegetable.entity.ErrorRate;
import com.vegetable.vegetable.entity.OtherSiteErrorRate;
import com.vegetable.vegetable.repository.ErrorRateRepository;
import com.vegetable.vegetable.repository.OtherSiteErrorRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class OtherSiteErrorRateService {
    final private OtherSiteErrorRateRepository otherSiteErrorRateRepository;

    @Autowired
    public OtherSiteErrorRateService(OtherSiteErrorRateRepository otherSiteErrorRateRepository) {
        this.otherSiteErrorRateRepository = otherSiteErrorRateRepository;
    }

    public List<OtherSiteErrorRate> getOtherSiteErrorRatesByName(String name) {
        return otherSiteErrorRateRepository.findByName(name);
    }

    public List<OtherSiteErrorRate> getAllErrorRates() {
        return otherSiteErrorRateRepository.findAll();
    }

    // 기타 필요한 메소드들
    public void createSampleErrorRates() {
        LocalDate startDate = LocalDate.of(2023, 3, 21);
        List<String> productNames = Arrays.asList("Radish", "RedPepper", "Cucumber");
        Random random = new Random();

        for (String productName : productNames) {
            for (int i = 0; i < 7; i++) {
                LocalDate date = startDate.plusDays(i);

                OtherSiteErrorRate errorRate = new OtherSiteErrorRate();
                errorRate.setDate(date);
                errorRate.setName(productName);

                for (int j = 1; j <= 7; j++) {
                    double error = random.nextDouble() * 10;

                    switch (j) {
                        case 1:
                            errorRate.setDay1Error(error);
                            break;
                        case 2:
                            errorRate.setDay2Error(error);
                            break;
                        case 3:
                            errorRate.setDay3Error(error);
                            break;
                        case 4:
                            errorRate.setDay4Error(error);
                            break;
                        case 5:
                            errorRate.setDay5Error(error);
                            break;
                        case 6:
                            errorRate.setDay6Error(error);
                            break;
                        case 7:
                            errorRate.setDay7Error(error);
                            break;
                    }
                }

                otherSiteErrorRateRepository.save(errorRate);
            }
        }
    }

}

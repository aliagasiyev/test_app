package az.edu.msregister.service;


import az.edu.msregister.dto.request.EducationRequest;
import az.edu.msregister.dto.response.EducationResponse;

import java.util.Optional;

public interface EducationService {
    EducationResponse createEducation(EducationRequest requestDto);

    Optional findById(Long id);
}
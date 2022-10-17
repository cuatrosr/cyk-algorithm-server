package co.edu.icesi.cyk.service;

import co.edu.icesi.cyk.dto.CykDTO;
import co.edu.icesi.cyk.model.Input;
import org.springframework.web.bind.annotation.RequestBody;

public interface CykService {
    CykDTO grammarDetector(@RequestBody Input input);
}
package co.edu.icesi.cyk.controller;

import co.edu.icesi.cyk.api.CykAPI;
import co.edu.icesi.cyk.dto.CykDTO;
import co.edu.icesi.cyk.model.Input;
import co.edu.icesi.cyk.service.CykService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CykController implements CykAPI {

    private final CykService cykService;

    @Override
    public CykDTO grammarDetector(Input input) {
        return cykService.grammarDetector(input);
    }
}

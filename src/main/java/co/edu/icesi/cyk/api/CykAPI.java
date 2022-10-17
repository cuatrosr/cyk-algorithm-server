package co.edu.icesi.cyk.api;

import co.edu.icesi.cyk.dto.CykDTO;
import co.edu.icesi.cyk.model.Input;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")
@RequestMapping("/cyk")
public interface CykAPI {

    @PostMapping
    CykDTO grammarDetector(@RequestBody Input input);
}

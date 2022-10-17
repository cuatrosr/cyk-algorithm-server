package co.edu.icesi.cyk.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Input {
    private String w;
    private List<Terminal> fnc;
}

package co.edu.icesi.cyk.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Terminal {
    private String root;
    private List<String> states;
}

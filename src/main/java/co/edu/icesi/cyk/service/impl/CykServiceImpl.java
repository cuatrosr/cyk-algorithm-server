package co.edu.icesi.cyk.service.impl;

import co.edu.icesi.cyk.dto.CykDTO;
import co.edu.icesi.cyk.model.Input;
import co.edu.icesi.cyk.model.Terminal;
import co.edu.icesi.cyk.service.CykService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CykServiceImpl implements CykService {

    @Override
    public CykDTO grammarDetector(Input input) {
        String[][] x = getInitialMatrix(input);
        fillMatrix(x, input);
        return buildResponse(x, input);
    }

    private String[][] getInitialMatrix(Input input) {
        int n = input.getW().length();
        String[][] x = new String[n][n];
        int i = 0;
        for (String c : input.getW().split("")) {
            List<String> listVal = input.getFnc().stream().filter(t -> t.getStates().stream().anyMatch(s -> s.equals(c))).map(Terminal::getRoot).collect(Collectors.toList());
            x[i++][0] = String.join(",", listVal);
        }
        return x;
    }

    private void fillMatrix(String[][] x, Input input) {
        int n = input.getW().length();
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < (n - j); i++) {
                List<String> tempGroups = new ArrayList<>();
                for (int k = 0; k <= (j - 1); k++) {
                    String[] b = x[i][k].split(",");
                    String[] c = x[i + (k + 1)][j - (k + 1)].split(",");
                    for (String vb : b) {
                        for (String vc : c) {
                            if (!vb.equals("") && !vc.equals("") && !tempGroups.contains(vb + vc))
                                tempGroups.add(vb + vc);
                        }
                    }
                }
                List<String> temp = new ArrayList<>();
                for (String c : tempGroups) {
                    List<String> listVal = input.getFnc().stream().filter(t -> t.getStates().stream().anyMatch(s -> s.equals(c))).map(Terminal::getRoot).collect(Collectors.toList());
                    for (String s : listVal) {
                        if (!temp.contains(s))
                            temp.add(s);
                    }
                }
                x[i][j] = String.join(",", temp);
            }
        }
    }

    private CykDTO buildResponse(String[][] x, Input input) {
        boolean response = Arrays.stream(x[0][input.getW().length() - 1].split(",")).anyMatch(e -> e.equals(input.getFnc().get(0).getRoot()));
        return CykDTO.builder().response(response).build();
    }
}

package homework_37;

///Exercise 4

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class StreamContinents {

    public static void main(String[] args) {
        List<String> continents = Arrays.asList("Europe", "Asia", "Africa", "Australia", "Antarctica", "South America", "North America");

        log.info("Initial list of continents: {}", continents);

        List<String> filteredContinents = continents.stream()
                .filter(continent -> continent.length() < 7)
                .collect(Collectors.toList());

        log.info("Filtered continents: {}", filteredContinents);

        System.out.println(filteredContinents);
    }
}

package homework_37;

///Exercise 5

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class StreamCountries2 {

    public static void main(String[] args) {
        List<String> countries = Arrays.asList("Mexico", "Sweden", "Brazil", "Russia", "Canada", "France", "Norway");

        log.info("Initial list of countries: {}", countries);

        List<String> filteredCountries = countries.stream()
                .filter(country -> country.length() == 6)
                .collect(Collectors.toList());

        log.info("Filtered list of countries: {}", filteredCountries);

        System.out.println(filteredCountries);
    }
}

package homework_37;

///Exercise 1

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class StreamCountries {

    public static void main(String[] args) {
        List<String> countries = Arrays.asList("Germany", "France", "Brazil", "Argentina", "Canada", "China", "Australia", "India");

        log.info("Initial list of countries: {}", countries);

        List<String> filteredCountries = countries.stream()
                .filter(country -> country.startsWith("C"))
                .collect(Collectors.toList());

        log.info("Filtered countries (start with C): {}", filteredCountries);

        System.out.println(filteredCountries);
    }
}

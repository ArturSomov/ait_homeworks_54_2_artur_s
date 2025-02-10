package homework_37;

///Exercise 2

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class StreamCities {

    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Berlin", "Buenos Aires", "Paris", "Los Angeles", "New York", "London", "Beijing");

        log.info("Initial list of cities: {}", cities);

        List<String> filteredCities = cities.stream()
                .filter(city -> city.length() > 6)
                .collect(Collectors.toList());

        log.info("Filtered cities (length > 6): {}", filteredCities);

        System.out.println(filteredCities);
    }
}

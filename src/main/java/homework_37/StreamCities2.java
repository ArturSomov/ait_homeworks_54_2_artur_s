package homework_37;

///Exercise 7

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class StreamCities2 {

    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Berlin", "Buenos Aires", "Paris", "Los Angeles", "New York", "London", "Beijing", "Tokyo", "Oslo");

        log.info("Initial list of cities: {}", cities);

        List<String> filteredCities = cities.stream()
                .filter(city -> city.toLowerCase().endsWith("o"))
                .collect(Collectors.toList());

        log.info("Filtered list of cities: {}", filteredCities);

        System.out.println(filteredCities);
    }
}

package homework_37;

///Exercise 8

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class StreamRivers2 {

    public static void main(String[] args) {
        List<String> rivers = Arrays.asList("Amazon", "Nile", "Yangtze", "Mississippi", "Danube", "Main", "Ganges");

        log.info("Initial list of rivers: {}", rivers);

        List<String> filteredRivers = rivers.stream()
                .filter(river -> river.length() > 7)
                .collect(Collectors.toList());

        log.info("Filtered list of rivers: {}", filteredRivers);

        System.out.println(filteredRivers);
    }
}

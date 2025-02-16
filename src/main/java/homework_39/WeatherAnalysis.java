package homework_39;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class WeatherAnalysis {

    public static void main(String[] args) {
        List<Weather> weatherList = WeatherTestData.getWeatherList();

        /// Задание 1: Фильтрация данных по температуре
        List<Weather> coldCities = weatherList.stream()
                .filter(w -> w.getTemperature() < 0)
                .collect(Collectors.toList());

        System.out.println("Cities with temperatures below 0 °C?:");
        coldCities.forEach(System.out::println);
        System.out.println("_____________________________");

        /// Задание 2.1: Есть ли хотя бы один город с температурой выше 25°C
        boolean hasHotCity = weatherList.stream()
                .anyMatch(w -> w.getTemperature() > 25);

        System.out.println("Is there a city with a temperature above 25°C?: \n" + hasHotCity);
        System.out.println("_____________________________");

        /// Задание 2.2: Найти город (объект Weather) с максимальной температурой
        Optional<Weather> hottestCity = weatherList.stream()
                .max(Comparator.comparingDouble(Weather::getTemperature));

        hottestCity.ifPresent(city ->
                System.out.println("The city with the maximum temperature: \n" + city));
        System.out.println("_____________________________");

        //Дополнительные задания
        ///1. Средняя температура всех городов с помощью mapToDouble и average()
        double avgTemp = weatherList.stream()
                .mapToDouble(Weather::getTemperature)
                .average()
                .orElse(0);

        System.out.println("Average temperature: " + avgTemp + "°C");
        System.out.println("_____________________________");

        ///2. Группировка по isRainy (идёт ли дождь)
        Map<Boolean, List<Weather>> groupedByRain = weatherList.stream()
                .collect(Collectors.groupingBy(Weather::isRainy));

        System.out.println("Grouped by rain: \n" + groupedByRain);
        System.out.println("_____________________________");

        ///3. Сортировка городов по названию
        List<Weather> sortedCities = weatherList.stream()
                .sorted(Comparator.comparing(Weather::getCity))
                .collect(Collectors.toList());

        System.out.println("Sorted cities:\n");
        sortedCities.forEach(System.out::println);
        System.out.println("_____________________________");
    }
}

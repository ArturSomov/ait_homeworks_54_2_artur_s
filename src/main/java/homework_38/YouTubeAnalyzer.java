package homework_38;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

class Video {
    @Getter
    private String title;
    @Getter
    private String channel;
    @Getter
    private int views;
    @Getter
    private int likes;
    @Getter
    private int duration;
    @Getter
    private String category;
    private boolean isMonetized;

    public Video(String title, String channel, int views, int likes, int duration, String category, boolean isMonetized) {
        this.title = title;
        this.channel = channel;
        this.views = views;
        this.likes = likes;
        this.duration = duration;
        this.category = category;
        this.isMonetized = isMonetized;
    }

    public boolean isMonetized() {
        return isMonetized; }

    @Override
    public String toString() {
        return title + " (" + views + " views, " + likes + " likes, " + duration + " sec, " + category + ")";
    }
}

public class YouTubeAnalyzer {
    private List<Video> videos;

    public YouTubeAnalyzer(List<Video> videos) {
        this.videos = videos;
    }

    // Задание 1. Фильтрация и сбор данных
    public List<Video> getVideosWithMoreThan1MViews() {
        return videos.stream()
                .filter(v -> v.getViews() > 1_000_000)
                .collect(Collectors.toList());
    }

    public List<String> getTitlesOfLongVideos() {
        return videos.stream()
                .filter(v -> v.getDuration() > 600)
                .map(Video::getTitle)
                .collect(Collectors.toList());
    }

    public Set<String> getUniqueCategories() {
        return videos.stream()
                .map(Video::getCategory)
                .collect(Collectors.toSet());
    }

    // Задание 2. Преобразование данных
    public List<String> getTitlesInUpperCase() {
        return videos.stream()
                .map(v -> v.getTitle().toUpperCase())
                .collect(Collectors.toList());
    }

    public List<Map.Entry<String, Integer>> getTitleAndLikes() {
        return videos.stream()
                .map(v -> Map.entry(v.getTitle(), v.getLikes()))
                .collect(Collectors.toList());
    }

    // Задание 3. Сортировка и ограничение
    public List<Video> getTop5ByViews() {
        return videos.stream()
                .sorted(Comparator.comparingInt(Video::getViews).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<Video> getTop3ByDuration() {
        return videos.stream()
                .sorted(Comparator.comparingInt(Video::getDuration))
                .limit(3)
                .collect(Collectors.toList());
    }

    // Задание 4. Агрегация данных
    public long getTotalVideoCount() {
        return videos.stream().count();
    }

    public Optional<Video> getMostLikedVideo() {
        return videos.stream().max(Comparator.comparingInt(Video::getLikes));
    }

    public Optional<Video> getShortestVideo() {
        return videos.stream().min(Comparator.comparingInt(Video::getDuration));
    }

    // Задание 5. Проверка условий
    public boolean hasVideoWithMoreThan10MViews() {
        return videos.stream().anyMatch(v -> v.getViews() > 10_000_000);
    }

    public boolean areAllMusicVideosMonetized() {
        return videos.stream()
                .filter(v -> v.getCategory().equalsIgnoreCase("Музыка"))
                .allMatch(Video::isMonetized);
    }

    // Дополнительные задания
    public Map<String, List<Video>> groupVideosByCategory() {
        return videos.stream().collect(Collectors.groupingBy(Video::getCategory));
    }

    public double getAverageViews() {
        return videos.stream().collect(Collectors.averagingInt(Video::getViews));
    }

    public boolean hasVideoLongerThan1Hour() {
        return videos.stream().anyMatch(v -> v.getDuration() > 3600);
    }

    // Проверка всех выполненных заданий
    public static void main(String[] args) {
        List<Video> videos = List.of(
                new Video("Как научиться программировать", "IT Channel", 1500000, 12000, 720, "Образование", true),
                new Video("Лучшие моменты матча", "Sports Channel", 500000, 8000, 600, "Спорт", false),
                new Video("Новый трек 2025", "Music Channel", 3000000, 25000, 240, "Музыка", true),
                new Video("Обзор новой игры", "Gaming Channel", 2000000, 15000, 900, "Игры", true),
                new Video("Как приготовить пиццу", "Cooking Channel", 800000, 10000, 1200, "Кулинария", false)
        );

        YouTubeAnalyzer analyzer = new YouTubeAnalyzer(videos);
        System.out.println("Видео с более чем 1 млн просмотров: " + analyzer.getVideosWithMoreThan1MViews());
        System.out.println("____________________________________");
        System.out.println("Названия видео дольше 10 минут: " + analyzer.getTitlesOfLongVideos());
        System.out.println("____________________________________");
        System.out.println("Уникальные категории: " + analyzer.getUniqueCategories());
        System.out.println("____________________________________");
        System.out.println("Названия видео в верхнем регистре: " + analyzer.getTitlesInUpperCase());
        System.out.println("____________________________________");
        System.out.println("Топ-5 видео по просмотрам: " + analyzer.getTop5ByViews());
        System.out.println("____________________________________");
        System.out.println("Самое короткое видео: " + analyzer.getShortestVideo().orElse(null));
        System.out.println("____________________________________");
        System.out.println("Все видео по категориям: " + analyzer.groupVideosByCategory());
        System.out.println("____________________________________");
        System.out.println("Среднее количество просмотров: " + analyzer.getAverageViews());
        System.out.println("____________________________________");
        System.out.println("Есть ли видео дольше 1 часа: " + analyzer.hasVideoLongerThan1Hour());
        System.out.println("____________________________________");
        System.out.println("Есть ли видео с более 10M просмотров: " + analyzer.hasVideoWithMoreThan10MViews());
        System.out.println("____________________________________");
        System.out.println("Все ли музыкальные видео монетизированны: " + analyzer.areAllMusicVideosMonetized());
    }
}

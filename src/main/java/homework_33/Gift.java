package homework_33;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Gift {

    private String name;
    private GiftCategory category;
    @Setter
    private GiftStatus status;

    public Gift(String name, GiftCategory category, GiftStatus status) {
        this.name = name;
        this.category = category;
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Gift: %s, Category: %s, Status: %s,", name, category, status);
    }
}

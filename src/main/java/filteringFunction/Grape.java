package filteringFunction;

import java.util.Objects;

public class Grape {
    private int weight = 0;
    private Color color;
    private Taste taste;

    public Grape(int weight, Color color, Taste taste) {
        this.weight = weight;
        this.color = color;
        this.taste = taste;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Taste getTaste() {
        return taste;
    }

    public int getWeight() {
        return weight;
    }

    public void setTaste(Taste taste) {
        this.taste = taste;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grape)) return false;
        Grape grape = (Grape) o;
        return weight == grape.weight && color == grape.color && Objects.equals(taste, grape.taste);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, color, taste);
    }

    @Override
    public String toString() {
        return String.format("Grape{color=%s, weight=%d, taste=%s}", color, weight, taste);

//                "Grape{" +
//                "weight=" + weight +
//                ", color=" + color +
//                ", taste='" + taste + '\'' +
//                '}';
    }
}

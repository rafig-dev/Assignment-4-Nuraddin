public abstract class Shape implements ParsableEntity {

    protected String color;
    protected Boolean filled;

    public Shape() {
        this.color = "black";
        this.filled = false; // it is by default false, can be ignored
    }

    public Shape(String color, Boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean isFilled() {
        return filled;
    }

    public void setFilled(Boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    @Override
    public String toString() {
        return "Shape [color=" + color + ", filled=" + filled + "]";
    }

}
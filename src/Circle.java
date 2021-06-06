public class Circle extends Shape {

    protected double radius;

    public Circle() {
        this.radius = 1;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, Boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle [" + super.toString() + ", radius=" + radius + "]";
    }

    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String parseToSaveString() {
        return "Circle;" + this.color + ';' + this.filled + ';' + this.radius;
    }

    @Override
    public void parseFromSaveString(String line) {
        String[] fields = line.split(";");
        this.setColor(fields[1]);
        this.setFilled(Boolean.valueOf(fields[2]));
        this.setRadius(Double.parseDouble(fields[3]));
    }
}

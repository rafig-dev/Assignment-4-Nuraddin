public class Rectangle extends Shape {
    protected double width;
    protected double length;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, Boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Rectangle [" + super.toString() + ", width=" + width + ", length=" + length + "]";
    }


    @Override
    public double getArea() {
        return this.length * this.width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (this.length + this.width);
    }

    @Override
    public String parseToSaveString() {
        return "Rectangle;"+this.color+';'+this.filled+';'+this.getWidth()+';'+this.getLength();
    }

    @Override
    public void parseFromSaveString(String line) {
        Rectangle rectangle = new Rectangle();
        String[] fields = line.split(";");
        rectangle.setColor(fields[1]);
        rectangle.setFilled(Boolean.valueOf(fields[2]));
        rectangle.setWidth(Double.parseDouble(fields[3]));
        rectangle.setLength(Double.parseDouble(fields[4]));
    }
}

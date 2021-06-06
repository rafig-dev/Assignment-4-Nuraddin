public class Square extends Rectangle {

    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, Boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return this.width;
    }

    public void setSide(double side) {
        this.width = side;
        this.length = side;
    }

    public void setLength(double side) {
        this.width = side;
        this.length = side;
    }

    public void setWidth(double side) {
        this.width = side;
        this.length = side;
    }

    @Override
    public String toString() {
        return "Square [" + super.toString() + "]";
    }

    @Override
    public String parseToSaveString() {
        return "Square;" + this.color + ';' + this.filled + ';' + this.getSide();
    }

    @Override
    public void parseFromSaveString(String line) {
        String[] fields = line.split(";");
        this.setColor(fields[1]);
        this.setFilled(Boolean.valueOf(fields[2]));
        this.setSide(Double.parseDouble(fields[3]));
    }
}


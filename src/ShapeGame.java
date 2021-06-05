import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShapeGame {
    private List<Shape> shapes = new ArrayList<>(10);

    public ShapeGame(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public ShapeGame() {

    }

    public void loadShapes(String fileName) throws IOException {
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.startsWith("C")) {
                    Circle circle = new Circle();
                    circle.parseFromSaveString(data);
                    shapes.add(circle);
                }
                if (data.startsWith("S")) {
                    Square square = new Square();
                    square.parseFromSaveString(data);
                    shapes.add(square);
                }
                if (data.startsWith("R")) {
                    Rectangle rectangle = new Rectangle();
                    rectangle.parseFromSaveString(data);
                    shapes.add(rectangle);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void saveShapes(String fileName) throws IOException {
        try {
            File file = new File(fileName);

            System.out.println("File has been created successfully");
            FileWriter fw = new FileWriter(file.getName());
            BufferedWriter bw = new BufferedWriter(fw);
            for (Shape shape : shapes) {
                System.out.println(shape);
                bw.write(String.valueOf(shapes.get(shapes.indexOf(shape))));
            }
            fw.close();

        } catch (IOException e) {
            System.out.println("Exception Occurred:");
            e.printStackTrace();
        }
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public List<Shape> getShapes(ShapeType shapeType) {
        List<Shape> shapesCopy = new ArrayList<>(10);

        for (Shape shape : shapes) {
            if (shapeType.equals(ShapeType.CIRCLE)) {
                if (shape instanceof Circle) {
                    shapesCopy.add(shape);
                }
            }
            if (shapeType.equals(ShapeType.RECTANGLE)) {
                if (shape instanceof Rectangle) {
                    shapesCopy.add(shape);
                }
            }
            if (shapeType.equals(ShapeType.SQUARE)) {
                if (shape instanceof Square) {
                    shapesCopy.add(shape);
                }
            }
        }

        return shapesCopy;
    }
}

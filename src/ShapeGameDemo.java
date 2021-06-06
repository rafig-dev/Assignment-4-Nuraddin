import java.io.IOException;

public class ShapeGameDemo {
    private static ShapeGame shg = new ShapeGame();

    public static void main(String[] args) {
        try {
            shg.loadShapes("C:\\JavaSources\\Assignment4\\shapes.txt");

            printShapes(null);
            printShapes(ShapeType.CIRCLE);
            printShapes(ShapeType.SQUARE);
            printShapes(ShapeType.RECTANGLE);

            for (Shape sh : shg.getShapes(ShapeType.CIRCLE))
                sh.setColor("gray");

            for (Shape sh : shg.getShapes(ShapeType.SQUARE))
                sh.setFilled(true);

            shg.getShapes().get(shg.getShapes().size() - 1).setColor("green");

            shg.saveShapes("C:\\JavaSources\\Assignment4\\shapes_modified.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void printShapes(ShapeType type) {
        if (type == null) {
            for (Shape sh : shg.getShapes())
                System.out.println(sh);
        } else {
            for (Shape sh : shg.getShapes(type)) {
                System.out.print(sh);
                System.out.print(", Area: " + sh.getArea());
                System.out.println(", Per: " + sh.getPerimeter());
            }
        }
        System.out.println("----------------------------------------\n");
    }
}
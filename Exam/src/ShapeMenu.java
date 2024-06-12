import java.util.Scanner;

public class ShapeMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shape shape = null;

        while (true) {
            System.out.println("Select a shape to create:");
            System.out.println("1. Circle");
            System.out.println("2. Ellipse");
            System.out.println("3. Triangle");
            System.out.println("4. Rectangle");
            System.out.println("5. Square");
            System.out.println("6. Exit\n");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter radius:");
                    double radius = scanner.nextDouble();
                    shape = new Circle(radius);
                    break;
                case 2:
                    System.out.println("Enter major axis:");
                    double majorAxis = scanner.nextDouble();
                    System.out.println("Enter minor axis:");
                    double minorAxis = scanner.nextDouble();
                    shape = new Ellipse(majorAxis, minorAxis);
                    break;
                case 3:
                    System.out.println("Enter side 1:");
                    double side1 = scanner.nextDouble();
                    System.out.println("Enter side 2:");
                    double side2 = scanner.nextDouble();
                    System.out.println("Enter side 3:");
                    double side3 = scanner.nextDouble();
                    shape = new Triangle(side1, side2, side3);
                    break;
                case 4:
                    System.out.println("Enter length:");
                    double length = scanner.nextDouble();
                    System.out.println("Enter width:");
                    double width = scanner.nextDouble();
                    shape = new Rectangle(length, width);
                    break;
                case 5:
                    System.out.println("Enter side:");
                    double side = scanner.nextDouble();
                    shape = new Square(side);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }

            System.out.println("Shape created: " + shape.getClass().getSimpleName());
            System.out.println("Number of sides: " + shape.getNumberOfSides());
            System.out.println("Area: " + shape.getArea());
            System.out.println("Perimeter: " + shape.getPerimeter());
        }
    }
}

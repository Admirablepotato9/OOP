class Rectangle extends Quadrilateral {

    // Constructor for Rectangle
    public Rectangle(double length, double width) {
        super(length, width, length, width);
    }

    // Overriding the getArea method
    @Override
    public double getArea() {
        return side1 * side2;
    }

    // Overriding the getPerimeter method
    @Override
    public double getPerimeter() {
        return 2 * (side1 + side2);
    }
}

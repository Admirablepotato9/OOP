class Triangle extends Shape {
    // Sides of the triangle
    private double side1, side2, side3;

    // Constructor for Triangle
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Overriding the getNumberOfSides method
    @Override
    public int getNumberOfSides() {
        return 3; // Triangle has 3 sides
    }

    // Overriding the getArea method (using Heron's formula)
    @Override
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    // Overriding the getPerimeter method
    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
}

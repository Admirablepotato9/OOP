class Ellipse extends Shape {
    // Major and minor axes of the ellipse
    private double majorAxis;
    private double minorAxis;

    // Constructor for Ellipse
    public Ellipse(double majorAxis, double minorAxis) {
        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;
    }

    // Overriding the getNumberOfSides method
    @Override
    public int getNumberOfSides() {
        return 1; // Ellipse is considered to have 1 edge
    }

    // Overriding the getArea method
    @Override
    public double getArea() {
        return Math.PI * majorAxis * minorAxis;
    }

    // Overriding the getPerimeter method (approximation using Ramanujan's formula)
    @Override
    public double getPerimeter() {
        return Math.PI * (3 * (majorAxis + minorAxis) - Math.sqrt((3 * majorAxis + minorAxis) * (majorAxis + 3 * minorAxis)));
    }
}

class Circle extends Ellipse {
    // Radius of the circle
    private double radius;

    // Constructor for Circle
    public Circle(double radius) {
        super(radius, radius);
        this.radius = radius;
    }

    // Overriding the getNumberOfSides method
    @Override
    public int getNumberOfSides() {
        return 1; // Circle is considered to have 1 edge
    }

    // Overriding the getArea method
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Overriding the getPerimeter method
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

abstract class Quadrilateral extends Shape {
    // Sides of the quadrilateral
    protected double side1, side2, side3, side4;

    // Constructor for Quadrilateral
    public Quadrilateral(double side1, double side2, double side3, double side4) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.side4 = side4;
    }

    // Overriding the getNumberOfSides method
    @Override
    public int getNumberOfSides() {
        return 4; // Quadrilateral has 4 sides
    }

}

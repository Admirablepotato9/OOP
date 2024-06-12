class Square extends Rectangle {

    // Constructor for Square
    public Square(double side) {
        super(side, side);
    }

    // Overriding the getNumberOfSides method
    @Override
    public int getNumberOfSides() {
        return 4; // Square has 4 sides
    }

}

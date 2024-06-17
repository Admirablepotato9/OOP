package exam2;

public enum DistributionPoints {
    OAXACA("OAX", 48.2, 2.50),
    QUINTANAROO("QROO", 36.5, 3.70),
    MORELOS("MOR", 18.4, 1.60),
    QUERETARO("QRO", 35.3, 3.0),
    SINALOA("SIN", 48.4, 4.0);

	private String destination;
    private double arrivalTime;
    private double costPerKg;

    DistributionPoints(String destination, double arrivalTime, double costPerKg) {
        this.destination = destination;
        this.arrivalTime = arrivalTime;
        this.costPerKg = costPerKg;
    }

    public String getDestination() {
        return destination;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public double getCostPerKg() {
        return costPerKg;
    }
}

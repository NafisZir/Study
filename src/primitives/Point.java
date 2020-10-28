package primitives;

public class Point {
    private double coordinateX = 0;
    private double coordinateY = 0;

    public Point(){ }

    public Point(double x, double y){
        this.coordinateX = x;
        this.coordinateY = y;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateX(double coordinateX) {
        this.coordinateX += coordinateX;
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY += coordinateY;
    }
}

package hexlet.courses.oopBasic;

public class Segment {
    private Point beginPoint;
    private Point endPoint;

    Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {
        return new Point(
            (beginPoint.getCoordinateX() + endPoint.getCoordinateX()) / 2,
            (beginPoint.getCoordinateY() + endPoint.getCoordinateY()) / 2
        );
    }
}

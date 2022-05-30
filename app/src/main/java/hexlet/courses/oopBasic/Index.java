package hexlet.courses.oopBasic;

import org.apache.commons.lang3.StringUtils;

public class Index {
    public static double getSquare(int side1, int side2, int angle) {
        return (side1 * side2 * Math.sin(angle * Math.PI / 180)) / 2;
    }

    public static Point getSymmetricalPoint(Point point) {
        return new Point(point.getCoordinateX(), -point.getCoordinateY());
    }

    public static double getCircumference(Circle circle) {
        return circle.radius * 2 * Math.PI;
    }

    public static boolean isPalindrome(String string) {
        return StringUtils.reverse(string).equalsIgnoreCase(string);
    }

    public static String getFigureSquare(Geometric figure) {
        return "Square of " + figure.getName() + " is " + figure.getSquare();
    }
    
    public static Quadrate enlargeQuadrate(Quadrate quadrate) {
        return new Quadrate(quadrate.getSideSize() * 2);
    }
}

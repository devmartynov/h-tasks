package hexlet.courses;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SegmentTest {
    @Test
    void testSegment() {
        Point point1 = new Point(2, 3);
        Point point2 = new Point(4, 5);
        Segment segment = new Segment(point1, point2);
        assertThat(segment.getBeginPoint()).isEqualTo(point1);
        assertThat(segment.getEndPoint()).isEqualTo(point2);
    }

    @Test
    void testGetMidPoint1() {
        Point point1 = new Point(-4, -4);
        Point point2 = new Point(2, 6);
        Segment segment = new Segment(point1, point2);
        Point midPoint = segment.getMidPoint();
        assertThat(midPoint.getCoordinateX()).isEqualTo(-1);
        assertThat(midPoint.getCoordinateY()).isEqualTo(1);
    }

    @Test
    void testGetMidPoint2() {
        Point point1 = new Point(10, 20);
        Point point2 = new Point(4, 8);
        Segment segment = new Segment(point1, point2);
        Point midPoint = segment.getMidPoint();
        assertThat(midPoint.getCoordinateX()).isEqualTo(7);
        assertThat(midPoint.getCoordinateY()).isEqualTo(14);
    }
}

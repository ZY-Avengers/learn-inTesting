package github.meifans.inTesting.leetcode.abilitycode;

/**
 * @author pengfei.zhao
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        if (matrix.length <= 1) {
            return;
        }

        int x = 0, end = matrix.length - 1;
        while (x < end) {
            for (int i = x; i < end; i++) {
                Point last = Point.of(x, i);
                int value, stag = matrix[x][i];
                for (int j = 0; j < 4; j++) {
                    Point next = rotatePoint(x, end, last);
                    value = matrix[next.x][next.y];
                    matrix[next.x][next.y] = stag;
                    stag = value;
                    last = next;
                }
            }

            x++;
            end -= 1;
        }
    }

    Point rotatePoint(int s, int end, Point cur) {
        int x = -1, y = -1;
        if (cur.x == s) {
            y = end;
            x = cur.y;
        } else if (cur.y == end) {
            x = end;
            y = s + end - cur.x;
        } else if (cur.x == end) {
            x = cur.y;
            y = s;
        } else if (cur.y == s) {
            y = end - cur.x + s;
            x = s;
        }
        return Point.of(x, y);
    }

    static class Point {
        int x;
        int y;

        static Point of(int x, int y) {
            Point point = new Point();
            point.x = x;
            point.y = y;
            return point;
        }
    }


//    public void rotate(int[][] matrix) {
//        int N = matrix.length;
//        for (int offset = 0; offset <= N / 2; ++offset) {
//            for (int i = offset; i < N - offset - 1; ++i) {
//                int t = matrix[offset][i];
//                matrix[offset][i] = matrix[N - 1 - i][offset];
//                matrix[N - 1 - i][offset] = matrix[N - 1 - offset][N - 1 - i];
//                matrix[N - 1 - offset][N - 1 - i] = matrix[i][N - 1 - offset];
//                matrix[i][N - 1 - offset] = t;
//            }
//        }
//    }
}

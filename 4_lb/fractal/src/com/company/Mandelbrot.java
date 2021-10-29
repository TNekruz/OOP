package com.company;
import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator{

    public static final int MAX_ITERATIONS = 2000;
    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }

    @Override
    public int numIterations(double x0, double y0) {
        int i = 0;           //z^2 = (x + y(i))^2 =
        double temp;         // = x^2 + 2xyi - y^2 //представление комплексного числа в координатах
        double x = 0, y = 0;

        for (i = 0; i < MAX_ITERATIONS; i++)
        {
            if (x * x + y * y < 2 * 2)
            {
                temp = x * x - y * y + x0;
                y = 2 * x * y + y0;
                x = temp;
            }
            else break;
        }
        return i == MAX_ITERATIONS ? -1 : i;
    }
}
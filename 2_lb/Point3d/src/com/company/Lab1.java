package com.company;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class Lab1 {

    public static void main(String[] args) {
        //ввод с клавиатуры
        /*Point3d a = new Point3d();
        Point3d b = new Point3d();
        Point3d c = new Point3d();
        Set(a, b, c);*/

        //или установка кооординат через конструктор
        Point3d a = new Point3d(1.0, 2.0, 3.0);
        Point3d b = new Point3d(2.0, 3.0, 4.0);
        Point3d c = new Point3d(5.0, 5.0, 6.0);

        //если нет одинаковых точек, находит площадь
        if (a.compare(b) && a.compare(c) && b.compare(c)) {
            String result = String.format("%.2f",computeArea(a, b, c));
            System.out.println("S = " + result);

        }
            else System.out.println("Такого треугольника не существует");
    }

    //вычисляет площадь
    public static double computeArea(Point3d a, Point3d b, Point3d c)
    {
            double A = parseDouble(a.distanceTo(b).replace(",","."));
            double B = parseDouble(a.distanceTo(c).replace(",","."));
            double C = parseDouble(b.distanceTo(c).replace(",","."));
            double p = (A + B + C) / 2;
            System.out.println("Первая сторона: " + A);
            System.out.println("Вторая сторона: " + B);
            System.out.println("Третья сторона: " + C);
            double S = Math.sqrt(p*(p-A)*(p-B)*(p-C));
            return S;
    }
//ввод координат с клавиатуры
    public static void Set(Point3d a, Point3d b, Point3d c)
    {
        Scanner str = new Scanner(System.in);
        System.out.println("Первая точка:");
        System.out.println("х = ");
        a.setX(str.nextDouble());
        System.out.println("y = ");
        a.setY(str.nextDouble());
        System.out.println("z = ");
        a.setZ(str.nextDouble());
        System.out.println("Вторая точка:");
        System.out.println("х = ");
        b.setX(str.nextDouble());
        System.out.println("y = ");
        b.setY(str.nextDouble());
        System.out.println("z = ");
        b.setZ(str.nextDouble());
        System.out.println("Третья точка:");
        System.out.println("х = ");
        c.setX(str.nextDouble());
        System.out.println("y = ");
        c.setY(str.nextDouble());
        System.out.println("z = ");
        c.setZ(str.nextDouble());
    }
}

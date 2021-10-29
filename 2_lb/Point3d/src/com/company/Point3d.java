package com.company;

public class Point3d {
    private double xCoord;
    private double yCoord;
    private double zCoord;

    //по умолчанию координаты равны нулю
    public Point3d() {
        this(0.0,0.0,0.0);
    }

    //Конструктор инициализации
    public Point3d(double xCoord, double yCoord, double zCoord)
    {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.zCoord = zCoord;
    }

    //Установка значения координаты X
    public void setX(double xCoord)
    {
        this.xCoord = xCoord;
    }

    //Установка значения координаты Y
    public void setY(double yCoord)
    {
        this.yCoord = yCoord;
    }

    //Установка значения координаты Z
    public void setZ(double zCoord)
    {
        this.zCoord = zCoord;
    }

    //Возвращение координаты X
    public double getX(double xCoord)
    {
        return xCoord;
    }

    //Возвращение координаты Y
    public double getY(double yCoord)
    {
        return yCoord;
    }

    //Возвращение координаты Z
    public double getZ(double zCoord)
    {
        return zCoord;
    }

    //Сравниваем координаты двух объектов
    public boolean compare(Point3d a)
    {
        if (xCoord == a.xCoord || yCoord == a.yCoord || zCoord == a.zCoord)
            return false;
        return true;
    }

    public String distanceTo(Point3d a)
    {
        double d = Math.sqrt(Math.pow((xCoord-a.xCoord),2)  + Math.pow((yCoord-a.yCoord),2) + Math.pow((zCoord-a.zCoord),2));
        String result = String.format("%.2f",d);
        return result;
    }

}

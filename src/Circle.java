public class Circle {
    private double radius;
    private String color;

    public Circle(){
        this.radius = 1.0;
        color = "red";
    }

    public Circle(double r){
        this.radius = r;
        color = "red";
    }

    public Circle(double r, String c){
        this.radius = r;
        color = c;
    }

    public double getRadius(){
        return radius;

    }

    public double getArea(){
        return radius*radius*Math.PI;
    }

    public String getColor(){
        return color;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public void setColor(String newColor){
        color = newColor;
    }

    public String toString(){
        return "Circle[radius=" + radius + ", color=" + color + "]";
    }

}

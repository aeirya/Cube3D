package util;

public class Vector {
    public final int x;
    public final int y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return this - other
     */
    public Vector sub(Vector other) {
        return new Vector(x - other.x, y - other.y);
    }

    /**
     * @return this + other
     */
    public Vector sum(Vector other) {
        return new Vector(x + other.x, y + other.y);
    }

    public Vector addX(int x) {
        return add(x, 0);
    }
    
    public Vector addY(int y) {
        return add(0, y);
    }

    public Vector add(int x, int y) {
        return new Vector(x, y).sum(this);
    }


    public Vector scale(float k) { 
        return new Vector((int)(k * x), (int)(k * y));
    }

    public Vector scale(float k, Vector p) {
        return p.sub(this).scale(k).sum(this);
    }

    public Vector scale(int len, Vector p) {
        return p.sub(this).normalize(len).sum(this);
    }

    public Vector normalize(int len) {
        double size = Math.sqrt((double)x*x + y*y);
        return new Vector((int)(len*x/size), (int)(len*y/size));
    }

    public Vector normalize() {
        double size = Math.sqrt((double)x*x + y*y);
        return new Vector((int)(x/size), (int)(y/size));
    }

    public int size2() {
        return x*x + y*y;
    }
}

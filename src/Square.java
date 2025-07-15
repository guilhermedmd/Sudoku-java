public class Square {
    private int number, expectednumber;
    private boolean fixed;

    // construtor para valores fixos
    public Square(int number) {
        this.number = number;
        this.fixed = true;
    }
    // construtor para números não fixos
    public Square(int number, int expectednumber) {
        this.number = number;
        this.expectednumber = expectednumber;
        this.fixed = false;
    }
    // construtor para iniciar as 9 listas vazias
    public Square(Object object) {
        //TODO Auto-generated constructor stub
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public int getExpectednumber() {
        return expectednumber;
    }



    public void setExpectednumber(int expectednumber) {
        this.expectednumber = expectednumber;
    }
    @Override
    public String toString() {
        return "["+number+"]";
    }

    
    

    
}

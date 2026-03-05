// Creation Date: March 05, 2026. at 9:59 AM
// Last Modified: March 05, 2026. at 10:39 AM

public class GameObject {
    //=======VARIABLES=======//
    private int x;
    private int y;
    private int layer;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public GameObject() {

    }
    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public GameObject(int x, int y, int layer) {
        this.x = x;
        this.y = y;
        this.layer = layer;
    }


    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getLayer() {
        return layer;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setLayer(int layer) {
        this.layer = layer;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}

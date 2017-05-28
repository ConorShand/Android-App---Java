package a420.blaze.it.final_frontier.Missile;
//enemy code is adapted from http://gamecodeschool.com/android/coding-a-space-invaders-game/
//created by aaron
        import android.content.Context;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.graphics.Canvas;
        import android.graphics.RectF;
        import java.util.Random;

        import a420.blaze.it.final_frontier.Architecture.GameObject;
        import a420.blaze.it.final_frontier.Player.Animation;


public class Enemy extends GameObject {

    RectF rect;
    private Bitmap enemyShip;
    private int speed;
    private int score;
    private int enemyMove;
    public final int LEFT = 2;
    boolean visible;
    private long fps;

    private Animation animation = new Animation();

    // X is the far left of the rectangle which is the enemy ship
    private float x;

    // Y is the top coordinate
    private float y;

    //length and height of the enemy ships
    private float length;
    private float height;



    //random number generated
    Random number = new Random();

    /*
     *constructor
     */
    public Enemy(Bitmap res, int x, int y, int w, int h, int s, int noOfFrames)
    {
        length = x / 20;
        height = y /20;
        enemyMove = LEFT; //the enemy is moving left
        visible = true; //enemy is visible initially
        this.score = score;
        //the enemy ship is drawn
        Bitmap[] image = new Bitmap[noOfFrames];
        enemyShip = res;

        //the ship is made to be a size appropriate for the screen resolution
        enemyShip = Bitmap.createScaledBitmap(enemyShip,
                (int) (length),
                (int) (height),
                false);

        //speed setting
        speed = 5;
    }

    /*
    end of constructor
     */

    //set invisible
    public void setInvisible() {
        boolean visible = false;
    }


    public boolean getVisible() {
        return visible;
    }



    //the enemy will keep moving once it hits the edge of the screen
    public void upDown() {

    }


    public void draw(Canvas canvas) {
        try {
            canvas.drawBitmap(animation.getImage(), x, y, null);
        } catch (Exception e) {
        }
    }


    public void update() {
        if (enemyMove == LEFT) {
            x = x - speed / fps;
        }
    }

    public RectF getRect() {
        return rect;
    }

    public Bitmap getBitmap() {
        return enemyShip;
    }


    public float getLength(){
        return length;
    }

    //method for firing taken from tutorial
    public boolean firing(float playerShipX, float playerShipLength){

        //random number
        int randomNumber = -1;

        //if statement to find if the enemy is near the player
        if((playerShipX + playerShipLength > x && playerShipX + playerShipLength < x + length) ||
                (playerShipX > x && playerShipX < x + length)) {

            //the chance of shooting is higher if the enemies are near the player
            randomNumber = number.nextInt(150);
            if(randomNumber == 0) {
                return true;
            }

        }

        //if not near the player there is less of a chance of firing
        randomNumber = number.nextInt(2000);
        if(randomNumber == 0){
            return true;
        }

        return false;
    }

} //end of class


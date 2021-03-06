package a420.blaze.it.final_frontier.Environment;
//Loosely based on tutorial found on Reddit.com
import android.graphics.Bitmap;
import android.graphics.Canvas;

import a420.blaze.it.final_frontier.Architecture.GameObject;
import a420.blaze.it.final_frontier.Architecture.MainGame;

/**
 * Created by Josh on 16/03/16.
 */
public class TopBorder extends GameObject {

    private Bitmap image;

    public TopBorder(Bitmap res, int x, int y, int h)
    {
        height = h;
        width = 20;

        this.x = x;
        this.y = y;

        dx = MainGame.MOVESPEED;
        image = Bitmap.createBitmap(res, 0, 0, width, height);
    }

    public void update()
    {
        x+=dx;
    }

    public void draw(Canvas canvas)
    {
        try{canvas.drawBitmap(image, x, y, null);} catch(Exception e){}
    }

}

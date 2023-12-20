package displaybook;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class DisplayStar {
    @FXML
    private ImageView star_1,star_2,star_3,star_4,star_5;
    private Image star_1_image,star_2_image,star_3_image,star_4_image,star_5_image;
    private boolean resetStarBlooen=true,savedStars=false;

    public void displayStarFrame()
    {
        star_1_image = new Image("star_before.png");
        star_2_image = new Image("star_before.png");
        star_3_image = new Image("star_before.png");
        star_4_image = new Image("star_before.png");
        star_5_image = new Image("star_before.png");
        star_1.setImage(star_1_image);
        star_2.setImage(star_2_image);
        star_3.setImage(star_3_image);
        star_4.setImage(star_4_image);
        star_5.setImage(star_5_image);
    }
    public void resetStars()
    {
        if(resetStarBlooen)
        {
            displayStarFrame();
        }
    }
    public void display_Star_1() {
        if (!savedStars) {
            resetStars();
            star_1_image = new Image("star_fill.png");
            star_1.setImage(star_1_image);
        }
    }
    public void display_Star_2() {
        if (!savedStars) {
            resetStars();
            display_Star_1();
            star_2_image = new Image("star_fill.png");
            star_2.setImage(star_2_image);
        }
    }
    public void display_Star_3() {
        if (!savedStars) {
            resetStars();
            display_Star_2();
            star_3_image = new Image("star_fill.png");
            star_3.setImage(star_3_image);
        }
    }
    public void display_Star_4() {
        if (!savedStars) {
            resetStars();
            display_Star_3();
            star_4_image = new Image("star_fill.png");
            star_4.setImage(star_4_image);
        }
    }
    public void display_Star_5()
    {
        if(!savedStars) {
            resetStars();
            display_Star_4();
            star_5_image = new Image("star_fill.png");
            star_5.setImage(star_5_image);
        }
    }
}

package resourcesimports;

import javafx.scene.image.Image;

public class UserInterfaceIcons {
    public static final Image goBack = loadImage("/UserInterfaceIcons/BackIcon.png");
    public static final Image goBackOnHover = loadImage("/UserInterfaceIcons/BackIconOnHover.png");
    public static final Image goBackOnClick = loadImage("/UserInterfaceIcons/BackIconOnClick.png");
    public static final Image profile = loadImage("/UserInterfaceIcons/Profile.png");
    public static final Image profileOnHover = loadImage("/UserInterfaceIcons/ProfileOnHover.png");
    public static final Image profileOnClick = loadImage("/UserInterfaceIcons/ProfileOnClick.png");
    public static final Image shoppingCart = loadImage("/UserInterfaceIcons/ShoppingCart.png");
    public static final Image shoppingCartOnHover = loadImage("/UserInterfaceIcons/ShoppingCartHover.png");
    public static final Image shoppingCartOnClick = loadImage("/UserInterfaceIcons/ShoppingCartOnClick.png");

    private static Image loadImage(String path) {
        return new Image(UserInterfaceIcons.class.getResource(path).toExternalForm());
    }
}

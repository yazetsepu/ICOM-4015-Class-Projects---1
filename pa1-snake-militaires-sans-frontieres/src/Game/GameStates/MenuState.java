package Game.GameStates;


import Main.Handler;
import Resources.Images;
import UI.ClickListlener;
import UI.UIImageButton;
import UI.UIManager;

import java.awt.*;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class MenuState extends State {

    private UIManager uiManager;
    
    //public State stateChecker = State.getState();

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);


        //changed from uiManager.addObjects(new UIImageButton(handler.getWidth()/2-64, handler.getHeight()/2-32, 128, 64, Images.butstart, new ClickListlener() to the following:
        uiManager.addObjects(new UIImageButton(handler.getWidth()/5-100, handler.getHeight()/3, 128, 64, Images.butstart, new ClickListlener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUimanager(null);
                handler.getGame().reStart();
                State.setState(handler.getGame().gameState);
            }
        }));
        //added options button
        uiManager.addObjects(new UIImageButton(56, 320+(64+16), 128, 64, Images.Options, () -> {
            handler.getMouseManager().setUimanager(null);
            State.setState(handler.getGame().menuState);
        }));
    }

    @Override
    public void tick() {
        handler.getMouseManager().setUimanager(uiManager);
        uiManager.tick();

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.darkGray);
        g.fillRect(0,0,handler.getWidth(),handler.getHeight());
        g.drawImage(Images.title,0,0,handler.getWidth(),handler.getHeight(),null);
        uiManager.Render(g);

    }


}

package com.itamus90.game.screen;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Itamar on 06-Dec-17.
 */
public class Screen
{
    //VC => Mean Video Card
    private GraphicsDevice vc;

    public Screen()
    {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        vc = env.getDefaultScreenDevice();
    }

    public void setFullScreen(DisplayMode dm, JFrame window)
    {
        window.setUndecorated(true);
        window.setResizable(false);
        vc.setFullScreenWindow(window);

        if (dm != null && vc.isDisplayChangeSupported())
        {
            try
            {
                vc.setDisplayMode(dm);
            }
            catch (Exception e)
            {
                System.out.println("Error " + e.getMessage());
            }
        }
    }

    public Window getFullScreenWindow()
    {
        return vc.getFullScreenWindow();
    }

    public void restoreScreen()
    {
        Window window = vc.getFullScreenWindow();

        if(window != null)
        {
            window.dispose();
        }

        vc.setFullScreenWindow(null);
    }

}

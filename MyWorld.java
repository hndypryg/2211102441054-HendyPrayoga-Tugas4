import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @fahreza rayhan yudhistira 
 * @l200200001
 */
public class MyWorld extends World
{
    private GreenfootImage youwinimage = new GreenfootImage("gameover.png");
    int currentMaxTurnSpeed = 2;
    int currentLevel = 1;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        prepare();
    }
    private void prepare()
    {
       Pacman pacman = new Pacman();
       addObject(pacman,38,38);
       Wall wall = new Wall();
       addObject (wall,110,101);
       Wall wall2 = new Wall();
       addObject (wall2,688,212);
       Wall wall3 = new Wall();
       addObject (wall3,444,597);
       Wall wall4 = new Wall();
       addObject (wall4,462,13);
       Wall wall5 = new Wall();
       addObject (wall5,687,13);
       Wall wall6 = new Wall();
       addObject (wall6,463,437);
       Wall wall7 = new Wall();
       addObject (wall7,343,223);
       Wall wall8 = new Wall();
       addObject (wall8,234,597);
       Wall wall9 = new Wall();
       addObject (wall9,626,597);
       Wall wall10 = new Wall();
       addObject (wall10,13,474);
       WallY wally = new WallY();
       addObject (wally,589,338);
       WallY wally2 = new WallY();
       addObject (wally2,239,322);
       Point point = new Point();
       addObject (point,320,109);
       Point point2 = new Point();
       addObject (point2,519,109);
       Point point3 = new Point();
       addObject (point3,690,109);
       Point point4 = new Point();
       addObject (point4,105,224);
       Point point5 = new Point();
       addObject (point5,372,528);
       Point point6 = new Point();
       addObject (point6,712,331);
       Point point7 = new Point();
       addObject (point7,486,356);
       Point point8 = new Point();
       addObject (point8,631,528);
       Point point9 = new Point();
       addObject (point9,105,361);
       Point point10 = new Point();
       addObject (point10,345,356);
       Ghost ghost = new Ghost();
       addObject (ghost,510,178);
       Ghost2 ghost2 = new Ghost2();
       addObject (ghost2,171,298);
       Scorepanel scorepanel = new Scorepanel();
       addObject (scorepanel, 71, 554);
       Portal portal = new Portal();
       addObject (portal,769,569);
    }
    public void setUpLevel()
    {
        if(currentLevel == 2){
            addObject(new Ghost2(),654,358);
            addObject(new Point(),320,109);
            addObject(new Point(),519,109);
            addObject(new Point(),690,109);
            addObject(new Point(),105,224);
            addObject(new Point(),372,528);
            addObject(new Point(),712,331);
            addObject(new Point(),486,356);
            addObject(new Point(),631,528);
            addObject(new Point(),105,361);
            addObject(new Point(),345,356);
        }else if(currentLevel == 3){
            addObject(new Ghost(),294,452);
            addObject(new Point(),320,109);
            addObject(new Point(),519,109);
            addObject(new Point(),690,109);
            addObject(new Point(),105,224);
            addObject(new Point(),372,528);
            addObject(new Point(),712,331);
            addObject(new Point(),486,356);
            addObject(new Point(),631,528);
            addObject(new Point(),105,361);
            addObject(new Point(),345,356);
        }
    }
    public void increaseLevel(){
        currentLevel++;
        setUpLevel();
    }
}

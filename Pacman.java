import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pacman here.
 * 
 * @Fahreza Rayhan Yudhistira 
 * @L200200001
 */
public class Pacman extends Actor
{
    private GreenfootImage pacmanimage1 = new GreenfootImage("pacman.png");
    private GreenfootImage pacmanimage2 = new GreenfootImage("pacman2.png");
    private GreenfootImage gameoverimage = new GreenfootImage("gameover.png");
    private GreenfootImage wingameimage = new GreenfootImage("youwin.png");
    private int lives = 3;
    private int score;
    private int pointEaten;
    private int timer;
    private int level = 1;
    public Pacman()
    {
        timer = 1000;
    }
    public void act() 
    {
        pacmanMove();
        detectGhost();
        detectPortal();
        eatPoint();
        showStatus();
        youWin();
        updateTimer();
    }
    public void animate()
    {
        if(getImage()==pacmanimage1){
            setImage(pacmanimage2);
        }
        else{
            setImage(pacmanimage1);
        }
    }
    public void pacmanMove()
    {
        if(Greenfoot.isKeyDown("right")){
            setLocation(getX()+4, getY());
            setRotation(360);
            animate();
            Actor wall = getOneIntersectingObject(Wall.class);
            if (wall !=null)
            {
                setLocation (getX()-4,getY());
            }
        }
        if(Greenfoot.isKeyDown("left")){
            setLocation(getX()-4, getY());
            setRotation(180);
            animate();
            Actor wall = getOneIntersectingObject(Wall.class);
            if (wall !=null)
            {
                setLocation (getX()+4,getY());
            }
        }
        if(Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY()+4);
            setRotation(90);
            animate();
            Actor wall = getOneIntersectingObject(Wall.class);
            if (wall !=null)
            {
                setLocation (getX(),getY()-4);
            }
        }
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY()-4);
            setRotation(-90);
            animate();
            Actor wall = getOneIntersectingObject(Wall.class);
            if (wall !=null)
            {
                setLocation (getX(),getY()+4);
            }
        }
    }
    public void detectGhost()
    {
        if(isTouching(Ghost.class)){
            Greenfoot.playSound("hurt03.wav");
            setLocation(28,39);
            removeLife();
        }
    }
    public void detectPortal()
    {
        if(isTouching(Portal.class)){
            level++;
            Greenfoot.playSound("cartoon-yuppie.wav");
            setLocation(28,39);
            MyWorld myworld = (MyWorld)getWorld();
            myworld.increaseLevel();
            timer = 1000;
        }
    }
    public void eatPoint()
    {
        if(isTouching(Point.class)){
            Greenfoot.playSound("nom.wav");
            removeTouching(Point.class);
            increaseScore();
            timer = timer + 200;
        }
    }
    public void removeLife()
    {
        lives--;
        timer = 1000;
        gameOver();
        showStatus();
    }
    public void youWin()
    {
        if(level > 3){
            setImage(wingameimage);
            Greenfoot.playSound("you win.wav");
            setLocation(422,353);
            setRotation(360);
            Greenfoot.stop();
        }
    }
    public void gameOver()
    {
        if(lives <= 0){
            setImage(gameoverimage);
            setLocation(422,353);
            setRotation(360);
            Greenfoot.playSound("game over.wav");
            Greenfoot.stop();
        }
    }
    public void increaseScore()
    {
        score+=10;
        showStatus();
    }
    public void showStatus()
    {
        getWorld().showText("Level : "+level, 70, 520);
        getWorld().showText("Lives : "+lives, 70, 540);
        getWorld().showText("Score : "+score, 70, 560);
    }
    public void updateTimer()
    {
        timer--;
        getWorld().showText("Time Left = "+timer, 70, 580);
        if(timer < 1){
            removeLife();
            Greenfoot.playSound("hurt03.wav");
            setLocation(28,39);
        }
    }
}

import java.awt.Graphics;
import java.awt.Event;
import java.awt.Font;
import java.awt.Color;
import java.applet.Applet;
import java.awt.*;
import java.awt.Image;
public class spaceinvader extends Applet implements Runnable{
    Dimension setaim=getSize();
    Thread main=new Thread(this);
    int x=0;
    int y=0;
    int z=0;
    int s=0;
    int dead=0;
    int click=0;
    int level=1;
    int score=0;
    int shot=0;
    Image buffer;
    Graphics bufferg;
    Image logo;
    Image spaceship;
    Image shoot;
    Image invader;
    Image eshoot;
    int enemies=0;
    int xplace=75;
    int yplace=0;
    int left = 0;
    int es = 0;
    int levelstatus=0;
    int newstage = 0;
    int kcthegreat=0;
    int goaway[] = new int[900];
    int shotx[] = new int[900];
    int shoty[] = new int[900];
    int eshotx[] = new int[900];
    int eshoty[] = new int[900];
    int ex[] = new int[900];
    int ey[] = new int[900];
    public void init()
    {
      click=0;
      s=0;
      setSize(300,400);
      buffer=createImage(getSize().width,getSize().height);
      bufferg=buffer.getGraphics();
      logo=getImage(getDocumentBase(),"hot.jpg");
      spaceship=getImage(getDocumentBase(),"spaceship.jpg");
      shoot=getImage(getDocumentBase(),"flame.jpg");
      eshoot=getImage(getDocumentBase(),"eflame.jpg");
      invader=getImage(getDocumentBase(),"invader.jpg");
      setBackground(Color.black);
      enemies = (6 + (3*(level-1)));
      left = enemies;
      xplace=75;
      yplace=0;
      for (int x=0;x<enemies;x++)
       {
        if (x%6==0 && x!=0){xplace=75;yplace+=25;}
        else{}
        ex[x] = xplace;
        ey[x] =yplace;
        goaway[x] = 0;
        xplace+=25;
       }
     if (level==1)
        {
      main.start();
        }
    }

      public void run()
         {
           while (kcthegreat==0)
             {
                   try
                     {
                      main.sleep(80);
                     }

  
             catch(Exception e){}
    if (s==0)
       {
      for (int y=0;y<99999999;y++);
      for (int x=0;x<99999999;x++); 
       }
       s++;
             if (newstage==1)
               {
                  newstage=0;
                  shot=0;
                  click=0;
                  levelstatus=1;
                  es=0;
                  res();
               }
             else {
             for (int x=0;x<shot;x++)
              {
                shoty[x]= shoty[x] -20;
                if (shoty[x] - 15< 0){}
                else
                   {
                for (int z=0;z<enemies;z++)
                  {
                    if (shotx[x] <= ex[z] && ex[z] <= shotx[x]+25)
                      {
                         if (shoty[x] <= ey[z] && ey[z] <= shoty[x]+25)
                          {
                           goaway[z] =1;
                           score+=100;
                            shotx[x] = 500;
                            break;
                          }
                         else{}
                      }
                    else if (shotx[x] <= ex[z]+15 && ex[z]+15 <= shotx[x]+25)
                      {
                         if (shoty[x] <= ey[z]+15 && ey[z]+15 <= shoty[x]+25)
                          {
                           goaway[z] =1;
                           score+=100;
                            shotx[x] = 500;
                            break;
                          }
                         else{}
                      }
                    else{}
                  }
                }
              }




             for (int x=0;x<enemies;x++)
               {
                int movex =(int)(Math.random()*40);
                int movey =(int)(Math.random()*40);
                movex-=20;
                movey-=20;
                ex[x]+=movex;
                ey[x]+=movey;
                if (ex[x] <0){ex[x] = 0;}
                else if (ex[x] >275) {ex[x] = 275;}else{}
                if (ey[x] <0){ey[x] = 0;}
                else if (ey[x] >375) {ey[x] = 375;}else{}
                }

            for (int x=0;x<enemies;x++)
             {
              if (goaway[x] == 0)
                  {
                    int att =(int)(Math.random()*10);
                    if (att==1)
                        {
                          eshotx[es] = ex[x];
                          eshoty[es] = ey[y];
                          es++;
                        }
                    else{}
                  }
              else{}
             }

            for (int b=0;b<es;b++)
             {
              eshoty[b]+=15;
                           if (x  <= eshotx[b] && eshotx[b] <=x+25)
                               {
                                     if (y <= eshoty[b] && eshoty[b] <=y+25)
                                      {
                                        spaceship=getImage(getDocumentBase(),"boom.jpg");
                                        dead=1;
                                      }
                               }
             }
            left=enemies;
            for (int x=0;x<enemies;x++)
             {
                if (goaway[x] ==1 ){left--;}
                else{}
                if (left==0){newstage=1;level++;}else{}
             }
            repaint();
             }
  }     
}



    public void stop()
        {
        if(main!=null){main.stop();}
       }


      public void paint(Graphics g)
    {
    update(g);
    }






public void update(Graphics g)
  {
    Dimension d=getSize();
    bufferg.setColor(getBackground());
    bufferg.fillRect(0,0,d.width,d.height);
       bufferg.setColor(Color.green);
       bufferg.setFont(new Font("Tahoma",Font.BOLD,10));
       bufferg.drawString("Score: "+score,3,395);
       bufferg.setColor(Color.yellow);
       bufferg.setFont(new Font("Tahoma",Font.BOLD,10));
       int shotsleft = shot;
       bufferg.drawString("Level: "+level,120,395);
       bufferg.setColor(Color.green);
       bufferg.setFont(new Font("Tahoma",Font.BOLD,10));
       bufferg.drawString("Cannon: "+shotsleft,220,395);
       bufferg.drawImage(spaceship,x,y,this);

for (int x=0;x<es;x++)
 {
  bufferg.drawImage(eshoot,eshotx[x],eshoty[x],this);
 }

for (int x=0;x<shot;x++)
 {
   bufferg.drawImage(shoot,shotx[x],shoty[x],this);
 }
  
for (int x=0;x<enemies;x++)
 {
   if (goaway[x] == 0)
      {
       bufferg.drawImage(invader,ex[x],ey[x],this);
      }
   else{}
 }
if (es==200){es=0;}
if (dead==1)
{
    Dimension q=getSize();
    bufferg.setColor(getBackground());
    bufferg.fillRect(0,0,q.width,q.height);
    bufferg.drawImage(logo, 0,30, this);
    bufferg.setColor(Color.green);
    bufferg.setFont(new Font("Tahoma",Font.BOLD,30));
    bufferg.drawString("SPACE INVADERS",25,25);
    bufferg.setColor(Color.green);
    bufferg.setFont(new Font("Tahoma",Font.BOLD,20));
    bufferg.setColor(Color.blue);
    bufferg.drawString("Your Score: "+score, 65 , 340);
    bufferg.setFont(new Font("Tahoma",Font.BOLD,10));
    bufferg.setColor(Color.yellow);
    bufferg.setFont(new Font("Tahoma",Font.BOLD,10));
    bufferg.drawString("Email: kcmerrill@hotmail.com",65,375);
    bufferg.drawString("Website: ais.cms.k12.nm.us/~cmerrill",55,390);
    es=100000;
}
else{}
g.drawImage(buffer,0,0,this);
}



public boolean mouseDown(Event e, int x, int y) 
 {
   click++;
   shotx[shot] = x;
   shoty[shot] = y;
   if (shot==50)
     {shot=0;}
   else{shot++; score+=5;}
   return true;
 }

public boolean mouseMove(Event e, int xone, int yone)
  {
    x= xone;
    y= yone;
    if (x>275){xone=275;x=275;}
    else if (y>361) {yone=361; y=361;}
    else{x=xone;y=yone;}
    repaint();
    return true;
  }




public void res()
 {
  init();
 }
}

import java.awt.Color;

public class Main {
    public static void main(String[] args) {

      //Exercise 1.13
      //Open the house project. Create an instance of class Picture and invoke its draw method. Also, try out the setBlackAndWhite and setColor methods.

      Picture picture = new Picture();;;;
      Person person = new Person();
      // picture.isVisible();
      picture.draw();
      person.makeVisible();
      // picture.setBlackAndWhite();
      // picture.setColor();
      picture.sunSet();
      person.slowMoveHorizontal(-20);

      
      

      //Exercise 1.16
      //In the source code of class Picture, find the part that actually draws the picture. Change it so that the sun will be blue rather than yellow.

      //Exercise 1.30
      //In this chapter we have mentioned the data types int and String. Java has more predefined data types. Find out what they are and what they are used for.
       //To do this, you can check Appendix B, or look it up in another Java book or in an online Java language manual.

      //CHALLENGE EXERCISES
      //Exercise  1.18
      //Add a sunset to the single-sun version of Picture. That is, make the sun go down slowly.
      //Remember: The circle has a method slowMoveVertical that you can use to do this.
      

      //Exercise 1.19
      // If you added your sunset to the end of the draw method (so  that  the  sun  goes  down  automatically  when  the  picture  is  drawn),  change  this  now.
      //We  now want the sunset in a separate method, so that we can call draw and see the picture with the sun up, and then call sunset (a separate method!) to make the sun go down.

      //Exercise 1.20
      // Make a person walk up to the house after the sunset.
    }
}

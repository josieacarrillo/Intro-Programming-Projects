class CreateShapes

{
   public static void main (String [] args)

 {
      World w = new World();

      Turtle t = new Turtle (200,200,w);

      t.createShapes(60 ,12);

      Turtle t2 =new Turtle (240,186,w);
      t2.createShapes(30,6);


      Turtle t3= new Turtle (258,178,w);
      t3.createShapes(15,2);


      Turtle t4=new Turtle (220,192,w);
      t4.createShapes(45,3);


 }


}

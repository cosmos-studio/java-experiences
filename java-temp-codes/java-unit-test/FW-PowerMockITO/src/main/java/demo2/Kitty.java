package demo2;

public class Kitty {
	{
		System.out.println("Kitty.class.constructor()");
	}
	
    public String getName() {
        return "Kitty";
    }
    
    public static String getNameStatic() {
        return "Kitty";
    }
    
    public void say3() {
        System.out.println("say3");
    }
}